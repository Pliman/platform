/*
 * JsonUtil.java 2012-2-15
 * 智域工作室
 */
package net.intellizone.coupon.util.web.json;

import net.sf.json.JSONObject;

/**
 * Json帮助类
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
public class JsonUtil {
	/**
	 * 从json字符串中获取某一个变量的值
	 * 
	 * @param str
	 *            json字符串
	 * @param name
	 *            变量名
	 * @return 变量值
	 */
	public static String getValueFromJsonStr(String str, String name) {
		JSONObject jo = JSONObject.fromObject(str);
		return jo.getString(name);
	}
}
