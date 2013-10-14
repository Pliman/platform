/*
 * UserService.java 2012-1-12
 * 智域工作室
 */
package net.intellizone.coupon.user.services;

import javax.annotation.Resource;
import javax.sql.DataSource;

import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.user.model.UserWithAddr;
import net.intellizone.coupon.user.services.wingspay.ProvinceWsInterService;
import net.intellizone.db.MysqlDataSourceManager;
import net.intellizone.sysparam.services.SysParam;
import net.intellizone.utils.DateUtils;
import net.intellizone.utils.FlowNoUtil;
import net.intellizone.utils.xml.XmlEditor;
import net.intellizone.utils.xml.XmlUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.impl.NutDao;
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
public class UserService {
	// nutz dao
	private Dao dao;

	@Resource
	UserAddrService userAddrService;

	private static final String USER_WITH_ADDR = "select a.ADDR_DETAIL,u.* from iz_user u left join iz_useraddress a on u.ADDRESS_ID=a.id where u.user_id=@UserId";
	private static final String UPDATE_USER_ADDR = "update iz_useraddress a set a.ADDR_DETAIL=@addrStr";

	// 查询用户是否有爱优惠套餐(来判断爱优惠用户)
	private static final String USER_PACKAGE = "select count(1) from iz_package p inner join iz_user_package up on p.id=up.package_id inner join iz_user u on u.user_id=up.user_id where u.user_id=@userId and p.id=@discountPackageId";

	public UserService() {
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
		// String Url = "http://udb/~/ authorize.aspx";
		// 获取返回消息
		// String responseMsg = UrlUtils.getURLResponseByGet(Url);
		if(!"".equals(name)){
			return 0;
		}else{
			return 1;
		}
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
		return dao.fetch(User.class, userId);
	}

	/**
	 * 根据用户名获取用户对象
	 * 
	 * @param userName
	 *            用户名
	 * @return 用户对象
	 */
	public User getUserByUserName(String userName) {
		return dao.fetch(User.class, Cnd.where("name", "=", userName));
	}

	/**
	 * 根据用户业务id获取用户
	 * 
	 * @param pUserID
	 *            用户业务id
	 * @return 用户对象
	 */
	public User getUserByPUserID(String pUserID) {
		return dao.fetch(User.class, Cnd.where("pUserID", "=", pUserID));
	}

	/**
	 * 根据用户名和密码获取用户对象
	 * 
	 * @param userName
	 *            用户名
	 * @return 用户对象
	 */
	public User getUserByUserNameAndPass(String userName, String pass) {
		return dao.fetch(User.class, Cnd.where("userName", "=", userName).and("password", "=",
				DigestUtils.md5Hex(pass)));
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

	public UserWithAddr getUserWithAddrByUser(User user) {
		Sql sql = Sqls.create(USER_WITH_ADDR);
		sql.params().set("UserId", user.getId());

		sql.setCallback(Sqls.callback.entity());
		Entity<UserWithAddr> entity = dao.getEntity(UserWithAddr.class);
		sql.setEntity(entity);

		dao.execute(sql);

		return sql.getObject(UserWithAddr.class);
	}

	public int updateUserAddr(User user, String addr) {
		Sql sql = Sqls.create(UPDATE_USER_ADDR);
		sql.params().set("addrStr", addr);

		userAddrService.updateUserAddrDetailById(user.getAddr(), addr);

		dao.execute(sql);

		return sql.getInt();
	}

	/**
	 * 是否是翼支付用户 <?xml version="1.0" encoding="UTF-8"?> <PayPlatRequestParameter>
	 * <CTRL-INFO WEBSVRNAME="服务名称" WEBSVRCODE="服务编码" APPFROM="请求本服务的应用标识码"
	 * KEEP="本次服务的标识流水" /> <PARAMETERS> ... </PARAMETERS>
	 * </PayPlatRequestParameter>
	 * 
	 * @return true是/false否
	 */
	public boolean isAndSetWingsPayUser(User user) {
		SysParam instance = SysParam.INSTANCE;
		String sysAppId = instance.getSysParamValueByCode("sysAppId");
		String sysVersion = instance.getSysParamValueByCode("sysVersion");
		String QueryCustomCode = instance.getSysParamValueByCode("QueryCustomCode");
		String appOrgCode = instance.getSysParamValueByCode("appOrgCode");
		// 应用编码
		String appCode = String.format("510000-%s-%s", sysAppId, sysVersion);

		// 组织请求xml
		StringBuilder xmlBuilder = new StringBuilder(XmlUtils.XML_HEADER);
		xmlBuilder.append("<PayPlatRequestParameter>");
		xmlBuilder.append("<CTRL-INFO ").append("WEBSVRNAME=\"客户查询\" ").append("WEBSVRCODE=\"")
				.append(QueryCustomCode).append("\" ").append("APPFROM=\"").append(appCode).append(
						"\" ").append("KEEP=\"").append(FlowNoUtil.timeBased20FlowNo()).append(
						"\" />");

		xmlBuilder.append("<PARAMETERS>");
		xmlBuilder.append("<PRODUCTNO>").append(user.getUserNo()).append("</PRODUCTNO>");
		xmlBuilder.append("<ACCEPTORGCODE>").append(appOrgCode).append("</ACCEPTORGCODE>");
		xmlBuilder.append("<ACCEPTSEQNO>").append(FlowNoUtil.timeBased20FlowNo()).append(
				"</ACCEPTSEQNO>");
		xmlBuilder.append("<INPUTTIME>").append(DateUtils.formatCurrentDate("yyyyMMddHHmmss"))
				.append("</INPUTTIME>");
		xmlBuilder.append("</PARAMETERS>");

		xmlBuilder.append("</PayPlatRequestParameter>");

		ProvinceWsInterService service = new ProvinceWsInterService();
		String rtnXml = service.getProvinceWsInterDelegate().doBusiness(xmlBuilder.toString());

		return parseResult(rtnXml, user);
	}

	// 处理结果
	private boolean parseResult(String rtnXml, User user) {
		Document doc = XmlEditor.stringToXmlDoc(rtnXml);
		String responseCode = XmlEditor.getValueByXPath(doc,
				"/PayPlatResponseParameter/RESPONSECODE");

		if (responseCode.equals("000000")) {
			String customNo = XmlEditor.getValueByXPath(doc,
					"/PayPlatResponseParameter/RESPONSECONTENT/RESULTDATESET/DATAS/CUSTOMER_NO");
			String productNo = XmlEditor.getValueByXPath(doc,
					"/PayPlatResponseParameter/RESPONSECONTENT/RESULTDATESET/DATAS/PRODUCT_NO");
			// String customName = XmlEditor.getValueByXPath(doc,
			// "/PayPlatResponseParameter/RESPONSECONTENT/RESULTDATESET/DATAS/CUSTOMER_NAME");
			String idType = XmlEditor.getValueByXPath(doc,
					"/PayPlatResponseParameter/RESPONSECONTENT/RESULTDATESET/DATAS/ID_TYPE");
			String certNum = XmlEditor.getValueByXPath(doc,
					"/PayPlatResponseParameter/RESPONSECONTENT/RESULTDATESET/DATAS/CertNum");
			user.setCustomNo(customNo);
			user.setProductNo(productNo);
			user.setIdType(idType);
			user.setCertNum(certNum);

			return true;
		}

		return false;
	}

	/**
	 * 是否是爱优惠用户
	 * 
	 * @return true是/false否
	 */
	public boolean isIDiscountUser(User user) {
		String discountPackageId = SysParam.INSTANCE.getSysParamValueByCode("discountPackageId");

		Sql sql = Sqls.create(USER_PACKAGE);
		sql.params().set("userId", user.getId());
		sql.params().set("discountPackageId", discountPackageId);

		sql.setCallback(Sqls.callback.integer());

		dao.execute(sql);

		int count = sql.getInt();
		if (count > 0) {
			return true;
		}

		return false;
	}

	/**
	 * 通过卡号获取用户
	 * 
	 * @param cardNo
	 *            卡号
	 * @return 用户
	 */
	public User getUserByCardNo(String cardNo) {
		return dao.fetch(User.class, Cnd.where("cardNo", "=", cardNo));
	}

	/**
	 * 通过卡号验证用户
	 * 
	 * @param cardNo
	 *            卡号
	 * @return 是否是有效用户
	 */
	public boolean validateByCardNo(String cardNo) {
		User user = dao.fetch(User.class, Cnd.where("cardNo", "=", cardNo));

		if (user != null) {
			return true;
		}

		return false;
	}

	/**
	 * 根据用户号码和密码来验证用户
	 * 
	 * @param userNo
	 *            用户号码
	 * @param pass
	 *            密码
	 * @return 是否有效用户
	 */
	public boolean validateByUserNoAndPass(String userNo, String pass) {
		User user = dao.fetch(User.class, Cnd.where("userNo", "=", userNo).and("password", "=",
				DigestUtils.md5Hex(pass)));

		if (user != null) {
			return true;
		}

		return false;
	}

	// 测试
	public static void main(String[] args) {
		UserService service = new UserService();
		System.out.println(service.isIDiscountUser(service.getUserById(5)));
	}
}