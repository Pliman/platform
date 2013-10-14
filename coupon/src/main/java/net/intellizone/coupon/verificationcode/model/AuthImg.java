/*
 * AuthImg.java 2012-4-6
 * 智域工作室
 */
package net.intellizone.coupon.verificationcode.model;

/**
 * 验证码类
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
public class AuthImg {
	// 当前的验证码
	private String content;

	// 验证码创建时间
	private long bornTime;
	
	public AuthImg(String content,long bornTime){
		this.content = content;
		this.bornTime = bornTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getBornTime() {
		return bornTime;
	}

	public void setBornTime(long bornTime) {
		this.bornTime = bornTime;
	}

}
