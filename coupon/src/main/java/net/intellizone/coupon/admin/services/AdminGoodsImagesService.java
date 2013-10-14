package net.intellizone.coupon.admin.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.coupon.model.GoodsImages;
import net.intellizone.coupon.shop.model.ShopPic;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;
@Service
public class AdminGoodsImagesService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public AdminGoodsImagesService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	public List<GoodsImages> getAllGoodsImages(){
		
		return dao.query(GoodsImages.class, null, null);	
	}
	
	public int deleteGoodsPicById(int l){
		
		return dao.delete(GoodsImages.class, l);
		
	}
	
}
