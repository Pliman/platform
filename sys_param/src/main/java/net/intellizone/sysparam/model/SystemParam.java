/*
 * SystemParam.java 2012-2-15
 * 智域工作室
 */
package net.intellizone.sysparam.model;

import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

/**
 * 系统参数模型
 * 
 * @author Pliman
 * @version 1.0
 * @since sys_param 1.0
 */
@Table("iz_sys_param")
public class SystemParam {
	@Id
	@Prev(@SQL(db = DB.MYSQL, value = "select MAX(id) from iz_sys_param"))
	@Column("id")
	private long id;

	@Column("code")
	private String code;

	@Column("name")
	private String name;

	@Column("description")
	private String description;

	@Column("value")
	private String value;

	@Column("sysFlag")
	private int sysFlag;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public int getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(int sysFlag) {
		this.sysFlag = sysFlag;
	}
}
