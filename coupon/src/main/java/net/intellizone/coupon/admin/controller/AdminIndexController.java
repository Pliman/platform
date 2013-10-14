package net.intellizone.coupon.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class AdminIndexController {
	@RequestMapping(value="/admin/index",method=RequestMethod.GET) 
	public  String homess(HttpServletResponse response,HttpServletRequest request, Model model){
	//model.addAttribute("cityList", cityList);
		return "admin/admin";
	}
	
	@RequestMapping(value="/admin/welcome",method=RequestMethod.GET) 
	public  String welcome(HttpServletResponse response,HttpServletRequest request, Model model){
	//model.addAttribute("cityList", cityList);
		return "admin/welcome";
	}
}
