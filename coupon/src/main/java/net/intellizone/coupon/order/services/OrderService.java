/*
 * OrderService.java 2012-2-9
 * 智域工作室
 */
package net.intellizone.coupon.order.services;

import java.util.Date;
import java.util.List;

import net.intellizone.coupon.order.model.Order;
import net.intellizone.coupon.order.model.OrderItem;
import net.intellizone.coupon.user.model.User;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

/**
 * 订单服务
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Service
public class OrderService {
	Dao dao;

	OrderService() {
		dao = new NutDao(MysqlDataSourceManager.INSTANCE.getDataSource());
	}

	/**
	 * 根据id获取订单
	 * 
	 * @param id
	 *            订单id
	 * @return 订单对象
	 */
	public Order getOrderById(long id) {
		Order order = dao.fetch(Order.class, id);
		dao.fetchLinks(order, "user");
		dao.fetchLinks(order, "goods");
		dao.fetchLinks(order, "orderItemList");
		return order;
	}
	
	// 获取订单条目
	public List<OrderItem> getOrderItemByOrder(Order order){
		List<OrderItem> orderItemList = order.getOrderItemList();
		dao.fetchLinks(orderItemList, "belongShopObj");
		dao.fetchLinks(orderItemList, "goods");
		
		return orderItemList;
	}

	/**
	 * 通过订单编码获取订单
	 * 
	 * @param orderNo
	 *            订单编码
	 * @return 订单
	 */
	public Order getOrderbyOrderNo(String orderNo) {
		return dao.fetch(Order.class, Cnd.where("orderNo", "=", orderNo));
	}

	/**
	 * 插入订单
	 * 
	 * @param order
	 *            订单对象
	 * @return 插入后的订单对象
	 */
	public Order insertOrder(Order order) {
		dao.insert(order);
		return dao.insertLinks(order, "orderItemList");
	}

	/**
	 * 根据用户和商品获取订单
	 * 
	 * @param userId
	 *            用户
	 * @param goodsId
	 *            商品
	 * @return 订单
	 */
	public Order getOrderbyOrderItem(long goodsId) {
		OrderItem orderItem = getOrderItemById(goodsId);
		
		return dao.fetch(Order.class, orderItem.getOrder_id());
	}

	/**
	 * 查询订单
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
	public QueryResult queryOrder(String orderNo, long beginTime, long endTime, int pageSize,
			int page) {
		Pager pager = dao.createPager(page, pageSize);

		Cnd cnd = Cnd.where("createTime", ">=", beginTime);
		if (!"".equals(orderNo)) {
			cnd.and("orderNo", "like", "%" + orderNo + "%");
		}
		if (endTime != 0) {
			cnd.and("createTime", "<=", endTime);
		}

		List<Order> orderList = dao.query(Order.class, cnd, pager);
		dao.fetchLinks(orderList, "user");
		dao.fetchLinks(orderList, "goods");

		pager.setRecordCount(dao.count(Order.class, cnd));
		return new QueryResult(orderList, pager);
	}

	/**
	 * 查询用户收藏的所有优惠劵
	 * 
	 * @return 订单列表
	 */
	public List<Order> queryCouponByUser(User user) {
		Cnd cnd = Cnd.where("userId", "=", user.getId()).and("orderType", "=", 2);

		List<Order> orderList = dao.query(Order.class, cnd, null);
		dao.fetchLinks(orderList, "user");
		dao.fetchLinks(orderList, "goods");

		return orderList;
	}
	
	/**
	 * 查询用户收藏的未使用优惠劵
	 * 
	 * @return 订单列表
	 */
	public List<Order> queryUnusedCouponByUser(User user) {
		Cnd cnd = Cnd.where("userId", "=", user.getId()).and("orderType", "=", 2).and("orderStatus","=","0");

		List<Order> orderList = dao.query(Order.class, cnd, null);
		dao.fetchLinks(orderList, "user");
		dao.fetchLinks(orderList, "goods");

		return orderList;
	}

	/**
	 * 删除order
	 * 
	 * @param order
	 * @return
	 */
	public int deleteOrder(Order order) {
		return dao.delete(order);
	}

	/**
	 * 更新订单
	 * 
	 * @param order
	 * @return
	 */
	public int updateOrder(Order order) {
		return dao.update(order);
	}
	
	public OrderItem getOrderItemById(long id){
		OrderItem orderItem = dao.fetch(OrderItem.class, id);
		dao.fetchLinks(orderItem, "goods");
		return orderItem;
	}

	public static void main(String[] args) {
		OrderService service = new OrderService();

		Order order = new Order();
		order.setOrderType(2);
		order.setCreateTime(new Date().getTime());

		System.out.println(service.insertOrder(order).getId());
	}
}