/*
 * BulletinController.java 2012-1-19
 * 智域团队
 */
package net.intellizone.coupon.bulletin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.bulletin.model.Bulletin;
import net.intellizone.coupon.bulletin.services.BulletinService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 公告控制器
 * 
 * @author Pliman
 * @version 1.0 2012-1-19
 * @since coupon 1.0
 */

@Controller
public class BulletinController {
	// 日志记录器
	private static final Logger logger = Logger.getLogger(BulletinController.class.getSimpleName());

	// 公告服务
	@Resource
	private BulletinService bulletinService;

	/**
	 * 获取所有公告
	 * @param response 响应
	 * @param request 请求
	 * @param model 前端参数
	 */
	@RequestMapping(value = "/bulletins", method = RequestMethod.GET)
	public void getAllBulletins(HttpServletResponse response, HttpServletRequest request,
			Model model) {
		response.setContentType("text/plain; charset=UTF-8");

		List<Bulletin> bulletinList = bulletinService.getAllBulletins();

		StringBuilder bulletinBuilder = new StringBuilder();

		for (int i = 0, len = bulletinList.size(); i < len; i++) {
			bulletinBuilder.append(i+1).append(".");
			bulletinBuilder.append(bulletinList.get(i).getContent());
			bulletinBuilder.append(" ");
		}

		try {
			PrintWriter out = response.getWriter();

			out.print(bulletinBuilder.toString());

			out.flush();
			out.close();
		} catch (IOException e) {
			logger.warn("获取响应输出流失败", e);
		}
	}
}