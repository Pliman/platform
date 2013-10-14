package net.intellizone.coupon.admin.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 系统参数配置
 * */
@Table("iz_sys_param")
public class SysParam {
	@Id
	private int id;
	@Column("code")
	private String code;
	@Column("name")
	private String name;
	@Column("description")
	private String description;
	@Column("value")
	private String value;
	@Column("sysflag")
	private int sysflag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getSysflag() {
		return sysflag;
	}
	public void setSysflag(int sysflag) {
		this.sysflag = sysflag;
	}
	
	
	
}
