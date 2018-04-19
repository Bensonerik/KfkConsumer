package com.asiainfo.kafka.consumer.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;

public class MySqlSession {
	
	private static SqlSession sqlSession = null;

	public static SqlSession getSqlSession() {
		if (sqlSession == null) {
			SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

			sqlSession = SqlSessionManager.newInstance(sqlSessionFactory).openSession(false);
		}
		return sqlSession;
	}
}