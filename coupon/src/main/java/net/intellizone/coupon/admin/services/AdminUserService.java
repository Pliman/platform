/*
 * UserService.java 2012-1-12
 * 智域工作室
 */
package net.intellizone.coupon.admin.services;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import net.intellizone.coupon.activity.model.Activity;
import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.user.model.UserWithAddr;
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

/**
 * User服务类
 * 
 * @author Pliman
 * @version 1.0 2012-1-12
 * @since User 1.0
 */
@Service
public class AdminUserService {
	// nutz dao
	private Dao dao;
	
	@Resource
	AdminUserAddrService adminUserAddrService;
	
	private static final String USER_WITH_ADDR = "select a.ADDR_DETAIL,u.* from iz_user u inner join iz_useraddress a on u.ADDRESS_ID=a.id where u.user_id=@UserId";
	private static final String UPDATE_USER_ADDR = "update iz_useraddress a set a.ADDR_DETAIL=@addrStr";

	AdminUserService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	/**
	 * 通过电信能力开放平台验证用户 返回 0成功 1用户不存在 2...地补充
	 * 
	 * @param name
	 *            用户名
	 * @param password
	 *            密码
	 * @return 验证结果代码
	 */
	// TODO Pliman 先使用假验证，之后再改成真验证
	public int validateWingsUser(String name, String password) {
		// 用户验证url 请求参数需要编码
		// String Url = "http://www.baidu.com?username=?&password=?";
		// 获取返回消息
		// String responseMsg = UrlUtils.getURLResponseByGet(Url);

		return 0;
	}

	/**
	 * 插入用户
	 * 
	 * @param user
	 *            需要插入的用户
	 * @return 插入后的用户
	 */
	public User insertUser(User user) {
		return dao.insert(user);
	}

	/**
	 * 删除用户
	 * 
	 * @param user
	 *            需要删除的用户
	 * @return 是否成功
	 */
	public int deleteUser(User user) {
		return dao.delete(user);
	}
	
	/**
	 * 更新用户
	 * 
	 * @param user
	 *            需要更新的用户
	 * @return 是否成功
	 */
	public int updateUser(User user) {
		return dao.update(user);
	}

	/**
	 * 根据用户Id，获取用户
	 * 
	 * @param userId
	 *            用户id
	 * @return 用户对象
	 */
	public User getUserById(long userId) {
		return dao.fetch(User.class);
	}
	
	/**
	 * 根据用户名获取用户对象
	 * 
	 * @param userName 用户名
	 * @return 用户对象
	 */
	public User getUserByUserName(String userName) {
		return dao.fetch(User.class, Cnd.where("userNo", "=", userName));
	}

	/**
	 * 根据用户号码获取用户对象
	 * 
	 * @param userNo
	 * @return 用户对象
	 */
	public User getUserByUserNo(String userNo) {
		return dao.fetch(User.class, Cnd.where("userNo", "=", userNo));
	}
	
	public UserWithAddr getUserWithAddrByUser(User user){
		Sql sql = Sqls.create(USER_WITH_ADDR);
		sql.params().set("UserId", user.getId());

		sql.setCallback(Sqls.callback.entity());
		Entity<UserWithAddr> entity = dao.getEntity(UserWithAddr.class);
		sql.setEntity(entity);

		dao.execute(sql);

		return sql.getObject(UserWithAddr.class);
	}
	
	public int updateUserAddr(User user,String addr){
		Sql sql = Sqls.create(UPDATE_USER_ADDR);
		sql.params().set("addrStr", addr);
		
		adminUserAddrService.updateUserAddrDetailById(user.getAddr(), addr);

		dao.execute(sql);

		return sql.getInt();
	}

	/**
	 * 是否是翼支付用户
	 * 
	 * @return true是/false否
	 */
	// 缺少wsdl，没有生成客户端，暂时使用爱优惠用户验证
	public boolean isWingsPayUser(String userName, String password) {
		return isIDiscountUser(userName, password);
	}

	/**
	 * 是否是爱优惠用户
	 * 
	 * @return true是/false否
	 */
	public boolean isIDiscountUser(String userName, String password) {
		return validateUser(userName, password);
	}

	/**
	 * 验证是否是爱优惠用户的具体方法
	 * 
	 * @return true是/false否
	 */
	private boolean validateUser(String userName, String password) {
		User user = dao.fetch(User.class, Cnd.where("name", "=", userName).and("password", "=", password));
		return user != null;
	}


	public QueryResult getUserListPagination(int pageNumber,int pageSize){
		
		List<User> list=null;
		Condition c=null;
	
		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(User.class, c, pager);
	

		pager.setRecordCount(dao.count(User.class));
		return new QueryResult(list, pager);

		
	}
	// 测试
	public static void main(String[] args) {
		AdminUserService service = new AdminUserService();
		service.getUserById(1);
		service.isIDiscountUser("tom", "aaaaaa");
		service.isIDiscountUser("Jerry", "bbbbbb");
		service.isIDiscountUser("Jerry", "1111111");
	}
}