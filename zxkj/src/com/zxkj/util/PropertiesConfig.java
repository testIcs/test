package com.zxkj.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertiesConfig {

	/**
	 * 日志记录器
	 */
	private static final Log logger = LogFactory.getLog(PropertiesConfig.class);

	public static final String DEFAULT_CONFIG = "db";

	private Map<String, Properties> map;

	private static PropertiesConfig propertiesConfig = new PropertiesConfig();

	public static PropertiesConfig getInstance() {
		return propertiesConfig;
	}

	private PropertiesConfig() {
		map = new HashMap<String, Properties>();
		this.loadProperty(DEFAULT_CONFIG);
	}

	public Properties getProperties() {
		return getProperties(DEFAULT_CONFIG);
	}

	public Properties getProperties(String config) {
		Properties properties = map.get(config);

		if (properties == null) {
			loadProperty(config);
			properties = map.get(config);
		}

		return properties;
	}

	private void loadProperty(String config) {
		Properties props = new Properties();
		try {
			props.load(PropertiesConfig.class.getResourceAsStream("/" + config + ".properties"));

			map.put(config, props);
		} catch (IOException e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
	}

	public String getProperty(String config, String key) {
		return (String) getProperties(config).get(key);
	}

	public String getProperty(String key) {
		return (String) getProperties(DEFAULT_CONFIG).get(key);
	}

}
