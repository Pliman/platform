/*
 * UserCenterActivityContoller.java 2012-1-16
 * 智域工作室
 */
package net.intellizone.coupon.usercenter.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.activity.model.Activity;
import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.coupon.model.BussinessCircle;
import net.intellizone.coupon.coupon.services.BussinessCircleService;
import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.user.services.UserService;
import net.intellizone.coupon.usercenter.services.UCActivityService;

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
public class UserCenterActivityContoller {
	// 用户服务
	@Resource
	UserService userService;

	// 用户服务
	@Resource
	UCActivityService ucActivityService;

	// 商圈服务
	@Resource
	BussinessCircleService bussinessCircleService;

	/**
	 * 用户中心--活动列表
	 * 
	 * @return
	 */

	@RequestMapping(value = "/uc/uc_activity_list", method = RequestMethod.GET)
	public String userCenterActivityList(@RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int bc,@RequestParam(required = false, defaultValue = "0")
	String bcStr, @RequestParam(required = false, defaultValue = "0")
	int on,@RequestParam(required = false, defaultValue = "0")
	String onStr, @RequestParam(required = false, defaultValue = "")
	String kw, HttpServletResponse response, HttpServletRequest request, Model model)
			throws UnsupportedEncodingException {
		User currUser = (User) request.getSession().getAttribute("currUser");

		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}

		City city = (City) request.getSession().getAttribute("city");
		List<BussinessCircle> buizCircleList = bussinessCircleService
				.getAllBussinessCircleByCityId((int) city.getId());

		QueryResult qr = ucActivityService.getActivityByKwBCAndOn(kw, bc, on, p,
				Constants.PAGESIZE8);
		

		String queryString = String.format("kw=%s&bc=%s&on=%s", URLEncoder.encode(kw, "UTF-8"), bc,
				on);
		model.addAttribute("queryString", queryString);

		model.addAttribute("buizCircleList", buizCircleList);
		model.addAttribute("page", p);
		model.addAttribute("totalPage", qr.getPager().getPageNumber());
		model.addAttribute("kw", kw);
		model.addAttribute("bc", bc);
		model.addAttribute("bcStr", bcStr.equals("0")?"":bcStr);
		model.addAttribute("on", on);
		model.addAttribute("onStr", onStr.equals("0")?"进行中":onStr);
		model.addAttribute("activityList", qr.getList(Activity.class));

		return "uc/uc_activity_list";
	}
}
