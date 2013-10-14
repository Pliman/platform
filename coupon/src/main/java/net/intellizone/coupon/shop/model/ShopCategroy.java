/*
 * ShopCategroy.java 2012-3-12
 * 智域工作室
 */
package net.intellizone.coupon.shop.model;

import java.util.List;

import net.intellizone.coupon.city.model.City;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.ManyMany;

import org.nutz.dao.entity.annotation.Table;

/**
 * 商店分类（属性）实体
 * 
 * @author mass
 * @version 1.0
 * @since coupon 1.0
 */
@Table("iz_shop_categories")
public class ShopCategroy {
	@Id
	private int category_id;
	private int p_category_id;
	private String category_name;
	private String category_desc;
	private byte sysflag;
	private byte isvisible;
	private String belongCity;

	@ManyMany(target = City.class, relation = "iz_city_shop_category", from = "shop_category_id", to = "city_id")
	private List<City> CityList;

	@Many(target = ShopCategroy.class, field = "p_category_id")
	private List<ShopCategroy> shopCategoryList;

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setP_category_id(int p_category_id) {
		this.p_category_id = p_category_id;
	}

	public int getP_category_id() {
		return p_category_id;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_desc(String category_desc) {
		this.category_desc = category_desc;
	}

	public String getCategory_desc() {
		return category_desc;
	}

	public void setSysflag(byte sysflag) {
		this.sysflag = sysflag;
	}

	public byte getSysflag() {
		return sysflag;
	}

	public void setIsvisible(byte isvisible) {
		this.isvisible = isvisible;
	}

	public byte getIsvisible() {
		return isvisible;
	}

	public void setShopCategoryList(List<ShopCategroy> shopCategoryList) {
		this.shopCategoryList = shopCategoryList;
	}

	public List<ShopCategroy> getShopCategoryList() {
		return shopCategoryList;
	}

	public List<City> getCityList() {
		return CityList;
	}

	public void setCityList(List<City> cityList) {
		CityList = cityList;
	}

	public String getBelongCity() {
		return belongCity;
	}

	public void setBelongCity(String belongCity) {
		this.belongCity = belongCity;
	}
	
	
}
