package com.asiainfo.kafka.consumer.util;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;

public class AsiaInfoDataSourceFactory extends UnpooledDataSourceFactory {

	public AsiaInfoDataSourceFactory(){
		this.dataSource = new DruidDataSource();
	}
}
