/*
 * CookieUtils.java 2012-2-12
 * 智域工作室
 */
package net.intellizone.coupon.util.web.cookie;

import javax.servlet.http.Cookie;

/**
 * Cookie帮助类
 * 
 * @author Pliman
 * @version 1.0
 * @since utils 1.0
 */
public class CookieUtil {
	/**
	 * 获取cookie的值
	 * 
	 * @param cookies
	 *            当前request的所有cookie
	 * @param name
	 *            cookie名
	 * @return cookie值
	 */
	public static String getCookieValue(Cookie[] cookies, String name) {
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}

		return "";
	}
}
