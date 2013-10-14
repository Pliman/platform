/*
 * ShopController.java
 * 智域工作室
 */
package net.intellizone.coupon.shop.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import net.intellizone.core.constants.Constants;

import net.intellizone.coupon.city.model.City;

import net.intellizone.coupon.coupon.model.BussinessCircle;
import net.intellizone.coupon.coupon.services.BussinessCircleService;
import net.intellizone.coupon.shop.model.Shop;
import net.intellizone.coupon.shop.services.ShopService;

import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 商家类
 * 
 * @author applenono
 * @version 1.0
 */
@Controller
public class ShopController {
	@Resource
	private BussinessCircleService bussinessCircleService;
	@Resource
	private ShopService shopService;

	// 商户列表
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shop(@RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "0")
	int order, @RequestParam(required = false, defaultValue = "0")
	int cat, HttpServletResponse response, HttpServletRequest request, Model model)
			throws UnsupportedEncodingException {

		City city = (City) request.getSession().getAttribute("city");
		
		wd = wd.trim();
		QueryResult shopPageList = shopService.getAllShopCatBykeyIdPagination(p,
				Constants.DEFAULT_PAGESIZE, cat, bc, URLDecoder.decode(wd, "utf-8"), order, city);

		List<BussinessCircle> bussinessCircleList = bussinessCircleService
				.getAllBussinessCircleByCityId((int) city.getId());
		
		model.addAttribute("order", order);
		model.addAttribute("wd", wd);
		model.addAttribute("cat", cat);
		model.addAttribute("bc", bc);
		model.addAttribute("shopList", shopPageList);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", city.getShopCategoryList());
		return "shoplist";
	}

	// 商户detail
	@RequestMapping(value = "/shopdetail", method = RequestMethod.GET)
	public String couponDetail(@RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "0")
	int cat, @RequestParam(required = false, defaultValue = "1")
	int id, HttpServletResponse response, HttpServletRequest request, Model model) {
		Shop shop = shopService.getShopById(id);
		if (shop == null) {
			model.addAttribute("opinfo", "对不起,相关信息丢失,请联系客服..");
			return "shopdetail";
		}

		City city = (City) request.getSession().getAttribute("city");
		List<BussinessCircle> bussinessCircleList = bussinessCircleService
		.getAllBussinessCircleByCityId((int) city.getId());

		int shopCat = shop.getBelong_shopcat();

		List<Shop> randomList = shopService.getRandomShop(shopCat, id); // 随机获取相关商户

		model.addAttribute("cat", cat);
		model.addAttribute("bc", bc);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", city.getShopCategoryList());
		model.addAttribute("randomList", randomList);
		model.addAttribute("shop", shop);
		return "shopdetail";
	}
}
