package net.intellizone.coupon.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.admin.services.AdminBussinessCircleService;
import net.intellizone.coupon.admin.services.AdminCityService;
import net.intellizone.coupon.admin.services.AdminShopCategoryService;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.coupon.model.BussinessCircle;
import net.intellizone.coupon.shop.model.ShopCategroy;
import net.intellizone.coupon.util.web.AppContext;

@Controller
public class AdminBcController {
	@Resource
	private AdminBussinessCircleService adminBussinessCircleService;
	@Resource
	private AdminCityService adminCityService;
	@Resource
	private AdminShopCategoryService adminShopCategoryService;

	@RequestMapping(value = "/admin/cityadmin", method = RequestMethod.GET)
	public String index(@RequestParam(required = false, defaultValue = "1")
	int p, HttpServletResponse response, HttpServletRequest request, Model model) {

		List<City> cityList = adminCityService.getAllCity();
		model.addAttribute("p", p);
		model.addAttribute("cityList", cityList);
		return "admin/city_admin";
	}

	/** *************************************************************************** */
	// 对城市进行添，删，改
	@RequestMapping(value = "/admin/ctAction", method = RequestMethod.GET)
	public String ctActionGet(City city, @RequestParam(required = false, defaultValue = "0")
	int a, @RequestParam(required = false, defaultValue = "1")
	int p, HttpServletResponse response, HttpServletRequest request, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		if (a == 1) {// 添加
			adminCityService.insertCity(city);
			return "redirect:cityadmin";
		}
		if (a == 2) { // 更新
			adminCityService.updateCity(city);
			return "redirect:cityadmin";
		}
		if (a == 3) {// 跳转更新页面
			city = adminCityService.findCityById(city.getId());
			model.addAttribute("city", city);
			return "admin/ct_edit";
		}
		if (a == 4) {// 跳转添加页面
			return "admin/ct_edit";
		}
		if (a == 5) {// 删除
			adminCityService.deleteCity(city.getId());
			return "redirect:cityadmin";
		}

		return null;

	}

	@RequestMapping(value = "/admin/ctAction", method = RequestMethod.POST)
	public String ctAction(City city, int[] id_city,
			@RequestParam(required = false, defaultValue = "0")
			int a, @RequestParam(required = false, defaultValue = "1")
			int p, HttpServletResponse response, HttpServletRequest request, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		if (a == 1) {// 添加
			adminCityService.insertCity(city);
			return "redirect:cityadmin";
		}
		if (a == 2) { // 更新
			adminCityService.updateCity(city);
			return "redirect:cityadmin";
		}
		if (a == 3) {// 跳转更新页面
			city = adminCityService.findCityById(city.getId());
			model.addAttribute("city", city);
			return "admin/ct_edit";
		}
		if (a == 4) {// 跳转添加页面
			return "admin/ct_edit";
		}
		if (a == 5) {// 删除
			adminCityService.deleteCity(city.getId());
			return "redirect:cityadmin";
		} else if (a == 8) { // 批量删除
			if (id_city != null && id_city.length > 0) {
				adminCityService.delteAllCity(id_city);
			}
			return "redirect:cityadmin";
		}

		return null;

	}

	/** ******************************************************************************* */
	// 查看城市下属商圈
	@RequestMapping(value = "/admin/bcadmin", method = RequestMethod.GET)
	public String bcadmin(BussinessCircle bussinessCircle,
			@RequestParam(required = false, defaultValue = "0")
			int cityId, @RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "0")
			int a, HttpServletResponse response, HttpServletRequest request, Model model) {

		List<ShopCategroy> shopCategoryList = adminShopCategoryService.getAllShopCategory(1);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(cityId);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		model.addAttribute("cityId", cityId);

		return "admin/bc_admin";
	}

	// 商圈内容管理查询
	@RequestMapping(value = "/admin/conadmin", method = RequestMethod.GET)
	public String conadmin(BussinessCircle bussinessCircle,
			@RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "")
			String wd, @RequestParam(required = false, defaultValue = "0")
			int cat, @RequestParam(required = false, defaultValue = "0")
			int a, @RequestParam(required = false, defaultValue = "0")
			int cityId, HttpServletResponse response, HttpServletRequest request, Model model) {

		List<BussinessCircle> listBuss = adminBussinessCircleService.getAllBussinessCircle();
		model.addAttribute("p", p);
		model.addAttribute("listBuss", listBuss);
		model.addAttribute("a", a);
		model.addAttribute("cityId", cityId);

		return "admin/citycon_admin";
	}

	@RequestMapping(value = "/admin/conAction", method = RequestMethod.POST)
	public String bcAction(BussinessCircle bussinessCircle, int[] id_circle,
			@RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "0")
			int a, @RequestParam(required = false, defaultValue = "1")
			int cityId, HttpServletResponse response, HttpServletRequest request, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("cityId", cityId);
		bussinessCircle.setBelong_city(cityId);
		if (a == 1) {// 添加
			adminBussinessCircleService.insertObj(bussinessCircle);
			return "redirect:conadmin.html";
		} else if (a == 5) {// 删除
			adminBussinessCircleService.deleteBussinessCircleById(bussinessCircle.getId());
			return "redirect:conadmin.html";
		} else if (a == 2) {
			adminBussinessCircleService.updateObj(bussinessCircle);
			return "redirect:conadmin.html";
		} else if (a == 3) {// 编辑
			bussinessCircle = adminBussinessCircleService.getBussinessCircleById(bussinessCircle
					.getId());
			model.addAttribute("bussinessCircle", bussinessCircle);
			return "admin/bc_edit";
		} else if (a == 4) {// 添加
			List<City> cityList = adminCityService.getAllCity();
			model.addAttribute("cityList", cityList);
			return "admin/bc_edit";
		} else if (a == 8) {
			if (id_circle != null && id_circle.length > 0) {
				adminBussinessCircleService.deleteAllCircle(id_circle);
			}
			return "redirect:conadmin.html";
		}

		return "admin/citycon_admin";

	}

	@RequestMapping(value = "/admin/conAction", method = RequestMethod.GET)
	public String bcActionGet(BussinessCircle bussinessCircle,
			@RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "1")
			int cityId, @RequestParam(required = false, defaultValue = "0")
			int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		model.addAttribute("a", a);
		bussinessCircle.setBelong_city(cityId);
		model.addAttribute("cityId", cityId);
		if (a == 1) {// 添加
			adminBussinessCircleService.insertObj(bussinessCircle);
			return "redirect:conadmin.html";
		} else if (a == 5) {// 删除
			adminBussinessCircleService.deleteBussinessCircleById(bussinessCircle.getId());
			return "redirect:conadmin.html";
		} else if (a == 2) {
			adminBussinessCircleService.updateObj(bussinessCircle);
			return "redirect:conadmin.html";
		} else if (a == 3) {// 编辑
			bussinessCircle = adminBussinessCircleService.getBussinessCircleById(bussinessCircle
					.getId());
			List<City> cityList = adminCityService.getAllCity();
			model.addAttribute("cityList", cityList);
			model.addAttribute("bussinessCircle", bussinessCircle);
			return "admin/bc_edit";
		} else if (a == 4) {// 添加
			List<City> cityList = adminCityService.getAllCity();
			model.addAttribute("cityList", cityList);
			return "admin/bc_edit";
		}

		return "admin/citycon_admin";

	}

	
	
	/**
	 * 获取城市
	 * 
	 * @param p
	 * @param wd
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/getCitys", method = RequestMethod.GET)
	public String getCity(@RequestParam(required = false, defaultValue = "1")int from,
						  @RequestParam(required = false, defaultValue = "1")int p,
						  @RequestParam(required = false, defaultValue = "")String wd,
					 HttpServletResponse response, HttpServletRequest request, Model model) {

		QueryResult cityList = adminCityService.getAllCity(wd,p,Constants.PAGESIZE20);
		model.addAttribute("p", p);
		model.addAttribute("cityList", cityList);
		model.addAttribute("wd", wd);
		model.addAttribute("from",from);
		
		model.addAttribute("appContext", AppContext.getInstance().getAPP_CONTEXT());
		return "admin/city_AdminAjax";
	}
	/**
	 * 获取城市的商圈，返回json格式 <optoin value="1">1</option>
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/city_bc", method = RequestMethod.GET)
	public Object getBcByCity(@RequestParam(required = false, defaultValue = "0")
	int cityId, HttpServletResponse response, HttpServletRequest request, Model model) {
		StringBuffer opBuffer = new StringBuffer();
		for (BussinessCircle bc : adminBussinessCircleService.getAllBussinessCircleByCityId(cityId)) {
			opBuffer.append("<option").append(" value=").append(bc.getId()).append(">").append(
					bc.getBc_name()).append("</option>");
		}

		return opBuffer;
	}
}
