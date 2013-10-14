package net.intellizone.coupon.shop.model;

import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;
@Table("iz_shopadmin")
public class ShopAdmin {
	// 主键id
	@Column("id")
	@Prev(@SQL(db = DB.ORACLE, value = "select MAX(id) from iz_shopadmin"))
	@Id(auto = false)
	private long id;
	@Column("name")
	private String name;
	@Column("loginname")
	private String loginname;
	@Column("password")
	private String password;
	@Column("description")
	private String description;
	@Column("bc_id")
	private int bcid;
	@Column("status")
	private int status;
	@Column("isrecomed")
	private int isrecomed;
	@Column("shop_addr_id")
	private int address;
	@Column("phone")
	private String phone;
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
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBcid() {
		return bcid;
	}
	public void setBcid(int bcid) {
		this.bcid = bcid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsrecomed() {
		return isrecomed;
	}
	public void setIsrecomed(int isrecomed) {
		this.isrecomed = isrecomed;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
