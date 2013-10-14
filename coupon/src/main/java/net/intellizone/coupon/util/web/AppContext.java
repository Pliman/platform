/*
 * AppContext.java 2012-2-29
 * 智域工作室
 */
package net.intellizone.coupon.util.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * 应用环境初始化帮助类，可以获取应用本身的参数，比如 应用绝对路径,应用相对上下文,应用完整上下文
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
public class AppContext {
	private volatile static AppContext instance;

	// 应用绝对路径
	private final String APP_PATH;
	// 应用相对上下文
	private final String APP_CONTEXT;
	// 应用完整上下文
	//private final String APP_FULL_CONTEXT;
	// 图片路径
	private final String PIC_URL;
	// 上传图片路径
	private final String UPLOADED_PIC_URL;

	private AppContext(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();

		APP_PATH = sc.getRealPath("/");
		APP_CONTEXT = sc.getContextPath() + "/";
		PIC_URL = APP_CONTEXT + "res/images";
		UPLOADED_PIC_URL = APP_CONTEXT + "goods0/img";
	}

	/**
	 * 初始化instance
	 * 
	 * @param sce
	 *            ServletContext事件
	 */
	public static AppContext initInstance(ServletContextEvent sce) {
		if (instance == null) {
			synchronized (AppContext.class) {
				if (instance == null)
					instance = new AppContext(sce);
			}
		}
		return instance;
	}

	/**
	 * 直接获取instance
	 */
	public static AppContext getInstance() {
		return instance;
	}

	public String getAPP_PATH() {
		return APP_PATH;
	}

//	public String getAPP_FULL_CONTEXT() {
//		return APP_FULL_CONTEXT;
//	}

	public String getAPP_CONTEXT() {
		return APP_CONTEXT;
	}

	public String getPIC_URL() {
		return PIC_URL;
	}

	public String getUPLOADED_PIC_URL() {
		return UPLOADED_PIC_URL;
	}
}
