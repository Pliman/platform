/*
 * UserCenterOrderController.java 2012-2-17
 * 智域工作室
 */
package net.intellizone.coupon.usercenter.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.activity.model.Activity;
import net.intellizone.coupon.activity.services.ActivityService;
import net.intellizone.coupon.order.model.Order;
import net.intellizone.coupon.order.services.OrderService;
import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.user.services.UserService;
import net.intellizone.coupon.usercenter.services.UCOrderService;
import net.intellizone.utils.DateUtils;

import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户中心，订单查询
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Controller
public class UserCenterOrderController {
	// 用户服务
	@Resource
	UserService userService;
	
	// 订单服务
	@Resource
	OrderService orderService;

	// 用户订单服务
	@Resource
	UCOrderService ucOrderService;

	
	@Resource
	private ActivityService activityService;
	/**
	 * 列出本用户的购物订单
	 * 
	 * @param p
	 * @param orderNo
	 * @param beginTime
	 * @param endTime
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/uc/uc_order_list", method = RequestMethod.GET)
	public String userCenterOrderList(@RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "")
	String orderNo, @RequestParam(required = false, defaultValue = "")
	String beginTime, @RequestParam(required = false, defaultValue = "")
	String endTime, HttpServletResponse response, HttpServletRequest request, Model model)
			throws UnsupportedEncodingException {
		User currUser = (User) request.getSession().getAttribute("currUser");

		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}

		long beginTimeLong = !"".equals(beginTime) ? (DateUtils.converToDateTime(beginTime).getTime()) : 0;
		long endTimeLong = !"".equals(endTime) ? (DateUtils.converToDateTime(endTime).getTime()) : 0;

		String queryString = String.format("%s%s%s", "".equals(orderNo) ? "" : "&orderNo=" + orderNo, ""
				.equals(beginTime) ? "" : "&beginTime=" + beginTime, "".equals(endTime) ? "" : "&endTime=" + endTime);

		QueryResult qr = ucOrderService.queryCommonOrderByUser(orderNo, beginTimeLong, endTimeLong,
				Constants.DEFAULT_PAGESIZE, p, currUser.getId());

		model.addAttribute("queryString", queryString);
		model.addAttribute("page", p);
		model.addAttribute("orderNo", orderNo);
		model.addAttribute("totalPage", qr.getPager().getPageCount());
		model.addAttribute("beginTime", beginTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("orderList", qr.getList(Order.class));

		return "uc/uc_order_list";
	}

	/**
	 * 查看订单
	 * 
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/uc/uc_order_view", method = RequestMethod.GET)
	public String userCenterOrderView(@RequestParam(required = true)
	long order_id, HttpServletResponse response, HttpServletRequest request, Model model) {
		User currUser = (User) request.getSession().getAttribute("currUser");

		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}
		
		Order order = orderService.getOrderById(order_id);
		List<Activity> actList = activityService.getOrderAct(6);
		model.addAttribute("actList",actList);
		model.addAttribute("order",order);
		

		return "uc/uc_order_view";
	}
	
	/**
	 * 条件查询订单
	 * 
	 * @param 
	 * @return
	 * */
	@RequestMapping(value = "/uc/uc_order_search" , method = RequestMethod.GET)
	public String orderSearch(
							  @RequestParam(required = false, defaultValue = "1")int p,
							  @RequestParam(required = false, defaultValue = "")String orderstatus,
							  @RequestParam(required = false, defaultValue = "")String orderNo,
							  @RequestParam(required = false, defaultValue = "1")String time,
							  HttpServletResponse response,HttpServletRequest request,Model model){
		QueryResult orderList = null;
		User currUser = (User) request.getSession().getAttribute("currUser");
		orderList =  ucOrderService.getByOrderSearch(Constants.DEFAULT_PAGESIZE, p, time, orderNo, orderstatus,currUser.getId());
		model.addAttribute("orderList",orderList.getList(Order.class));
		model.addAttribute("page", p);
		model.addAttribute("orderNo", orderNo);
		model.addAttribute("totalPage", orderList.getPager().getPageCount());
		return "uc/uc_order_list";
	}
}
