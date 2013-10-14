package net.intellizone.coupon.coupon.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;


@Table("iz_goodsimg")
public class GoodsImages {
	@Id
	private int id;
	@Column("goods_id")
	private int goods_id;
	@Column("url")
	private String url;
	@Column("publishman")
	private String publishman;
	@Column("isvalid")
	private int isvalid;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}

	public void setPublishman(String publishman) {
		this.publishman = publishman;
	}
	public String getPublishman() {
		return publishman;
	}
	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}
	public int getIsvalid() {
		return isvalid;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getGoods_id() {
		return goods_id;
	}

}
