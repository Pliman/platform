/*
 * UserAddrService.java 2012-1-12
 * 智域工作室
 */
package net.intellizone.coupon.admin.services;

import javax.sql.DataSource;

import net.intellizone.coupon.user.model.UserAddress;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;

/**
 * User地址服务类
 * 
 * @author Pliman
 * @version 1.0 2012-1-12
 * @since User 1.0
 */
@Service
public class AdminUserAddrService {
	// nutz dao
	private Dao dao;
	
	AdminUserAddrService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	public UserAddress getUserAddressById(long userAddrId){
		return dao.fetch(UserAddress.class,userAddrId);
	}

	/**
	 * 更新用户地址
	 * 
	 * @param user
	 *            需要删除的用户
	 * @return 是否成功
	 */
	public int updateUserAddrDetailById(long userAddrId,String addrDetail) {
		UserAddress userAddr = getUserAddressById(userAddrId);
		userAddr.setAddrDetail(addrDetail);
		return dao.update(userAddr);
	}


}