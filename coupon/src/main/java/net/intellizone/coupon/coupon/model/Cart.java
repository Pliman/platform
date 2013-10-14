package net.intellizone.coupon.coupon.model;

import net.intellizone.coupon.user.model.User;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("iz_cart")
public class Cart {
	@Id
	@Column("CART_ID")
	private long id;
	@Column("USER_ID")
	private long userId;
	@Column("GOODS_ID")
	private long goodsId;
	@Column("GOODS_NUM")
	private int goodsNum;
	@Column("ADD_TIME")
	private long addTime;
	
	@One(target = User.class, field = "userId")
	private User user;
	
	@Column("SYSFLAG")
	private long sysflag;
	
	@Column("cart_type")
	private byte cart_type;
	
	@Column("cart_status")
	private byte cart_status;
	
	@One(target = Goods.class, field = "goodsId")
	private Goods goods;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public long getAddTime() {
		return addTime;
	}

	public void setAddTime(long addTime) {
		this.addTime = addTime;
	}

	public long getSysflag() {
		return sysflag;
	}

	public void setSysflag(long sysflag) {
		this.sysflag = sysflag;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setCart_type(byte cart_type) {
		this.cart_type = cart_type;
	}

	public byte getCart_type() {
		return cart_type;
	}

	public void setCart_status(byte cart_status) {
		this.cart_status = cart_status;
	}

	public byte getCart_status() {
		return cart_status;
	}
}
