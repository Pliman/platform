package net.intellizone.coupon.shop.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.shop.model.Shop;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public ShopService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	// 取得所有商户数据
	public List<Shop> getShop() {
		return dao.query(Shop.class, null, null);
	}

	/**
	 * 获取Shop分页数据
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public QueryResult getAllShopsByPagination(int pageNumber, int pageSize) {
		List<Shop> list = null;

		Pager pager = dao.createPager(pageNumber, pageSize);
		pager.setRecordCount(dao.count(Shop.class, Cnd.where("isverified", "=", 1)));
		list = dao.query(Shop.class, Cnd.where("isverified", "=", 1).desc("id"), pager);
		if (list == null) {
			return null;
		}

		return new QueryResult(list, pager);
	}

	/**
	 * 商户搜索方法汇总
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param cat
	 * @param bc
	 * @param wd
	 * @param order
	 * @return
	 */

	public QueryResult getAllShopCatBykeyIdPagination(int pageNumber, int pageSize, int cat,
			int bc, String wd, int order,City city) {
		List<Shop> list = null;
		Condition c = null;
		String orderCondition = "id";// 排序条件
		if (order == 1) {
			orderCondition = "modify_time";
		} else if (order == 2) {
			orderCondition = "name";
		}

		if (cat == 0 && bc != 0) {
			if (null != wd && !"".equals(wd)) {
				c = Cnd.where("belong_bc", "=", bc).and("isverified", "=", 1).and("belong_city","=",city.getId()).and("name", "like",
						"%" + wd + "%").desc(orderCondition);
			} else {
				c = Cnd.where("belong_bc", "=", bc).and("isverified", "=", 1).and("belong_city","=",city.getId()).desc(orderCondition);
			}
		} else if (cat == 0 && bc == 0) {
			if (null != wd && !"".equals(wd)) {
				c = Cnd.where("name", "like", "%" + wd + "%").and("isverified", "=", 1).and("belong_city","=",city.getId()).desc(
						orderCondition);
			} else {
				c = Cnd.where("isverified", "=", 1).and("belong_city","=",city.getId()).desc(orderCondition);
			}
		} else if (cat != 0 && bc == 0) {
			if (null != wd && !"".equals(wd)) {
				c = Cnd.where("belong_shopcat", "like", "%" + cat + "%").and("isverified", "=", 1).and("belong_city","=",city.getId())
						.and("name", "like", "%" + wd + "%").desc(orderCondition);
			} else {
				c = Cnd.where("belong_shopcat", "like", "%" + cat + "%").and("isverified", "=", 1).and("belong_city","=",city.getId())
						.desc(orderCondition);
			}
		} else {
			if (null != wd && !"".equals(wd)) {
				c = Cnd.where("belong_shopcat", "like", "%" + cat + "%").and("isverified", "=", 1).and("belong_city","=",city.getId())
						.and("name", "like", "%" + wd + "%").and("belong_bc", "=", bc).desc(
								orderCondition);
			} else {
				c = Cnd.where("belong_shopcat", "like", "%" + cat + "%").and("isverified", "=", 1).and("belong_city","=",city.getId())
						.and("belong_bc", "=", bc).desc(orderCondition);
			}
		}

		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Shop.class, c, pager);
		// dao.fetchLinks(list, "shopList");
		pager.setRecordCount(dao.count(Shop.class, c));
		return new QueryResult(list, pager);
	}

	/*
	 * *通过id取得商户
	 */
	public Shop getShopById(long id) {
		Shop shop = dao.fetch(Shop.class, id);
		dao.fetchLinks(shop, "couponList");
		dao.fetchLinks(shop, "shopPicList");
		dao.fetchLinks(shop, "city");
		return shop;
	}

	// 获取指定商圈商户信息
	public List<Shop> getShopByCatebusscircId(int id) {
		return dao.query(Shop.class, Cnd.where("BELONG_BC", "=", id).and("isverified", "=", 1),
				null);
	}

	/*
	 * *通过热门取得商户
	 */
	public List<Shop> getShopByHotList() {
		List<Shop> hotshopList = dao.query(Shop.class, Cnd.where("is_hot", "=", 1).and(
				"isverified", "=", 1), null);
		return hotshopList;
	}

	/*
	 * *通过热门取得商户
	 */
	public List<Shop> getShopByRecommendList() {
		List<Shop> recomshopList = dao.query(Shop.class, Cnd.where("isremmend", "=", 1).and(
				"isverified", "=", 1), null);
		return recomshopList;
	}

	public int deleteShopById(long l) {
		return dao.delete(Shop.class, l);
	}

	public Shop insertObj(Shop shop) {
		return dao.insert(shop);
	}

	public int updateObj(Shop shop) {
		return dao.update(shop);
	}

	public Shop insertLink(Shop shop) {
		return dao.insertLinks(shop, "shopPicList");
	}

	public int deletLink(Shop shop) {
		return dao.deleteLinks(shop, "shopPicList");
	}

	/**
	 * 获取优惠劵商户
	 */
	public List<Shop> getCouponShop() {
		List<Shop> shopList = dao.query(Shop.class, Cnd.where("shop_type", "=", "2"), null);
		dao.fetchLinks(shopList, "couponList");
		dao.fetchLinks(shopList, "shopPicList");
		dao.fetchLinks(shopList, "city");

		return shopList;
	}
	
	
	/**
	 * 随机获取相关商户
	 * */
	public List<Shop> getRandomShop(int type,int id){
		
		String sqlStr = "SELECT * FROM iz_shop where BELONG_SHOPCAT='"+type+"'and isverified = 1" +
						" and id not in(select id from iz_shop where id="+id+") ORDER BY rand() LIMIT 5";

		Sql sql = Sqls.create(sqlStr);
		sql.setCallback(Sqls.callback.entities());
		Entity<Shop> shopEntity = dao.getEntity(Shop.class);
		sql.setEntity(shopEntity);
		dao.execute(sql);
		return sql.getList(Shop.class);
	}
}
