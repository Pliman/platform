package net.intellizone.coupon.system.service;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.system.common.SysConstants;
import net.intellizone.coupon.system.model.Functions;
import net.intellizone.coupon.system.model.Users;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

@Service
public class FunctionsService {
	
	private Dao dao;

	// 初始化数据源
	public FunctionsService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	public int createFunction(Functions function) throws Exception{
		Functions f=this.findFunctionByName(function.getFunction_name());
		if(null!=f)
			return SysConstants.NAME_EXIST;
		this.dao.insert(function);
		return SysConstants.EXCUTE_OK;	
	}

	public void deleteFunction(String functionId) throws Exception {
		this.dao.delete(Functions.class,functionId);
	}

	public Functions findFunction(String functionId) throws Exception {	
		return this.dao.fetch(Functions.class, functionId);
	}

	/**查询所有父级菜单*/
	public List<Functions> findAllParentMenus() throws Exception{
		List<Functions> fList=dao.query(Functions.class, Cnd.wrap("function_type='"+SysConstants.FUNCTION_TYPE_FOLDER+"' "), null);
		return fList;
	}
	
	/**
	 * 查询某个功能文件夹或菜单下的子级(菜单或请求操作)
	 * 
	 */
	public List<Functions> findNextLevelResources(String parentFunctionId,String functionType) throws Exception{
		List<Functions> fList=dao.query(Functions.class, Cnd.wrap("function_type='"+functionType+"' and parent_id='"+parentFunctionId+"'  order by show_order "), null);
		return fList;
	}
	
//	/**查询所有功能菜单*/
//	public List<Functions> findAllMenus() throws Exception{
//		List<Functions> fList=dao.query(Functions.class, Cnd.wrap("function_type<>'"+SysConstants.FUNCTION_TYPE_RESOURCE+"' "), null);
//		return fList;
//	}
	

	public int updateFunction(Functions function) throws Exception{
//		Functions f=this.findFunctionByName(function.getFunction_name());
//		if(null!=f&&!f.getFunction_id().equals(function.getFunction_id()))
//			return SysConstants.NAME_EXIST; //去掉同名判断 即允许改为同名的
		this.dao.update(function);
		return SysConstants.EXCUTE_OK;
		
	}


	public Functions findFunctionByName(String functionName) throws Exception {
		Functions f=null;//this.findUniqueByProperty("username", username);
		List<Functions> fList = dao.query(Functions.class, Cnd.where("function_name", "=",functionName), null);
		if(null!=fList&&fList.size()>0){
			f=fList.get(0);
		}
		return f;	
	}
	public QueryResult getPagination(Condition c, int pageNumber, int pageSize) {
		List<Functions> list = null;
		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Functions.class, c, pager);
		if (list == null) {
			return null;
		}
		for (Functions f : list) {  
			if(Functions.ROOT_FUNCTIONS_ID.equals(f.getParent_id())){
				f.setParent_name(f.getParent_id());
				continue;
			}
			Functions pf=dao.fetch(Functions.class,f.getParent_id());
			if(null!=pf){
				f.setParent_name(pf.getFunction_name());
			}
		}
		pager.setRecordCount(dao.count(Functions.class));
		
		return new QueryResult(list, pager);
	}
	public List<Functions> getAll(){
		Condition condition1 = Cnd.where("1", "=", 1);
		return dao.query(Functions.class, condition1, null);
	}
	
	public void save(Functions f){
		this.dao.insert(f);
	}
}
