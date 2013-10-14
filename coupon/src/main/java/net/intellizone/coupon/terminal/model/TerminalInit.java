package net.intellizone.coupon.terminal.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TerminalInit {
	private String heartbeat;
	private String auth;
	private String coupon;
	private String printlog;
	private String upload;
	private String alarm;

	private String url;
	private String logoconfirm;
	private String printconfirm;

	public void setHeartbeat(String heartbeat) {
		this.heartbeat = heartbeat;
	}

	public String getHeartbeat() {
		return heartbeat;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getAuth() {
		return auth;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setPrintlog(String printlog) {
		this.printlog = printlog;
	}

	public String getPrintlog() {
		return printlog;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public String getUpload() {
		return upload;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

	public String getAlarm() {
		return alarm;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setLogoconfirm(String logoconfirm) {
		this.logoconfirm = logoconfirm;
	}

	public String getLogoconfirm() {
		return logoconfirm;
	}

	public void setPrintconfirm(String printconfirm) {
		this.printconfirm = printconfirm;
	}

	public String getPrintconfirm() {
		return printconfirm;
	}

}
