package net.intellizone.coupon.terminal.services;

//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.intellizone.utils.xml.XmlUtils;

//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @author： applenono
 * @modify:
 * @主要功能：
 * @see
 * @version 1.0
 */
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
	private String disabled = "false";// 如果 true 则拦截不做任何处理 可配置
	// 访问权限不足提示页URI
	private String noAuthorizePageView;
	// private ModelAndView errorMsgView;
	// 不需要拦截的URI列表
	private List<String> notInterceptorURIList;

	// 取得 /test/testAjaxText.html?xx=y&yy=nn 中/test/testAjaxText.html部分
	// private String getRequestOperateStr(String requestURI) {
	// int toPoint = requestURI.indexOf(".");
	// if (toPoint < 0)
	// return "";
	// String mapPath = requestURI.substring(0, toPoint) + ".html";
	// return mapPath;
	//	}

	// 重写 preHandle()方法，在业务处理器处理请求之前对所有请求进行拦截处理
	@SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {

		if (disabled.equals("true")) {// 如果 true 则拦截不做任何处直接返回
			return super.preHandle(request, response, handler);
		}

		String requestURI = request.getRequestURI();
		// String currentOperateStr=this.getRequestOperateStr(requestURI);
		// System.out.println("CHECK URI->"+request.getRequestURI());
		// System.out.println("CHECK->"+currentOperateStr);
		// 不需要拦截的URI请求过滤
		if (null != notInterceptorURIList) {
			if (this.notInterceptorURIList.contains(requestURI)) {
				return super.preHandle(request, response, handler);
			}
		}

		// 用户，权限检查
		// Object user=request.getSession().getAttribute("terminal");
		// if(null==user){
		// PrintWriter out = response.getWriter();
		// StringBuilder tBuilder = new StringBuilder(XmlUtils.XML_HEADER);
		// tBuilder.append("<root><result code=\"-2\" message=\"检测不到用户\"/>");
		// tBuilder.append("</root>");
		// out.print(tBuilder.toString());
		// return false;
		// }

		// 登录用户合法操作则通过
		return super.preHandle(request, response, handler);
	}

	public List<String> getNotInterceptorURIList() {
		return notInterceptorURIList;
	}

	public void setNotInterceptorURIList(List<String> notInterceptorURIList) {
		this.notInterceptorURIList = notInterceptorURIList;
	}

	public String getNoAuthorizePageView() {
		return noAuthorizePageView;
	}

	public void setNoAuthorizePageView(String noAuthorizePageView) {
		this.noAuthorizePageView = noAuthorizePageView;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

}
