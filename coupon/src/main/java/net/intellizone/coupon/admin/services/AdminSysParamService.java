package net.intellizone.coupon.admin.services;

import java.util.List;

import javax.sql.DataSource;


import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.admin.model.SysParam;
import net.intellizone.coupon.msg.template.model.MsgTemplate;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

@Service
public class AdminSysParamService {

	private Dao dao;

	// 初始化数据源
	public AdminSysParamService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	//取得所有参数信息
	public List<SysParam> getSysParam(){
		return dao.query(SysParam.class, null, null);
	}
	
	
	/**
	 * 按页获取信息
	 * 
	 * @param page
	 *            页码
	 * @return 当页模板
	 */
	public List<SysParam> getSysParam(int page) {
		Pager pager = dao.createPager(page, Constants.DEFAULT_PAGESIZE);
		return dao.query(SysParam.class,Cnd.where("sysflag","=","0"), pager);
	}
	
	/**
	 * 根据ID查询信息
	 * */
	public SysParam getSysById(int id){
		return dao.fetch(SysParam.class,id);
	}
	/**
	 * 修改信息
	 * */
	public int updateSys(SysParam sysParam){
		return dao.update(sysParam);
	}
	/**
	 * 删除信息
	 * */
	public int deleteSys(SysParam sysParam){
		return dao.delete(sysParam);
	}
	
	/**
	 * 批量删除信息
	 * */
	public int deleteAllSys(int[] sysId_list){
		return dao.clear(SysParam.class,Cnd.where("id","in",sysId_list));
	}
}
