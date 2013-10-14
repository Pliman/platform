/*
 * Constants.java 2012-1-18
 * 智域工作室
 */
package net.intellizone.core.constants;

/**
 * 系统使用的常量
 * 
 * @author Pliman
 * @version 1.0
 * @since core 1.0
 */
public interface Constants {
	// 成功返回
	int SUCCESS = 0;

	// 失败返回
	int FAILURE = 1;

	// 分页默认每页记录数
	int DEFAULT_PAGESIZE = 10;

	int PAGESIZE7 = 7;

	int PAGESIZE8 = 8;
	
	int PAGESIZE20 = 20;

	// 验证码过期时间 毫秒 默认10分钟
	long AUTH_IMG_INVALID_TIME = 10 * 60 * 1000;
}
