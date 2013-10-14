/*
 * IPEntry.java 2012-3-9
 * 智域工作室
 */
package net.intellizone.coupon.city.model;

/**
 * <pre>
 * 一条IP范围记录，不仅包括国家和区域，也包括起始IP和结束IP
 * </pre>
 * @author Pliman
 * @version 1.0
 * @since city 1.0
 */
public class IPEntry {
	public String beginIp;
	public String endIp;
	public String country;
	public String area;

	/**
	 * 构造函数
	 */
	public IPEntry() {
		beginIp = endIp = country = area = "";
	}
}
