/*
 * IndexController.java 2012-1-10
 * 智域工作室
 */
package net.intellizone.coupon.index.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.admin.services.AdminCityService;
import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.util.web.AppContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 首页控制器
 * 
 * @author mass
 * @version 1.0
 * @since coupon 1.0
 */
@Controller
public class IndexController {
	@Resource
	private AdminCityService adminCityService;

	/**
	 * 获取城市
	 * 
	 * @param p
	 * @param wd
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getCity", method = RequestMethod.GET)
	public String getCity(@RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "")
	String wd, HttpServletResponse response, HttpServletRequest request, Model model) {

		List<City> cityList = adminCityService.getAllCity();
		model.addAttribute("p", p);
		model.addAttribute("cityList", cityList);
		model.addAttribute("wd", wd);
		
		model.addAttribute("appContext", AppContext.getInstance().getAPP_CONTEXT());
		return "city_Ajax";
	}

	/**
	 * 首页控制器
	 * 
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String index(HttpServletResponse response, HttpServletRequest request, Model model) {

		return "index";
	}
	
	

	
	
}