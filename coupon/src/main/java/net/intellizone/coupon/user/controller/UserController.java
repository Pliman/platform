/*
 * UserCenterCouponContoller.java 2012-1-18
 * 智域工作室
 */
package net.intellizone.coupon.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.intellizone.sysparam.services.SysParam;
import net.intellizone.utils.DateUtils;
import net.intellizone.utils.UrlUtils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sun.misc.BASE64Encoder;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.user.services.UserService;
import net.intellizone.coupon.usercenter.controller.UserCenterAdminController;
import net.intellizone.coupon.util.web.json.JsonUtil;

/**
 * 用户相关请求的控制器
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Controller
public class UserController {
	// 日志记录器
	private static final Logger logger = Logger.getLogger(UserCenterAdminController.class
			.getSimpleName());

	@Resource
	UserService userService;

	// 系统参数服务
	SysParam instance = SysParam.INSTANCE;
	private final String clientId = instance.getSysParamValueByCode("clientId");
	private final String udbCodeUrl = instance.getSysParamValueByCode("udbCodeUrl");
	private final String redirectUri = instance.getSysParamValueByCode("redirectUri");
	private final String scope = instance.getSysParamValueByCode("scope");
	private final String udbTokenUrl = instance.getSysParamValueByCode("udbTokenUrl");
	private final String udbResourceUrl = instance.getSysParamValueByCode("udbResourceUrl");

	/**
	 * 验证是否是天翼用户并登陆
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码 -- 暂时用不到
	 * @param response
	 *            响应
	 * @param request
	 *            请求
	 * @param model
	 *            前端数据对象
	 */
	@RequestMapping(value = "/validate_wings_user", method = RequestMethod.POST)
	public void validateWingsUser(@RequestParam(required = false, defaultValue = "")
	String userName, @RequestParam(required = false, defaultValue = "")
	String password, HttpServletResponse response, HttpServletRequest request, Model model) {
		String returnStr = "{'rtnCode':'%s','userName':'%s','lastVist':'%s','rtnMsg':'%s'}";

		String sessionId = request.getSession().getId();

		try {
			// 如果是天翼用户
			if (userService.validateWingsUser(userName, password) == 0) {
				User user = userService.getUserByUserName(userName);

				if (user != null) {
					returnStr = String.format(returnStr, Constants.SUCCESS, user.getName(),
							DateUtils.formatDate(new Date(user.getLastVisit()),
									DateUtils.DATE_TIME_24_FORMAT), "登录成功");

					// 更新最后访问时间
					user.setLastVisit(new Date().getTime());
					user.setLastSessionId(sessionId);
					userService.updateUser(user);
				} else {
					user = new User();
					user.setName(userName);
					user.setLastVisit(new Date().getTime());
					user.setLastSessionId(sessionId);
					userService.insertUser(user);

					returnStr = String.format(returnStr, Constants.SUCCESS, user.getName(),
							DateUtils.formatDate(new Date(user.getLastVisit()),
									DateUtils.DATE_TIME_24_FORMAT), "登录成功");
				}

				request.getSession().setAttribute("currUser", user);
			} else {
				returnStr = String
						.format(returnStr, Constants.FAILURE, "null", "null", "该账号不是天翼用户");
			}

			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.print(returnStr);

			out.flush();
			out.close();
		} catch (IOException e) {
			logger.warn("validate_wings_user,获取响应输出流失败", e);
		}
	}

	/**
	 * 用户登出
	 * 
	 * @param response
	 *            响应
	 * @param request
	 *            请求
	 * @param model
	 *            前端数据对象
	 */
	@RequestMapping(value = "/wings_user_logout", method = RequestMethod.POST)
	public void logoutWingsUser(HttpServletResponse response, HttpServletRequest request,
			Model model) {
		String returnStr = "{'rtnCode':'%s','userName':'%s','rtnMsg':'%s'}";

		try {
			User user = (User) request.getSession().getAttribute("currUser");
			user.setLastSessionId("");
			userService.updateUser(user);

			returnStr = String.format(returnStr, Constants.SUCCESS, user.getName(), "退出成功！");

			request.getSession().removeAttribute("currUser");

			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.print(returnStr);

			out.flush();
			out.close();
		} catch (IOException e) {
			logger.warn("wings_user_logout,获取响应输出流失败", e);
		}
	}

	/**
	 * 用户登录
	 * 
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "userlogin", method = RequestMethod.POST)
	public void login(@RequestParam(required = false, defaultValue = "")
	String em_username, @RequestParam(required = false, defaultValue = "")
	String em_password, @RequestParam(required = false, defaultValue = "")
	String rPass, @RequestParam(required = false, defaultValue = "")
	String jumpUrl, HttpServletResponse response, HttpServletRequest request, Model model)
			throws IOException {
		String sessionId = request.getSession().getId();

		if (jumpUrl == null || "".equals(jumpUrl)) {
			jumpUrl = "uc/uc_index";
		}

		if (userService.validateWingsUser(em_username, em_password) == 0) {
			User user = userService.getUserByUserName(em_username);

			if (user != null) {
				// 更新最后访问时间
				user.setLastVisit(new Date().getTime());
				user.setLastSessionId(sessionId);
				userService.updateUser(user);
			} else {
				user = new User();
				user.setName(em_username);
				user.setLastVisit(new Date().getTime());
				user.setLastSessionId(sessionId);
				userService.insertUser(user);
			}

			// 自动登录
			Cookie ckUserName, ckSessionId;
			if ("on".equals(rPass)) {
				ckUserName = new Cookie("autoLoginUser", new BASE64Encoder().encode(user.getName().getBytes("UTF-8"))); // user是代表用户的bean
				ckUserName.setMaxAge(60 * 60 * 24 * 14); // 设置Cookie有效期为14天
				response.addCookie(ckUserName);
				ckSessionId = new Cookie("sessionid", sessionId);
				ckSessionId.setMaxAge(60 * 60 * 24 * 14);
				response.addCookie(ckSessionId);
			}

			request.getSession().setAttribute("currUser", user);
			model.addAttribute("currUser", user);

			response.sendRedirect(jumpUrl);
		} else {
			response.sendRedirect("userlogin?login_msg=" + URLEncoder.encode("该账号不是天翼用户", "UTF-8"));
		}
	}

	/**
	 * 用户登录--用于登录错误信息传递
	 */
	@RequestMapping(value = "userlogin", method = RequestMethod.GET)
	public String login(@RequestParam(required = false, defaultValue = "")
	String login_msg, HttpServletResponse response, HttpServletRequest request, Model model)
			throws IOException {
		model.addAttribute("login_msg", login_msg);

		return "login";
	}

	/**
	 * udb登录--重定向登录
	 * 
	 * @param response
	 *            响应
	 */
	@RequestMapping(value = "/udb_login", method = RequestMethod.GET)
	public void udbLogin(HttpServletResponse response) {
		String url = String.format(udbCodeUrl, clientId, scope, redirectUri);

		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			logger.warn("重定向到udb验证服务时失败，url：" + url, e);
		}
	}

	/**
	 * udb登录请求回调
	 * 
	 * @param code
	 *            返回的编码
	 * @param status
	 *            与请求的status相同
	 */
	@RequestMapping(value = "/udb_code_cb", method = RequestMethod.GET)
	public String udbCodeCallBack(@RequestParam(required = true, defaultValue = "")
	String code, @RequestParam(required = false, defaultValue = "")
	String status, HttpServletResponse response, HttpServletRequest request) {
		String accessToken;
		// 如果code不为空，说明翼支付用户验证成功了，但是还要获取用户名才能确定是谁登录成功了
		if (!"".equals(code)) {
			accessToken = getAccessToken(code);
			// 如果获取到了accessToken
			if (!"".equals(accessToken)) {
				HttpURLConnection resourceConn = getResourceConnection(accessToken);
				String pUserID, alias, account, provinceID, numFlag;
				if (resourceConn != null) {
					pUserID = getPUserId(accessToken, resourceConn);
					alias = getAlias(accessToken, resourceConn);
					account = getAccount(accessToken, resourceConn);
					provinceID = getProvinceID(accessToken, resourceConn);
					numFlag = getNumFlag(accessToken, resourceConn);
					// 用户登录信息的后续处理
					processUserInfo(pUserID, alias, account, provinceID, numFlag, request
							.getSession());
				}
			}
		}

		return "index.htm";
	}

	// 回去用户令牌
	private String getAccessToken(String code) {
		try {
			URL url = new URL(udbTokenUrl);

			// 构造请求，去获取访问令牌
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.addRequestProperty("grant_type", "authorization_code");
			con.addRequestProperty("client_id", clientId);
			con.addRequestProperty("code", code);
			con.addRequestProperty("redirect_uri", redirectUri);
			// String expiresIn =
			// JsonUtil.getValueFromJsonStr(UrlUtils.getURLResponse(con,
			// "POST"),("expires_in");
			return JsonUtil.getValueFromJsonStr(UrlUtils.getURLResponse(con, "POST"),
					"access_token");
		} catch (MalformedURLException e) {
			logger.warn("无效的udbTokenUrl地址：" + udbTokenUrl, e);
		} catch (IOException e) {
			logger.warn("连接udbTokenUrl地址失败：" + udbTokenUrl, e);
		}
		return "";
	}

	// 获取到http资源的连接
	private HttpURLConnection getResourceConnection(String accessToken) {
		try {
			URL url = new URL(udbResourceUrl);

			// 构造请求，去获取用户Id和用户别名
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.addRequestProperty("client_id", clientId);
			con.addRequestProperty("access_token", accessToken);
		} catch (MalformedURLException e) {
			logger.warn("无效的udbResourceUrl地址：" + udbResourceUrl, e);
		} catch (IOException e) {
			logger.warn("连接udbResourceUrl地址失败：" + udbResourceUrl, e);
		}

		return null;
	}

	// 用去用户id
	private String getPUserId(String accessToken, HttpURLConnection con) {
		con.addRequestProperty("resource_id", "01");
		return JsonUtil.getValueFromJsonStr(UrlUtils.getURLResponse(con, "POST"), "PUserID");
	}

	// 获取用户别名
	private String getAlias(String accessToken, HttpURLConnection con) {
		con.addRequestProperty("resource_id", "01");
		return JsonUtil.getValueFromJsonStr(UrlUtils.getURLResponse(con, "POST"), "Alias");
	}

	// 获取用户账号
	private String getAccount(String accessToken, HttpURLConnection con) {
		con.addRequestProperty("resource_id", "02");
		return JsonUtil.getValueFromJsonStr(UrlUtils.getURLResponse(con, "POST"), "Account");
	}

	// 获取用户省份id
	private String getProvinceID(String accessToken, HttpURLConnection con) {
		con.addRequestProperty("resource_id", "03");
		return JsonUtil.getValueFromJsonStr(UrlUtils.getURLResponse(con, "POST"), "ProvinceID");
	}

	// 获取用户类型
	private String getNumFlag(String accessToken, HttpURLConnection con) {
		con.addRequestProperty("resource_id", "04");
		return JsonUtil.getValueFromJsonStr(UrlUtils.getURLResponse(con, "POST"), "NumFlag");
	}

	// 处理用户登录信息
	private void processUserInfo(String pUserID, String alias, String account, String provinceID,
			String numFlag, HttpSession session) {
		User user = userService.getUserByPUserID(pUserID);

		if (user == null) {
			user = new User();
			user.setPUserID(pUserID);
			user = userService.insertUser(user);
		}

		// 验证用户是否是翼支付用户
		user.setIsWingsPayUser(userService.isAndSetWingsPayUser(user) ? 1 : 0);
		// 验证用户是否是爱优惠用户
		user.setIsIPromoteUser(userService.isIDiscountUser(user) ? 1 : 0);

		user.setName(account);
		user.setNick(alias);
		user.setProvinceID(provinceID);
		user.setNumFlag(numFlag);
		user.setLastVisit(new Date().getTime());
		user.setLastSessionId(session.getId());
		userService.updateUser(user);

		session.setAttribute("currUser", user);
	}
}
