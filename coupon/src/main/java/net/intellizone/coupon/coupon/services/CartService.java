package net.intellizone.coupon.coupon.services;

import java.util.List;

import net.intellizone.coupon.coupon.model.Cart;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	// nutz dao
	private Dao dao;

	// 初始化数据源
	public CartService() {
		dao = new NutDao(MysqlDataSourceManager.INSTANCE.getDataSource());
	}

	public List<Cart> getAllCart() {
		return dao.query(Cart.class, null, null);
	}

	public Cart getCartById(long id) {
		Cart cart = dao.fetch(Cart.class, id);

		dao.fetchLinks(cart, "user");
		dao.fetchLinks(cart, "goods");
		return cart;
	}

	public int deleteCartById(long l) {
		return dao.delete(Cart.class, l);
	}

	public Cart insertObj(Cart cart) {
		return dao.insert(cart);
	}

	public int updateObj(Cart cart) {
		return dao.update(cart);
	}

	/**
	 * 分页查询用户收藏的优惠券
	 * @param userId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public QueryResult getCartByUserIdGoods(long userId,int pageNumber,int pageSize,int bc,int cat,String name){

		List<Cart> list = null;
		
		
	    StringBuffer SEARCH_COUPON = new StringBuffer("select * from iz_cart a left join iz_goods b on a.goods_id=b.id where a.user_id=@user_id"); 
		if(cat!=0){
		    SEARCH_COUPON.append(" and b.belong_cat=@cat");
		}
		if(bc!=0){
	    SEARCH_COUPON.append(" and b.belong_bc=@bc");
		}
		if(null!=name&&!"".equals(name)){
	    SEARCH_COUPON.append(" and b.name like @name");
		}
	    SEARCH_COUPON.append(" order by id desc limit @start,@end ");

		
		Sql sql = Sqls.create(String.format(SEARCH_COUPON.toString()));

		sql.params().set("name", "%" + name + "%");

		sql.params().set("bc", bc);


		sql.params().set("cat", cat);
	
		sql.params().set("user_id", userId);
		//sql.params().set("now", System.currentTimeMillis());
		sql.params().set("start", (pageNumber - 1) * pageSize);
		sql.params().set("end", pageNumber * pageSize);

		sql.setCallback(Sqls.callback.entities());
		
		
		sql.setCallback(Sqls.callback.entities());
		Entity<Cart> entity = dao.getEntity(Cart.class);
		sql.setEntity(entity);

		dao.execute(sql);

		list= sql.getList(Cart.class);
		dao.fetchLinks(list, "goods");
		sql.setCallback(Sqls.callback.integer());
		Pager pager = dao.createPager(pageNumber, pageSize);
		pager.setRecordCount(this.getRecCount(userId, pageNumber, pageSize, bc, cat, name));
		pager.setPageSize(pageSize);
		pager.setPageNumber(pageNumber);
		QueryResult queryObj=new QueryResult();
		queryObj.setList(list);
		queryObj.setPager(pager);
		return queryObj;
		
	}
	
	
	
	/**
	 * 获取总记录数
	 * 
	 * @param shop
	 *            店铺名
	 * @param type
	 *            分类名
	 * @return 总记录数
	 */
	public int getRecCount(long userId,int pageNumber,int pageSize,int bc,int cat,String name) {
		
	    StringBuffer SEARCH_COUPON = new StringBuffer("select count(*) from iz_cart a left join iz_goods b on a.goods_id=b.id where a.user_id=@user_id"); 
		if(cat!=0){
		    SEARCH_COUPON.append(" and b.belong_cat=@cat");
		}
		if(bc!=0){
	    SEARCH_COUPON.append(" and b.belong_bc=@bc");
		}
		if(null!=name&&!"".equals(name)){
	    SEARCH_COUPON.append(" and b.name like @name");
		}
		 SEARCH_COUPON.append(" order by id desc");

		
		Sql sql = Sqls.create(String.format(SEARCH_COUPON.toString()));
		
		
		sql.params().set("name", "%" + name + "%");

		sql.params().set("bc", bc);


		sql.params().set("cat", cat);
	
		sql.params().set("user_id", userId);
		sql.setCallback(Sqls.callback.integer());

		dao.execute(sql);

		return sql.getInt();
	}

	
	/**
	 * 根据用户和商品获取收藏
	 * 
	 * @param userId
	 *            用户
	 * @param goodsId
	 *            商品
	 * @return 收藏
	 */
	public Cart getCartbyUserAndGoods(long userId, long goodsId) {
		Cart cart = dao.fetch(Cart.class, Cnd.where("userId", "=", userId).and("goodsId", "=",
				goodsId));

		dao.fetchLinks(cart, "user");
		dao.fetchLinks(cart, "goods");

		return cart;
	}
	
	public static void main(String[] args) {
		CartService service = new CartService();
		service.getCartByUserIdGoods(1, 1, 10, 0, 0, "");
	}
}
