package com.zxkj.util;

import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 短息发送处理类
 * @author zj
 */
public class SmsHandle {
	//日志记录器
	private static final Log logger = LogFactory.getLog(SmsHandle.class);

	private static final String url="http://sms.253.com/msg/send";
	private static final String un = "N3112707";// 账号
	private static final String pw = "t52E9zjQA8f480";// 密码
	private static final String rd = "1";// 是否需要状态报告，需要1，不需要0
	private static final String ex = null;// 扩展码
	
	/**
	 * 短息发送
	 * @param mobile 手机号码
	 * @param content 短息内容
	 * @return 成功返回<code>String</code>
	 * @throws Exception
	 */
	public String smsSend(String phone, String msg){
		logger.info("SmsHandle->phone="+phone);
		logger.info("SmsHandle->msg="+msg);
		HttpClientUtil client = HttpClientUtil.getInstance();
		client.parameter("un", un);
		client.parameter("pw", pw);
		client.parameter("phone", phone);
		client.parameter("rd", rd);
		client.parameter("msg", msg);
		//client.parameter("ex", ex);
	    
		String result = client.call(url);
		
		logger.info("SmsHandle->result="+result);
		return result;
	}

	

	public static void main(String[] args) throws Exception {
		SmsHandle smsHandle = new SmsHandle();
		smsHandle.smsSend("13152173881", "试算邮件测试");
	}

}