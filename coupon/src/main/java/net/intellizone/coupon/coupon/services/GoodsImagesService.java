package net.intellizone.coupon.coupon.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.coupon.model.GoodsImages;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;
@Service
public class GoodsImagesService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public GoodsImagesService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	public List<GoodsImages> getAllGoodsImages(){
		
		return dao.query(GoodsImages.class, null, null);	
	}
	
}
