package net.intellizone.coupon.admin.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.activity.model.Activity;
import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.shop.model.Shop;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;

@Service
public class AdminRecommendService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public AdminRecommendService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	
	/*
	 * *通过热门取得商户
	 */
	public List<Shop> getShopByHotList() {
		
		List<Shop> hotshopList = dao.query(Shop.class,Cnd.where("is_hot", "=", 1),null);

		return hotshopList;
	}
	
	/*
	 * *通过热门取得商户
	 */
	public List<Shop> getShopByRecommendList() {
		
		List<Shop> recomshopList = dao.query(Shop.class,Cnd.where("isremmend", "=", 1),null);

		return recomshopList;
	}
	/*
	 * *通过推荐取得优惠券
	 */
	public  List<Goods> getRecommendCoupon(){
		
		 List<Goods> recomGoodsList = dao.query(Goods.class,Cnd.where("is_recommend", "=", 1),null);

		return recomGoodsList;
		
	}
	
	/*
	 * *通过推荐取得活动
	 */
	public  List<Activity> getRecommendActivity(){
		
		 List<Activity> recomActivityList = dao.query(Activity.class,Cnd.where("is_recommend", "=", 1),null);

		return recomActivityList;
		
	}
	
	
	
}
