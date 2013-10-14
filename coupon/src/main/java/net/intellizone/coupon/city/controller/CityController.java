/*
 * IndexController.java 2012-3-9
 * 智域工作室
 */
package net.intellizone.coupon.city.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.city.services.CityService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 城市控制器
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Controller
public class CityController {
	@Resource
	private CityService cityService;

	/**
	 * 切换当前城市
	 * 
	 * @param city
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/change_city", method = RequestMethod.GET)
	public Object changeCity(@RequestParam(required = true)
	long cityId, @RequestParam(required = false)
	String currentURL, HttpServletResponse response, HttpServletRequest request, Model model) {
		City city = cityService.getCityById(cityId);

		if (city != null) {
			request.getSession().setAttribute("city", city);
		} else {
			request.getSession().setAttribute("city", cityService.getCityById(1));
			model.addAttribute("cityErrorMsg","所选城市暂未开通此服务，切换到成都市。");
		}

		return "redirect:" + currentURL;
	}
}
