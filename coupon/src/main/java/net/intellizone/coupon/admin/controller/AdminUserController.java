package net.intellizone.coupon.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.admin.services.AdminUserService;

import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 会员管理
 * @author applenono
 *
 */
@Controller
public class AdminUserController {
	@Resource 
	private AdminUserService adminUserService;
	@RequestMapping(value="/admin/useradmin",method=RequestMethod.GET)
	public  String useradmin(@RequestParam(required = false, defaultValue = "1") int p,@RequestParam(required = false, defaultValue = "20") int n,@RequestParam(required = false, defaultValue = "0") int a,HttpServletResponse response,HttpServletRequest request, Model model){

		QueryResult pageObj=adminUserService.getUserListPagination(p,n);
		model.addAttribute("pageObj", pageObj);
		return "admin/user_admin";
	}
	

}
