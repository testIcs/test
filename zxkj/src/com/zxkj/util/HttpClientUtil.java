package com.zxkj.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * httpclient工具类
 * @author liulong
 *
 */
public class HttpClientUtil {
	
	private static final Log logger = LogFactory.getLog(HttpClientUtil.class);
	
	private List<NameValuePair> parameters = new ArrayList<NameValuePair>();//请求参数
	
	private boolean usingPost = true;//使用post方式
	private boolean byRest = false;//使用rest方式
	
	private String responseOutString;
	
	private String errorMessage;
	
	public static HttpClientUtil getInstance(){
		return new HttpClientUtil();
	}
	
	//设置请求参数
	public HttpClientUtil parameter(String key, String value)
	  {
	    if (key==null){
	    	return this;
	    }
	    this.parameters.add(new NameValuePair(key.trim(), value.trim()));
	    logger.debug(new StringBuilder().append("HttpClientUtil key=").append(key.trim()).append(",value=").append(value.trim()).toString());
	    return this;
	  }
	
    public String getErrorMessage(){
    	return this.errorMessage;
    }
	
	public HttpClientUtil api(String apiPath){
	    this.errorMessage = null;
	    long startTime = System.currentTimeMillis();
	    try{
	      StringBuilder url = new StringBuilder();
	      url.append(apiPath);
	      HttpMethodBase httpMethod = null;
	      if (this.byRest){
	        int i = 0;
	        int len = this.parameters.size();
	        while (i < len){
	          url.append("/");
	          NameValuePair kv = (NameValuePair)this.parameters.get(i);
	          try{
	            url.append(URLEncoder.encode(kv.getValue() == null ? "" : kv.getValue(), "utf-8"));
	          }catch (UnsupportedEncodingException e){
	            url.append(kv.getValue());
	          }
	          i++;
	        }
	        httpMethod = new PostMethod(url.toString());
	      }else if (this.usingPost){
	        httpMethod = new PostMethod(url.toString());
	        httpMethod.getParams().setParameter("http.protocol.content-charset", "UTF-8");
	        ((PostMethod)httpMethod).setRequestBody((NameValuePair[])this.parameters.toArray(new NameValuePair[0]));
	      }else{
	        int i = 0;
	        int len = this.parameters.size();
	        while (i < len){
	          url.append(i == 0 ? "?" : "&");
	          NameValuePair kv = (NameValuePair)this.parameters.get(i);
	          url.append(kv.getName()).append("=");
	          try{
	            url.append(URLEncoder.encode(kv.getValue() == null ? "" : kv.getValue(), "utf-8"));
	          }catch (UnsupportedEncodingException e){
	            url.append(kv.getValue());
	          }
	          i++;
	        }
	        String apiURL = url.toString();
	        logger.debug(new StringBuilder().append("api url:").append(apiURL).toString());
	        httpMethod = new GetMethod(apiURL);
	      }
	      
	      HttpClient httpClient = new HttpClient();
	      int statusCode = httpClient.executeMethod(httpMethod);
	      String out = httpMethod.getResponseBodyAsString();
	      logger.trace(new StringBuilder().append("api out:").append(out).toString());
	      if (statusCode == 404){
	    	  throw new Exception(new StringBuilder().append("不能处理的请求:").append(url.toString()).toString());
	      }
	      if (statusCode != 200){
	    	  throw new Exception(out);
	      }
	      responseOutString = out;
	    }catch (Exception e){
	      this.errorMessage = e.getMessage();
	      logger.error("api error", e);
	    }finally{
	      this.parameters.clear();
	      logger.debug(new StringBuilder().append("API('").append(apiPath).append("')调用耗时:").append(System.currentTimeMillis() - startTime).toString());
	    }
	    return this;
	  }
	
	public String call(String apiPath)
	  {
	    api(apiPath);
	    return toString();
	  }
	
	public String toString(){
		return responseOutString;
	}
}
