package com.zxkj.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class DBUtil {
	private static final Logger LOG = LoggerFactory.getLogger(DBUtil.class);
	private static JdbcTemplate jdbcTemplate;
	private static SQLUtil sqlUtil;
	static{
		jdbcTemplate = (JdbcTemplate) new ClassPathXmlApplicationContext("applicationContext-db.xml").getBean("jdbcTemplate");
		LOG.debug("instance JdbcTemplate");
		sqlUtil = (SQLUtil) new ClassPathXmlApplicationContext("applicationContext-sql.xml").getBean("sqlUtil");
	}
	public static JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}
	public static SQLUtil getSqlUtil(){
		return sqlUtil;
	}
}
