package com.zxkj.util;

import org.apache.log4j.chainsaw.Main;

/**
 * 短信发送工具类
 * @author Administrator
 *
 */
public class SmsSendUtil {
	//private static final String url = "http://sms.253.com/msg/";// 应用地址
	private static final String url="http://sms.253.com/msg/send";
	//private static final String un = "yibaika1";// 账号
	//private static final String pw = "Tch663777";// 密码
	private static final String un = "N3112707";// 账号
	private static final String pw = "t52E9zjQA8f480";// 密码
	private static final String rd = "1";// 是否需要状态报告，需要1，不需要0
	private static final String ex = null;// 扩展码
    
	public static String send(String phone,String msg){
		HttpClientUtil client = HttpClientUtil.getInstance();
		client.parameter("un", un);
		client.parameter("pw", pw);
		client.parameter("phone", phone);
		client.parameter("rd", rd);
		client.parameter("msg", msg);
		//client.parameter("ex", ex);
        
		String result = client.call(url);
		return result;
	}
	
	public static void main(String[] args) {
		String a = SmsSendUtil.send("13152173881", "测试test。");
		System.out.println(a);
	}
}
 