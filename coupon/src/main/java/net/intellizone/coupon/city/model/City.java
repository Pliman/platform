package net.intellizone.coupon.city.model;

import java.util.List;

import net.intellizone.coupon.shop.model.ShopCategroy;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Table;

@Table("iz_city")
public class City {
	// 主键id

	@Id(auto = true)
	private long id;
	@Column("country")
	private String country;
	@Column("province")
	private String province;
	@Column("city")
	private String city;
	@Column("isvisible")
	private int isvisible;

	@ManyMany(target = ShopCategroy.class, relation = "iz_city_shop_category", from = "city_id", to = "shop_category_id")
	private List<ShopCategroy> shopCategoryList;
	
	public List<ShopCategroy> getShopCategoryList() {
		return shopCategoryList;
	}

	public void setShopCategoryList(List<ShopCategroy> shopCategoryList) {
		this.shopCategoryList = shopCategoryList;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return province;
	}

	public void setIsvisible(int isvisible) {
		this.isvisible = isvisible;
	}

	public int getIsvisible() {
		return isvisible;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

}
