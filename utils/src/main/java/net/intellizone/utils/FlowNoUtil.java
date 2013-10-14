/*
 * FlowNoUtil.java 2012-2-15
 * 智域工作室
 */
package net.intellizone.utils;

/**
 * 流水号帮助类
 * 
 * @author Pliman
 * @version 1.0
 * @since utils 1.0
 */
public class FlowNoUtil {
	/**
	 * 获取20位基于时间的流水号
	 * 
	 * @return 20位基于时间的流水号
	 */
	public static String timeBased20FlowNo() {
		return DateUtils.formatCurrentDate("yyyyMMddHHmmss") + StringUtils.getRandomString(6);
	}
}
