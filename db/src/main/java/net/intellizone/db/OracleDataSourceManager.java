/*
 * OracleDataSourceManager.java 2011-12-28
 * 智域工作室
 */
package net.intellizone.db;

import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.log4j.Logger;

/**
 * oracle数据源管理类
 * 
 * @author Pliman
 * @version 1.0
 * @since demo 1.0
 */
public enum OracleDataSourceManager {
	INSTANCE;

	/**
	 * 日志记录
	 */
	private Logger logger = Logger.getLogger(OracleDataSourceManager.class
			.getName());

	// 数据源
	OracleDataSource dataSource;

	/**
	 * 获取数据源 如果数据源未初始化，则先初始化数据源
	 * 
	 * @return 数据源
	 */
	public DataSource getDataSource() {
		if (dataSource == null) {
			try {
				dataSource = new OracleDataSource();

				if (logger.isDebugEnabled()) {
					logger.debug("创建数据源...");
				}
				// 设置数据源信息 --今后从配置文件中读取
				dataSource.setURL("jdbc:oracle:thin:@10.4.6.184:1521:orcl");
				dataSource.setUser("platform");
				dataSource.setPassword("platform");
			} catch (SQLException e) {
				logger.error("创建数据源失败", e);
			}
		}

		return dataSource;
	}
}