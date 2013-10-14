/*
 * AdminOrderController.java 2012-2-20
 * 智域工作室
 */
package net.intellizone.coupon.admin.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.order.model.Order;
import net.intellizone.coupon.order.services.OrderService;
import net.intellizone.utils.DateUtils;

import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminOrderController {
	@Resource
	private OrderService orderService;

	/**
	 * 订单列表
	 * 
	 * @param p
	 * @param orderNo
	 * @param beginTime
	 * @param endTime
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/order_admin", method = RequestMethod.GET)
	public String orderAdmin(@RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "")
	String orderNo, @RequestParam(required = false, defaultValue = "")
	String beginTime, @RequestParam(required = false, defaultValue = "")
	String endTime, HttpServletResponse response, HttpServletRequest request, Model model) {
		long beginTimeLong = !"".equals(beginTime) ? (DateUtils.converToDateTime(beginTime)
				.getTime()) : 0;
		long endTimeLong = !"".equals(endTime) ? (DateUtils.converToDateTime(endTime).getTime())
				: 0;

		QueryResult qr = orderService.queryOrder(orderNo, beginTimeLong, endTimeLong,
				Constants.PAGESIZE20, p);

		String queryString = String.format("%s%s%s", "".equals(orderNo) ? "" : "&orderNo="
				+ orderNo, "".equals(beginTime) ? "" : "&beginTime=" + beginTime, ""
				.equals(endTime) ? "" : "&endTime=" + endTime);

		model.addAttribute("queryString", queryString);
		model.addAttribute("page", p);
		model.addAttribute("orderNo", orderNo);
		model.addAttribute("totalPage", qr.getPager().getPageCount());
		model.addAttribute("beginTime", beginTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("orderList", qr.getList(Order.class));

		return "admin/order_admin";
	}

	@RequestMapping(value = "/admin/order_action", method = RequestMethod.GET)
	public String orderAction(Order order, @RequestParam(required = false, defaultValue = "0")
	String audit_reason, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("p", p);

		if (a == 1) {// 添加
			order.setCreateTime(new Date().getTime());
			orderService.insertOrder(order);
			return "redirect:order_admin.html";
		} else if (a == 5) {// 删除
			orderService.deleteOrder(order);
			return "redirect:order_admin.html";
		} else if (a == 2) {
			order.setModifyTime(new Date().getTime());
			orderService.updateOrder(order);
			return "redirect:order_adminmin.html";
		} else if (a == 3) {// 编辑
			order = orderService.getOrderById(order.getId());
			model.addAttribute("order", order);
			return "admin/order_edit";
		} else if (a == 4) {// 添加
			return "admin/order_edit";
		} else if (a == 6) {// 审核通过
			return "redirect:order_admin.html";
		} else if (a == 7) {// 审核不通过
			return "redirect:order_admin.html";
		} else if (a == 8) { // 查看
			order = orderService.getOrderById(order.getId());
			model.addAttribute("order", order);

			// 暂时支持一个
			// TODO Pliman 支持多个
			model.addAttribute("goods", order.getOrderItemList().get(0));

			return "admin/order_edit";
		}

		return "admin/order_admin";
	}
}
