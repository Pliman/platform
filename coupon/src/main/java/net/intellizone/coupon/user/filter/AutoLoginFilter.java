/*
 * AutoLoginFilter.java 2012-2-12
 * 智域工作室
 */
package net.intellizone.coupon.user.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;

import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.user.services.UserService;
import net.intellizone.coupon.util.web.cookie.CookieUtil;

/**
 * 自动登录过滤器
 * 
 * @author Pliman
 * @version 1.0 2012-2-12
 * @since coupon 1.0
 */
public class AutoLoginFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException,
			IOException {
		UserService userService = new UserService();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(true);

		// 如果session中没有user对象，则创建一个。
		User user = (User) session.getAttribute("currUser");

		// 需要当前是未登录用户状态
		if (user == null) {
			Cookie[] cookies = request.getCookies();
			String userName = CookieUtil.getCookieValue(cookies, "autoLoginUser");
			userName = new String(new BASE64Decoder().decodeBuffer(userName),"UTF-8");
			String sessionId = CookieUtil.getCookieValue(cookies, "sessionid");

			user = userService.getUserByUserName(userName);
			if (user != null && user.getLastSessionId() != null && user.getLastSessionId().equals(sessionId)) {
				// 如果最后登录sessionId和cookies中的sessionId一致，则自动登录成功
				session.setAttribute("currUser", user);
			}
		}
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}
}