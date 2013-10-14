/*
 * ActivityService.java
 * 智域工作室
 */
package net.intellizone.coupon.activity.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.activity.model.Activity;
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

/**
 * 活动服务
 * 
 * @author mass
 * @version 1.0
 */
@Service
public class ActivityService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public ActivityService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	/**
	 * * 活动分页查询 条件查询
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param cat
	 * @param bc
	 * @param name
	 * @return
	 */
	public QueryResult getActivityByTypeAndkeyIdAndKeyWordsPagination(int pageNumber, int pageSize,
			int bc, String name, int order) {
		List<Activity> list = null;
		name=name.trim();
		Cnd c = Cnd.where("title", "like", "%" + name + "%");
	
		String orderCondition = "id";// 排序，默认根据ID
		if (order == 1) {
			orderCondition = "modify_time";
		} else if (order == 2) {
			orderCondition = "title";
		}
		
		if(bc != 0){
			c.and("belong_bc", "=", bc);
		}
		
		c.and("activty_status", "=", 1); // 非冻结
		c.desc(orderCondition);

		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Activity.class, c, pager);

		pager.setRecordCount(dao.count(Activity.class, c));
		return new QueryResult(list, pager);
	}

	/**
	 * 根据ID获得活动
	 * 
	 * @param id
	 * @return
	 */
	public Activity getActivityById(int id) {
		Activity activity = dao.fetch(Activity.class, id);
		return activity;
	}

	/**
	 * 删除活动
	 * 
	 * @param l
	 * @return
	 */
	public int deleteActivityById(long l) {
		return dao.delete(Activity.class, l);
	}

	/**
	 * 添加活动
	 * 
	 * @param activity
	 * @return
	 */
	public Activity insertObj(Activity activity) {
		return dao.insert(activity);
	}

	/**
	 * 修改活动
	 * 
	 * @param activity
	 * @return
	 */
	public int updateObj(Activity activity) {
		return dao.update(activity);
	}

	public List<Activity> getOrderAct(int size) {
		String sqlStr = "select * from iz_activity ORDER BY rand() limit " + size;
		Sql sql = Sqls.create(sqlStr);
		sql.setCallback(Sqls.callback.entities());
		Entity<Activity> activityEntity = dao.getEntity(Activity.class);
		sql.setEntity(activityEntity);
		dao.execute(sql);
		return sql.getList(Activity.class);
	}
}
