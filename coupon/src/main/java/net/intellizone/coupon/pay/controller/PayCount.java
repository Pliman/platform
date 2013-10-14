/*
 * PayCount.java 2012-1-14
 * 智域团队
 */
package net.intellizone.coupon.pay.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.coupon.services.GoodsService;
import net.intellizone.coupon.order.services.OrderService;
import net.intellizone.utils.NumberUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 支付结算
 * 
 * @author Pliman
 * @version 1.0 2012-1-14
 * @since coupon 1.0
 */
@Controller
public class PayCount {
	@Resource
	GoodsService goodsService;

	@Resource
	OrderService orderService;

	/**
	 * 跳到支付结算页面
	 * 
	 * @param response
	 *            响应
	 * @param request
	 *            请求
	 * @param model
	 *            模型
	 * @return 订单确认页面
	 */
	@RequestMapping(value = "/paycount", method = RequestMethod.POST)
	public String payCount(HttpServletResponse response, HttpServletRequest request, Model model) {
		int cargoCode = NumberUtils.convertToInteger(request.getParameter("cargocode"));
		Goods goods = goodsService.getGoodsByCode(cargoCode);

		// 购买数量默认设置为1
		goods.setNumber(1);

		model.addAttribute("goods", goods);
		model.addAttribute("isCustomAmount", "none_custom_amount");

		return "pay_count";
	}
}
