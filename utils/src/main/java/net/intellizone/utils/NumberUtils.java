/*
 * NumberUtils.java 2012-1-10
 * 智域团队
 */
package net.intellizone.utils;

/**
 * 数值帮助类
 * 
 * @author Pliman
 * @version 1.0 2012-1-10
 * @since Utils 1.0
 */
public class NumberUtils {
	/**
	 * 对象转化为长整形
	 * 
	 * @param obj
	 *            对象
	 * @return 长整形
	 */
	public static long convertToLong(Object obj) {
		return Math.round(NumberUtils.convertToDouble(obj));
	}
	
	/**
	 * 对象转化为整形
	 * 
	 * @param obj
	 *            对象
	 * @return 长整形
	 */
	public static Integer convertToInteger(Object obj) {
		return (int)Math.round(NumberUtils.convertToDouble(obj));
	}

	/**
	 * 对象转化为双精度型
	 * 
	 * @param obj
	 *            对象
	 * @return 双精度型
	 */
	public static double convertToDouble(Object obj) {
		return Double.parseDouble(StringUtils.convertToString(obj));
	}
}