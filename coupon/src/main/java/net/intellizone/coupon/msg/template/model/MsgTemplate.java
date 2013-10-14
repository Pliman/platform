/*
 * MsgTemplate.java 2012-2-6
 * 智域工作室
 */
package net.intellizone.coupon.msg.template.model;

import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

/**
 * 信息模板模型类
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Table("iz_msg_template")
public class MsgTemplate {
	// id

	@Id(auto = true)

	private int id;

	// 模板编码
	@Column("template_code")
	private String templateCode;

	// 模板内容
	@Column("template_content")
	private String templateContent;

	// 修改时间
	@Column("modify_time")
	private long modifyTime;

	// 修改者
	@Column("modifier")
	private int modifier;

	// 系统标识
	@Column("sysflag")
	private int sysFlag;

	// 简要描述
	@Column("description")
	private String description;
	
	//0为短信，2为彩信
	@Column("msg_flag")
	private byte msg_flag;
	
	@Column("title")
	private String title;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}

	public int getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(int sysFlag) {
		this.sysFlag = sysFlag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMsg_flag(byte msg_flag) {
		this.msg_flag = msg_flag;
	}

	public byte getMsg_flag() {
		return msg_flag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
