/*
 * CouponDemo.java
 * 智域工作室
 */
package net.intellizone.coupon.admin.model;

/**
 * 生成样券信息类
 * 
 * @author mass
 * @version 1.0
 */
public class CouponDemo {
	private String no;// 序列号
	private String shopLogoPath;// 商户logo
	private String title;// 标题(名称)
	private String yqMarkPath = ""; // 样卷水印路径
	//private String simpleDecs;// 简单介绍
	private String beginTime;// 开始时间
	private String endTime;// 截止时间
	private String userInfo;// 使用规则
	private String useAddress;// 使用地址
	private String telphone;
	// private String detailDesc;// 详细描述
	private String btmLogoPath;// 底部LOGO路径

	public void setNo(String no) {
		this.no = no;
	}

	public String getNo() {
		return no;
	}

	public void setBtmLogoPath(String btmLogoPath) {
		this.btmLogoPath = btmLogoPath;
	}

	public String getBtmLogoPath() {
		return btmLogoPath;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setUseAddress(String useAddress) {
		this.useAddress = useAddress;
	}

	public String getUseAddress() {
		return useAddress;
	}

	public String getShopLogoPath() {
		return shopLogoPath;
	}

	public void setShopLogoPath(String shopLogoPath) {
		this.shopLogoPath = shopLogoPath;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getYqMarkPath() {
		return yqMarkPath;
	}

	public void setYqMarkPath(String yqMarkPath) {
		this.yqMarkPath = yqMarkPath;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
}
