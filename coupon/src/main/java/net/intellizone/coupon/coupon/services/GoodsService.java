package net.intellizone.coupon.coupon.services;

import java.util.List;

import javax.sql.DataSource;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Criteria;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Service;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.db.MysqlDataSourceManager;

@Service
public class GoodsService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public GoodsService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	public List<Goods> getAllGoods() {

		return dao.query(Goods.class, null, null);
	}

	public List<Goods> getAllGoodsByType(int type) {

		return dao.query(Goods.class, null, null);
	}

	/**
	 * 查询商品
	 * 
	 * @param id
	 * @return
	 */
	public Goods getGoodsById(long id) {
		Goods goods = dao.fetch(Goods.class, id);
		dao.fetchLinks(goods, "goodsImages");
		dao.fetchLinks(goods, "belongShopObj");
		return goods;
	}
	
	/**
	 * 根据编码查询商品
	 * 
	 * @param code
	 *            商品编码
	 * @return 商品
	 */
	public Goods getGoodsByCode(int code) {
		Goods goods = dao.fetch(Goods.class, Cnd.where("code", "=", code));
		return goods;
	}

	
	/**
	 * 优惠券查询总方法
	 * 
	 * @param goodstype
	 * @param pageNumber
	 * @param pageSize
	 * @param cat
	 * @param bc
	 * @param name
	 * @return
	 */
	public QueryResult getAllGoodsByTypeAndkeyIdAndKeyWordsPagination(int goodstype,
			int pageNumber, int pageSize, int cat, int bc, String name, int order,int belong_city) {
		long now = System.currentTimeMillis();
		
		String orderConditon = "id"; // 排序，默认根据ID
		if (order == 1) {
			orderConditon = "modify_time";
		} else if (order == 2) {
			orderConditon = "name";
		}
		
		Criteria c = Cnd.cri();
		
		if(bc != 0){
			c.where().and("belong_bc", "=", bc);
		}
		if(goodstype != 0){
			c.where().and("cat_type", "=", goodstype);
		}
		if(null != name && !"".equals(name)){
			c.where().and("name", "like", "%"+name + "%");
		}
		if(cat != 0){
			c.where().and("belong_cat", "=", cat);
		}
		
		c.where().and("belong_city", "=", belong_city).and("goods_status", "=",1).and("begin_time", "<", now).and("end_time", ">", now);
		
		c.getOrderBy().desc(orderConditon);
		
		Pager pager = dao.createPager(pageNumber, pageSize);
		List<Goods> list = dao.query(Goods.class, c, pager);
		if (list == null) {
			return null;
		}
		dao.fetchLinks(list, "goodsImages");
	
		pager.setRecordCount(dao.count(Goods.class, c));
		return new QueryResult(list, pager);
	}

	/**
	 * 删除商品通过ID
	 * 
	 * @param l
	 * @return
	 */
	public int deleteGoodsById(long l) {

		return dao.delete(Goods.class, l);

	}

	/**
	 * 添加商品
	 * 
	 * @param goods
	 * @return
	 */
	public Goods insertObj(Goods goods) {
		return dao.insert(goods);
	}

	/**
	 * 添加商品图片
	 * 
	 * @param goods
	 * @return
	 */
	public Goods insertLink(Goods goods) {
		return dao.insertLinks(goods, "goodsImages");
	}

	/**
	 * 更新商品
	 * 
	 * @param goods
	 * @return
	 */
	public int updateObj(Goods goods) {
		return dao.update(goods);
	}
	
	
	public List<Goods> getPayGoods(int size){
		String sqlStr = "select * from iz_goods  ORDER BY rand() limit "+size;
		Sql sql = Sqls.create(sqlStr);
		sql.setCallback(Sqls.callback.entities());
		Entity<Goods> goodsEntity  = dao.getEntity(Goods.class);
		sql.setEntity(goodsEntity);
		dao.execute(sql);
		return sql.getList(Goods.class);
	}
}
