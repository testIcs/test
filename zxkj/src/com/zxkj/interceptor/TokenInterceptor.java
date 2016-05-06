package com.zxkj.interceptor;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zxkj.service.ITokenService;


public class TokenInterceptor extends HandlerInterceptorAdapter{
	
	//定义字面量常量
	private static final String TOKEN_STR = "token";
	
	/**
	 * 判断客户端是否为重复提交
	 */
	private boolean isRepeatSubmit(HttpServletRequest request) {
        //获取服务器端的token
		String serverToken = (String) request.getSession(false).getAttribute(TOKEN_STR);
        //session中没有token,即服务器端没有token
        if (null == serverToken) {
            return true;
        }
        
        //客户端提交的token
        String clinetToken = request.getParameter(TOKEN_STR);
        //客户端没有token
        if (null == clinetToken) {
            return true;
        }
        
        //客户端提交的token和服务器端的token不一致,确认为重复提交
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        
        return false;
    }

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		  if (handler instanceof HandlerMethod) {
	            HandlerMethod handlerMethod = (HandlerMethod) handler;
	            Method method = handlerMethod.getMethod();
	            ITokenService annotation = method.getAnnotation(ITokenService.class);
	            if (null != annotation) {
	            	//进入审核页面,生成token
	                if (annotation.save()) {
	                	//生成token,放到session中
	                    request.getSession(false).setAttribute(TOKEN_STR, UUID.randomUUID().toString());
	                }
	                //执行需要验证token的方法
	                if (annotation.remove()) {
	                	//客户端重复提交,直接返回
	                    if (isRepeatSubmit(request)) {
	                    	response.getWriter().write("req_again");
	                        return false;
	                    }
	                    //验证通过后,从session中删除token
	                    request.getSession(false).removeAttribute(TOKEN_STR);
	                }
	            }
	            return true;
	        } else {
	            return super.preHandle(request, response, handler);
	        }  	  
	}
}