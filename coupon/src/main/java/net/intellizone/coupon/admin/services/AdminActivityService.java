package net.intellizone.coupon.admin.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.activity.model.Activity;
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
public class AdminActivityService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public AdminActivityService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	public QueryResult getActivityByTypeAndkeyIdAndKeyWordsPagination(int pageNumber,int pageSize,int cat,int bc){
		List<Activity> list=null;
		Condition c=null;
		if(cat==0&&bc!=0){
			c=Cnd.where("belong_bc", "=", bc).and("isverified","=",1).desc("id");;
		}else if(cat==0&&bc==0){
			
		}else if(cat!=0&&bc==0){
			c=Cnd.where("belong_cat", "=", cat).desc("id");
		}else{
			c=Cnd.where("belong_cat", "=", cat).and("belong_bc", "=", bc).desc("id");
		}

		
		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Activity.class, c, pager);
		
		//dao.fetchLinks(list, "goodsImages");
		pager.setRecordCount(dao.count(Activity.class));
		return new QueryResult(list, pager);
	}
	
	
	public QueryResult getActivityByTypeAndkeyIdAndKeyWordsPagination(int pageNumber,int pageSize,int cat,int bc,String name,int search,long begin_time,long end_time){
		List<Activity> list=null;
		Condition c=null;
		String wd=name.trim();
		/**
		 * search 查询条件：1-ID 2-名称  3-状态 4-时间
		 * */
		
		if(search == 0){
			if(cat==0&&bc!=0){
				c=Cnd.where("belong_bc", "=", bc).and("title","like","%"+wd+"%").desc("id");;
			}else if(cat==0&&bc==0){
				 c=Cnd.where("title", "like","%"+wd+"%").desc("id");
			}else if(cat!=0&&bc==0){
				c=Cnd.where("belong_cat", "=", cat).and("title","like","%"+wd+"%").desc("id");
			}else{
				c=Cnd.where("belong_cat", "=", cat).and("title","like","%"+wd+"%").and("belong_bc", "=", bc).desc("id");
			}
		}else{
			  if(search == 1){
				  c=Cnd.where("id", "like","%"+wd+"%").desc("id");
			  }else if(search == 2){
				  c=Cnd.where("title", "like","%"+wd+"%").desc("id");
			  }else if(search == 3){
				  c=Cnd.where("activty_status","=",wd).desc("id");
			  }else if(search == 4){
				  Cnd cnd = null;
				  if(begin_time!= 0 ){
					  c=cnd.where("modify_time",">=",begin_time);
				  }else if(end_time !=0){
					  c = cnd. and("modify_time","<=",end_time).desc("id");
				  }else{
					  c=Cnd.where("modify_time","like","%"+begin_time+"%");
				  }
			  }
		}
		
		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Activity.class, c, pager);
		
		//dao.fetchLinks(list, "goodsImages");
		pager.setRecordCount(dao.count(Activity.class,c));
		return new QueryResult(list, pager);
	}
	
	/**
	 * 首页精选活动静态化
	 * */
	public List<Activity> getActivityByTime(int p){
		Pager pager = dao.createPager(p, 7);
		return dao.query(Activity.class, Cnd.where(null).desc("modify_time"), pager);
	}
	
	/***
	 * @param id
	 * @return
	 */
	public Activity getActivityById(int id) {
		Activity activity = dao.fetch(Activity.class, id);
		//dao.fetchLinks(goods, "goodsImages");
		return activity;
	}

	
	
	public QueryResult getAllActivityByTypeAndkeyIdPagination(int pageNumber,int pageSize,int cat,int bc){
		List<Activity> list=null;
		Condition c=null;
		if(cat==0&&bc!=0){
			c=Cnd.where("belong_bc", "=", bc).desc("id");;
		}else if(cat==0&&bc==0){
			//c=Cnd.where("cat_type","=",goodstype).desc("id");
		}else if(cat!=0&&bc==0){
			c=Cnd.where("belong_cat", "=", cat).desc("id");
		}else{
			c=Cnd.where("belong_cat", "=", cat).and("belong_bc", "=", bc).desc("id");
		}
		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Activity.class, c, pager);
		if(list==null){
			return null;
		}

		pager.setRecordCount(dao.count(Activity.class));
		return new QueryResult(list, pager);
	}

	
	

	public int deleteActivityById(long l){
		
		return dao.delete(Activity.class, l);
		
	}
	
	public Activity insertObj(Activity activity){
		return dao.insert(activity);
	}
	
	public int updateObj(Activity activity){
		return dao.update(activity);
	}

	/**审核状态更新**/
	public  int checkObjById(int id,int activty_status,String audit_reason){
		Activity activity = dao.fetch(Activity.class,id);
		activity.setActivty_status(activty_status);
		activity.setAudit_reason(audit_reason);
		return dao.update(activity);
	}
	/**
	 * 批量删除活动
	 * @param idList
	 * @return
	 */
	public int batchDelActivity(int[] idList){
		return dao.clear(Activity.class,Cnd.where("id", "in", idList));	
	}
	public List<Activity> get4HotAct(){
		String sqlStr = "select a.* from iz_activity a where a.IS_HOT=1 limit 0,4";
		
		Sql sql = Sqls.create(sqlStr);
		sql.setCallback(Sqls.callback.entities());
		Entity<Activity> activityEntity = dao.getEntity(Activity.class);
		sql.setEntity(activityEntity);
		
		return sql.getList(Activity.class);
	}
	
	public List<Activity> get4RecAct(){
		String sqlStr = "select a.* from iz_activity a where a.IS_RECOMMEND=1 limit 0,4";
		
		Sql sql = Sqls.create(sqlStr);
		sql.setCallback(Sqls.callback.entities());
		Entity<Activity> activityEntity = dao.getEntity(Activity.class);
		sql.setEntity(activityEntity);
		
		return sql.getList(Activity.class);
	}

}
