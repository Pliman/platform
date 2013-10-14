package net.intellizone.coupon.admin.services;

import java.util.List;

import javax.sql.DataSource;


import net.intellizone.coupon.shop.model.ShopAdmin;

import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;
@Service
public class AdminShopAdminService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public AdminShopAdminService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	// 取得所有商户数据
	public List<ShopAdmin> getShopAdmin() {
		return dao.query(ShopAdmin.class, null, null);
	}
/*	//获取所有分类数据
	public List<ShopCategories> getShopCategories() {
		return dao.query(ShopCategories.class, null, null);
	}
	//获取所有商圈数据
	public List<BussinessCircle> getBussinessCircle() {
		return dao.query(BussinessCircle.class, null, null);
	}
*/
	
	// 获取指定商圈商户信息
	public List<ShopAdmin> getShopByCatebusscircId(int id) {
		
		return dao.query(ShopAdmin.class, Cnd.where("BELONG_BC", "=", id), null);
	}	
	//获取指定分类商户信息
}
