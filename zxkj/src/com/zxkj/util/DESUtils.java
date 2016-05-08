package com.zxkj.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESUtils {
	private static Key generateKey(String keyStr){
		Key key = null;
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(keyStr.getBytes());
			generator.init(secureRandom);
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return key;
	}
	/**
	 * 对字符串进行加密，返回BASE64的加密字符串 <功能详细描述>
	 * @param str
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String getEncryptString(String str,String keyStr) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			byte[] strBytes = str.getBytes("UTF-8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, generateKey(keyStr));
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64Encoder.encode(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 对BASE64加密字符串进行解密 <功能详细描述>
	 * @param str
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String getDecryptString(String str,String keyStr) {
		BASE64Decoder base64Decoder = new BASE64Decoder();
		try {
			byte[] strBytes = base64Decoder.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, generateKey(keyStr));
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return new String(encryptStrBytes, "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static void main(String[] args) {
		String name = "pt";
		String password = "111111";
		String encryname = getEncryptString(name,"mykey");
		String encrypassword = getEncryptString(password,"123!@#Qaz");
		System.out.println(encryname);
		System.out.println(encrypassword);

		System.out.println(getDecryptString(encryname,"mykey"));
		System.out.println(getDecryptString("u/x9FsSM6+A=","123!@#Qaz"));
	}
}