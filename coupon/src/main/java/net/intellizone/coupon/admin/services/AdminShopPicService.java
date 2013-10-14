package net.intellizone.coupon.admin.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.shop.model.Shop;
import net.intellizone.coupon.shop.model.ShopPic;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;
@Service
public class AdminShopPicService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public AdminShopPicService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	// 取得所有商户数据
	public List<Shop> getShop() {
		return dao.query(Shop.class, null, null);
	}
	
	
	public int deleteShopPicById(long l){
		
		return dao.delete(ShopPic.class, l);
		
	}
	
}
