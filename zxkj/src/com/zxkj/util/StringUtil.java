package com.zxkj.util;

public class StringUtil 
{
	public static final String charRightSlashToLeftSlash(String srcStr)
	{
		return srcStr.replaceAll("\\\\", "/");
	}
	
	public static void main(String[] args) {
		String str = "E:\\java\\tomcat\\apache-tomcat-7.0.47\\webapps\\zxkj\\id_card_images";
		String[] strArr = str.split("\\");
		str = String.join("/", strArr);
	}
}
