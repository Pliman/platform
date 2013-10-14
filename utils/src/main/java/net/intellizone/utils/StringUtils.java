/*
 * StringUtils.java 2012-1-10
 * 智域团队
 * 转换为字符串
 */
package net.intellizone.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * 字符串帮助类
 * 
 * @author Pliman
 * @version 1.0
 * @since Utils 1.0
 */
public class StringUtils {
	private static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * 将对象转为字符串，如果是空对象，则返回空字符串
	 * 
	 * @param obj
	 *            需要转换的对象
	 * @return 转换后的字符串
	 */
	public static String convertToString(Object obj) {
		return obj == null ? "" : String.valueOf(obj);
	}

	/**
	 * InputStream 转换为字符串
	 * 
	 * @param is
	 *            InputStream输入流
	 * @return 字符串
	 */
	public static String inputStreamToString(InputStream is) {
		ByteArrayOutputStream os = null;
		try {
			os = new ByteArrayOutputStream(1024);
			byte[] data = new byte[1024];
			int n = -1;
			while ((n = is.read(data)) != -1) {
				os.write(data, 0, n);
			}

			os.flush();

			return new String(os.toByteArray(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "";
	}

	/**
	 * 获取随机字符串
	 * 
	 * @param counts
	 *            字符串长度
	 * @return 指定长度的随机字符串
	 */
	public static String getRandomString(int counts) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < counts; i++) {
			sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
		}
		return sb.toString();
	}
}
