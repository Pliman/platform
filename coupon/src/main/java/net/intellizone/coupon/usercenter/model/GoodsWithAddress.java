/*
 * GoodsWithAddress.java 2012-1-16
 * 智域工作室
 */
package net.intellizone.coupon.usercenter.model;

import java.util.List;

import net.intellizone.coupon.coupon.model.GoodsImages;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Table;

/**
 * 带地址的商品对象
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Table("iz_goods")
public class GoodsWithAddress {
	@Id
	private int id;

	private String name;

	private String description;

	private String ercode;

	private String use_intro;

	private int cat_type;

	private String belong_bc;

	private String belong_cat;

	private String price;

	private int number;

	private long create_time;

	private long modify_time;

	private double x;

	private double y;

	private int belong_shop;

	private long begin_time;

	private long end_time;

	private String use_addr;

	private byte isvalid;

	private byte sysflag;

	private String default_pic;

	private String address;

	@Many(target = GoodsImages.class, field = "goods_id")
	private List<GoodsImages> goodsImages;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setCat_type(int cat_type) {
		this.cat_type = cat_type;
	}

	public int getCat_type() {
		return cat_type;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setModify_time(long modify_time) {
		this.modify_time = modify_time;
	}

	public long getModify_time() {
		return modify_time;
	}

	public void setIsvalid(byte isvalid) {
		this.isvalid = isvalid;
	}

	public byte getIsvalid() {
		return isvalid;
	}

	public void setSysflag(byte sysflag) {
		this.sysflag = sysflag;
	}

	public byte getSysflag() {
		return sysflag;
	}

	public void setGoodsImages(List<GoodsImages> goodsImages) {
		this.goodsImages = goodsImages;
	}

	public List<GoodsImages> getGoodsImages() {
		return goodsImages;
	}

	public void setUse_intro(String use_intro) {
		this.use_intro = use_intro;
	}

	public String getUse_intro() {
		return use_intro;
	}

	public void setErcode(String ercode) {
		this.ercode = ercode;
	}

	public String getErcode() {
		return ercode;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public void setBelong_bc(String belong_bc) {
		this.belong_bc = belong_bc;
	}

	public String getBelong_bc() {
		return belong_bc;
	}

	public void setBelong_cat(String belong_cat) {
		this.belong_cat = belong_cat;
	}

	public String getBelong_cat() {
		return belong_cat;
	}

	public void setBegin_time(long begin_time) {
		this.begin_time = begin_time;
	}

	public long getBegin_time() {
		return begin_time;
	}

	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}

	public long getEnd_time() {
		return end_time;
	}

	public void setUse_addr(String use_addr) {
		this.use_addr = use_addr;
	}

	public String getUse_addr() {
		return use_addr;
	}

	public void setBelong_shop(int belong_shop) {
		this.belong_shop = belong_shop;
	}

	public int getBelong_shop() {
		return belong_shop;
	}

	public void setDefault_pic(String default_pic) {
		this.default_pic = default_pic;
	}

	public String getDefault_pic() {
		return default_pic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
