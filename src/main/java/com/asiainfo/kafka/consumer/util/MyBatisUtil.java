package com.asiainfo.kafka.consumer.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.logging.log4j.Logger;  
import org.apache.logging.log4j.LogManager;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private final static Logger logger = LogManager.getLogger(MyBatisUtil.class);
	
	private final static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		String resource = "conf/mybatis/mybatis-config.xml";
		logger.info("本次程序加载的MyBatis配置文件的路径是：" + resource);
		
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			logger.error("程序在加载MyBatis配置文件中，出现异常，异常信息：" + e.getMessage());
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}