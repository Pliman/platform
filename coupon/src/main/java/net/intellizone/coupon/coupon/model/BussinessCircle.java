package net.intellizone.coupon.coupon.model;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("iz_busscircl")
public class BussinessCircle {
	@Id
	private int id;
	private String bc_name;
	private String bc_description;
	private int belong_city;
	private byte isvisible;
	private int sysflag;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setBc_name(String bc_name) {
		this.bc_name = bc_name;
	}
	public String getBc_name() {
		return bc_name;
	}
	public void setBc_description(String bc_description) {
		this.bc_description = bc_description;
	}
	public String getBc_description() {
		return bc_description;
	}
	public void setBelong_city(int belong_city) {
		this.belong_city = belong_city;
	}
	public int getBelong_city() {
		return belong_city;
	}
	public void setSysflag(int sysflag) {
		this.sysflag = sysflag;
	}
	public int getSysflag() {
		return sysflag;
	}
	public void setIsvisible(byte isvisible) {
		this.isvisible = isvisible;
	}
	public byte getIsvisible() {
		return isvisible;
	}

}
