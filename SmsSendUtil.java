package com.zxkj.util;

import org.apache.log4j.chainsaw.Main;

/**
 * ���ŷ��͹�����
 * @author Administrator
 *
 */
public class SmsSendUtil {
	//private static final String url = "http://sms.253.com/msg/";// Ӧ�õ�ַ
	private static final String url="http://sms.253.com/msg/send";
	//private static final String un = "yibaika1";// �˺�
	//private static final String pw = "Tch663777";// ����
	private static final String un = "N3112707";// �˺�
	private static final String pw = "t52E9zjQA8f480";// ����
	private static final String rd = "1";// �Ƿ���Ҫ״̬���棬��Ҫ1������Ҫ0
	private static final String ex = null;// ��չ��
    
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
		String a = SmsSendUtil.send("13152173881", "����test��");
		System.out.println(a);
	}
}
 