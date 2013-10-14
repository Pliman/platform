/*
 * User.java 2012-1-12
 * 智域工作室
 */
package net.intellizone.coupon.user.model;

import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

/**
 * User实体类
 * 
 * @author Pliman
 * @version 1.0 2012-1-12
 * @since User 1.0
 */
@Table("iz_user")
public class User {
	@Column("USER_ID")
	@Prev(@SQL(db = DB.MYSQL, value = "select MAX(USER_ID) from iz_user"))
	@Id
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

	@Column("REG_TIME")
	private long regTime;

	@Column("MODIFY_TIME")
	private long modifyTime;

	@Column("LAST_VISIT")
	private long lastVisit;

	@Column("SYSFLAG")
	private int sysFlag;

	@Column("is_wings_pay_user")
	private int isWingsPayUser;

	@Column("is_i_promote_user")
	private int isIPromoteUser;

	@Column("user_addr")
	private String userAddr;

	@Column("last_session_id")
	private String lastSessionId;
	
	@Column("puserid")
	private String pUserID;
	
	@Column("provinceid")
	private String provinceID;
	
	@Column("numflag")
	private String numFlag;
	
	@Column("id_type")
	private String idType;
	
	@Column("cert_num")
	private String certNum;
	
	@Column("product_no")
	private String productNo;
	
	@Column("custom_no")
	private String customNo;
	
	@Column("card_no")
	private String cardNo;

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getPayPass() {
		return payPass;
	}

	public void setPayPass(String payPass) {
		this.payPass = payPass;
	}

	public int getIsWingsPayUser() {
		return isWingsPayUser;
	}

	public void setIsWingsPayUser(int isWingsPayUser) {
		this.isWingsPayUser = isWingsPayUser;
	}

	public int getIsIPromoteUser() {
		return isIPromoteUser;
	}

	public void setIsIPromoteUser(int isIPromoteUser) {
		this.isIPromoteUser = isIPromoteUser;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getLastSessionId() {
		return lastSessionId;
	}

	public void setLastSessionId(String lastSessionId) {
		this.lastSessionId = lastSessionId;
	}

	public String getPUserID() {
		return pUserID;
	}

	public void setPUserID(String userID) {
		pUserID = userID;
	}

	public String getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(String provinceID) {
		this.provinceID = provinceID;
	}

	public String getNumFlag() {
		return numFlag;
	}

	public void setNumFlag(String numFlag) {
		this.numFlag = numFlag;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getCertNum() {
		return certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getCustomNo() {
		return customNo;
	}

	public void setCustomNo(String customNo) {
		this.customNo = customNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}
