/*
 * AppContextListener.java 2012-2-29
 * 智域工作室 
 */
package net.intellizone.coupon.system.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.intellizone.coupon.util.web.AppContext;

/**
 * 应用事件监听器
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
public class AppContextListener implements ServletContextListener {
	/**
	 * 监听servlet销毁事件
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("--------------谢谢使用，再见--------------");
	}

	/**
	 * 监听servlet初始化事件
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("--------------系统初始化--------------");
		// 初始化应用上下文
		initAppContext(arg0);
	}

	// 初始化应用上下文
	private void initAppContext(ServletContextEvent arg0) {
		System.out.println("--------------开始初始化应用上下文--------------");
		AppContext.initInstance(arg0);
		System.out.println("--------------应用上下文初始化完成--------------");
	}

}
