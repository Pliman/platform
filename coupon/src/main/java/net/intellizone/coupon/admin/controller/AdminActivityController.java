package net.intellizone.coupon.admin.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.activity.model.Activity;
import net.intellizone.coupon.admin.services.AdminActivityService;
import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.coupon.controller.BaseController;
import net.intellizone.coupon.coupon.model.BussinessCircle;
import net.intellizone.coupon.shop.model.Shop;
import net.intellizone.coupon.shop.model.ShopCategroy;
import net.intellizone.coupon.util.web.BuildHtmlFile;
import net.intellizone.coupon.admin.services.AdminBussinessCircleService;
import net.intellizone.coupon.admin.services.AdminCityService;
import net.intellizone.coupon.admin.services.AdminShopCategoryService;
import net.intellizone.coupon.admin.services.AdminShopService;

import net.intellizone.utils.DateUtils;

import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminActivityController extends BaseController {
	@Resource
	private AdminShopService adminShopService;
	@Resource
	private AdminActivityService adminActivityService;
	@Resource
	private AdminShopCategoryService adminShopCategoryService;
	@Resource
	private AdminBussinessCircleService adminBussinessCircleService;
	@Resource
	private AdminCityService adminCityService;

	@RequestMapping(value = "/admin/activityadmin", method = RequestMethod.GET)
	public String index(@RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = false, defaultValue = "0")
	int cat, @RequestParam(required = false, defaultValue = "0")
	int bc,  @RequestParam(required = false , defaultValue = "")
	String beginTime,  @RequestParam(required = false , defaultValue = "")
	String endTime,  @RequestParam(required = false , defaultValue = "0")
	int search,HttpServletResponse response, HttpServletRequest request, Model model) {
		long begin_time = !"".equals(beginTime)?(DateUtils.converToDateTime(beginTime).getTime()):0;
		long end_time = !"".equals(endTime)?(DateUtils.converToDateTime(endTime).getTime()):0;
		QueryResult pageObj = adminActivityService.getActivityByTypeAndkeyIdAndKeyWordsPagination(
				p, Constants.PAGESIZE20, cat, bc, wd,search,begin_time,end_time);
		if(begin_time!=0 || end_time!=0){
			model.addAttribute("time","1");
		}
		model.addAttribute("pageObj", pageObj);
		model.addAttribute("p", p);
		model.addAttribute("wd", wd);
		model.addAttribute("search",search);
		model.addAttribute("begin_time",begin_time);
		model.addAttribute("end_time",end_time);
		return "admin/activity_admin";
	}

	@RequestMapping(value = "/admin/activityAction", method = RequestMethod.GET)
	public String activityAction(Activity activity,
			@RequestParam(required = false,defaultValue = "")String audit,
			@RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "0")
			int a, @RequestParam(required = false, defaultValue = "0") 
			int freeze, @RequestParam(required = false, defaultValue = "0") 
			String audit_reason ,HttpServletResponse response, HttpServletRequest request, Model model) {
		City city =  (City) request.getSession().getAttribute("city");
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.getAllShopCategory(3);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(city);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		model.addAttribute("audit_reason",audit_reason);

		if (a == 1) {// 添加
			activity.setCreate_time(System.currentTimeMillis());
			activity.setModify_time(System.currentTimeMillis());
			adminActivityService.insertObj(activity);
			return "redirect:activityadmin.html";
		} else if (a == 5) {// 删除
			adminActivityService.deleteActivityById(activity.getId());
			return "redirect:activityadmin.html";
		} else if (a == 2) {
			activity.setModify_time(System.currentTimeMillis());
			adminActivityService.updateObj(activity);
			return "redirect:activityadmin.html";
		} else if (a == 3) {// 编辑
		
			activity = adminActivityService.getActivityById((int) activity.getId());
			
			if(null!=activity){//取得所属商户列表
				if(null!=activity.getBelong_shops()&&!"".equals(activity.getBelong_shops())){
					String [] belongShopIdList=activity.getBelong_shops().split("-");
					List<String> idLists=new ArrayList<String>();
					for(int i=0;i<belongShopIdList.length;i++){
						idLists.add(belongShopIdList[i]);
					}
					List<Shop> belongShopList=adminShopService.getShopByIdList(idLists);
					model.addAttribute("belongShopList", belongShopList);
					
				}
				if(null!=activity.getBelong_citys() && !"".equals(activity.getBelong_citys())){
					String[] belongCityIdList = activity.getBelong_citys().split("-");
					List<String> idLists = new ArrayList<String>();
					for(int i=0;i<belongCityIdList.length;i++){
						idLists.add(belongCityIdList[i]);
					}
					List<City> belongCityList=adminCityService.getCityByIdList(idLists);
					model.addAttribute("belongCityList",belongCityList);
				}
			}
			
			if (activity.getAct_article() != null && !"".equals(activity.getAct_article())) {
				activity.setAct_article(activity.getAct_article().replaceAll("\\r", "").replaceAll(
						"\\n", ""));
			}
			model.addAttribute("activity", activity);
			if(!"".equals(audit) && audit != null){ //审核页面
				return "admin/activity_audit";
			}
			return "admin/activity_edit";

		} else if (a == 4) {// 添加
			List<Shop> shopList = adminShopService.getShop();
			model.addAttribute("shopList", shopList);
			return "admin/activity_edit";
		} else if (a == 6) {// 审核通过
			if (null != activity && 0 != activity.getId()) {
				int ret = adminActivityService.checkObjById((int) activity.getId(), 1,null);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:activityadmin.html";
		} else if (a == 7) {// 冻结
			if (null != activity && 0 != activity.getId()) {
				int ret = adminActivityService.checkObjById((int) activity.getId(), 2,audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:activityadmin.html";
		}else if (a == 8) {// 解冻
			if (null != activity && 0 != activity.getId()) {
				int ret = adminActivityService.checkObjById((int) activity.getId(), 1,audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:activityadmin.html";
		}else if (a == 9) {// 上架
			if (null != activity && 0 != activity.getId()) {
				int ret = adminActivityService.checkObjById((int) activity.getId(), 1,audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:activityadmin.html";
		}else if (a == 10) {// 下架
			if (null != activity && 0 != activity.getId()) {
				int ret = adminActivityService.checkObjById((int) activity.getId(), -1,audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:activityadmin.html";
		}else if (a == 11) {// 审核不通过
			if (null != activity && 0 != activity.getId()) {
				int ret = adminActivityService.checkObjById((int) activity.getId(), -2,audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:activityadmin.html";
		}
		

		return "admin/activity_admin";
	}

	@RequestMapping(value = "/admin/activityAction", method = RequestMethod.POST)
	public String activityActionPost(Activity activity, int[] idList,String[] idShopList,String[] idCityList,
			@RequestParam(required = false, defaultValue = "1970-01-01 00:00:00")
			String begin_time1,
			@RequestParam(required = false, defaultValue = "1970-01-01 00:00:00")
			String end_time1, @RequestParam(required = false, defaultValue = "")
			String act_article, @RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "0")
			int a, @RequestParam(required = false, defaultValue = "0")
			String audit_reason ,HttpServletResponse response, HttpServletRequest request, Model model) {
		City city =  (City) request.getSession().getAttribute("city");
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.getAllShopCategory(3);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(city);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		model.addAttribute("audit_reason",audit_reason);

		if (a == 1) {// 添加
			activity.setCreate_time(System.currentTimeMillis());
			activity.setModify_time(System.currentTimeMillis());
			activity.setBegin_time(DateUtils.converToDateTime(begin_time1).getTime());
			activity.setEnd_time(DateUtils.converToDateTime(end_time1).getTime());
			adminActivityService.insertObj(activity);
			return "redirect:activityadmin.html";
		} else if (a == 5) {// 删除
			adminActivityService.deleteActivityById(activity.getId());
			return "redirect:activityadmin.html";
		} else if (a == 2) {
			activity.setModify_time(System.currentTimeMillis());
			activity.setBegin_time(DateUtils.converToDateTime(begin_time1).getTime());
			activity.setEnd_time(DateUtils.converToDateTime(end_time1).getTime());
			activity.setAct_article(act_article);
			
			//多选商户操作
			String belongShops="";
			if((!"".equals(idShopList)&& idShopList!=null )|| (!"".equals(idCityList) && idCityList!=null)){	
				for(int i=0;i<idShopList.length;i++){
					if(i<idShopList.length-1){
						belongShops+=idShopList[i]+"-";
					}else{
						belongShops+=idShopList[i];
					}
				}
				activity.setBelong_shops(belongShops);
				
				//多选城市操作
				String belongCitys="";
				for(int j=0;j<idCityList.length;j++){
					if(j<idCityList.length-1){
						belongCitys += idCityList[j]+"-";
					}else{
						belongCitys +=idCityList[j];
					}
				}
				activity.setBelong_citys(belongCitys);
			}
			adminActivityService.updateObj(activity);
			return "redirect:activityadmin.html";
		} else if (a == 3) {// 编辑
			activity = adminActivityService.getActivityById((int) activity.getId());
			model.addAttribute("activity", activity);
			return "admin/activity_edit";
		} else if (a == 4) {// 添加
			return "admin/activity_edit";
		} else if (a == 8) {// 批量删除活动
			if (null != idList && idList.length > 0) {
				adminActivityService.batchDelActivity(idList);
			}
			return "redirect:activityadmin.html";
		}else if (a == 11) {// 审核不通过
			if (null != activity && 0 != activity.getId()) {
				int ret = adminActivityService.checkObjById((int) activity.getId(), -2,audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:activityadmin.html";
		}

		return "admin/activity_admin";
	}

	@RequestMapping(value = "/admin/getAct", method = RequestMethod.GET)
	public String getActAjax(@RequestParam(required = true, defaultValue = "0")
	int from, @RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "0")
	int search, @RequestParam(required = false, defaultValue = "1")
	int cat, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		QueryResult actList = adminActivityService.getActivityByTypeAndkeyIdAndKeyWordsPagination(p, Constants.DEFAULT_PAGESIZE, cat, bc, wd,search,0,0);
		model.addAttribute("actList", actList);
		model.addAttribute("p", p);
		model.addAttribute("from", from);

		return "admin/act_ajax";
	}
	
	/**
	 * 首页精选活动 ，静态化
	 * */
	@RequestMapping(value="/admin/createActHtml",method = RequestMethod.GET)
	public String createActHtml(@RequestParam(required = false,defaultValue="1")int p,HttpServletResponse response, HttpServletRequest request, Model model){
		List<Activity> listAct = adminActivityService.getActivityByTime(p);
		String basePath = request.getSession().getServletContext().getRealPath("/")+"WEB-INF\\velocity\\template";
		File saveDir = new File(basePath+"/product");
		String loaderPath = basePath;
		BuildHtmlFile.createProductActHtml(listAct, saveDir, loaderPath);
		return "admin/home_admin";
	}
}
