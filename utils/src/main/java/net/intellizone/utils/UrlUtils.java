/*
 * UrlUtils.java 2012-1-12
 * 智域工作室
 */
package net.intellizone.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

/**
 * URL帮助类
 * 
 * @author Pliman
 * @version 1.0 2012-1-12
 * @since Utils 1.0
 */
public class UrlUtils {

	// 日志记录器
	private static final Logger logger = Logger.getLogger(UrlUtils.class.getSimpleName());

	/**
	 * 使用指定方法访问网址，获取返回值
	 * 
	 * @param urlAddr
	 *            网址
	 * @param method
	 *            制定方法
	 * @return 网址返回值
	 */
	public static String getURLResponse(String urlAddr, String method) {
		try {
			URL url = new URL(urlAddr);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod(method);
			con.getResponseCode();
			String message = StringUtils.inputStreamToString((InputStream) con.getContent());
			con.disconnect();

			return message;
		} catch (Exception e) {
			logger.warn(method + "方式访问地址出错", e);
		}

		return "";
	}
	
	/**
	 * 使用指定方法访问网址，获取返回值
	 * 
	 * @param urlAddr
	 *            网址
	 * @param method
	 *            制定方法
	 * @return 网址返回值
	 */
	public static String getURLResponse(HttpURLConnection con,String method) {
		try {
			con.setRequestMethod(method);
			con.getResponseCode();
			String message = StringUtils.inputStreamToString((InputStream) con.getContent());
			con.disconnect();

			return message;
		} catch (Exception e) {
			logger.warn(method + "方式访问地址出错", e);
		}

		return "";
	}

	public static void main(String[] args) {
		// UrlUtils.getURLResponseByGet("http://localhost:8080/coupon/cmd/device.do?terminalid=1");
		// UrlUtils.getURLResponseByGet("http://www.google.com.hk");
		UrlUtils.getURLResponse("http://www.baidu.com", "GET");
	}
}