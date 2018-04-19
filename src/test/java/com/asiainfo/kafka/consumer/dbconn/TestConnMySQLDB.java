package com.asiainfo.kafka.consumer.dbconn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.Before;
import org.junit.Test;

import com.asiainfo.kafka.consumer.util.MyBatisUtil;

public class TestConnMySQLDB {

	private ConfigurationSource source = null;

	@Before
	public void initTestEnv() {
		String config = System.getProperty("user.dir");
		try {
			source = new ConfigurationSource(new FileInputStream(config + "\\src\\main\\resources\\conf\\settings\\log4j2.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Configurator.initialize(null, source);
	}

	@Test
	public void testGetSqlSessionFactory() {

		SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
		if (sqlSessionFactory != null) {
			System.out.println("已经成功的获取了数据库的连接");
		}
	}
}
