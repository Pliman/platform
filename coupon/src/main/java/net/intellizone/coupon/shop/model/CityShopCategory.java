package net.intellizone.coupon.shop.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * 城市对应类别 中间表
 * */
@Table("iz_city_shop_category")
public class CityShopCategory {

	@Column("city_sc_id")
	private int city_sc_id;
	@Column("shop_category_id")   //类别ID
	private int shop_category_id;
	@Column("city_id") 			 //城市ID
	private int city_id;
	
	
	public int getCity_sc_id() {
		return city_sc_id;
	}
	public void setCity_sc_id(int cityScId) {
		city_sc_id = cityScId;
	}
	public int getShop_category_id() {
		return shop_category_id;
	}
	public void setShop_category_id(int shopCategoryId) {
		shop_category_id = shopCategoryId;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int cityId) {
		city_id = cityId;
	}
	
	
}
