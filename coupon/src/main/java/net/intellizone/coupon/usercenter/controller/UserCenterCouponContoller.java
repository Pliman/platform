/*
 * UserCenterCouponContoller.java 2012-1-16
 * 智域工作室
 */
package net.intellizone.coupon.usercenter.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.coupon.model.BussinessCircle;
import net.intellizone.coupon.coupon.services.BussinessCircleService;
import net.intellizone.coupon.coupon.services.CartService;
import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.user.services.UserService;
import net.intellizone.coupon.usercenter.services.UCGoodsService;
import net.intellizone.utils.NumberUtils;

import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 处理用户中心优惠劵的相关请求
 * 
 * @author Pliman
 * @version 1.0 2012-1-16
 * @since coupon 1.0
 */
@Controller
public class UserCenterCouponContoller {
	// 用户服务
	@Resource
	UserService userService;

	// 用户服务
	@Resource
	UCGoodsService ucGoodsService;
	
	
	@Resource
	private BussinessCircleService bussinessCircleService;
	@Resource
	CartService cartService;

	/**
	 * 用户中心--优惠劵列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/uc/uc_coupon_list", method = RequestMethod.GET)
	public String userCenterCouponList(@RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int bc,  @RequestParam(required = false, defaultValue = "0")
	int cat,@RequestParam(required = false, defaultValue = "")
	String name,@RequestParam(required = false, defaultValue = "")
	String d,HttpServletResponse response, HttpServletRequest request, Model model)
			throws UnsupportedEncodingException {
		User currUser = (User) request.getSession().getAttribute("currUser");

		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}
		City city = (City) request.getSession().getAttribute("city");

		List<BussinessCircle> bussinessCircleList = bussinessCircleService
				.getAllBussinessCircleByCityId((int) city.getId());
		
		// 删除收藏
		if(!"".equals(d)){
			cartService.deleteCartById(NumberUtils.convertToInteger(d));
		}
		
		QueryResult pageObj = cartService.getCartByUserIdGoods(currUser.getId(), p, 6,bc,cat,name);

		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", city.getShopCategoryList());
		model.addAttribute("page", p);
		model.addAttribute("pageObj", pageObj);
		model.addAttribute("bc", bc);
		model.addAttribute("cat", cat);
		model.addAttribute("wd", name);
		return "uc/uc_coupon_list";
	}
}
