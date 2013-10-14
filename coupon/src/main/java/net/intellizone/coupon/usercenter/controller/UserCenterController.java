/*
 * UserCenterController.java 2012-1-16
 * 智域工作室
 */
package net.intellizone.coupon.usercenter.controller;

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
import net.intellizone.coupon.user.services.UserService;
import net.intellizone.coupon.usercenter.services.UCOrderService;
import net.intellizone.coupon.util.web.AppContext;
import net.intellizone.sysparam.services.SysParam;
import net.intellizone.utils.DateUtils;
import net.intellizone.utils.FlowNoUtil;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 处理用户中心的相关请求
 * 
 * @author Pliman
 * @version 1.0 2012-1-16
 * @since coupon 1.0
 */
@Controller
public class UserCenterController {
	// 用户服务
	@Resource
	UserService userService;

	@Resource
	UCOrderService ucOrderService;
	@Resource
	OrderService orderService;

	/**
	 * 用户中心--首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/uc/uc_index", method = RequestMethod.GET)
	public String userCenterIndex(HttpServletResponse response, HttpServletRequest request, Model model) {
		User currUser = (User) request.getSession().getAttribute("currUser");

		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			model.addAttribute("jumpUrl", request.getRequestURI());

			return "login";
		}

		model.addAttribute("used6Coupon", ucOrderService.get6UsedCoupon(currUser.getId()));

		// 获取用户未使用的优惠卷，先最多获取5张
		List<Goods> goodsList = ucOrderService.get5UnusedCoupon(currUser.getId());
		
		// 如果多于2张，则拆分
		if (goodsList.size() > 2) {
			model.addAttribute("unused2Coupon", goodsList.subList(0, 2));
			model.addAttribute("unused3Coupon", goodsList.subList(2, goodsList.size()));
		} else {
			model.addAttribute("unused2Coupon", goodsList);
		}

		return "uc/uc_index";
	}

	/**
	 * 用户中心--充值
	 * 
	 * @return
	 */
	@RequestMapping(value = "/uc/uc_charge", method = RequestMethod.GET)
	public String userCenterCharge(HttpServletResponse response, HttpServletRequest request, Model model) {
		User currUser = (User) request.getSession().getAttribute("currUser");

		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}

		return "uc/uc_charge";
	}
	
	
	/**
	 * 用户中心--充值第二步
	 * 
	 * @return
	 */
	@RequestMapping(value = "/uc/uc_charge_step2", method = RequestMethod.GET)
	public String userCenterCharge2(HttpServletResponse response, HttpServletRequest request, Model model,String BANK) {
		User currUser = (User) request.getSession().getAttribute("currUser");
		
		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}
		model.addAttribute("bank", BANK);
		return "uc/uc_charge_step2";
	}
	
	
	/**
	 * 用户中心--充值第二步
	 * 
	 * @return
	 */
	@RequestMapping(value = "/uc/uc_charge_step3", method = RequestMethod.GET)
	public String userCenterCharge3(@RequestParam(required = true, defaultValue = "0")
			int amount, HttpServletResponse response, HttpServletRequest request, Model model,String BANK) {
		User currUser = (User) request.getSession().getAttribute("currUser");
		
		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}
		
		OrderItem orderItem=new OrderItem();//支付一种特殊goods 
		orderItem.setName("翼支付充值");
		orderItem.setGoods_number(1);
		orderItem.setPrice(amount);
		orderItem.setGoods_id(1); // 充值的商品号为1
		
		List<OrderItem> orderItemList=new ArrayList<OrderItem>();
		orderItemList.add(orderItem);
		
		Order order = new Order();
		// 订单号 CHAR(30)
		order.setOrderNo(FlowNoUtil.timeBased20FlowNo());
		order.setOrderReqTranSeq(FlowNoUtil.timeBased20FlowNo());
		order.setCreateTime(new Date().getTime());
		order.setCurType("RMB");
		order.setEncodeType("1");
		order.setOrderItemList(orderItemList);
		
		
		
		
		// 设置购买者和商品
		User user = (User)request.getSession().getAttribute("currUser");
		order.setUser(user);
		order.setUseId(user.getId());
	

		order.setOrderType(1);
		order.setOrderAmount(amount);
		order.setProductAmount(1);
		order.setAttachAmount(10);
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
		double ORDERAMOUNT =amount;
		model.addAttribute("ORDERAMOUNT", ORDERAMOUNT);
		// MAC校验域 CHAR(256)
		// TODO Pliman 作为订单的一个字段
		model.addAttribute("MAC", DigestUtils.md5Hex(String.format(
				"MERCHANTID=%s&ORDERSEQ=%s&ORDERDATE=%s&ORDERAMOUNT=%s", MERCHANTID, order
						.getOrderNo(), DateUtils.formatDate(new Date(order.getCreateTime()),
						"yyyyMMdd"), ORDERAMOUNT)));
		
		
		String url="http://webpay.bestpay.com.cn/payWebDirect.do";
		model.addAttribute("bank", BANK);
		return "redirect:"+url;
	}


	/**
	 * 根据索引，获取一张未使用的优惠卷
	 */
	@RequestMapping(value = "/uc/uc_uc", method = RequestMethod.GET)
	public String userCenterUC(@RequestParam(required = true, defaultValue = "0")
	int index, HttpServletResponse response, HttpServletRequest request, Model model) {
		User currUser = (User) request.getSession().getAttribute("currUser");

		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}

		model.addAttribute("goods", ucOrderService.getUnusedCouponByIndex(currUser.getId(), index));
		model.addAttribute("appUploadedPic", AppContext.getInstance().getUPLOADED_PIC_URL());
		model.addAttribute("appPic", AppContext.getInstance().getPIC_URL());

		return "uc/uc_index_uc_unit_ajax";
	}
}