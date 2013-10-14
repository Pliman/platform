/*
 * MMS.java 2012-3-13
 * 智域工作室
 */
package net.intellizone.coupon.msg.model;

import java.util.List;

/**
 * 彩信类
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
public class MMS {
	private String content;

	private List<String> attachmentList;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<String> attachmentList) {
		this.attachmentList = attachmentList;
	}
}
