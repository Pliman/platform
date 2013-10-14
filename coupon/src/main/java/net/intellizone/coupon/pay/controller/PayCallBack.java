/*
 * BestPayCallBack.java 2012-1-14
 * 智域团队
 */
package net.intellizone.coupon.pay.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.coupon.model.Cart;
import net.intellizone.coupon.coupon.services.CartService;
import net.intellizone.coupon.order.model.Order;
import net.intellizone.coupon.order.services.OrderService;
import net.intellizone.utils.NumberUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 支付结果接受类
 * 
 * @author Pliman
 * @version 1.0 2012-1-14
 * @since coupon 1.0
 */
@Controller
public class PayCallBack {
	// 日志记录器
	private static final Logger logger = Logger.getLogger(PayCallBack.class.getSimpleName());
	
	@Resource
	CartService cartService;
	
	@Resource
	OrderService orderService;

	/**
	 * 获取支付结果并返回值给支付端
	 * 
	 * @param response
	 *            响应
	 * @param request
	 *            支付结果请求
	 * @param model
	 *            模型
	 * @return 支付成功页面
	 */
	@RequestMapping(value = "/paycallback", method = RequestMethod.POST)
	public void payCallBack(HttpServletResponse response, HttpServletRequest request, Model model) {
		String upTranSeq = request.getParameter("UPTRANSEQ");

		// 获取签名字段的值，并计算签名
		String merchantId = request.getParameter("MERCHANTID");
		String orderId = request.getParameter("ORDERID");
		String payment = request.getParameter("PAYMENT");
		String retnCode = request.getParameter("RETNCODE");
		String retnInfo = request.getParameter("RETNINFO");
		String payDate = request.getParameter("PAYDATE");
		String key = request.getParameter("KEY");
		String attach = request.getParameter("ATTACH");
		
		if(attach.indexOf("buy_coupon") > -1){
			Cart cart = cartService.getCartById(NumberUtils.convertToLong(attach.substring(14, attach.length())));
			cart.setCart_status((byte)1);
			
			cartService.updateObj(cart);
		}

		String validateStr = String.format(
				"UPTRANSEQ=%s&MERCHANTID=%s&ORDERID=%s&PAYMENT=%s&RETNCODE=%s&RETNINFO=%s&PAYDATE=%s&KEY=%s",
				upTranSeq, merchantId, orderId, payment, retnCode, retnInfo, payDate, key);

		String sign = request.getParameter("SIGN");

		try {
			// 验证支付是否被改动了
			if (DigestUtils.md5Hex(validateStr).equalsIgnoreCase(sign)) {
				if (logger.isDebugEnabled()) {
					logger.debug("支付成功");
				}
				Order order = orderService.getOrderById(NumberUtils.convertToLong(orderId));
				order.setOrderStatus(1);
				orderService.updateOrder(order);
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("支付失败");
				}
			}

			PrintWriter out = response.getWriter();

			// 将结果信息或写给支付平台
			out.write("UPTRANSEQ_" + upTranSeq);
			out.flush();
			out.close();
		} catch (IOException e) {
			logger.warn("获取响应输出流出错", e);
		}
	}
}
