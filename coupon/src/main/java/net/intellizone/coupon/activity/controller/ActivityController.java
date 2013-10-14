package net.intellizone.coupon.activity.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.activity.model.Activity;
import net.intellizone.coupon.activity.services.ActivityService;
import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.coupon.model.BussinessCircle;
import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.coupon.services.BussinessCircleService;
import net.intellizone.coupon.coupon.services.RecommendService;
import net.intellizone.coupon.shop.model.Shop;

import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivityController {
	@Resource
	private ActivityService activityService;
	@Resource
	private BussinessCircleService bussinessCircleService;
	@Resource
	private RecommendService recommendService;

	/**
	 * 活动查询
	 * 
	 * @param wd
	 * @param p
	 * @param bc
	 */
	@RequestMapping(value = "/activity", method = RequestMethod.GET)
	public String activity(@RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "0")
	int order, HttpServletResponse response, HttpServletRequest request, Model model) {
		City city = (City) request.getSession().getAttribute("city");

		/** 取得热门商户*** */

		List<Shop> hotShop = recommendService.getShopByHotList();
		model.addAttribute("hotShop", hotShop);
		/** 取得推荐商户*** */
		List<Shop> recomShop = recommendService.getShopByRecommendList();
		model.addAttribute("recomShop", recomShop);
		/** * 取得推荐优惠券*** */
		List<Goods> recomGoods = recommendService.getRecommendCoupon();
		model.addAttribute("recomGoods", recomGoods);
		/** * 取得推荐活动*** */
		List<Activity> recomActivity = recommendService.getRecommendActivity();
		model.addAttribute("recomActivity", recomActivity);
		List<BussinessCircle> bussinessCircleList = bussinessCircleService
				.getAllBussinessCircleByCityId((int) city.getId());
		
		wd = wd.trim();
		QueryResult pageObj = activityService.getActivityByTypeAndkeyIdAndKeyWordsPagination(p,
				Constants.PAGESIZE7, bc, wd, order);

		model.addAttribute("wd", wd);
		model.addAttribute("pageObj", pageObj);
		model.addAttribute("bc", bc);
		model.addAttribute("p", p);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", city.getShopCategoryList());
		model.addAttribute("order", order);

		return "activitylist";
	}

	/**
	 * 活动详细
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/activityDetail", method = RequestMethod.GET)
	public String couponDetail(@RequestParam(required = false, defaultValue = "1")
	int id, HttpServletResponse response, HttpServletRequest request, Model model) {
		/** 取得热门商户*** */

		List<Shop> hotShop = recommendService.getShopByHotList();
		model.addAttribute("hotShop", hotShop);
		/** 取得推荐商户*** */
		List<Shop> recomShop = recommendService.getShopByRecommendList();
		model.addAttribute("recomShop", recomShop);
		/** * 取得推荐优惠券*** */
		List<Goods> recomGoods = recommendService.getRecommendCoupon();
		model.addAttribute("recomGoods", recomGoods);
		/** * 取得推荐活动*** */
		List<Activity> recomActivity = recommendService.getRecommendActivity();
		model.addAttribute("recomActivity", recomActivity);

		Activity activity = activityService.getActivityById(id);

		model.addAttribute("activity", activity);
		return "activityDetail";
	}

}