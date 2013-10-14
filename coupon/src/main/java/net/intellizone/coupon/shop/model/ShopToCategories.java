package net.intellizone.coupon.shop.model;

import java.util.List;


import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;
@Table("iz_shop_shop_category")
public class ShopToCategories {
	// 主键id
	@Column("SHOP_CATEGORY_ID")
	@Id(auto = true)
	private long shop_category_id; 
	@Column("SHOP_ID")
	private long shop_id;
	
	@ManyMany(target = ShopCategroy.class, relation = "iz_shop", from = "CATEGORY_ID", to = "SHOP_ID")
	private List<Shop> shopList;
	
	
	
	
	public long getShop_category_id() {
		return shop_category_id;
	}
	public void setShop_category_id(long shopCategoryId) {
		shop_category_id = shopCategoryId;
	}
	public long getShop_id() {
		return shop_id;
	}
	public void setShop_id(long shopId) {
		shop_id = shopId;
	}
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long categoryId) {
		category_id = categoryId;
	}
	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
	public List<Shop> getShopList() {
		return shopList;
	}
	@Column("CATEGORY_ID")
	private long category_id;



}
