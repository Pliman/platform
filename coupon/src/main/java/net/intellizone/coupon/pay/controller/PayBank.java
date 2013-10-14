/*
 * PayBank.java 2012-2-16
 * 智域工作室
 */
package net.intellizone.coupon.pay.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.order.model.Order;
import net.intellizone.coupon.order.model.OrderItem;
import net.intellizone.coupon.order.services.OrderService;
import net.intellizone.coupon.user.model.User;
import net.intellizone.sysparam.services.SysParam;
import net.intellizone.utils.DateUtils;
import net.intellizone.utils.FlowNoUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 支付结算
 * 
 * @author Pliman
 * @version 1.0 2012-2-16
 * @since coupon 1.0
 */
@Controller
public class PayBank {
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
	 * @return 支付结算页面
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/paybank", method = RequestMethod.POST)
	public String payCount(@RequestParam(required = false, defaultValue = "none_custom_amount")
	String isCustomAmount,@RequestParam(required = false, defaultValue = "")
	String attach, Goods goods, HttpServletResponse response, HttpServletRequest request,
			Model model) throws IllegalAccessException, InvocationTargetException {
		model.addAttribute("goods", goods);

		Order order = new Order();
		// 订单号 CHAR(30)
		order.setOrderNo(FlowNoUtil.timeBased20FlowNo());
		order.setOrderReqTranSeq(FlowNoUtil.timeBased20FlowNo());
		order.setCreateTime(new Date().getTime());
		order.setCurType("RMB");
		order.setEncodeType("1");
		
		if(attach.indexOf("buy_coupon") > -1){
			order.setOrderType(2);
		}

		// 设置购买者和商品
		User user = (User) request.getSession().getAttribute("currUser");
		order.setUser(user);
		order.setUseId(user.getId());

		order.setOrderType(1);
		order.setOrderAmount(goods.getPrice() - goods.getDiscount());
		order.setProductAmount(goods.getPrice());
		order.setAttachAmount(goods.getDiscount());

		// 生成订单项
		OrderItem orderItem = new OrderItem();
		BeanUtils.copyProperties(orderItem, goods);
		orderItem.setGoods_id(goods.getId());

		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItemList.add(orderItem);
		order.setOrderItemList(orderItemList);

		orderService.insertOrder(order);

		model.addAttribute("order", order);

		SysParam instance = SysParam.INSTANCE;
		// SP身份标识 CHAR(30)
		String MERCHANTID = instance.getSysParamValueByCode("MERCHANTID");
		model.addAttribute("MERCHANTID", MERCHANTID);
		// SP下的子SP身份标识 CHAR(30)
		// model.addAttribute("SUBMERCHANTID",
		// instance.getSysParamValueByCode("SUBMERCHANTID"));
		// 前台返回地址 CHAR(255)
		model.addAttribute("MERCHANTURL", instance.getSysParamValueByCode("MERCHANTURL"));
		// 后台返回地址 CHAR(255)
		model.addAttribute("BACKMERCHANTURL", instance.getSysParamValueByCode("BACKMERCHANTURL"));
		// 业务类型代码 CHAR(10)
		model.addAttribute("BUSICODE", "0001");
		// 订单总金额
		int ORDERAMOUNT = (int)(goods.getPrice() - goods.getDiscount())*100;
		model.addAttribute("ORDERAMOUNT", ORDERAMOUNT);
		// 产品金额
		int PRODUCTAMOUNT = (int)(goods.getPrice()*100);
		model.addAttribute("PRODUCTAMOUNT", PRODUCTAMOUNT);
		// 附加金额
		int ATTACHAMOUNT = (int)(goods.getDiscount()*100);
		model.addAttribute("ATTACHAMOUNT", ATTACHAMOUNT);
		// MAC校验域 CHAR(256)
		// TODO Pliman 作为订单的一个字段
		model.addAttribute("MAC", DigestUtils.md5Hex(String.format(
				"MERCHANTID=%s&ORDERSEQ=%s&ORDERDATE=%s&ORDERAMOUNT=%s", MERCHANTID, order
						.getOrderNo(), DateUtils.formatDate(new Date(order.getCreateTime()),
						"yyyyMMdd"), ORDERAMOUNT)));
		System.out.println(String.format(
				"MERCHANTID=%s&ORDERSEQ=%s&ORDERDATE=%s&ORDERAMOUNT=%s", MERCHANTID, order
				.getOrderNo(), DateUtils.formatDate(new Date(order.getCreateTime()),
				"yyyyMMdd"), ORDERAMOUNT));
		
		model.addAttribute("ATTACH", attach);

		return "pay_select_bank";
	}
}
