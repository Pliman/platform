package net.intellizone.coupon.admin.services;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

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

import net.intellizone.coupon.activity.model.Activity;
import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.shop.model.Shop;
import net.intellizone.coupon.usercenter.model.GoodsWithAddress;
import net.intellizone.db.MysqlDataSourceManager;

@Service
public class AdminGoodsService {
	// nutz dao
	private Dao dao;

	// 根据城市名称查询优惠劵
	private static final String GOODS_CAT_COUPON = "select g.*,s.city from iz_goods g inner join iz_city s on g.BELONG_CITY=s.id  where s.city like @cityName and g.cat_type = @goodstype order by id desc limit @start,@end";
	//根据城市名称查询优惠劵  总记录数
	private static final String GOODS_CAT_COUPONALL="select count(1) from iz_goods g inner join iz_city s on g.BELONG_CITY=s.id  where s.city like @cityName and g.cat_type = @goodstype";
	
	//根据优惠劵种类查询优惠劵
	private static final String GOODS_CAT_TYPE = "select * from iz_goods where cat_type = @goodstype and coupon_type like @cityName order by id desc limit @start,@end";
	//根据优惠劵种类查询优惠劵 总记录数
	private static final String GOODS_CAT_TYPEALL="select count(1) from iz_goods where cat_type = @goodstype and coupon_type like @cityName";
	
	//根据ID查询优惠劵
	private static final String GOODS_CAT_ID = "select * from iz_goods where cat_type = @goodstype and id like @cityName order by id desc limit @start,@end";
	//根据ID查询优惠劵 总记录数
	private static final String GOODS_CAT_IDALL="select count(1) from iz_goods where cat_type = @goodstype and id like @cityName";
	
	//根据名称查询优惠劵
	private static final String GOODS_CAT_NAME= "select * from iz_goods g where g.cat_type = @goodstype and g.name like @cityName order by id desc limit @start,@end";
	//根据名称查询优惠劵 总记录数
	private static final String GOODS_CAT_NAMEALL = "select count(1) from iz_goods g where g.cat_type = @goodstype and g.name like @cityName";
	
	//根据行业查询优惠劵
	private static final String GOODS_CAT = "select g.* from iz_goods g inner join iz_shop_categories s on g.BELONG_CAT = s.p_category_id where s.category_name like @cityName and g.cat_type = @goodstype order by id desc limit @start,@end";
	//根据行业查询优惠劵 总记录数
	private static final String GOODS_CATALL = "select count(1) from  iz_goods g inner join iz_shop_categories s on g.BELONG_CAT = s.p_category_id where s.category_name like @cityName and g.cat_type = @goodstype";
	// 初始化数据源
	public AdminGoodsService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	public List<Goods> getAllGoods() {

		return dao.query(Goods.class, null, null);
	}

	public List<Goods> getAllGoodsByType(int type) {

		return dao.query(Goods.class, null, null);
	}

	/***************************************************************************
	 * @param id
	 * @return
	 */
	public Goods getGoodsById(int id) {
		Goods goods = dao.fetch(Goods.class, id);
		dao.fetchLinks(goods, "goodsImages");
		dao.fetchLinks(goods, "belongShopObj");

		
		return goods;
	}
	
	/***
	 * 获得优惠券使用分店方法
	 * @param goods
	 * @return
	 */
	public List<Shop> getGoodsUseShopList(Goods goods){
		List<Shop> shopList=null;
		if(null!=goods){
		String branchShop=goods.getUse_branchshop();
		if(null!=branchShop&&!"".equals(branchShop)){
			String[] shopIdList=branchShop.split("-");
			if(shopIdList.length>0){
				shopList=dao.query(Shop.class,Cnd.where("id", "in", shopIdList), null);
			}
		}
		}
		return shopList;
	}

	
	/**
	 * 
	 * 首页优惠劵动态查询，根据修改时间，静态化
	 * @param page 页码
	 * @return 优惠劵
	 * **/
	
	public List<Goods> getAllGoodsByTime(int page){
		Pager pager = dao.createPager(page, 7);
		return dao.query(Goods.class, Cnd.where(null).desc("modify_time"), pager);
	}
	
	/**
	 * 优惠券查询总方法
	 * @param goodstype
	 * @param pageNumber
	 * @param pageSize
	 * @param cat
	 * @param bc
	 * @param name
	 * @return
	 */
	public QueryResult getAllGoodsByTypeAndkeyIdAndKeyWordsPagination(int goodstype,
			int pageNumber, int pageSize, int cat, int bc, String name) {
		List<Goods> list = null;
		Condition c = null;
		
			if (cat == 0 && bc != 0) {
				if(null!=name&&!"".equals(name)){
					c = Cnd.where("cat_type", "=", goodstype).and("belong_bc", "=", bc).and("name", "like",
						name + "%").desc("id");
				}else{
					c = Cnd.where("cat_type", "=", goodstype).and("belong_bc", "=", bc).desc("id");
				}
				
			} else if (cat == 0 && bc == 0) {
				if(null!=name&&!"".equals(name)){
					c = Cnd.where("cat_type", "=", goodstype).and("name", "like", name + "%").desc("id");
				}else{
					c = Cnd.where("cat_type", "=", goodstype).desc("id");
				}
			} else if (cat != 0 && bc == 0) {
				if(null!=name&&!"".equals(name)){
					c = Cnd.where("cat_type", "=", goodstype).and("belong_cat", "=", cat).and("name",
						"like", name + "%").desc("id");
				}else{
					c = Cnd.where("cat_type", "=", goodstype).and("belong_cat", "=", cat).desc("id");
				}
			} else {
				if(null!=name&&!"".equals(name)){
					c = Cnd.where("cat_type", "=", goodstype).and("belong_cat", "=", cat).and("belong_bc",
						"=", bc).and("name", "like", name + "%").desc("id");
				}else{
					c = Cnd.where("cat_type", "=", goodstype).and("belong_cat", "=", cat).and("belong_bc",
							"=", bc).desc("id");
				}
			}
		
		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Goods.class, c, pager);
		if (list == null) {
			return null;
		}
		dao.fetchLinks(list, "goodsImages");
		dao.fetchLinks(list, "belongCityObj");
		dao.fetchLinks(list, "belongShopObj");
		pager.setRecordCount(dao.count(Goods.class, c));
		return new QueryResult(list, pager);
	}
	
	//条件查询
	public List<Goods> getGoodsByCity(int goodstype,
		int pageNumber, int pageSize, int cat, int bc, String name,int ctype) {
		String wd=name.trim();
		List<Goods> list = null;
		Sql sql = null;
		if(ctype==1){ //城市
			sql = Sqls.create(GOODS_CAT_COUPON);
			sql.params().set("cityName", "%"+wd+"%");
			sql.params().set("goodstype", goodstype);
		}
		if(ctype == 2){//行业
			sql = Sqls.create(GOODS_CAT);
			sql.params().set("cityName", "%"+wd+"%");
			sql.params().set("goodstype", goodstype);
		}
		if(ctype == 3){//ID
			sql = Sqls.create(GOODS_CAT_ID);
			sql.params().set("goodstype",goodstype);
			sql.params().set("cityName", "%"+wd+"%");
		}
		if(ctype == 4){//种类
			if(wd.equals("折扣券")){
				wd = "1";
			}else if(wd.equals("代金券")){
				wd = "2";
			}
			sql = Sqls.create(GOODS_CAT_TYPE);
			sql.params().set("goodstype",goodstype);
			sql.params().set("cityName", "%"+wd+"%");
		}
		if(ctype == 5){//名称
			sql = Sqls.create(GOODS_CAT_NAME);
			sql.params().set("goodstype",goodstype);
			sql.params().set("cityName", "%"+wd+"%");
		}
		sql.params().set("start", (pageNumber - 1) * pageSize);
		sql.params().set("end", pageSize);
		sql.setCallback(Sqls.callback.entities());
		Entity<Goods> entity = dao.getEntity(Goods.class);
		sql.setEntity(entity);
		
		dao.execute(sql);
		list = sql.getList(Goods.class);
		dao.fetchLinks(list, "goodsImages");
		dao.fetchLinks(list, "belongCityObj");
		dao.fetchLinks(list, "belongShopObj");
		return list;
	}
	/**
	 * 总记录数
	 * */
	public int getCouponCount(int goodstype, String name,int ctype){
		String wd=name.trim();
		Sql sql = null;
		if(ctype==1){ //城市
			sql = Sqls.create(GOODS_CAT_COUPONALL);
			sql.params().set("cityName", "%"+wd+"%");
			sql.params().set("goodstype", goodstype);
		}
		if(ctype == 2){//行业
			sql = Sqls.create(GOODS_CATALL);
			sql.params().set("cityName", "%"+wd+"%");
			sql.params().set("goodstype", goodstype);
		}
		if(ctype == 3){//ID
			sql = Sqls.create(GOODS_CAT_IDALL);
			sql.params().set("goodstype",goodstype);
			sql.params().set("cityName", "%"+wd+"%");
		}
		if(ctype == 4){//种类
			if(wd.equals("折扣券")){
				wd = "1";
			}else if(wd.equals("代金券")){
				wd = "2";
			}
			sql = Sqls.create(GOODS_CAT_TYPEALL);
			sql.params().set("goodstype",goodstype);
			sql.params().set("cityName", "%"+wd+"%");
		}
		if(ctype == 5){//名称
			sql = Sqls.create(GOODS_CAT_NAMEALL);
			sql.params().set("goodstype",goodstype);
			sql.params().set("cityName", "%"+wd+"%");
		}
		sql.setCallback(Sqls.callback.integer());
		dao.execute(sql);
		return sql.getInt();
	}
	/**
	 * 根据id查询
	 * @param l
	 * @return
	 */
	public int deleteGoodsById(long l) {

		return dao.delete(Goods.class, l);

	}

	/**
	 * 添加商品
	 * @param goods
	 * @return
	 */
	public Goods insertObj(Goods goods) {
		return dao.insert(goods);
	}
	
	
	/**
	 * 添加商品图片
	 * @param goods
	 * @return
	 */
	public Goods insertLink(Goods goods){
		return dao.insertLinks(goods,"goodsImages");
	}
	public Goods updateLink(Goods goods){
		
		return dao.updateLinks(goods,null);
		
	}

	/**
	 * 更新商品
	 * @param goods
	 * @return
	 */
	public int updateObj(Goods goods) {
		return dao.update(goods);
	}
	
	/**
	 * 批量删除活动
	 * @param idList
	 * @return
	 */
	public int batchDelGoods(int[] idList){
		return dao.clear(Goods.class,Cnd.where("id", "in", idList));	
	}
	/**审核状态更新**/
	public  int checkObjById(int id,int goods_status,String audit_reason){
		Goods goods = dao.fetch(Goods.class,id);
		goods.setGoods_status((byte)goods_status);
		goods.setAudit_reason(audit_reason);
		return dao.update(goods);
	}
	public List<Goods> get4HotGoods() {
		String sqlStr = "select g.* from iz_goods g where g.IS_HOT=1 limit 0,4";

		Sql sql = Sqls.create(sqlStr);
		sql.setCallback(Sqls.callback.entities());
		Entity<Goods> goodsEntity = dao.getEntity(Goods.class);
		sql.setEntity(goodsEntity);

		return sql.getList(Goods.class);
	}

	public List<Goods> get4RecGoods() {
		String sqlStr = "select g.* from iz_goods g where g.IS_RECOMMEND=1 limit 0,4";

		Sql sql = Sqls.create(sqlStr);
		sql.setCallback(Sqls.callback.entities());
		Entity<Goods> goodsEntity = dao.getEntity(Goods.class);
		sql.setEntity(goodsEntity);

		return sql.getList(Goods.class);
	}
	
	public List<Goods> get8Goods() {
		String sqlStr = "select g.* from iz_goods g limit 0,8";

		Sql sql = Sqls.create(sqlStr);
		sql.setCallback(Sqls.callback.entities());
		Entity<Goods> goodsEntity = dao.getEntity(Goods.class);
		sql.setEntity(goodsEntity);

		return sql.getList(Goods.class);
	}
}
