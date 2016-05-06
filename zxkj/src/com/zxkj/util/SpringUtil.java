package com.zxkj.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {

	private static ApplicationContext ac;

	static {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public static ApplicationContext getApplicationContext() {
		return ac;
	}

}
