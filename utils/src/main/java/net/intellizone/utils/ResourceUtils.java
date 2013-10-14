/*
 * ResourceUtils.java 2012-1-12
 * 智域工作室
 */
package net.intellizone.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 加载资源的帮助类
 * 
 * @author Pliman
 * @version 1.0 2012-1-12
 * @since Utils 1.0
 */
public final class ResourceUtils {
	// 日志记录器
	private static final Logger logger = Logger.getLogger(ResourceUtils.class.getName());

	/**
	 * 获取当前类路径下面的资源文件的输入流
	 * 
	 * @param clazz
	 *            当前类 一般使用 当前类.class
	 * @param resourcePath
	 *            资源类路径 实例 绝对路径："/net/intellizone/123.xml" 或者相对路径"/123.xml"
	 * @return 输入流
	 */
	public static InputStream getClassPathResource(Class<?> clazz, String resourcePath) {
		return clazz.getResourceAsStream(resourcePath);
	}

	/**
	 * 读取当前类路径下面的属性文件，并以属性的形式返回
	 * 
	 * @param clazz
	 *            当前类 一般使用 当前类.class
	 * @param resourcePath
	 *            资源类路径 实例 绝对路径："/net/intellizone/123.xml" 或者相对路径"/123.xml"
	 * @return 属性
	 */
	public static Properties getClassPathProperties(Class<?> clazz, String resourcePath) {
		try {
			// 加载属性
			Properties prop = new Properties();
			prop.load(clazz.getResourceAsStream(resourcePath));

			return prop;
		} catch (IOException e) {
			logger.warn("没有找到资源文件：" + resourcePath);
			return null;
		}
	}
}