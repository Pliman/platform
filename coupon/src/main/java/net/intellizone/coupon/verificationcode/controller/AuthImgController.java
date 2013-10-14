/*
 * AuthImgController.java 2012-4-6
 * 智域工作室
 */
package net.intellizone.coupon.verificationcode.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.intellizone.coupon.verificationcode.helper.AuthImgHelper;
import net.intellizone.coupon.verificationcode.model.AuthImg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 获取验证码
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */

@Controller
public class AuthImgController {
	@RequestMapping(value = "/update_auth_img", method = RequestMethod.GET)
	public void updateAuthImg(HttpServletResponse response, HttpServletRequest request) throws IOException{
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		
		AuthImg authImg = AuthImgHelper.writeAuthImg(response.getOutputStream());
		
		HttpSession session = request.getSession();
		session.setAttribute("authImg", authImg);
	} 
}
