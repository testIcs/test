package com.zxkj.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.zxkj.util.PropertiesConfig;


public class ContextPathListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		ServletContext sc = contextEvent.getServletContext();
		destroyBaseUrl(sc);		
	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		ServletContext sc = contextEvent.getServletContext();
		initBaseUrl(contextEvent,sc);
	}
	
	private void initBaseUrl(ServletContextEvent contextEvent, ServletContext sc) {
		sc.setAttribute("baseUrl", getValueByName("base.url"));
	}
	
	private void destroyBaseUrl(ServletContext sc) {
		sc.removeAttribute("baseUrl");		
	}
	
	/**
	 * 获取相应配置值
	 */
	private String getValueByName(String name) {	
		return PropertiesConfig.getInstance().getProperty(name);		
	}

}
