package net.intellizone.coupon.shop.model;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("iz_shoppic")
public class ShopPic {
	@Id
	private int id;
	private int shop_id;
	private String url;
	private int ismain;
	private int sysflag;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public void setIsmain(int ismain) {
		this.ismain = ismain;
	}
	public int getIsmain() {
		return ismain;
	}
	public void setSysflag(int sysflag) {
		this.sysflag = sysflag;
	}
	public int getSysflag() {
		return sysflag;
	}

}
