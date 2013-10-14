package net.intellizone.coupon.admin.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.admin.model.ActivityRec;
import net.intellizone.coupon.admin.model.GoodsRec;
import net.intellizone.coupon.admin.model.HomePage;
import net.intellizone.coupon.admin.model.ShopRec;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.springframework.stereotype.Service;

@Service
public class AdminHomePageService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public AdminHomePageService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	public List<HomePage> getHomePageModelByType(int type) {
		return dao.query(HomePage.class, Cnd.where("type", "=", type).desc("top"), null);
	}

	public HomePage getHomeById(int id) {
		return dao.fetch(HomePage.class, id);
	}

	public int getHomePageByTop(HomePage homepage) {
		return dao.update(homepage);
	}

	public HomePage insertobj(HomePage homepage) {
		return dao.insert(homepage);
	}

	public int updateObj(HomePage homepage) {
		return dao.update(homepage);

	}

	public void insertObjList(List<HomePage> homePageList) {
		dao.insert(homePageList);
	}

	public void updateObjList(List<HomePage> homePageList) {
		dao.update(homePageList);
	}

	public List<ShopRec> getShopRecByTypeAndCity(long type, long cityId, int p,int pageSize) {
		String sqlStr = String
				.format(
						"select h.*,s.* from iz_shop s left join iz_homepage_push h on s.id=h.ref_id where h.type=%s and h.home_cityId=%s order by h.orderHome limit @start,@end",
						type, cityId);

		Sql sql = Sqls.create(sqlStr);
		sql.params().set("start", (p - 1) * pageSize);
		sql.params().set("end", p * pageSize);

		sql.setCallback(Sqls.callback.entities());
		Entity<ShopRec> entity = dao.getEntity(ShopRec.class);
		sql.setEntity(entity);

		dao.execute(sql);

		return sql.getList(ShopRec.class);
	}

	public int getShopRecByTypeAndCityCount(long type, long cityId) {
		String sqlStr = String
				.format(
						"select count(1) from iz_shop s left join iz_homepage_push h on s.id=h.ref_id where h.type=%s and h.home_cityId=%s order by h.orderHome",
						type, cityId);

		Sql sql = Sqls.create(sqlStr);

		sql.setCallback(Sqls.callback.ints());
		dao.execute(sql);

		return sql.getInt();
	}

	public List<GoodsRec> getGoodsRecByTypeAndCity(long type, long cityId) {
		String sqlStr = String
				.format(
						"select h.*,s.* from iz_goods s left join iz_homepage_push h on s.id=h.ref_id where h.type=%s and h.home_cityId=%s order by h.orderHome",
						type, cityId);

		Sql sql = Sqls.create(sqlStr);

		sql.setCallback(Sqls.callback.entities());
		Entity<GoodsRec> entity = dao.getEntity(GoodsRec.class);
		sql.setEntity(entity);

		dao.execute(sql);

		return sql.getList(GoodsRec.class);
	}

	public List<ActivityRec> getActivityRecByTypeAndCity(long type, long cityId) {
		String sqlStr = String
				.format(
						"select h.*,s.* from iz_activity s left join iz_homepage_push h on s.id=h.ref_id where h.type=%s and h.home_cityId=%s order by h.orderHome",
						type, cityId);

		Sql sql = Sqls.create(sqlStr);

		sql.setCallback(Sqls.callback.entities());
		Entity<ActivityRec> entity = dao.getEntity(ActivityRec.class);
		sql.setEntity(entity);

		dao.execute(sql);

		return sql.getList(ActivityRec.class);
	}

	public static void main(String[] args) {
		AdminHomePageService ahp = new AdminHomePageService();
		ahp.getShopRecByTypeAndCity(3, 1, 1,20);
	}
}
