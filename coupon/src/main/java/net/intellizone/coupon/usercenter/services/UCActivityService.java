/*
 * UCActivityService.java 2012-1-16
 * 智域工作室
 */
package net.intellizone.coupon.usercenter.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.activity.model.Activity;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

/**
 * 用户中心-活动相关的服务
 * 
 * @author Administrator
 * 
 */
@Service
public class UCActivityService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public UCActivityService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	/**
	 * 按照店铺和分类，获取活动
	 * 
	 * @param shop
	 *            店铺名
	 * @param type
	 *            分类名
	 * @param page
	 *            页码数
	 * @return 活动列表
	 */
	public QueryResult getActivityByKwBCAndOn(String kw, int bc, int on, int page, int pageSize) {
		Pager pager = dao.createPager(page, pageSize);
		
		long currentTime = System.currentTimeMillis();
		Cnd cnd = Cnd.where("begin_time", "<", currentTime);
		
		if(bc != 0){
			cnd.and("belong_bc", "=", bc);
		}
		
		cnd.and("keyword", "like", "%" + kw + "%");
		if(on != 0){
			cnd.and("end_time", on==1?">":"<", currentTime);
		}
		
		List<Activity> activityList = dao.query(Activity.class, cnd, pager);

		pager.setRecordCount(dao.count(Activity.class, cnd));
		
		return new QueryResult(activityList,pager);
	}
}
