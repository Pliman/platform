/*
 * MysqlDataSourceManager.java 2012-1-9
 * 智域工作室
 */
package net.intellizone.db;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * mysql数据源管理类
 * 
 * @author Pliman
 * @version 1.0
 * @since demo 1.0
 */
public enum MysqlDataSourceManager {
	INSTANCE;

	/**
	 * 日志记录
	 */
	private Logger logger = Logger.getLogger(MysqlDataSourceManager.class
			.getName());

	// 数据源
	MysqlDataSource dataSource;

	/**
	 * 获取数据源 如果数据源未初始化，则先初始化数据源
	 * 
	 * @return 数据源
	 */
	public DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new MysqlDataSource();

			if (logger.isDebugEnabled()) {
				logger.debug("创建数据源...");
			}
			// 设置数据源信息 --今后从配置文件中读取
			//dataSource.setURL("jdbc:mysql://10.4.8.125:3306/iz_coupon?characterEncoding=utf-8");
			dataSource.setURL("jdbc:mysql://localhost:3306/iz_coupon?characterEncoding=utf-8");
			dataSource.setUser("root");
			dataSource.setPassword("password");
		}

		return dataSource;
	}
}