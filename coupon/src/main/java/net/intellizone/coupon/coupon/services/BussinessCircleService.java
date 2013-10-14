package net.intellizone.coupon.coupon.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.coupon.model.BussinessCircle;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;
@Service
public class BussinessCircleService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public BussinessCircleService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	public List<BussinessCircle> getAllBussinessCircle(){	
		return dao.query(BussinessCircle.class, null, null);	
	}
	public List<BussinessCircle> getAllBussinessCircleByCityId(int cityId){	
		return dao.query(BussinessCircle.class, Cnd.where("belong_city", "=", cityId), null);	
	}
	
	
	
	/***
	 * @param id
	 * @return
	 */
	public BussinessCircle getBussinessCircleById(int id) {
		BussinessCircle bussinessCircle = dao.fetch(BussinessCircle.class, id);
		return bussinessCircle;
	}
	
	public int deleteBussinessCircleById(long l){	
		return dao.delete(BussinessCircle.class, l);	
	}
	
	public BussinessCircle insertObj(BussinessCircle bussinessCircle){
		return dao.insert(bussinessCircle);
	}
	
	public int updateObj(BussinessCircle bussinessCircle){
		return dao.update(bussinessCircle);
	}
}
