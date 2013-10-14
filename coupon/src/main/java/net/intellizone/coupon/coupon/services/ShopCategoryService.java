package net.intellizone.coupon.coupon.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.shop.model.ShopCategroy;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;

@Service
public class ShopCategoryService {

	// nutz dao
	private Dao dao;

	// 初始化数据源
	public ShopCategoryService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	public List<ShopCategroy> getAllShopCategory() {
		return dao.query(ShopCategroy.class,null, null);
	}

	/**
	 * @param id
	 * @return
	 */
	public ShopCategroy getShopCategroyId(int id) {
		ShopCategroy shopCategroy = dao.fetch(ShopCategroy.class, id);
		return shopCategroy;
	}

	public int deleteShopCategroyById(long l) {
		return dao.delete(ShopCategroy.class, l);
	}

	public ShopCategroy insertObj(ShopCategroy shopCategroy) {
		return dao.insert(shopCategroy);
	}

	public int updateObj(ShopCategroy shopCategroy) {
		return dao.update(shopCategroy);
	}
	
	// 获取子类型
	public List<ShopCategroy> getSubShopCategroy(List<ShopCategroy> shopCategroyList){
		dao.fetchLinks(shopCategroyList, "shopCategoryList");
		
		return shopCategroyList;
	}
	
	// 获取子类型
	public List<ShopCategroy> getCategroyListByCity(City city){
		if(city==null)return null;
		dao.fetchLinks(city, "shopCategoryList");
		dao.fetchLinks(city.getShopCategoryList(), "shopCategoryList");//zhuangpei erji fenlei 
		return city.getShopCategoryList();
	}
}
