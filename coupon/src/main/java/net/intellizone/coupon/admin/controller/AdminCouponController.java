package net.intellizone.coupon.admin.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.city.services.CityService;
import net.intellizone.coupon.coupon.model.BussinessCircle;
import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.coupon.model.GoodsImages;
import net.intellizone.coupon.activity.model.Activity;
import net.intellizone.coupon.admin.model.CouponDemo;
import net.intellizone.coupon.admin.services.AdminActivityService;
import net.intellizone.coupon.admin.services.AdminBussinessCircleService;
import net.intellizone.coupon.admin.services.AdminGoodsImagesService;
import net.intellizone.coupon.admin.services.AdminGoodsService;
import net.intellizone.coupon.admin.services.AdminShopCategoryService;
import net.intellizone.coupon.admin.services.AdminShopService;
import net.intellizone.coupon.shop.model.Shop;
import net.intellizone.coupon.shop.model.ShopCategroy;

import net.intellizone.coupon.util.web.AppContext;
import net.intellizone.coupon.util.web.BuildHtmlFile;
import net.intellizone.coupon.util.web.BuildSerialNo;
import net.intellizone.coupon.util.web.Constant;
import net.intellizone.coupon.util.web.WaterMark;
import net.intellizone.coupon.util.web.ZxingEncoderHandler;
import net.intellizone.utils.DateUtils;

import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminCouponController {
	@Resource
	private CityService cityService;
	@Resource
	private AdminGoodsService adminGoodsService;
	@Resource
	private AdminShopService adminShopService;
	@Resource
	private AdminActivityService adminActivityService;
	@Resource
	private AdminShopCategoryService adminShopCategoryService;
	@Resource
	private AdminBussinessCircleService adminBussinessCircleService;

	@Resource
	private AdminGoodsImagesService adminGoodsImagesService;

	@RequestMapping(value = "/admin/goodsadmin", method = RequestMethod.GET)
	public String index(@RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int ctype, @RequestParam(required = false, defaultValue = "")
	String wd, HttpServletResponse response, HttpServletRequest request, Model model) {
		// List<ShopAdmin> shopAdminList=shopAdminService.getShopAdmin();
		// model.addAttribute("shopList",shopAdminList);

		QueryResult pageObj = adminGoodsService.getAllGoodsByTypeAndkeyIdAndKeyWordsPagination(1,
				p, Constants.PAGESIZE20, 0, 0, "");
		model.addAttribute("pageObj", pageObj);

		model.addAttribute("wd", wd);
		model.addAttribute("p", p);
		model.addAttribute("ctype", ctype);
		return "admin/coupon_admin";
	}

	/**
	 * 首页优惠劵动态，静态化
	 * 
	 * 
	 */
	@RequestMapping(value = "/admin/createCoupHtml", method = RequestMethod.GET)
	public String createCoupHtml(@RequestParam(required = false, defaultValue = "1")
	int type, @RequestParam(required = false, defaultValue = "1")
	int p, HttpServletResponse response, HttpServletRequest request, Model model) {
		List<Goods> listGoods = adminGoodsService.getAllGoodsByTime(p);
		String basePath = request.getSession().getServletContext().getRealPath("/")
				+ "WEB-INF\\velocity\\template";
		File saveDir = new File(basePath + "/product");
		String loaderPath = basePath;
		BuildHtmlFile.createProductGoodsHtml(listGoods, saveDir, loaderPath);
		return "admin/home_admin";

	}

	/**
	 * 优惠券操作
	 * 
	 * @param goods
	 * @param idList
	 * @param p
	 * @param a
	 * @param audit_reason
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/goodsAction", method = RequestMethod.GET)
	public String shopAction(Goods goods, int[] idList,
			@RequestParam(required = false, defaultValue = "")
			String audit, @RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "0")
			int a, @RequestParam(required = false, defaultValue = "0")
			String audit_reason, HttpServletResponse response, HttpServletRequest request,
			Model model) {
		
		City city = (City) request.getSession().getAttribute("city");
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.selectShopCategoryList(0);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(city);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("cityList", cityService.getAllCity());
		model.addAttribute("a", a);
		model.addAttribute("p", p);



		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		model.addAttribute("audit_reason", audit_reason);

		if (a == 1) {// 添加
			adminGoodsService.insertObj(goods);
			return "redirect:goodsadmin.html";
		} else if (a == 5) {// 删除
			adminGoodsService.deleteGoodsById(goods.getId());
			return "redirect:goodsadmin.html";
		} else if (a == 2) {
			adminGoodsService.updateObj(goods);
			return "redirect:goodsadmin.html";
		} else if (a == 3) {// 编辑
			List<Shop> shopList = adminShopService.getShop();
			model.addAttribute("shopList", shopList);
			goods = adminGoodsService.getGoodsById((int) goods.getId());

			List<Shop> branchShopList = adminGoodsService.getGoodsUseShopList(goods);
			model.addAttribute("branchShopList", branchShopList);
			model.addAttribute("goods", goods);
			if (!"".equals(audit) && audit != null) {
				return "admin/goods_audit";
			}
			return "admin/goods_edit";

		} else if (a == 4) {// 添加
			List<Shop> shopList = adminShopService.getShop();
			model.addAttribute("shopList", shopList);
			return "admin/goods_edit";
		} else if (a == 6) {// 审核通过
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), 1, null);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 7) {// 冻结
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), 2, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 8) {// 解冻
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), 1, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 9) {// 上架
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), 1, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 10) {// 下架
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), -1, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 11) {// 审核不通过
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), -2, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 12) {// 批量删除活动
			if (null != idList && idList.length > 0) {
				adminGoodsService.batchDelGoods(idList);
			}
			return "redirect:goodsadmin.html";
		}

		return "admin/coupon_admin";
	}

	@RequestMapping(value = "/admin/goodsAction", method = RequestMethod.POST)
	public String shopActionPost(Goods goods, int[] idList,
			@RequestParam(required = false, defaultValue = "1")
			int haserwei, @RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "1970-01-01")
			String begin_time1, @RequestParam(required = false, defaultValue = "1970-01-01")
			String end_time1, @RequestParam(required = false, defaultValue = "0")
			int a, @RequestParam(required = false, defaultValue = "0")
			int yq_imgflag, @RequestParam(required = false, defaultValue = "0")
			String audit_reason, HttpServletResponse response, HttpServletRequest request,
			Model model) {
		City city = (City) request.getSession().getAttribute("city");
		List<ShopCategroy> shopCategoryList = adminShopCategoryService.getAllShopCategory(2);
		List<BussinessCircle> bussinessCircleList = adminBussinessCircleService
				.getAllBussinessCircleByCityId(city);
		model.addAttribute("bussinessCircleList", bussinessCircleList);
		model.addAttribute("shopCategoryList", shopCategoryList);
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		model.addAttribute("audit_reason", audit_reason);

		if (a == 1) {// 添加
			if (yq_imgflag == 0) {
				goods.setYq_img(null);
			}
			String use_branchshop = "";
			if (null != idList && idList.length > 0) {
				for (int i = 0; i < idList.length; i++) {
					use_branchshop += idList[i] + "-";
				}
			}
			goods.setUse_branchshop(use_branchshop);
			goods.setBegin_time(DateUtils.converToDateTime(begin_time1).getTime());
			goods.setEnd_time(DateUtils.converToDateTime(end_time1).getTime());
			goods.setCreate_time(System.currentTimeMillis());
			goods.setModify_time(System.currentTimeMillis());
			adminGoodsService.insertObj(goods);
			goods = adminGoodsService.insertLink(goods);
			if (goods != null && haserwei == 1) {//
				String erweiName = "erwei_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
				String path = request.getSession().getServletContext().getRealPath("/")
						+ Constant.RC_PIC_PATH + "/" + erweiName;
				// File file=RCCreator.createRC(goods.getName(),
				// String.valueOf(goods.getId()), path);

				try {
					String contents = goods.getDescription() == null ? "描述" : goods
							.getDescription()
							+ goods.getId();
					int width = 230, height = 230;
					ZxingEncoderHandler.encode(contents, width, height, path);

					goods.setErcode(erweiName);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			String Logo = "noLogo.jpg";
			if (yq_imgflag == 1) {
				CouponDemo couponDemo = new CouponDemo();

				if (goods.getBelongShopObj() != null) {// 属于所有商户
					if (goods.getBelongShopObj().getShop_logo() != null) {
						Logo = goods.getBelongShopObj().getShop_logo();
						couponDemo.setTelphone(goods.getBelongShopObj().getTelephone());
					}

				}
				String logopath = AppContext.getInstance().getAPP_PATH() + "goods0\\img\\" + "\\"
						+ Logo;

				couponDemo.setNo(BuildSerialNo.createSerialNum(goods.getId()));
				couponDemo.setShopLogoPath(logopath);
				couponDemo.setTitle(goods.getName());
				couponDemo.setYqMarkPath(AppContext.getInstance().getAPP_PATH()
						+ "res\\images\\yq_mark.jpg");
				couponDemo.setBeginTime(DateUtils.formatDate(new Date(goods.getBegin_time())));
				couponDemo.setEndTime(DateUtils.formatDate(new Date(goods.getEnd_time())));
				couponDemo.setUserInfo(goods.getUse_intro());
				couponDemo.setUseAddress(goods.getUse_addr());
				couponDemo.setBtmLogoPath(AppContext.getInstance().getAPP_PATH()
						+ "res\\images\\logo_btm.jpg");

				String yqpath = request.getSession().getServletContext().getRealPath("/")
						+ Constant.YQ_PIC_PATH + "\\" + "yq_"
						+ String.valueOf(System.currentTimeMillis()) + ".jpg";
				File file = WaterMark.createMarkLogo(yqpath, couponDemo);
				model.addAttribute("yqpath", yqpath);
				if (file != null) {
					goods.setYq_img(file.getName());
				} else {
					goods.setYq_img("noLogo.jpg");

				}
				adminGoodsService.updateObj(goods);
			}
			return "redirect:goodsadmin.html";
		} else if (a == 5) {// 删除
			adminGoodsService.deleteGoodsById(goods.getId());
			return "redirect:goodsadmin.html";
		} else if (a == 2) {

			String use_branchshop = "";
			if (null != idList && idList.length > 0) {
				for (int i = 0; i < idList.length; i++) {
					use_branchshop += idList[i] + "-";
				}
			}
			goods.setUse_branchshop(use_branchshop);
			goods.setBegin_time(DateUtils.converToDateTime(begin_time1).getTime());
			goods.setEnd_time(DateUtils.converToDateTime(end_time1).getTime());
			goods.setModify_time(System.currentTimeMillis());
			if (haserwei == 0) {
				goods.setErcode(null);// 删除二维码
			}
			if (goods != null && haserwei == 1) {// 重新生成二维码
				String erweiName = "erwei_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
				String path = request.getSession().getServletContext().getRealPath("/")
						+ Constant.RC_PIC_PATH + "/" + erweiName;
				// File file=RCCreator.createRC(goods.getName(),
				// String.valueOf(goods.getId()), path);
				try {
					String contents = goods.getDescription() == null ? "描述" : goods
							.getDescription()
							+ goods.getId();
					int width = 230, height = 230;
					ZxingEncoderHandler.encode(contents, width, height, path);

					goods.setErcode(erweiName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (yq_imgflag == 0) {
				goods.setYq_img(null);
			}
			String Logo = "noLogo.jpg";
			if (yq_imgflag == 1) {// 生成打印图
				CouponDemo couponDemo = new CouponDemo();

				if (goods.getBelongShopObj() != null) {// 属于所有商户
					if (goods.getBelongShopObj().getShop_logo() != null) {
						Logo = goods.getBelongShopObj().getShop_logo();
						couponDemo.setTelphone(goods.getBelongShopObj().getTelephone());
					}

				}
				String logopath = AppContext.getInstance().getAPP_PATH() + "goods0\\img\\" + "\\"
						+ Logo;

				couponDemo.setNo(BuildSerialNo.createSerialNum(goods.getId()));
				couponDemo.setShopLogoPath(logopath);
				couponDemo.setTitle(goods.getName());
				couponDemo.setYqMarkPath(AppContext.getInstance().getAPP_PATH()
						+ "res\\images\\yq_mark.jpg");
				couponDemo.setBeginTime(DateUtils.formatDate(new Date(goods.getBegin_time())));
				couponDemo.setEndTime(DateUtils.formatDate(new Date(goods.getEnd_time())));
				couponDemo.setUserInfo(goods.getUse_intro());
				couponDemo.setUseAddress(goods.getUse_addr());
				couponDemo.setBtmLogoPath(AppContext.getInstance().getAPP_PATH()
						+ "res\\images\\logo_btm.jpg");

				if (null != goods.getYq_img() && !"".equals(goods.getYq_img())) {
					// 将原打印图覆盖掉
					String yqpath = request.getSession().getServletContext().getRealPath("/")
							+ Constant.YQ_PIC_PATH + "\\" + goods.getYq_img();
					File file = WaterMark.createMarkLogo(yqpath, couponDemo);
					model.addAttribute("yqpath", yqpath);
					if (file != null) {
						goods.setYq_img(file.getName());
					} else {
						goods.setYq_img("noLogo.jpg");

					}
				} else {// 生成图并保存
					String yqpath = request.getSession().getServletContext().getRealPath("/")
							+ Constant.YQ_PIC_PATH + "\\" + "yq_"
							+ String.valueOf(System.currentTimeMillis()) + ".jpg";
					File file = WaterMark.createMarkLogo(yqpath, couponDemo);
					model.addAttribute("yqpath", yqpath);
					if (file != null) {
						goods.setYq_img(file.getName());
					} else {
						goods.setYq_img("noLogo.jpg");

					}

				}

			}

			adminGoodsService.updateObj(goods);
			if (null != goods.getGoodsImages() && goods.getGoodsImages().size() > 0) {// 如果没有原来图片则插入否则更新图片
				if (goods.getGoodsImages().get(0).getId() != 0) {// 更新
					adminGoodsService.updateLink(goods);
				} else {
					adminGoodsService.insertLink(goods);
				}
			}

			return "redirect:goodsadmin.html";
		} else if (a == 3) {// 编辑
			goods = adminGoodsService.getGoodsById((int) goods.getId());
			model.addAttribute("goods", goods);
			return "admin/goods_edit";

		} else if (a == 4) {// 添加
			return "admin/goods_edit";
		} else if (a == 6) {// 审核通过
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), 1, null);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 7) {// 冻结
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), 2, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 8) {// 解冻
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), 1, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 9) {// 上架
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), 1, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 10) {// 下架
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), -1, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 11) {// 审核不通过
			if (null != goods && 0 != goods.getId()) {
				int ret = adminGoodsService.checkObjById((int) goods.getId(), -2, audit_reason);
				if (ret == 0) {
					model.addAttribute("opinfo", "状态更新失败！");
				}
			}
			return "redirect:goodsadmin.html";
		} else if (a == 12) {// 批量删除活动
			if (null != idList && idList.length > 0) {
				adminGoodsService.batchDelGoods(idList);
			}
			return "redirect:goodsadmin.html";
		}

		return "admin/coupon_admin";
	}

	/**
	 * 删除优惠券图片
	 * 
	 * @param goodsImages
	 * @param goodsId
	 * @param p
	 * @param a
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/deleteGoodsPic", method = RequestMethod.GET)
	public String deleteGoodsPic(GoodsImages goodsImages,
			@RequestParam(required = true, defaultValue = "0")
			int goodsId, @RequestParam(required = false, defaultValue = "1")
			int p, @RequestParam(required = false, defaultValue = "0")
			int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("p", p);
		model.addAttribute("id", goodsId);
		// List<ShopPic> shopPicList=new ArrayList<ShopPic>();
		// shopPicList.add(shopPic);
		// Shop shop=new Shop ();
		// shop.setId(shopId);
		// shop.setShopPicList(shopPicList);
		// adminShopService.deletLink(shop);
		adminGoodsImagesService.deleteGoodsPicById(goodsImages.getId());

		return "redirect:goodsAction.html";
	}

	@RequestMapping(value = "/admin/checkPreview", method = RequestMethod.GET)
	public String checkPreview(@RequestParam(required = true, defaultValue = "0")
	int id, @RequestParam(required = true, defaultValue = "1")
	int type, @RequestParam(required = true, defaultValue = "")
	String template, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		model.addAttribute("p", p);
		if (!"".equals(template)) {
			if (type == 1) {
				Shop shop = adminShopService.getShopById(id);
				model.addAttribute("shop", shop);
			} else if (type == 2) {
				Goods goods = adminGoodsService.getGoodsById(id);
				model.addAttribute("goods", goods);
			} else if (type == 3) {
				Activity activty = adminActivityService.getActivityById(id);
				model.addAttribute("activity", activty);
			}
		}

		return template;

	}

	/**
	 * 优惠券查询控制器POST方法
	 * 
	 * @param p
	 *            分页
	 * @param wd
	 *            关键词
	 * @param cat
	 *            分类ID
	 * @param bc
	 *            商圈ID
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/couponSearch.html", method = RequestMethod.GET)
	public String couponPost(@RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = false, defaultValue = "0")
	int cat, @RequestParam(required = false, defaultValue = "0")
	int ctype, @RequestParam(required = false, defaultValue = "0")
	int bc, HttpServletResponse response, HttpServletRequest request, Model model) {
		int count = 0;
		if (ctype != 0) {
			List<Goods> goodsList = adminGoodsService.getGoodsByCity(1, p,
					Constants.PAGESIZE20, cat, bc, wd, ctype);
			count = adminGoodsService.getCouponCount(1, wd, ctype);
			model.addAttribute("count", count);
			model.addAttribute("goodsList", goodsList);
		} else {
			QueryResult pageObj = adminGoodsService.getAllGoodsByTypeAndkeyIdAndKeyWordsPagination(
					1, p, Constants.PAGESIZE20, cat, bc, wd);
			model.addAttribute("pageObj", pageObj);
		}

		model.addAttribute("wd", wd);
		model.addAttribute("ctype", ctype);
		model.addAttribute("cat", cat);
		model.addAttribute("bc", bc);
		model.addAttribute("p", p);

		return "admin/coupon_admin";
	}

	@RequestMapping(value = "/admin/getCoupon.html", method = RequestMethod.GET)
	public String getCouponAjax(@RequestParam(required = true, defaultValue = "0")
	int from, @RequestParam(required = false, defaultValue = "")
	String wd, @RequestParam(required = false, defaultValue = "0")
	int bc, @RequestParam(required = false, defaultValue = "0")
	int cat, @RequestParam(required = false, defaultValue = "1")
	int p, @RequestParam(required = false, defaultValue = "0")
	int ctype, @RequestParam(required = false, defaultValue = "0")
	int a, HttpServletResponse response, HttpServletRequest request, Model model) {
		QueryResult couponList = adminGoodsService.getAllGoodsByTypeAndkeyIdAndKeyWordsPagination(
				1, p, Constants.DEFAULT_PAGESIZE, cat, bc, wd);
		model.addAttribute("couponList", couponList);
		model.addAttribute("p", p);
		model.addAttribute("from", from);
		model.addAttribute("ctype", ctype);
		return "admin/coupon_ajax";
	}
}
