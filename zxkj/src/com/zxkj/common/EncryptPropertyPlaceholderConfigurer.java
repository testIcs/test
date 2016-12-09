package com.zxkj.common;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.zxkj.util.DesEncrypt;
import com.zxkj.util.EncryptKey;


public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	private String[] encryptPropNames = { "jdbc.password" };

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {

		// 如果在加密属性名单中发现该属性
		if (isEncryptProp(propertyName)) {
			DesEncrypt encrypt  = new DesEncrypt(EncryptKey.getKey());
			String decryptValue = encrypt.decrypt(propertyValue);
			return decryptValue;
		} else {
			return propertyValue;
		}

	}

	private boolean isEncryptProp(String propertyName) {
		for (String encryptName : encryptPropNames) {
			if (encryptName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}