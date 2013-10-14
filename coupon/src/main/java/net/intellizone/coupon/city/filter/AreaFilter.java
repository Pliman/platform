/*
 * AreaFilter.java 2012-3-9
 * 智域工作室
 */
package net.intellizone.coupon.city.filter;

import java.io.File;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.city.services.CityService;
import net.intellizone.coupon.city.services.IPSeekService;
import net.intellizone.coupon.util.web.AppContext;
import net.intellizone.utils.NumberUtils;

/**
 * 区域过滤器
 * 
 * @author mass
 * @version 1.0
 * @since coupon 1.0
 */
public class AreaFilter implements Filter {

	@Override
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		HttpSession session = requestHttp.getSession();
		
		City city = (City)session.getAttribute("city");
		
		CityService service = new CityService();
		String cityId = request.getParameter("cityId");
		
		if(cityId != null && !"".equals(cityId)){
			city = service.getCityById(NumberUtils.convertToInteger(cityId));
			session.setAttribute("city", city);
		}

		
		if (city == null) {
			// 获取客户端ip地址
			String ipAddress = requestHttp.getRemoteAddr();

			String ipDataFolder = AppContext.getInstance().getAPP_PATH() + "WEB-INF"
					+ File.separator + "classes";

			IPSeekService ip = new IPSeekService("qqwry.Dat", ipDataFolder);
			// 根据省份和城市名称，获取城市
			city = service.getCityByProvinceAndCity(ip.getIPLocation(ipAddress).getCountry());
			
			// 默认成都
			if(city == null){
				city = service.getCityById(1);
			}
			session.setAttribute("city", city);
		}

		chain.doFilter(request, response);
	}

	/**
	 * @param filterConfig
	 *            过滤器配置
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
