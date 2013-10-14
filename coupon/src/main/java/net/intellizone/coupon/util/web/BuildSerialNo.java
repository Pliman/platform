package net.intellizone.coupon.util.web;

import java.util.Random;



import org.apache.commons.lang.StringUtils;



public class BuildSerialNo {
	public static final String ORDER_SN_PREFIX = "";// 订单编号前缀
	public static final long ORDER_SN_FIRST = 100000L;// 订单编号起始数
	public static final long ORDER_SN_STEP = 1L;// 订单编号步长
	
	
	public static final String YQ_SN_PREFIX = "YQ";// 订单编号前缀
	
	
	public static Long lastOrderSnNumber;
	
	static {
		// 订单编号
		//SpringUtil.getBean("orderServiceImpl");
		String lastOrderSn = "";
		if (StringUtils.isNotEmpty(lastOrderSn)) {
			lastOrderSnNumber = Long.parseLong(StringUtils.removeStart(lastOrderSn, ORDER_SN_PREFIX));
		} else {
			lastOrderSnNumber = ORDER_SN_FIRST;
		}
	}
	public static String createSerialNum(int id){
		String riqi = DateUtil.nowDate(Constant.YYYYMMDD);
		Random rd = new java.util.Random(System.currentTimeMillis());
		long num = rd.nextLong();
		num = Math.abs(num);
		String no=YQ_SN_PREFIX+riqi + String.valueOf(num).substring(14)+String.valueOf(id);// 序列号
		return no;
	}
	
	/**
	 * 生成订单编号
	 * 
	 * @return 订单编号
	 */
	public synchronized static String buildOrderSn() {
		lastOrderSnNumber += ORDER_SN_STEP;
		return ORDER_SN_PREFIX + lastOrderSnNumber;
	}
}
