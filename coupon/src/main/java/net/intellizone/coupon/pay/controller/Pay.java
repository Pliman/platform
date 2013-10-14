/*
 * Payed.java 2012-1-14
 * 智域团队
 */
package net.intellizone.coupon.pay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 已提交支付
 * 
 * @author Pliman
 * @version 1.0 2012-1-14
 * @since coupon 1.0
 */
@Controller
public class Pay {
	/**
	 * 获取支付结果并返回值给支付端
	 * 
	 * @param response
	 *            响应
	 * @param request
	 *            请求
	 * @param model
	 *            模型
	 * @return 已提交支付页面
	 */
	@RequestMapping(value = "/payed", method = RequestMethod.GET)
	public String payed(HttpServletResponse response, HttpServletRequest request, Model model) {

		return "payed_t";
	}
}
