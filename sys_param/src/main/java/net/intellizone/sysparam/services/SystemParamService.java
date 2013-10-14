/*
 * SystemParamService.java 2012-2-15
 * 智域工作室
 */
package net.intellizone.sysparam.services;

import java.util.List;

import net.intellizone.core.constants.Constants;

import net.intellizone.db.MysqlDataSourceManager;
import net.intellizone.sysparam.model.SystemParam;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

/**
 * 系统参数服务
 * 
 * @author Pliman
 * @version 1.0
 * @since sys_param 1.0
 */
@Service
public class SystemParamService {
	Dao dao;

	SystemParamService() {
		dao = new NutDao(MysqlDataSourceManager.INSTANCE.getDataSource());
	}


	/**
	 * 根据编码获取系统参数
	 * 
	 * @param code
	 *            系统参数编码
	 * @return 系统参数
	 */
	public SystemParam getSystemParamByCode(String code) {
		return dao.fetch(SystemParam.class, Cnd.where("code", "=", code));
	}


	/**
	 * 插入系统参数
	 * 
	 * @param systemParam
	 *            系统参数对象
	 * @return 插入后返回的系统参数对象
	 */
	public SystemParam insertSystemParam(SystemParam systemParam) {
		return dao.insert(systemParam);
	}

	
	//取得所有参数信息
	public List<SystemParam> getSysParam(){
		return dao.query(SystemParam.class, null, null);
	}
	
	
	/**
	 * 按页获取信息
	 * 
	 * @param page
	 *            页码
	 * @return 当页模板
	 */
	public List<SystemParam> getSysParam(int page) {
		Pager pager = dao.createPager(page, Constants.PAGESIZE20);
		return dao.query(SystemParam.class,Cnd.where("sysflag","=","0"), pager);
	}
	
	/**
	 * 根据ID查询信息
	 * */
	public SystemParam getSysById(int id){
		return dao.fetch(SystemParam.class,id);
	}
	/**
	 * 修改信息
	 * */
	public int updateSys(SystemParam sysParam){
		return dao.update(sysParam);
	}
	/**
	 * 删除信息
	 * */
	public int deleteSys(SystemParam sysParam){
		return dao.delete(sysParam);
	}
	
	/**
	 * 批量删除信息
	 * */
	public int deleteAllSys(int[] sysId_list){
		return dao.clear(SystemParam.class,Cnd.where("id","in",sysId_list));
	}



}