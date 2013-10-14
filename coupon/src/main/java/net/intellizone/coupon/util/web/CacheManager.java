package net.intellizone.coupon.util.web;



import java.util.List;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.coupon.services.ShopCategoryService;

import net.intellizone.coupon.shop.model.ShopCategroy;

/**
 * 统一查询类别
 * */
public class CacheManager {
	/**
	 * 获得类别
	 * */
	public static List<ShopCategroy> shopCatList;
	
	private static ShopCategoryService shopCategoryService = new ShopCategoryService();
	/**
	 * 初始化类别实现
	 * */
	public static List<ShopCategroy> getAllCat(City city){
		shopCatList=shopCategoryService.getCategroyListByCity(city);
		return shopCatList;
	}
	
	
	public static List<ShopCategroy> getShopCatList() {
		return shopCatList;
	}


	public static void setShopCatList(List<ShopCategroy> shopCatList) {
		CacheManager.shopCatList = shopCatList;
	}


	
	
}
