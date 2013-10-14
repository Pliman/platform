/*
 * DateUtils.java 2011-1-10
 * 智域工作室
 */
package net.intellizone.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 日期帮助类
 * 
 * @author Pliman
 * @version 1.0
 * @since utils .10
 */
public class DateUtils {
	// 日志记录器
	private static final Logger logger = Logger.getLogger(DateUtils.class.getSimpleName());

	/**
	 * 日期时间24小时制格式("yyyy-MM-dd HH:mm:ss")
	 */
	public static final String DATE_TIME_24_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期格式("yyyy-MM-dd")
	 */
	public static final String DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * 日期字符串转化为日期
	 * 
	 * @param dateTime
	 *            yyyy-MM-dd HH:mm:ss 格式时间串
	 * @return 时间对象
	 */
	public static Date converToDateTime(String dateTime) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_24_FORMAT);
		try {
			return df.parse(dateTime);
		} catch (ParseException e) {
			logger.warn("parse date string error, return current date", e);
			return new Date();
		}
	}

	/**
	 * 使用自定义格式格式化当前日期
	 * 
	 * @param dateFormat
	 *            输出显示的时间格式
	 * @return 格式化结果
	 */
	public static String formatCurrentDate(String dateFormat) {
		return formatDate(new Date(), dateFormat);
	}

	/**
	 * 使用默认格式(yyyy-MM-dd)格式化当前日期
	 * 
	 * @return 格式化结果
	 */
	public static String formatCurrentDate() {
		return formatCurrentDate(DATE_FORMAT);
	}

	/**
	 * 格式化日期，自定义格式
	 * 
	 * @param date
	 *            日期
	 * @return 格式化结果
	 */
	public static String formatDate(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

		return sdf.format(date);
	}

	/**
	 * 使用默认格式(yyyy-MM-dd)格式化日期
	 * 
	 * @param date
	 * @return 格式化结果
	 */
	public static String formatDate(Date date) {
		return formatDate(date, DATE_FORMAT);
	}

	/**
	 * 使用自定义格式格式化当前时间
	 * 
	 * @param dateTime
	 *            日期时间
	 * @param datetimeFormat
	 *            日期时间格式
	 * @return 格式化结果
	 */
	public static String formatDateTime(Date dateTime, String datetimeFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(datetimeFormat);

		return sdf.format(dateTime);
	}

	/**
	 * 使用默认格式(yyyy-MM-dd HH:mm:ss)格式化日期时间,24小时制
	 * 
	 * @param dateTime
	 *            日期时间
	 * @return 格式化结果
	 */
	public static String formatDateTime(Date dateTime) {
		return formatDateTime(dateTime, DATE_TIME_24_FORMAT);
	}

	/**
	 * 使用格式(yyyy-MM-dd HH:mm:ss)格式化当前日期
	 * 
	 * @return 格式化结果
	 */
	public static String formatCurrentDateTime() {
		return formatDateTime(new Date(), DATE_TIME_24_FORMAT);
	}

	/**
	 * 获取日历0点
	 * 
	 * @param date
	 *            日期
	 * @return 日历0点
	 */
	public static Calendar getZeroCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.AM_PM, Calendar.AM);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal;
	}

	/**
	 * 获取日历昨天0点
	 * 
	 * @param date
	 *            今天日期
	 * @return 日历昨天0点
	 */
	public static Calendar getPreZeroCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.AM_PM, Calendar.AM);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal;
	}

	/**
	 * 获取日历今天23点30分
	 * 
	 * @param date
	 *            今天日期
	 * @return 日历今天23点30分
	 */
	public static Calendar getLateCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 30);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal;
	}

	public static void main(String[] args) {
		System.out.println(DateUtils.getZeroCalendar(new Date()).getTime());
		System.out.println(DateUtils.formatCurrentDate(DateUtils.DATE_TIME_24_FORMAT));
		System.out.println(DateUtils.converToDateTime("2010-08-18 24:33:53"));
		System.out.println(DateUtils.formatDate(DateUtils.getLateCalendar(new Date()).getTime(),
				DateUtils.DATE_TIME_24_FORMAT));
	}
}
