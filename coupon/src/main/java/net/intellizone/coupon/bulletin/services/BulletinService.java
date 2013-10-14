/*
 * BulletinService.java 2012-1-19
 * 智域工作室
 */
package net.intellizone.coupon.bulletin.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.coupon.bulletin.model.Bulletin;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;

/**
 * 公告服务
 * 
 * @author Pliman
 * @version 1.0 2012-1-19
 * @since coupon 1.0
 */
@Service
public class BulletinService {
	Dao dao;

	BulletinService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	/**
	 * 获取所有公告
	 */
	public List<Bulletin> getAllBulletins() {
		return dao.query(Bulletin.class, null, null);
	}
}
