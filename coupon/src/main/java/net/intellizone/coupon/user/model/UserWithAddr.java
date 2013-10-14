/*
 * UserWithAddr.java 2012-1-12
 * 智域工作室
 */
package net.intellizone.coupon.user.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * User实体类带地址
 * 
 * @author Pliman
 * @version 1.0 2012-1-12
 * @since User 1.0
 */
@Table("iz_user")
public class UserWithAddr {
	@Column("USER_ID")
	private long id;

	@Column("USER_NAME")
	private String name;

	@Column("PASSWORD")
	private String password;
	
	@Column("pay_pass")
	private String payPass;
	
	@Column("USER_NO")
	private String userNo; 

	@Column("NICK_NAME")
	private String nick;

	@Column("SEX")
	private int sex;

	@Column("EMAIL")
	private String email;

	@Column("MOBILE")
	private long mobile;

	@Column("TEL")
	private String tel;

	@Column("ADDRESS_ID")
	private long addr;
	
	@Column("ADDR_DETAIL")
	private String addrStr;

	@Column("REG_TIME")
	private long regTime;

	@Column("MODIFY_TIME")
	private long modifyTime;

	@Column("LAST_VISIT")
	private long lastVisit;

	@Column("SYSFLAG")
	private int sysFlag;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getAddr() {
		return addr;
	}

	public void setAddr(long addr) {
		this.addr = addr;
	}

	public long getRegTime() {
		return regTime;
	}

	public void setRegTime(long regTime) {
		this.regTime = regTime;
	}

	public long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
	}

	public long getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(long lastVisit) {
		this.lastVisit = lastVisit;
	}

	public int getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(int sysFlag) {
		this.sysFlag = sysFlag;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddrStr() {
		return addrStr;
	}

	public void setAddrStr(String addrStr) {
		this.addrStr = addrStr;
	}

	public String getPayPass() {
		return payPass;
	}

	public void setPayPass(String payPass) {
		this.payPass = payPass;
	}
}
