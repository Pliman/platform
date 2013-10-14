package net.intellizone.coupon.admin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.core.constants.Constants;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.city.services.CityService;
import net.intellizone.coupon.coupon.model.BussinessCircle;

import net.intellizone.coupon.admin.services.AdminBussinessCircleService;
import net.intellizone.coupon.admin.services.AdminShopCategoryService;
import net.intellizone.coupon.shop.model.Shop;
import net.intellizone.coupon.shop.model.ShopCategroy;
import net.intellizone.coupon.shop.model.ShopPic;
import net.intellizone.coupon.admin.services.AdminShopPicService;
import net.intellizone.coupon.admin.services.AdminShopService;
import net.intellizone.utils.DateUtils;

import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminShopController {
	@Resource
	private CityService cityService;
	@Resource
	private AdminShopService adminShopService;
	@Resource
	private AdminShopPicService adminShopPicService;
	@Resource
	private AdminShopCategoryService adminShopCategoryService;
	@Resource
	private AdminBussinessCircleService adminBussinessCircleService;
	/**
	 * 商户列表查询
	 * @param cat
	 * @param bc
	 * @param p
	 * @param searchShop
	 * @param wd
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/shopadmin", method = RequestMethod.GET)
	public String shop(@RequestParam(required = false, defaultValue = "0")
	int cat, @RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int searchShop, @RequestParam(required = false, defaultValue = "")
	String wd, HttpServletResponse response, HttpServletRequest request, Model model) {
		// List<ShopAdmin> shopAdminList=AdminShopAdminService.getShopAdmin();
		// model.addAttribute("shopList",shopAdminList);
		
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.selectShopCategoryList(0);
		QueryResult shopList = adminShopService.getAllShopCatBykeyIdPagination(p, Constants.PAGESIZE20, cat, bc, wd,
				searchShop,0,0);
		model.addAttribute("shopList", shopList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("p", p);
		model.addAttribute("searchShop", searchShop);
		model.addAttribute("wd", wd);
		return "admin/shop_admin";
	}

	@RequestMapping(value = "/admin/getBranchShop", method = RequestMethod.GET)
	public String branch(@RequestParam(required = false, defaultValue = "0")
	int pid, @RequestParam(required = false, defaultValue = "1")
	int p, HttpServletResponse response, HttpServletRequest request, Model model) {
		QueryResult shopList = adminShopService.getShopParentIdPagination(p, Constants.PAGESIZE20, pid);
		model.addAttribute("shopList", shopList);
		model.addAttribute("p", p);
		return "admin/shop_admin";

	}
	/**
	 * 商户增删改查GET方法
	 * @param shop
	 * @param audit_reason
	 * @param p
	 * @param a
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/shopAction", method = RequestMethod.GET)
	public String shopAction(Shop shop, @RequestParam(required = false, defaultValue = "0")
	String audit_reason, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		City city = (City) request.getSession().getAttribute("city");
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.selectShopCategoryList(0);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(city);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("cityList", cityService.getAllCity());
		model.addAttribute("a", a);
		model.addAttribute("p", p);

		if (a == 1) {// 添加
			shop.setCreate_time(System.currentTimeMillis());
			shop.setModify_time(System.currentTimeMillis());
			adminShopService.insertObj(shop);
			return "redirect:shopadmin.html";
		} else if (a == 5) {// 删除
			adminShopService.deleteShopById(shop.getId());
			return "redirect:shopadmin.html";
		} else if (a == 2) {
			shop.setModify_time(System.currentTimeMillis());
			adminShopService.updateObj(shop);
			return "redirect:shopadmin.html";
		} else if (a == 3) {// 编辑
			shop = adminShopService.getShopById((int) shop.getId());
			model.addAttribute("shop", shop);
			return "admin/shop_edit";

		} else if (a == 4) {// 添加
			return "admin/shop_edit";
		} else if (a == 6) {// 审核通过
			if (null != shop && 0 != shop.getId()) {
				int ret = adminShopService.checkObjById((int) shop.getId(), 1, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:shopadmin.html";
		} else if (a == 7) {// 审核不通过
			if (null != shop && 0 != shop.getId()) {
				int ret = adminShopService.checkObjById((int) shop.getId(), -1, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:shopadmin.html";
		} else if(a == 9){
			shop = adminShopService.getShopById((int) shop.getId());
			model.addAttribute("shop", shop);
			return "admin/shop_audit";
		}

		return "admin/shop_admin";
	}
	/**
	 * 商户增删改查POST方法
	 * @param shop
	 * @param idList
	 * @param p
	 * @param a
	 * @param audit_reason
	 * @param service
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/shopAction", method = RequestMethod.POST)
	public String shopActionPost(Shop shop, int[] idList,
			@RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "0")
			int a, @RequestParam(required = false, defaultValue = "0")
			String audit_reason, @RequestParam(required = false, defaultValue = "0")
			String service, HttpServletResponse response, HttpServletRequest request, Model model) {
		City city = (City) request.getSession().getAttribute("city");
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.selectShopCategoryList(0);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(city);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("cityList", cityService.getAllCity());
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		model.addAttribute("audit_reason", audit_reason);

		if (a == 1) {// 添加
			shop.setCreate_time(System.currentTimeMillis());
			shop.setModify_time(System.currentTimeMillis());
			shop.setService(service);
			adminShopService.insertObj(shop);
			return "redirect:shopadmin.html";
		} else if (a == 5) {// 删除
			adminShopService.deleteShopById(shop.getId());
			return "redirect:shopadmin.html";
		} else if (a == 2) {
			shop.setModify_time(System.currentTimeMillis());
			shop.setService(service);
			adminShopService.updateObj(shop);
			return "redirect:shopadmin.html";
		} else if (a == 3) {// 编辑
			shop = adminShopService.getShopById((int) shop.getId());
			model.addAttribute("shop", shop);
			return "admin/shop_edit";
		} else if (a == 4) {// 添加
			return "admin/shop_edit";
		} else if (a == 6) {// 审核通过
			if (null != shop && 0 != shop.getId()) {
				int ret = adminShopService.checkObjById((int) shop.getId(), 1, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:shopadmin.html";
		} else if (a == 7) {// 审核不通过
			if (null != shop && 0 != shop.getId()) {
				int ret = adminShopService.checkObjById((int) shop.getId(), -1, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:shopadmin.html";
		} else if (a == 8) {// 批量删除shop
			if (null != idList && idList.length > 0) {
				adminShopService.batchDelShop(idList);
			}
			return "redirect:shopadmin.html";
		}

		return "admin/shop_admin";
	}
	/**
	 * 商圈增删改查POST方法
	 * @param bussinessCircle
	 * @param id_circle
	 * @param p
	 * @param a
	 * @param cityId
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/bcAction", method = RequestMethod.POST)
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
			return "redirect:bcadmin.html";
		} else if (a == 5) {// 删除
			adminBussinessCircleService.deleteBussinessCircleById(bussinessCircle.getId());
			return "redirect:bcadmin.html";
		} else if (a == 2) {
			adminBussinessCircleService.updateObj(bussinessCircle);
			return "redirect:bcadmin.html";
		} else if (a == 3) {// 编辑
			bussinessCircle = adminBussinessCircleService.getBussinessCircleById(bussinessCircle
					.getId());
			model.addAttribute("bussinessCircle", bussinessCircle);
			return "admin/bc_edit";
		} else if (a == 4) {// 添加
			return "admin/bc_edit";
		} else if (a == 8) {
			if (id_circle != null && id_circle.length > 0) {
				adminBussinessCircleService.deleteAllCircle(id_circle);
			}
			return "redirect:bcadmin.html";
		}

		return "admin/bc_admin";

	}
	/**
	 * 商圈增删改查GET
	 * @param bussinessCircle
	 * @param p
	 * @param cityId
	 * @param a
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/bcAction", method = RequestMethod.GET)
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
			return "redirect:bcadmin.html";
		} else if (a == 5) {// 删除
			adminBussinessCircleService.deleteBussinessCircleById(bussinessCircle.getId());
			return "redirect:bcadmin.html";
		} else if (a == 2) {
			adminBussinessCircleService.updateObj(bussinessCircle);
			return "redirect:bcadmin.html";
		} else if (a == 3) {// 编辑
			bussinessCircle = adminBussinessCircleService.getBussinessCircleById(bussinessCircle
					.getId());
			model.addAttribute("bussinessCircle", bussinessCircle);
			return "admin/bc_edit";
		} else if (a == 4) {// 添加
			return "admin/bc_edit";
		}

		return "admin/bc_admin";

	}
	/**
	 * 类别增删改查POST 方法
	 * @param shopCategroy
	 * @param cat_type
	 * @param pid
	 * @param p
	 * @param a
	 * @param id_type
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/admin/catAction", method = RequestMethod.POST)
	public String catAction(ShopCategroy shopCategroy,String[] idCityList,
			@RequestParam(required = false, defaultValue = "1")
			int cat_type, @RequestParam(required = false, defaultValue = "0")
			int pid, @RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "0")
			int a, int[] id_type, HttpServletResponse response, HttpServletRequest request,
			Model model) {
		model.addAttribute("a", a);
		model.addAttribute("cat_type", cat_type);
		model.addAttribute("pid", pid);

		if (a == 1) {// 添加
			String category_type = request.getParameter("category_type");
			String belongCity = "";
			if(!"".equals(idCityList) && idCityList != null){
				for(int i=0;i<idCityList.length;i++){
					if(i<idCityList.length-1){
						belongCity += idCityList[i]+"-";
					}else{
						belongCity += idCityList[i];
					}
				}
				shopCategroy.setBelongCity(belongCity);
			}
			adminShopCategoryService.insertObj(shopCategroy,idCityList);
			model.addAttribute("cat_type", category_type);
			return "redirect:catadmin.html";
		} else if (a == 5) {// 删除
			adminShopCategoryService.deleteShopCategroyById(shopCategroy.getCategory_id());
			return "redirect:catadmin.html";
		} else if (a == 2) {
			String belongCity = "";
			if(!"".equals(idCityList) && idCityList != null){
				for(int i=0;i<idCityList.length;i++){
					if(i<idCityList.length-1){
						belongCity += idCityList[i]+"-";
					}else{
						belongCity += idCityList[i];
					}
				}
				shopCategroy.setBelongCity(belongCity);
			}
			adminShopCategoryService.updateObj(shopCategroy,idCityList);
			
			return "redirect:catadmin.html";
		} else if (a == 3) {// 编辑
			shopCategroy = adminShopCategoryService
					.getShopCategroyId(shopCategroy.getCategory_id());
			model.addAttribute("shopCategroy", shopCategroy);
			return "admin/cat_edit";
		} else if (a == 4) {// 添加
			return "admin/cat_edit";
		} else if (a == 8) { // 批量删除
			if (id_type != null && id_type.length > 0) {
				adminShopCategoryService.deleteAllCategroy(id_type);
			}
			return "redirect:catadmin.html";
		}
		return "admin/cat_admin";
	}
	/**
	 * 类别增删改查GET
	 * @param shopCategroy
	 * @param pid
	 * @param cat_type
	 * @param p
	 * @param a
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/catAction", method = RequestMethod.GET)
	public String catActionGet(ShopCategroy shopCategroy,String[] idCityList,
			@RequestParam(required = false, defaultValue = "0")
			int pid, @RequestParam(required = false, defaultValue = "1")
			int cat_type, @RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "0")
			int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("cat_type", cat_type);
		model.addAttribute("pid", pid);

		if (a == 1) {// 添加
			adminShopCategoryService.insertObj(shopCategroy,idCityList);
			return "redirect:catadmin.html";
		} else if (a == 5) {// 删除
			adminShopCategoryService.deleteShopCategroyById(shopCategroy.getCategory_id());
			return "redirect:catadmin.html";
		} else if (a == 2) {
			adminShopCategoryService.updateObj(shopCategroy,idCityList);
			return "redirect:catadmin.html";
		} else if (a == 3) {// 编辑
			shopCategroy = adminShopCategoryService
			.getShopCategroyId(shopCategroy.getCategory_id());
			if(!"".equals(shopCategroy.getBelongCity()) && null != shopCategroy.getBelongCity()){
				String[] belongCityLists = shopCategroy.getBelongCity().split("-");
				List<String> idList = new ArrayList<String>();
				for(int i=0;i<belongCityLists.length;i++){
					idList.add(belongCityLists[i]);
				}
				List<City> belongCityList=adminShopCategoryService.getCityByIdList(idList);
				model.addAttribute("belongCityList",belongCityList);
			}
			
			
			model.addAttribute("shopCategroy", shopCategroy);
			return "admin/cat_edit";
		} else if (a == 4) {// 添加

			return "admin/cat_edit";

		}
		return "admin/cat_admin";
	}
	/**
	 * 类别管理
	 * @param shopCategroy
	 * @param pid
	 * @param p
	 * @param cat_type
	 * @param a
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/catadmin", method = RequestMethod.GET)
	public String catadmin(ShopCategroy shopCategroy,
			@RequestParam(required = false, defaultValue = "0")
			int pid, @RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "1")
			int cat_type, @RequestParam(required = false, defaultValue = "0")
			int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		City city = (City) request.getSession().getAttribute("city");
		//List<ShopCategroy> shopCategoryList = adminShopCategoryService.getShopListCategoryByPId(
		//		pid, cat_type);
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.getShopListCategoryByPId(
				pid);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(city);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		model.addAttribute("cat_type", cat_type);
		model.addAttribute("pid", pid);

		return "admin/cat_admin";
	}
	/**
	 * 删除商户图片
	 * @param shopPic
	 * @param shopId
	 * @param p
	 * @param a
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/deleteShopPic", method = RequestMethod.GET)
	public String deleteShopPic(ShopPic shopPic, @RequestParam(required = true, defaultValue = "1")
	int shopId, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		model.addAttribute("id", shopId);
		// List<ShopPic> shopPicList=new ArrayList<ShopPic>();
		// shopPicList.add(shopPic);
		// Shop shop=new Shop ();
		// shop.setId(shopId);
		// shop.setShopPicList(shopPicList);
		// adminShopService.deletLink(shop);
		adminShopPicService.deleteShopPicById(shopPic.getId());

		return "redirect:shopAction.html";
	}


	/**
	 * 编辑下的分类查询
	 */
	@RequestMapping(value = "/admin/belongShop", method = RequestMethod.GET)
	public String belongShop(ShopCategroy shopCategroy,
			@RequestParam(required = false, defaultValue = "0")
			int pid, @RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "1")
			int cat_type, @RequestParam(required = false, defaultValue = "0")
			int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		City city = (City) request.getSession().getAttribute("city");
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.getShopListCategoryByPId(
				pid);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(city);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		model.addAttribute("cat_type", cat_type);
		model.addAttribute("pid", pid);

		return "admin/belongShop_ajax";
	}
	
	
	
	
	/**
	 * 获取商户弹出层方法GET方法
	 * @param from
	 * @param pid
	 * @param wd
	 * @param searchShop 查询条件：1-ID 2-名称  3-状态 4-时间
	 * @param goodsId
	 * @param bc
	 * @param cat
	 * @param p
	 * @param a
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/getShop", method = RequestMethod.GET)
	public String getShopAjax(@RequestParam(required = true, defaultValue = "0")
	int from, @RequestParam(required = true, defaultValue = "0")
	int pid, @RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = false, defaultValue = "0")
	int searchShop, @RequestParam(required = true, defaultValue = "0")
	int goodsId, @RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "0")
	int cat, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		QueryResult shopList = null;
		if (pid == 0) {
			shopList = adminShopService.getAllShopCatBykeyIdPagination(p,
					Constants.DEFAULT_PAGESIZE, cat, bc, wd, searchShop,0,0);
		} else {
			shopList = adminShopService.getShopParentIdPagination(p, 100, pid);
		}
		model.addAttribute("shopList", shopList);

		model.addAttribute("p", p);
		model.addAttribute("from", from);

		return "admin/shop_ajax";
	}
	/**
	 * 获取商户弹出层方法POST方法
	 * @param from
	 * @param wd
	 * @param goodsId
	 * @param bc
	 * @param cat
	 * @param p
	 * @param a
	 * @param searchShop
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/getShop", method = RequestMethod.POST)
	public String getShopAjaxPost(@RequestParam(required = true, defaultValue = "0")
	int from, @RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = true, defaultValue = "0")
	int goodsId, @RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "0")
	int cat, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int a, @RequestParam(required = false, defaultValue = "")
	int searchShop, HttpServletResponse response, HttpServletRequest request, Model model) {
		QueryResult shopList = adminShopService.getAllShopCatBykeyIdPagination(p,
				Constants.DEFAULT_PAGESIZE, cat, bc, wd, searchShop,0,0);
		model.addAttribute("shopList", shopList);

		model.addAttribute("p", p);
		model.addAttribute("from", from);

		return "admin/shop_ajax";
	}
	/**
	 * 商户搜索GET 方法
	 * @param from
	 * @param wd
	 * @param p
	 * @param bc
	 * @param searchShop
	 * @param cat
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/admin/shopSearch", method = RequestMethod.GET)
	public String shopSearch(@RequestParam(required = true, defaultValue = "0")
	int from, @RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = false, defaultValue = "1")
	int p,@RequestParam(required = false, defaultValue = "")
	String beginTime, @RequestParam(required = false, defaultValue = "")
	String endTime, @RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "0")
	int searchShop, @RequestParam(required = false, defaultValue = "0")
	int cat, HttpServletResponse response, HttpServletRequest request, Model model)
			throws UnsupportedEncodingException {
		long begin_time = !"".equals(beginTime)?(DateUtils.converToDateTime(beginTime).getTime()):0;
		long end_time = !"".equals(endTime)?(DateUtils.converToDateTime(endTime).getTime()):0;
		QueryResult shopPageList = adminShopService.getAllShopCatBykeyIdPagination(p,
				Constants.DEFAULT_PAGESIZE, cat, bc, URLDecoder.decode(wd, "utf-8"), searchShop,begin_time,end_time);

		City city = (City) request.getSession().getAttribute("city");
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.getAllShopCategory(1);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(city);
		if(begin_time != 0 || end_time!= 0){
			model.addAttribute("time","1");
		}
		model.addAttribute("from", from);
		model.addAttribute("wd", wd);
		model.addAttribute("cat", cat);
		model.addAttribute("bc", bc);
		model.addAttribute("shopList", shopPageList);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("searchShop", searchShop);
		return "admin/shop_admin";
	}
	/***
	 * 商户搜索POST 方法
	 * @param from
	 * @param wd
	 * @param p
	 * @param bc
	 * @param cat
	 * @param searchShop
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/admin/shopSearch", method = RequestMethod.POST)
	public String shopSearchPost(@RequestParam(required = true, defaultValue = "0")
	int from, @RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "0")
	int cat, @RequestParam(required = false, defaultValue = "")
	int searchShop, HttpServletResponse response, HttpServletRequest request, Model model)
			throws UnsupportedEncodingException {

		QueryResult shopPageList = adminShopService.getAllShopCatBykeyIdPagination(p,
				Constants.DEFAULT_PAGESIZE, cat, bc, URLDecoder.decode(wd, "utf-8"), searchShop,0,0);

		City city = (City) request.getSession().getAttribute("city");
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.getAllShopCategory(1);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(city);

		model.addAttribute("from", from);
		model.addAttribute("wd", wd);
		model.addAttribute("cat", cat);
		model.addAttribute("bc", bc);
		model.addAttribute("shopList", shopPageList);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		return "admin/shop_admin";
	}

}
