package net.intellizone.coupon.admin.services;

import java.util.List;


import javax.sql.DataSource;

import net.intellizone.coupon.city.model.City;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

@Service
public class AdminCityService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public AdminCityService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	public List<City> getAllCity() {
		return dao.query(City.class, null, null);
	}
	public QueryResult getAllCity(String wd,int pageNumber,int pageSize){
		List<City> list = null;
		Condition c = null;
		String name = wd.trim();
		if(!name.equals("") && name != null){
			 c =Cnd.where("city", "like", "%"+name+"%");
		}
		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(City.class, c, pager);
		pager.setRecordCount(dao.count(City.class, c));
		return new QueryResult(list,pager);
	}
	//添加城市
	public City insertCity(City city){
		return dao.insert(city);
	}
	
	//删除城市
	public int deleteCity(long id){
		return dao.delete(City.class,id);
	}
	
	//根据ID查询城市
	public City findCityById(long id){
		City city = dao.fetch(City.class,id);
		return city;
	}
	
	//更新城市信息
	public int updateCity(City city){
		return dao.update(city);
	}
	
	//批量删除城市信息
	public int delteAllCity(int[] id_city){
		return dao.clear(City.class,Cnd.where("id","in",id_city));
	}

	/**
	 * 根据IDLIST 查询城市
	 * @param idList
	 * @return
	 */
	public  List<City> getCityByIdList(List<String> idLists) {
		// TODO Auto-generated method stub
		if(idLists==null)return null;
		return dao.query(City.class, Cnd.where("id","in",idLists), null);
	}
}
