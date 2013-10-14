/*
 * CouponController.java
 * 智域工作室
 */
package net.intellizone.coupon.coupon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.admin.model.CouponDemo;
import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.coupon.model.BussinessCircle;
import net.intellizone.coupon.coupon.model.Cart;
import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.coupon.services.BussinessCircleService;
import net.intellizone.coupon.coupon.services.CartService;
import net.intellizone.coupon.coupon.services.GoodsService;
import net.intellizone.coupon.msg.services.CouponMMSService;
import net.intellizone.coupon.order.model.Order;
import net.intellizone.coupon.order.model.OrderItem;
import net.intellizone.coupon.order.services.OrderService;

import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.util.web.AppContext;
import net.intellizone.coupon.util.web.WaterMark;
import net.intellizone.utils.DateUtils;
import net.intellizone.utils.FlowNoUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mass
 * @version 1.0
 */
@Controller
public class CouponController {
	// 日志记录器
	private static final Logger logger = Logger.getLogger(CouponController.class.getSimpleName());

	@Resource
	private GoodsService goodsService;
	@Resource
	private BussinessCircleService bussinessCircleService;
	@Resource
	private OrderService orderService;
	@Resource
	private CartService cartService;
	@Resource
	CouponMMSService couponMMSService;

	/**
	 * 优惠券查询控制器GET方法
	 * 
	 * @param p
	 *            页码
	 * @param wd
	 *            关键词
	 * @param cat
	 *            分类ID
	 * @param bc
	 *            商圈ID
	 * @return 优惠劵列表
	 */
	@RequestMapping(value = "/coupon", method = RequestMethod.GET)
	public String coupon(@RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = false, defaultValue = "0")
	int cat, @RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "0")
	int order, HttpServletResponse response, HttpServletRequest request, Model model) {
		City city = (City) request.getSession().getAttribute("city");

		List<BussinessCircle> bussinessCircleList = bussinessCircleService
				.getAllBussinessCircleByCityId((int) city.getId());
		
		wd = wd.trim();
		QueryResult pageObj = goodsService.getAllGoodsByTypeAndkeyIdAndKeyWordsPagination(1, p,
				Constants.PAGESIZE7, cat, bc, wd, order,(int)city.getId());
		model.addAttribute("wd", wd);
		model.addAttribute("pageObj", pageObj);
		model.addAttribute("cat", cat);
		model.addAttribute("bc", bc);
		model.addAttribute("p", p);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList",city.getShopCategoryList());
		model.addAttribute("order", order);
		return "couponlist";
	}

	/**
	 * 优惠券详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/couponDetail", method = RequestMethod.GET)
	public String couponDetail(@RequestParam(required = false, defaultValue = "1")
	int id, HttpServletResponse response, HttpServletRequest request, Model model) {

		Goods goods = goodsService.getGoodsById(id);
		model.addAttribute("goods", goods);

		model.addAttribute("shop", goods.getBelongShopObj());

		return "coupondetail";
	}

	/**
	 * 打印优惠券
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/couponPrint", method = RequestMethod.GET)
	public String couponPrint(@RequestParam(required = false, defaultValue = "1")
	int id, HttpServletResponse response, HttpServletRequest request, Model model) {

		Goods goods = goodsService.getGoodsById(id);
		model.addAttribute("id", id);
		model.addAttribute("goods", goods);
		return "print";
	}

	/**
	 * 收藏优惠劵
	 * 
	 * @param id
	 *            优惠劵id
	 * @param response
	 * @param request
	 * @param model
	 * @return 返回响应码，相应信息，以及错误代码(如果有的话):0,成功 1,用户未登录 2,优惠劵信息非法 3,订单已经存在
	 */
	@RequestMapping(value = "/collectcoupon", method = RequestMethod.GET)
	public void collectCoupon(@RequestParam(required = false, defaultValue = "0")
	int id, HttpServletResponse response, HttpServletRequest request, Model model) {
		String rtnMsg = "{'rtnCode':%s,'rtnMsg':'%s','errorCode':%s}";

		User user = (User) request.getSession().getAttribute("currUser");
		// 如果用户未登录
		if (user == null) {
			rtnMsg = String.format(rtnMsg, Constants.FAILURE, "请先登录再收藏优惠劵", 1);
		} else {
			// 如果有商品id
			if (id != 0) {
				Goods goods = goodsService.getGoodsById(id);
				// 如果对应id没有商品
				if (goods == null) {
					rtnMsg = String.format(rtnMsg, Constants.FAILURE, "非法的优惠劵", 2);
				} else {
					Cart cart = cartService.getCartbyUserAndGoods(user.getId(), id);
					// 如果订单已经存在
					if (cart != null) {
						rtnMsg = String.format(rtnMsg, Constants.FAILURE, "您已经收藏过了该优惠劵！", 3);
					} else {// 收藏成功
						cart = new Cart();

						cart.setUserId(user.getId());
						cart.setGoodsId(id);
						cart.setGoodsNum(1);
						cart.setAddTime(System.currentTimeMillis());
						cartService.insertObj(cart);

						rtnMsg = String.format(rtnMsg, Constants.SUCCESS, "", 0);
					}
				}
				// 如果没有id
			} else {
				rtnMsg = String.format(rtnMsg, Constants.FAILURE, "非法的优惠劵", 2);
			}
		}

		try {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(rtnMsg);

			out.flush();
			out.close();
		} catch (IOException e) {
			logger.warn("获取响应输出流出错", e);
		}
	}

	/**
	 * 生成打印图
	 */
	@RequestMapping(value = "/goods/print_img.do", method = RequestMethod.GET)
	public void getYQByOrder(@RequestParam(required = false, defaultValue = "")
	String orderId, HttpServletResponse response, HttpServletRequest request, Model model) {
		response.setContentType("image/bmp");

		Order order = orderService.getOrderById(Long.parseLong(orderId));

		OrderItem orderItem = orderService.getOrderItemByOrder(order).get(0);

		String Logo = "nologo.jpg";

		CouponDemo couponDemo = new CouponDemo();

		if (orderItem.getBelongShopObj() != null) {// 属于所有商户
			if (orderItem.getBelongShopObj().getShop_logo() != null) {
				Logo = orderItem.getBelongShopObj().getShop_logo();
			}
		}
		String logopath = AppContext.getInstance().getAPP_PATH() + "goods0\\img\\" + "\\"
		+ Logo;

		couponDemo.setNo(order.getOrderNo());
		couponDemo.setShopLogoPath(logopath);
		couponDemo.setTitle(orderItem.getName());
		couponDemo.setBeginTime(DateUtils.formatDate(new Date(orderItem.getBegin_time())));
		couponDemo.setEndTime(DateUtils.formatDate(new Date(orderItem.getEnd_time())));
		couponDemo.setUserInfo(orderItem.getUse_intro());
		couponDemo.setTelphone(orderItem.getBelongShopObj().getTelephone());
		couponDemo.setUseAddress(orderItem.getUse_addr());
		couponDemo.setBtmLogoPath(AppContext.getInstance().getAPP_PATH()
				+ "res\\images\\logo_btm.jpg");

		WaterMark.outMarkLogo(response, couponDemo);
	}

	// 发送到手机
	@RequestMapping(value = "send_to_cell_phone", method = RequestMethod.POST)
	public Object sendToCellPhone(@RequestParam(required = false, defaultValue = "")
	long couponId, HttpServletResponse response, HttpServletRequest request, Model model)
			throws IllegalAccessException, InvocationTargetException {
		User user = (User) request.getSession().getAttribute("currUser");

		if (user == null) {
			// 如果没登陆，跳到登录页面
			model.addAttribute("jumpUrl", request.getRequestURI());

			return "login";
		}

		// 发送到手机的同时，也收藏
		// 如果已经收藏
		Cart cart = cartService.getCartbyUserAndGoods(user.getId(), couponId); 
		
		if(cart == null){
			cart = new Cart();
			cart.setUserId(user.getId());
			cart.setGoodsId(couponId);
			cart.setGoodsNum(1);
			cart.setAddTime(System.currentTimeMillis());
			// 收藏状态为未支付
			cart.setCart_status((byte) 0);
			
			cartService.insertObj(cart);
		}

		// 如果是翼支付用户，直接发送
		if (user.getIsWingsPayUser() == 1) {
			couponMMSService.sendCoupon((User) request.getSession().getAttribute("currUser"),
					"test_code", goodsService.getGoodsById(couponId));

			model.addAttribute("sendToCellPhoneMsg", "优惠劵已通过彩信方式，成功发送到您的手机");

			// 收藏状态为已支付
			cart.setCart_status((byte) 1);
			cartService.updateObj(cart);

			// 生成订购关系
			generateOrder(user, couponId);

			return "redirect:couponDetail.html?id=" + couponId;
		} else {
			// 如果是爱优惠用户，则支付后再发送
			model.addAttribute("goods", goodsService.getGoodsById(couponId));
			model.addAttribute("attach", "buy_coupon" + cart.getId());

			model.addAttribute("goodsList", goodsService.getPayGoods(6));

			return "pay_count";
		}
	}

	private void generateOrder(User user, long couponId) throws IllegalAccessException,
			InvocationTargetException {
		// 生成订单，并且为已支付
		Order order = new Order();
		order.setOrderNo(FlowNoUtil.timeBased20FlowNo());
		order.setOrderReqTranSeq(FlowNoUtil.timeBased20FlowNo());
		order.setOrderType(2); // 设置为优惠劵
		order.setCreateTime(new Date().getTime());
		order.setCurType("RMB");
		order.setEncodeType("1");
		// 设置购买者
		order.setUser(user);
		order.setUseId(user.getId());
		order.setOrderStatus(1);

		// 生成订单项
		OrderItem orderItem = new OrderItem();
		BeanUtils.copyProperties(orderItem, goodsService.getGoodsById(couponId));
		orderItem.setGoods_id(couponId);

		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItemList.add(orderItem);
		order.setOrderItemList(orderItemList);

		orderService.insertOrder(order);
	}
}
