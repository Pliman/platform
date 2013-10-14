/*
 * MsgConfig.java 2012-2-6
 * 智域工作室
 */
package net.intellizone.coupon.msg.config;

import java.util.Properties;

import net.intellizone.utils.ResourceUtils;

/**
 * 消息配置文件
 * @author Pliman
 * @version 1.0 2012-2-6
 * @since msg 1.0
 */
public enum MsgConfig {
	INSTANCE;
	
	final Properties prop = ResourceUtils.getClassPathProperties(MsgConfig.class, "/msg_conf.properties");
	
	public String getConfig(String config){
		return prop.getProperty(config);
	}
	
	public static void main(String[] args){
		System.out.println(MsgConfig.INSTANCE.getConfig("webserviceurl"));
	}
}
