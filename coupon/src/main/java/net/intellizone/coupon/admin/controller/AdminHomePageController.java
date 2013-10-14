package net.intellizone.coupon.admin.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.admin.model.ActivityRec;
import net.intellizone.coupon.admin.model.GoodsRec;
import net.intellizone.coupon.admin.model.Groups;
import net.intellizone.coupon.admin.model.HomePage;
import net.intellizone.coupon.admin.model.ShopRec;
import net.intellizone.coupon.admin.services.AdminCityService;
import net.intellizone.coupon.admin.services.AdminHomePageService;
import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.util.web.AppContext;
import net.intellizone.coupon.util.web.BuildHtmlFile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminHomePageController {
	@Resource
	private AdminHomePageService adminHomePageService;

	@Resource
	private AdminCityService adminCityService;

	@RequestMapping(value = "/admin/homeadmin.html", method = RequestMethod.GET)
	public String index(@RequestParam(required = false, defaultValue = "1")
	int p, HttpServletResponse response, HttpServletRequest request, Model model) {

		// return "admin/home_admin";
		List<City> cityList = adminCityService.getAllCity();
		model.addAttribute("p", p);
		model.addAttribute("cityList", cityList);

		return "admin/city_rec_admin";
	}

	/** 静态化 */
	@RequestMapping(value = "/admin/createHtml.html", method = RequestMethod.GET)
	public String createHtml(@RequestParam(required = false, defaultValue = "1")
	int type, HttpServletResponse response, HttpServletRequest request, Model model) {

		List<HomePage> homePageList = adminHomePageService.getHomePageModelByType(type);
		String basePath = request.getSession().getServletContext().getRealPath("/")
				+ "WEB-INF\\velocity\\template";
		File saveDir = new File(basePath + "/product");
		String loaderPath = basePath;
		BuildHtmlFile.createProducttypeHtml(homePageList, saveDir, loaderPath, type);
		return "admin/home_admin";
	}

	@RequestMapping(value = "/admin/homebk.html", method = RequestMethod.GET)
	public String homebk(@RequestParam(required = false, defaultValue = "1")
	int type, @RequestParam(required = false, defaultValue = "1")
	int p, HttpServletResponse response, HttpServletRequest request, Model model) {

		List<HomePage> homePageList = adminHomePageService.getHomePageModelByType(type);

		// model.addAttribute("homePageList", homePageList);
		model.addAttribute("type", type);
		String contentType = homePageList.get(0).getContentType();
		String link;
		if (contentType.equals("shop")) {
			link = AppContext.getInstance().getAPP_CONTEXT() + "/admin/shop_rec_admin";
		} else if (contentType.equals("goods")) {
			link = AppContext.getInstance().getAPP_CONTEXT() + "/admin/goods_rec_admin";
		} else {
			link = AppContext.getInstance().getAPP_CONTEXT() + "/admin/activity_rec_admin";
		}
		model.addAttribute("link", link);
		// return "admin/home/flash_edit";

		List<City> cityList = adminCityService.getAllCity();
		model.addAttribute("p", p);
		model.addAttribute("cityList", cityList);

		return "admin/city_rec_admin";
	}

	@RequestMapping(value = "/admin/shop_rec_admin", method = RequestMethod.GET)
	public String shopRecAdmin(@RequestParam(required = false, defaultValue = "1")
	int type, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "1")
	int cityId, HttpServletResponse response, HttpServletRequest request, Model model) {

		List<ShopRec> shopRecList = adminHomePageService.getShopRecByTypeAndCity(type, cityId, p,
				Constants.PAGESIZE20);
		model.addAttribute("shopRecList", shopRecList);

		return "shop_rec_admin";
	}

	@RequestMapping(value = "/admin/goods_rec_admin", method = RequestMethod.GET)
	public String goodsRecAdmin(@RequestParam(required = false, defaultValue = "1")
	int type, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "1")
	int cityId, HttpServletResponse response, HttpServletRequest request, Model model) {

		List<GoodsRec> goodsRecList = adminHomePageService.getGoodsRecByTypeAndCity(type, cityId);
		model.addAttribute("goodsRecList", goodsRecList);

		return "coupon_rec_admin";
	}

	@RequestMapping(value = "/admin/activity_rec_admin", method = RequestMethod.GET)
	public String activityRecAdmin(@RequestParam(required = false, defaultValue = "1")
	int type, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "1")
	int cityId, HttpServletResponse response, HttpServletRequest request, Model model) {

		List<ActivityRec> activityRecList = adminHomePageService.getActivityRecByTypeAndCity(type,
				cityId);
		model.addAttribute("activityRecList", activityRecList);

		return "activity_rec_admin";
	}

	@RequestMapping(value = "/admin/homeAction.html", method = RequestMethod.POST)
	public String homeAction(@RequestParam(required = false, defaultValue = "1")
	int type, Groups groups, @RequestParam(required = false, defaultValue = "1")
	int a, HttpServletResponse response, HttpServletRequest request, Model model) {

		if (a == 1) {// 插入
			adminHomePageService.insertObjList(groups.getObjList());
		} else if (a == 2) {// 更新
			adminHomePageService.updateObjList(groups.getObjList());
		}
		model.addAttribute("a", a);
		model.addAttribute("type", type);
		// return "admin/home_admin";
		return "redirect:/admin/homebk.html";
	}

	@RequestMapping(value = "/admin/topAction.html", method = RequestMethod.GET)
	public String topAction(HomePage homepage, @RequestParam(required = false, defaultValue = "0")
	int id, @RequestParam(required = false, defaultValue = "0")
	int type, @RequestParam(required = false, defaultValue = "0")
	int top, HttpServletResponse response, HttpServletRequest request, Model model) {
		homepage = adminHomePageService.getHomeById(id);
		if (top == 0) {
			homepage.setTop(1);
		} else if (top == 1) {

			homepage.setTop(0);
		}
		adminHomePageService.getHomePageByTop(homepage);
		model.addAttribute("type", type);
		return "redirect:/admin/homebk.html";
	}

	@RequestMapping(value = "/admin/orderHome.html", method = RequestMethod.GET)
	public String orderHome(HomePage homepage, @RequestParam(required = false, defaultValue = "0")
	int orderHome, @RequestParam(required = false, defaultValue = "0")
	int type, @RequestParam(required = false, defaultValue = "0")
	int id, HttpServletResponse response, HttpServletRequest request, Model model) {
		homepage = adminHomePageService.getHomeById(id);
		homepage.setOrderHome(orderHome);
		adminHomePageService.getHomePageByTop(homepage);
		model.addAttribute("type", type);
		return "redirect:/admin/homebk.html";
	}
}
