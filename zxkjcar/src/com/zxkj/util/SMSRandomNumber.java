package com.zxkj.util;
/**
 * 生成随机数类
 * @author
 *
 */
public class SMSRandomNumber {
	/**
	 * 生成6位随机数
	 * @return
	 */
	public static int generateNumber() {
		int random = (int) ((Math.random() * 9 + 1) * 100000);
		return random;
	}
}
