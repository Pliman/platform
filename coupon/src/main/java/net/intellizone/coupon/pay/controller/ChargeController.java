/*
 * ChargeController.java 2012-2-16
 * 智域工作室
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
 * 用户充值结算
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Controller
public class ChargeController {
	@Resource
	GoodsService goodsService;
	
	@Resource
	OrderService orderService;
	
	/**
	 * 用户充值
	 * @param response
	 * @param request
	 * @param model
	 * @return 订单确认页面
	 */
	@RequestMapping(value = "/uc/user_charge", method = RequestMethod.POST)
	public String payCount(HttpServletResponse response, HttpServletRequest request, Model model) {
		int cargoCode = NumberUtils.convertToInteger(request.getParameter("cargocode"));
		Goods goods = goodsService.getGoodsByCode(cargoCode);

		// 充值的购买数量是1
		goods.setNumber(1);
		
		double price = NumberUtils.convertToDouble(request.getParameter("price"));
		if(price > 5){
			goods.setPrice(price);
		}
		// 计算折扣 还可以使用其他算法
		double discount = 0;
		if (price >= 50 && price <= 100) {
			discount = price * 0.015;
		} else if (price > 100) {
			discount = price * 0.02;
		}
		goods.setDiscount(discount);
		model.addAttribute("goods", goods);
		model.addAttribute("isCustomAmount", "custom_amount");
		
		return "pay_count";
	}
}
