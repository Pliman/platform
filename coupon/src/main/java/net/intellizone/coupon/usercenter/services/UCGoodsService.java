/*
 * UCGoodsService.java 2012-1-16
 * 智域工作室
 */
package net.intellizone.coupon.usercenter.services;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.usercenter.model.GoodsWithAddress;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Service;

/**
 * 用户-优惠劵相关服务
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Service
public class UCGoodsService {
	// nutz dao
	private Dao dao;

	// 根据类别和商店名称查询优惠劵
	private static final String GOODS_CAT_SHOP = "select g.*,s.address from iz_goods g inner join iz_shop s on g.belong_shop=s.id inner join iz_order o on o.goods_id=g.id where s.name like @shopName and g.invalid_time >=@beginTime and g.invalid_time<=@endTime order by id desc limit @start,@end";
	// 查询总记录数
	private static final String TOTAL_PAGES = "select count(1) from iz_goods g inner join iz_shop s on g.belong_shop=s.id inner join iz_order o on o.goods_id=g.id where s.name like @shopName and g.invalid_time >=@beginTime and g.invalid_time<=@endTime";

	// 初始化数据源
	public UCGoodsService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	/**
	 * 按照店铺和分类，获取优惠劵
	 * @param goodsShop 店铺名
	 * @param goodsType 分类名
	 * @param pageSize 分页大小
	 * @param page 页码号
	 * @return 活动列表
	 */
	public List<GoodsWithAddress> getGoodsByShopAndTime(String goodsShop,
			long beginTime,long endTime, int pageSize, int page) {
		Sql sql = Sqls.create(GOODS_CAT_SHOP);
		sql.params().set("shopName", "%" + goodsShop + "%");
		sql.params().set("beginTime", beginTime);
		sql.params().set("endTime",endTime == 0?new Date().getTime():endTime);
		sql.params().set("start", (page - 1) * pageSize);
		sql.params().set("end", page * pageSize);

		sql.setCallback(Sqls.callback.entities());
		Entity<GoodsWithAddress> entity = dao.getEntity(GoodsWithAddress.class);
		sql.setEntity(entity);

		dao.execute(sql);

		return sql.getList(GoodsWithAddress.class);
	}
	
	/**
	 * 获取总记录数
	 * @param goodsShop 店铺名
	 * @param goodsType 分类名
	 * @return 总记录数
	 */
	public int getRecCount(String goodsShop,
			long beginTime,long endTime) {
		Sql sql = Sqls.create(TOTAL_PAGES);
		sql.params().set("shopName", "%" + goodsShop + "%");
		sql.params().set("beginTime", beginTime);
		sql.params().set("endTime",endTime == 0?new Date().getTime():endTime);

		sql.setCallback(Sqls.callback.integer());

		dao.execute(sql);

		return sql.getInt();
	}

	public static void main(String[] args) {
		UCGoodsService service = new UCGoodsService();
		service.getGoodsByShopAndTime("玉林兄弟手提", 1328073673655L,1328573673655L, Constants.DEFAULT_PAGESIZE, 1);
	}
}
