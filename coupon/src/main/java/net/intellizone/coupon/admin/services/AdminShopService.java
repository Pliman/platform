package net.intellizone.coupon.admin.services;

import java.util.List;

import javax.sql.DataSource;

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
public class AdminShopService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public AdminShopService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	// 取得所有商户数据
	public List<Shop> getShop() {
		return dao.query(Shop.class, null, null);
	}
	
	/**
	 * 根据IDLIST 查询商户
	 * @param idList
	 * @return
	 */
	public List<Shop> getShopByIdList(List<String> idList){
		if(idList==null)return null;
		return dao.query(Shop.class, Cnd.where("id", "in", idList), null);
	}

	/**
	 * 商户分页总方法
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param cat
	 * @param bc
	 * @param wd
	 * @return
	 */

	public QueryResult getAllAllShopCatBykeyIdPagination(int pageNumber,
			int pageSize, int cat, int bc, String wd) {
		List<Shop> list = null;
		Condition c = null;

		if (cat == 0 && bc != 0) {
			if (null != wd && !"".equals(wd)) {
				c = Cnd.where("belong_bc", "=", bc).and("name", "like",
						"%" + wd + "%").desc("id");
			} else {
				c = Cnd.where("belong_bc", "=", bc).desc("id");
			}
		} else if (cat == 0 && bc == 0) {
			if (null != wd && !"".equals(wd)) {
				c = Cnd.where("name", "like", "%" + wd + "%").desc("id");
			} else {
				// c=Cnd.where("p_id","=",0).desc("id");
			}
		} else if (cat != 0 && bc == 0) {
			if (null != wd && !"".equals(wd)) {
				c = Cnd.where("belong_shopcat", "like", "%" + cat + "%").and(
						"name", "like", "%" + wd + "%").desc("id");
			} else {
				c = Cnd.where("belong_shopcat", "like", "%" + cat + "%").desc(
						"id");
			}
		} else {
			if (null != wd && !"".equals(wd)) {
				c = Cnd.where("belong_shopcat", "like", "%" + cat + "%").and(
						"name", "like", "%" + wd + "%").and("belong_bc", "=",
						bc).desc("id");
			} else {
				c = Cnd.where("belong_shopcat", "like", "%" + cat + "%").and(
						"belong_bc", "=", bc).desc("id");
			}
		}

		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Shop.class, c, pager);
		dao.fetchLinks(list, "branchShopList");
		pager.setRecordCount(dao.count(Shop.class, c));
		return new QueryResult(list, pager);
	}

	/**
	 * 商户分页总方法
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param cat
	 * @param bc
	 * @param wd
	 * @return
	 */
	public QueryResult getAllShopCatBykeyIdPagination(int pageNumber,
			int pageSize, int cat, int bc, String wd, int searchCondition,long begin_time,long end_time) {
		List<Shop> list = null;
		Condition c = null;
		String name = wd.trim();
		/**
		 * searchCondition 查询条件：1-ID 2-名称 3-状态 4-时间
		 * */
		if (searchCondition == 0) {

			if (cat == 0 && bc != 0) {
				if (null != wd && !"".equals(wd)) {
					c = Cnd.where("belong_bc", "=", bc)
							.and("name", "like", "%" + name + "%").desc("id");
				} else {
					c = Cnd.where("belong_bc", "=", bc)
							.desc("id");

				}
			} else if (cat == 0 && bc == 0) {
				c = Cnd.where("name", "like",
						"%" + name + "%").desc("id");
			} else if (cat != 0 && bc == 0) {
				if (null != wd && !"".equals(wd)) {
					c = Cnd.where("belong_shopcat", "like", "%" + cat + "%")
							.and("name", "like",
									"%" + name + "%").desc("id");
				} else {
					c = Cnd.where("belong_shopcat", "like", "%" + cat + "%")
							.desc("id");
				}
			} else {
				if (null != wd && !"".equals(wd)) {
					c = Cnd.where("belong_shopcat", "like", "%" + cat + "%")
							.and("name", "like",
									"%" + name + "%").and("belong_bc", "=", bc)
							.desc("id");
				} else {
					c = Cnd.where("belong_shopcat", "like", "%" + cat + "%")
							.and("belong_bc", "=", bc)
							.desc("id");
				}
			}
		} else {
			if (searchCondition == 1) {
				c = Cnd.where("id", "like", "%" + name + "%").desc("id");
			}
			if (searchCondition == 2) {
				c = Cnd.where("name", "like", "%" + name + "%").desc("id");
			}
			if (searchCondition == 3) {
				c = Cnd.where("isverified", "=", name)
						.desc("id");
			}
			if (searchCondition == 4) {
				Cnd cnd = null;
				if(begin_time!=0 ){
					c = Cnd.where("modify_time", ">=",begin_time);
				}else if(end_time!=0){
					c = cnd.and("modify_time","<=",end_time).desc("id");
				}else{
					c = Cnd.where("modify_time","like","%"+begin_time+"%");
				}
			}
		}
		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Shop.class, c, pager);
		dao.fetchLinks(list, "branchShopList");
		pager.setRecordCount(dao.count(Shop.class, c));
		return new QueryResult(list, pager);
	}

	/**
	 * 根据总商户获取分店
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param pid
	 * @return
	 */
	public QueryResult getShopParentIdPagination(int pageNumber, int pageSize,
			int pid) {
		Cnd cnd = Cnd.where("p_id", "=", pid);
		Pager pager = dao.createPager(pageNumber, pageSize);
		List<Shop> list = dao.query(Shop.class, cnd, null);
		// dao.fetchLinks(list, "shopList");
		pager.setRecordCount(dao.count(Shop.class, cnd));
		return new QueryResult(list, pager);
	}

	/*
	 * *通过id取得商户
	 */
	public Shop getShopById(int id) {
		Shop shop = dao.fetch(Shop.class, id);
		dao.fetchLinks(shop, "couponList");
		dao.fetchLinks(shop, "shopPicList");
		dao.fetchLinks(shop, "pshop");
		dao.fetchLinks(shop, "city");
		return shop;
	}

	// 获取指定商圈商户信息
	public List<Shop> getShopByCatebusscircId(int id) {
		return dao.query(Shop.class, Cnd.where("BELONG_BC", "=", id), null);
	}

	/*
	 * *通过热门取得商户
	 */
	public List<Shop> getShopByHotList() {
		List<Shop> hotshopList = dao.query(Shop.class, Cnd.where("is_hot", "=",
				1), null);
		return hotshopList;
	}

	/*
	 * *通过热门取得商户
	 */
	public List<Shop> getShopByRecommendList() {
		List<Shop> recomshopList = dao.query(Shop.class, Cnd.where("isremmend",
				"=", 1), null);
		return recomshopList;
	}

	public int deleteShopById(long l) {
		return dao.delete(Shop.class, l);

	}

	/**
	 * 批量删除商户
	 * 
	 * @param idList
	 * @return
	 */
	public int batchDelShop(int[] idList) {
		return dao.clear(Shop.class, Cnd.where("id", "in", idList));
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

	/** 审核状态更新* */
	public int checkObjById(int id, int isverified, String audit_reason) {
		Shop shop = dao.fetch(Shop.class, id);
		shop.setIsverified((byte) isverified);
		shop.setAudit_reason(audit_reason);
		return dao.update(shop);
	}

	public List<Shop> get4HotShop() {
		String sqlStr = "select s.* from iz_shop s where s.IS_HOT=1 limit 0,4";

		Sql sql = Sqls.create(sqlStr);
		sql.setCallback(Sqls.callback.entities());
		Entity<Shop> shopEntity = dao.getEntity(Shop.class);
		sql.setEntity(shopEntity);

		return sql.getList(Shop.class);
	}

	public List<Shop> get4RecShop() {
		String sqlStr = "select s.* from iz_shop s where s.IS_RECOMMEND=1 limit 0,4";

		Sql sql = Sqls.create(sqlStr);
		sql.setCallback(Sqls.callback.entities());
		Entity<Shop> shopEntity = dao.getEntity(Shop.class);
		sql.setEntity(shopEntity);

		return sql.getList(Shop.class);
	}
}
