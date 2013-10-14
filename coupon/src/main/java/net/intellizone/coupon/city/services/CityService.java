package net.intellizone.coupon.city.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.city.model.City;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;

@Service
public class CityService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public CityService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	/**
	 * 获取所有城市
	 * 
	 * @return 所有城市
	 */
	public List<City> getAllCity() {
		return dao.query(City.class, null, null);
	}

	/**
	 * 根据城市名称，获取城市 此处的城市名包括省份名称 例如 四川省成都市
	 * 
	 * @param cityName
	 *            城市名称
	 * @return 城市
	 */
	public City getCityByProvinceAndCity(String cityName) {
		return dao.fetch(City.class, Cnd.wrap("CONCAT(PROVINCE,CITY) like '" + cityName + "'"));
	}

	/**
	 * 根据id获取城市
	 * 
	 * @param cityId
	 *            城市Id
	 * @return 城市
	 */
	public City getCityById(long cityId) {
		City city = dao.fetch(City.class, cityId);
		dao.fetchLinks(city, "shopCategoryList");
		return city;
	}
	
	public static void main(String[] args){
		CityService service = new CityService();
		City city = service.getCityById(1);
		System.out.println(city.getShopCategoryList());
	}
}
