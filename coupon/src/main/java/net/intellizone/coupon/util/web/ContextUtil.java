/*
 * ContextUtil.java 2012-2-24
 * 智域工作室
 */
package net.intellizone.coupon.util.web;

import javax.servlet.http.HttpServletRequest;

/**
 * 应用上下文帮助类
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
public class ContextUtil {
	/**
	 * 获取完整的上下文URL
	 */
	public static String getFullAppContext(HttpServletRequest request) {
		return new StringBuffer().append(request.getScheme()).append("://").append(
				request.getServerName()).append(":").append(request.getLocalPort()).append(
				request.getContextPath()).append("/").toString();
	}

	/**
	 * 获取上传图片URL
	 */
	public static String getImageUploadPath(HttpServletRequest request) {
		return getFullAppContext(request) + "/goods0/img/";
	}
}
