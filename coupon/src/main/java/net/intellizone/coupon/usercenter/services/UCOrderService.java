/*
 * UCOrderService.java 2012-2-17
 * 智域工作室
 */
package net.intellizone.coupon.usercenter.services;

import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.order.model.Order;
import net.intellizone.coupon.order.model.OrderItem;
import net.intellizone.coupon.order.services.OrderService;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

/**
 * 用户-优惠劵相关服务
 * 
 * @author Pliman
 * @version 1.0 2012-2-17
 * @since coupon 1.0
 */
@Service
public class UCOrderService {
	// nutz dao
	private Dao dao;

	@Resource
	OrderService orderService;

	// 初始化数据源
	public UCOrderService() {
		dao = new NutDao(MysqlDataSourceManager.INSTANCE.getDataSource());
	}

	/**
	 * 查询用户订单
	 * 
	 * @param orderNo
	 *            订单号
	 * @param beginTime
	 *            起始时间
	 * @param endTime
	 *            截止时间
	 * @param pageSize
	 *            分页大小
	 * @param page
	 *            页码
	 * @return 订单列表
	 */
	public QueryResult queryCommonOrderByUser(String orderNo, long beginTime, long endTime,
			int pageSize, int page, long userId) {
		Pager pager = dao.createPager(page, pageSize);

		Cnd cnd = Cnd.where("createTime", ">=", beginTime);
		if (!"".equals(orderNo)) {
			cnd.and("orderNo", "like", "%" + orderNo + "%");
		}
		if (endTime != 0) {
			cnd.and("createTime", "<=", endTime);
		}
		cnd.and("userId", "=", userId);
		cnd.and("orderType", "=", 1);

		List<Order> orderList = dao.query(Order.class, cnd, pager);
		dao.fetchLinks(orderList, "user");
		dao.fetchLinks(orderList, "goods");

		pager.setRecordCount(dao.count(Order.class, cnd));
		return new QueryResult(orderList, pager);
	}

	/**
	 * 条件查询订单
	 */

	public QueryResult getByOrderSearch(int pageSize, int p, String create_Time, String orderNo,
			String status, long userId) {
		Cnd cnd = null;
		List<Order> list = null;
		long timestamp = System.currentTimeMillis() - 30 * 24 * 60 * 60 * 1000; // 获取当前时间，精确到毫秒
		if (create_Time.equals("1")) {
			cnd = Cnd.where("createTime", "<", timestamp);
		}
		if (create_Time.equals("2")) {
			cnd = Cnd.where("createTime", "<", timestamp * 2);
		}
		if (create_Time.equals("3")) {
			cnd = Cnd.where("createTime", "<", timestamp * 3);
		}
		if (status != null || !"".equals(status)) {
			cnd.and("orderStatus", "=", status);
		}
		if (orderNo != null && !"订单编号".equals(orderNo)) {
			cnd.and("orderNo", "like", "%" + orderNo + "%");
		}
		cnd.and("userId", "=", userId);
		cnd.and("orderType", "=", 1);
		Pager pager = dao.createPager(p, pageSize);
		list = dao.query(Order.class, cnd, pager);
		dao.fetchLinks(list, "user");
		dao.fetchLinks(list, "goods");
		pager.setRecordCount(dao.count(Order.class, cnd));
		return new QueryResult(list, pager);
	}

	/**
	 * 获取用户最近使用过的6张优惠劵
	 * 
	 * @param userId
	 *            用户id
	 */
	public List<Goods> get6UsedCoupon(long userId) {
		Pager pager = dao.createPager(1, 6);

		Cnd cnd = Cnd.where("userId", "=", userId);
		cnd.and("orderType", "=", 2).and("orderStatus", "=", "4").desc("createTime");

		List<Order> orderList = dao.query(Order.class, cnd, pager);
		dao.fetchLinks(orderList, "user");
		dao.fetchLinks(orderList, "orderItemList");

		return getGoodsByOrder(orderList);
	}

	/**
	 * 获取用户未使用过的5张优惠劵
	 * 
	 * @param userId
	 *            用户id
	 */
	public List<Goods> get5UnusedCoupon(long userId) {
		Pager pager = dao.createPager(1, 5);

		Cnd cnd = Cnd.where("userId", "=", userId);
		cnd.and("orderType", "=", 2).and("orderStatus", "=", "0").desc("createTime");

		List<Order> orderList = dao.query(Order.class, cnd, pager);
		dao.fetchLinks(orderList, "user");
		dao.fetchLinks(orderList, "orderItemList");

		return getGoodsByOrder(orderList);
	}

	// 通过订单获取原始的商品
	private List<Goods> getGoodsByOrder(List<Order> orderList) {
		dao.fetchLinks(orderList, "user");
		dao.fetchLinks(orderList, "orderItemList");

		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for (Order order : orderList) {
			orderItemList.addAll(orderService.getOrderItemByOrder(order));
		}

		List<Goods> goodsList = new ArrayList<Goods>();
		for (OrderItem oi : orderItemList) {
			goodsList.add(oi.getGoods());
		}

		return goodsList;
	}

	/**
	 * 获取用户未使用过的5张优惠劵
	 * 
	 * @param userId
	 *            用户id
	 */
	public Goods getUnusedCouponByIndex(long userId, int index) {
		Pager pager = dao.createPager(index, 1);

		Cnd cnd = Cnd.where("userId", "=", userId);
		cnd.and("orderType", "=", 2).and("orderStatus", "=", "0").desc("createTime");

		List<Order> orderList = dao.query(Order.class, cnd, pager);
		dao.fetchLinks(orderList, "user");
		dao.fetchLinks(orderList, "orderItemList");

		if (orderList.size() > 0) {
			Order order = orderList.get(0);
			List<OrderItem> orderItemList = orderService.getOrderItemByOrder(order);
			if (orderItemList != null && orderItemList.size() > 0) {
				return orderItemList.get(0).getGoods();
			}
		}

		return null;
	}
}
