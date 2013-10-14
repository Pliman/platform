package net.intellizone.coupon.admin.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.coupon.model.BussinessCircle;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;

@Service
public class AdminBussinessCircleService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public AdminBussinessCircleService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	public List<BussinessCircle> getAllBussinessCircle() {
		return dao.query(BussinessCircle.class, null, null);
	}

	public List<BussinessCircle> getAllBussinessCircleByCityId(City city) {
		return dao.query(BussinessCircle.class, Cnd.where("belong_city", "=", city.getId()), null);
	}
	public List<BussinessCircle> getAllBussinessCircleByCityId(int cityId) {
		return dao.query(BussinessCircle.class, Cnd.where("belong_city", "=", cityId), null);
	}
	/**
	 * @param id
	 * @return
	 */
	public BussinessCircle getBussinessCircleById(int id) {
		BussinessCircle bussinessCircle = dao.fetch(BussinessCircle.class, id);
		return bussinessCircle;
	}

	public int deleteBussinessCircleById(long l) {
		return dao.delete(BussinessCircle.class, l);
	}

	public BussinessCircle insertObj(BussinessCircle bussinessCircle) {
		return dao.insert(bussinessCircle);
	}

	public int updateObj(BussinessCircle bussinessCircle) {
		return dao.update(bussinessCircle);
	}
	//批量删除商圈
	public int deleteAllCircle(int[] id_circle){
		return dao.clear(BussinessCircle.class,Cnd.where("id","in",id_circle));
	}
}
