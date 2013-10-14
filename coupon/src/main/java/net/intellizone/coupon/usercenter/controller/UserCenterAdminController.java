/*
 * UserCenterAdminController.java 2012-1-18
 * 智域工作室
 */
package net.intellizone.coupon.usercenter.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.user.services.UserService;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户中心-账户管理处理类
 * 
 * @author Pliman
 * @version 1.0
 * @since user 1.0
 */
@Controller
public class UserCenterAdminController {
	// 日志记录器
	private static final Logger logger = Logger.getLogger(UserCenterAdminController.class.getSimpleName());

	// 用户服务
	@Resource
	UserService userService;

	/**
	 * 用户中心--用户管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/uc/uc_admin", method = RequestMethod.GET)
	public String userCenterAdmin(HttpServletResponse response, HttpServletRequest request, Model model) {
		User currUser = (User) request.getSession().getAttribute("currUser");

		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}

		model.addAttribute("currUser", currUser);

		return "uc/uc_admin";
	}

	/**
	 * 用户中心--用户管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/uc/uc_admin", method = { RequestMethod.POST })
	public String userCenterAdminSave(@RequestParam(required = false)
	String username, @RequestParam(required = false)
	String nick, @RequestParam(required = false, defaultValue = "")
	String email, @RequestParam(required = false, defaultValue = "0")
	int sex, @RequestParam(required = false, defaultValue = "0")
	long mobile, @RequestParam(required = false, defaultValue = "0")
	String tel, @RequestParam(required = false, defaultValue = "")
	String addr, HttpServletResponse response, HttpServletRequest request, Model model) {
		User currUser = (User) request.getSession().getAttribute("currUser");

		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}

		currUser.setName(username);
		currUser.setNick(nick);
		currUser.setEmail(email);
		currUser.setSex(sex);
		currUser.setMobile(mobile);
		currUser.setTel(tel);
		currUser.setUserAddr(addr);

		userService.updateUser(currUser);

		model.addAttribute("currUser", currUser);

		return "uc/uc_admin";
	}

	/**
	 * 修改密码--进入页面
	 * 
	 * @param response
	 *            响应
	 * @param request
	 *            请求
	 * @param model
	 *            返回给页面的参数
	 * @return 页面代码
	 */
	@RequestMapping(value = "/uc/uc_change_pass", method = { RequestMethod.GET })
	public String userCenterPass(HttpServletResponse response, HttpServletRequest request, Model model) {
		User currUser = (User) request.getSession().getAttribute("currUser");

		if (currUser == null) {
			// 如果没登陆，跳到登录页面
			return "login";
		}

		return "uc/uc_change_pass";
	}

	/**
	 * 修改密码--执行页面
	 * 
	 * @param response
	 *            响应
	 * @param request
	 *            请求
	 * @param model
	 *            返回给页面的参数
	 * @return 页面代码
	 */
	@RequestMapping(value = "/uc/uc_change_pass", method = { RequestMethod.POST })
	public void userCenterPassSave(@RequestParam(required = false)
	String oldLp, @RequestParam(required = false)
	String newLp, @RequestParam(required = false)
	String oldPp, @RequestParam(required = false)
	String newPp, HttpServletResponse response, HttpServletRequest request, Model model) {
		User currUser = (User) request.getSession().getAttribute("currUser");

		StringBuilder returnMsg = new StringBuilder();

		if (currUser == null) {
			// 如果没登陆，返回错误信息
			returnMsg.append("当前用户非法，修改密码失败");
		} else {

			// 验证旧登录密码
			if (oldLp != null && !"".equals(oldLp)) {
				if (currUser.getPassword().equalsIgnoreCase(DigestUtils.md5Hex(oldLp))) {
					// 更新登录密码
					currUser.setPassword(DigestUtils.md5Hex(newLp));
					returnMsg.append("修改登录密码成功 ");
				} else {
					returnMsg.append("修改登录密码失败，原登录密码不匹配 ");
				}
			}

			// 验证旧支付密码
			if (oldPp != null && !"".equals(oldPp)) {
				if (currUser.getPayPass().equalsIgnoreCase(DigestUtils.md5Hex(oldPp))) {
					// 更新支付密码
					currUser.setPayPass(DigestUtils.md5Hex(newPp));
					returnMsg.append("修改支付密码成功");
				} else {
					returnMsg.append("修改支付密码失败，原支付密码不匹配");
				}
			}

			userService.updateUser(currUser);
		}

		try {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.print(returnMsg.toString());

			out.flush();
			out.close();
		} catch (IOException e) {
			logger.warn("获取响应输出流失败", e);
		}
	}
}
