/*
 * Terminal.java 2012-1-
 */
package net.intellizone.coupon.terminal.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 终端实体类
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Table("iz_terminal")
public class Terminal {
	// 主键id
	@Column("id")
	@Id(auto = false)
	private long id;
	
	// 终端版本
	@Column("terminal_id")
	private String terminalId;

	// 终端版本
	@Column("terminal_version")
	private String version;

	// 终端地址id
	@Column("terminal_addr_id")
	private int addrId;
	
	@Column("last_active_time")
	private long lastActiveTime;
	
	@Column("status")
	private int status;
	
	@Column("code")
	private int code;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public long getLastActiveTime() {
		return lastActiveTime;
	}

	public void setLastActiveTime(long lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
