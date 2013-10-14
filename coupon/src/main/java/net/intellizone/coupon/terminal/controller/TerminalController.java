package net.intellizone.coupon.terminal.controller;

/*
 * TerminalController.java 2012-1-10
 * 智域团队
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.coupon.services.GoodsService;
import net.intellizone.coupon.order.model.Order;
import net.intellizone.coupon.order.model.OrderItem;
import net.intellizone.coupon.order.services.OrderService;
import net.intellizone.coupon.shop.model.Shop;
import net.intellizone.coupon.shop.services.ShopService;
import net.intellizone.coupon.terminal.model.Terminal;
import net.intellizone.coupon.terminal.services.TerminalService;
import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.user.services.UserService;
import net.intellizone.coupon.util.web.ContextUtil;
import net.intellizone.sysparam.services.SysParam;
import net.intellizone.utils.DateUtils;
import net.intellizone.utils.NumberUtils;
import net.intellizone.utils.xml.XmlUtils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * pos机服务类
 * 
 * <?xml version="1.0" encoding="utf-8" ?> <root> <result code="0" message="" />
 * <config> <url><!--心跳url--> <heartbeat>coupon/cmd/heartbeat.do?method=mth</heartbeat>
 * <!--用户认证url--> <auth>coupon/cmd/auth.do?method=mth</auth>
 * <!--请求商家/收藏/团购url--> <coupon>coupon/cmd/coupon.do?method=mth</coupon>
 * <!--打印结果url--> <printlog> coupon/cmd/printlog.do?method=afterPrint
 * </printlog> <!--文件上报url--> <upload>coupon/cmd/upload.do?method=mth</upload>
 * <!--告警上报url--> <alarm>coupon/cmd/alarm.do?method=mth</alarm>
 * <!--default.xml文件url--> <default>coupon/cmd/default.do?method=mth</default>
 * <!-- 透光彩更换确认url --> <logoconfirm> coupon/cmd/logoconfirm.do?method=mth
 * </logoconfirm> <!--打印确认url--> <printconfirm>
 * coupon/cmd/printconfirm.do?method=mth </printconfirm> </url> </config>
 * </root>
 * 
 * @author applenono,Pliman
 * @version 2.0 2012-2-20
 * @since coupon 1.0
 */

@Controller
public class TerminalController {
	// 日志记录器
	private static final Logger logger = Logger.getLogger(TerminalController.class.getSimpleName());

	// 终端服务
	@Resource
	private TerminalService terminalService;
	@Resource
	private ShopService shopService;
	@Resource
	private UserService userService;
	@Resource
	private OrderService orderService;
	@Resource
	private GoodsService goodsService;

	// 系统参数
	private SysParam sysParam = SysParam.INSTANCE;

	/**
	 * 请求地址为coupon/cmd/device.do?method=init& terminalid=&
	 * progversion=&pageversion=
	 * 
	 * 将组织好的xml返回给终端
	 */
	@RequestMapping(value = "/cmd/device.do", method = RequestMethod.GET)
	public void SignIn(@RequestParam(required = true)
	String terminalid, @RequestParam(required = true)
	String method, HttpServletResponse response, HttpServletRequest request, Model model) {
		try {
			StringBuilder tBuilder = new StringBuilder(XmlUtils.XML_HEADER);
			Terminal terminal = terminalService.getTerminalReturnCode(terminalid);
			int result = -3;// 默认未登录
			if (terminal != null) {
				result = 0;
			}
			if (result == 0) {
				tBuilder.append("<root><result code=\"").append(result).append(
						"\" message=\"welcome!\" />");
				tBuilder.append("<config><url>");
				// <!--心跳url-->
				tBuilder.append("<heartbeat>").append(
						sysParam.getSysParamValueByCode("terminal_heartbeat")).append(
						"</heartbeat>");
				// <!--用户认证url-->
				tBuilder.append("<auth>").append(sysParam.getSysParamValueByCode("terminal_auth"))
						.append("</auth>");
				// <!--请求商家/收藏/团购url-->
				tBuilder.append("<coupon>").append(
						sysParam.getSysParamValueByCode("terminal_coupon")).append("</coupon>");
				// <!--打印结果url-->
				tBuilder.append("<printlog>").append(
						sysParam.getSysParamValueByCode("terminal_printlog")).append("</printlog>");
				// <!--文件上报url-->
				tBuilder.append("<upload>").append(
						sysParam.getSysParamValueByCode("terminal_upload")).append("</upload>");
				// <!--告警上报url-->
				tBuilder.append("<alarm>")
						.append(sysParam.getSysParamValueByCode("terminal_alarm")).append(
								"</alarm>");
				// <!--default.xml文件url-->
				tBuilder.append("<default>").append(
						sysParam.getSysParamValueByCode("terminal_default")).append("</default>");
				// <!-- 透光彩更换确认url -->
				tBuilder.append("<logoconfirm>").append(
						sysParam.getSysParamValueByCode("terminal_logoconfirm")).append(
						"</logoconfirm>");
				// <!--打印确认url-->
				tBuilder.append("<printconfirm>").append(
						sysParam.getSysParamValueByCode("terminal_printconfirm")).append(
						"</printconfirm>");
				tBuilder.append("</url></config></root>");
			} else {
				tBuilder.append("<root><result code=\"-3\" message=\"签到拒绝！\" />");
				tBuilder.append("</root>");
			}

			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.print(tBuilder.toString());
			out.flush();
		} catch (IOException e) {
			logger.error("签到响应输出流失败 terminalid=" + terminalid, e);
		}
	}

	/**
	 * 用户认证
	 * 
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/cmd/auth.do", method = RequestMethod.GET)
	public void auth(@RequestParam(required = true)
	String type, @RequestParam(required = false, defaultValue = "")
	String cardno, @RequestParam(required = false, defaultValue = "")
	String phone, @RequestParam(required = false, defaultValue = "")
	String password, HttpServletResponse response, HttpServletRequest request, Model model) {
		int result;
		if ("1".equals(type)) {
			result = userService.validateByCardNo(cardno) ? 0 : -5;
		} else {
			result = userService.validateByUserNoAndPass(phone, password) ? 0 : -5;
		}

		try {
			StringBuilder tBuilder = new StringBuilder(XmlUtils.XML_HEADER);
			tBuilder.append("<root><result code=\"").append(result).append("\" message=\"\"/>");

			tBuilder.append("</root>");

			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.print(tBuilder.toString());
			out.flush();
		} catch (IOException e) {
			logger.error("用户认证响应输出流失败 type=" + type, e);
		}
	}

	/**
	 * 心跳
	 * 
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/cmd/heartbeat.do", method = RequestMethod.GET)
	public void heartBeat(HttpServletResponse response, HttpServletRequest request, Model model) {
		try {
			StringBuilder tBuilder = new StringBuilder(XmlUtils.XML_HEADER);
			tBuilder.append("<root><result code=\"0\" message=\"\"/>");
			tBuilder.append("<cmd>");
			// <! —查询终端参数, 终端将结果通过reporturl 上报平台-->
			// 1003整机条码1004机器编号2004局域网IP
			tBuilder.append("<queryParam reporturl=\"").append(
					sysParam.getSysParamValueByCode("terminal_param_query")).append(
					"\" code=\"1003,1004,2004\" />");
			// <! —更新终端参数, 终端将结果通过reporturl 上报平台-->
			tBuilder.append("<updateParam reporturl=\"").append(
					sysParam.getSysParamValueByCode("terminal_param_update")).append("\">");
			tBuilder.append("<param code=\"1005\" value=\"").append(
					DateUtils.formatCurrentDate("yyyyMMddHHmmss")).append("\"/>");
			tBuilder.append("</updateParam>");

			tBuilder.append("<download>");

			tBuilder.append("<file filetype=\"couponall\" orderid=\"3088794\"").append(
					" reporturl=\"").append(
					sysParam.getSysParamValueByCode("terminal_file_reporturl")).append(
					"?OrderID=3088794\"").append(" url=\"").append(
					sysParam.getSysParamValueByCode("terminal_coupon")).append("&amp;key=all\"")
					.append(" version=\"\" />");
			tBuilder.append("</download>");

			tBuilder.append("</cmd></root>");

			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.print(tBuilder.toString());
			out.flush();
		} catch (IOException e) {
			logger.error("心跳响应输出流失败", e);
		}
	}

	/**
	 * 商户
	 * 
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/cmd/coupon.do", method = RequestMethod.GET)
	public void coupon(@RequestParam(required = false, defaultValue = "")
	String key, HttpServletResponse response, HttpServletRequest request, Model model) {
		String fullAppContext = ContextUtil.getFullAppContext(request);
		StringBuilder tBuilder = new StringBuilder(XmlUtils.XML_HEADER);
		int result;
		List<Shop> shopList;

		// 获取所有商家
		if ("all".equals(key)) {
			result = 0;
			tBuilder.append("<root><result code=\"").append(result).append(
					"\" message=\"所有商家的优惠劵\"/>");

			shopList = shopService.getCouponShop();
		} else { // 获取id=key的商家
			Shop shop = shopService.getShopById(NumberUtils.convertToLong(key));
			shopList = new ArrayList<Shop>();

			if (shop != null) {
				result = 0;
				shopList.add(shop);
			} else {
				result = 0;
			}

			tBuilder.append("<root><result code=\"").append(result).append("\" message=\"key= ")
					.append(key).append(" 的商家优惠劵\"/>");
		}

		for (int i = 0, length = shopList.size(); i < length; i++) {
			Shop shop = shopList.get(i);

			int x = i / 3;
			int y = i % 3;

			tBuilder.append("<merchant id=\"").append(shop.getId()).append("\" name=\"").append(
					shop.getName()).append("\" displayImg=\"").append(shop.getDefault_pic())
					.append("\" key=\"").append(i + 1).append("\" xy=\"").append(x).append(",")
					.append(y).append("\"");
			tBuilder.append(" currentlyPage=\"0\" service=\"1\">");
			for (Goods goods : shop.getCouponList()) {
				tBuilder.append("<coupon id=\"").append(goods.getId()).append("\" title=\"")
						.append(goods.getName()).append("\" remark=\"\"").append(" displayImg=\"")
						.append(fullAppContext).append("goods0/img/")
						.append(goods.getDefault_pic()).append("\" printImg=\"").append(
								fullAppContext).append("goods0/img/").append(goods.getYq_img())
						.append("\" enddate=\"").append(
								DateUtils.formatDate(new Date(goods.getEnd_time()), "yyyy-MM-dd"))
						.append("\"").append(" service=\"1\" fee=\"10\" confirmurl=\"").append(
								sysParam.getSysParamValueByCode("terminal_printconfirm")).append(
								"\" isreport=\"1\"").append(
								" iscard=\"0\" browserImg=\"\" vouchertype=\"").append(
								goods.getCat_type()).append("\"").append(
								" vbttcode=\"\" phonenum=\"\" psw=\"\" />");
			}

			tBuilder.append("</merchant>");
		}

		tBuilder.append("</root>");

		try {
			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.print(tBuilder.toString());
			out.flush();
		} catch (IOException e) {
			logger.error("响应输出流失败", e);
		}
	}

	/**
	 * 参数查询
	 * 
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/cmd/param_query.do", method = RequestMethod.GET)
	public void paramQuery(@RequestParam(required = false, defaultValue = "")
	String paramcode, @RequestParam(required = false, defaultValue = "")
	String paramvalue, @RequestParam(required = false, defaultValue = "")
	String result, HttpServletResponse response, HttpServletRequest request, Model model) {
		// 查询 1003整机条码1004机器编号2004局域网IP
		String[] paramCodeArr = paramcode.split(",");
		String[] paramValueArr = paramvalue.split(",");
		String[] resultArr = result.split(",");

		Map<String, Param> paramMap = new HashMap<String, Param>();
		for (int i = 0, length = paramCodeArr.length; i < length; i++) {
			paramMap.put(paramCodeArr[i],
					new Param(paramCodeArr[i], paramValueArr[i], resultArr[i]));
		}

		Terminal terminal = terminalService.getTerminalByCodeAndId(paramMap.get("1003").value,
				paramMap.get("1004").value);

		if (terminal != null) {
			terminal.setLastActiveTime(System.currentTimeMillis());
		}

		try {
			StringBuilder tBuilder = new StringBuilder(XmlUtils.XML_HEADER);
			tBuilder.append("<root><result code=\"0\" message=\"成功\"/>");
			tBuilder.append("</root>");

			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(tBuilder.toString());
			out.flush();
		} catch (IOException e) {
			logger.error("响应输出流失败", e);
		}
	}

	// 参数类
	private class Param {
		Param(String code, String value, String result) {
			this.code = code;
			this.value = value;
			this.result = result;
		}

		String code;
		String value;
		String result;
	}

	/**
	 * 参数更新
	 * 
	 * @param paramcode
	 *            更新编码
	 * @param result
	 *            结果
	 */
	@RequestMapping(value = "/cmd/param_update.do", method = RequestMethod.GET)
	public void paramUpdate(@RequestParam(required = false, defaultValue = "")
	String paramcode, @RequestParam(required = false, defaultValue = "")
	String result, HttpServletResponse response) {
		String[] paramCodeArr = paramcode.split(",");
		String[] resultArr = result.split(",");

		String code;
		int rtnCode;
		for (int i = 0, length = paramCodeArr.length; i < length; i++) {
			code = paramCodeArr[i];
			rtnCode = NumberUtils.convertToInteger(resultArr[i]);

			if (rtnCode == 0) {
				logger.info(String.format("更新参数 %s 成功", code));
			} else {
				logger.warn(String.format("更新参数 %s 失败", code));
			}
		}

		try {
			StringBuilder tBuilder = new StringBuilder(XmlUtils.XML_HEADER);
			tBuilder.append("<root><result code=\"0\" message=\"成功\"/>");
			tBuilder.append("</root>");

			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(tBuilder.toString());
			out.flush();
		} catch (IOException e) {
			logger.error("响应输出流失败", e);
		}
	}

	/**
	 * 文件下载结果
	 * 
	 * @param OrderID
	 *            订单编码
	 * @param result
	 *            结果
	 */
	@RequestMapping(value = "/cmd/file_reporturl.do", method = RequestMethod.GET)
	public void fileReport(@RequestParam(required = false, defaultValue = "")
	String OrderID, HttpServletResponse response) {
		try {
			StringBuilder tBuilder = new StringBuilder(XmlUtils.XML_HEADER);
			tBuilder.append("<root><result code=\"0\" message=\"成功\"/>");
			tBuilder.append("</root>");

			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(tBuilder.toString());
			out.flush();
		} catch (IOException e) {
			logger.error("响应输出流失败", e);
		}
	}

	/**
	 * 打印确认
	 * 
	 * @param method
	 * @param couponId
	 *            优惠劵id
	 * @param serialnum
	 *            终端产生的流水号
	 * @param cardno
	 *            用户卡号
	 * @param nextpage
	 *            下一页
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cmd/printconfirm.do", method = RequestMethod.GET)
	public void printConfirm(@RequestParam(required = false, defaultValue = "")
	String method, @RequestParam(required = true, defaultValue = "")
	long couponId, @RequestParam(required = false, defaultValue = "")
	String serialnum, @RequestParam(required = false, defaultValue = "")
	String cardno, @RequestParam(required = false, defaultValue = "")
	String nextpage, HttpServletResponse response, HttpServletRequest request, Model model) {
		String fullAppContext = ContextUtil.getFullAppContext(request);

		StringBuilder tBuilder = new StringBuilder(XmlUtils.XML_HEADER);
		int result;

		User user = userService.getUserByCardNo(cardno);
		// 如果用户验证失败
		if (user == null) {
			result = -6;
			tBuilder.append("<root><result code=\"").append(result).append(
					"\" message=\"用户卡号非法！\" count=\"\" pagenum=\"\" nextpage=\"\" continue=\"\"/>");
			tBuilder.append("</root>");
		} else {
			Goods goods = goodsService.getGoodsById(couponId);
			// 如果是普通优惠劵--直接验证打印
			if (goods.getCat_type() == 1) {
				Order order = orderService.getOrderbyOrderItem(couponId);

				// 如果优惠劵已经被锁定，正在打印，或者已经被打印
				if (order.getOrderStatus() == 2 || order.getOrderStatus() == 3
						|| order.getOrderStatus() == 4) {
					result = -1;
					tBuilder
							.append("<root><result code=\"")
							.append(result)
							.append(
									"\" message=\"该收藏已被锁定！请确定该优惠劵没有正在在别处打印\" count=\"\" pagenum=\"\" nextpage=\"\" continue=\"\"/>");
					tBuilder.append("</root>");
				} else {
					// 可以打印 立刻锁定该订单
					order.setOrderStatus(2);
					order.setModifyTime(System.currentTimeMillis());
					orderService.updateOrder(order);

					// tBuilder.append("<root><result code=\"0\" message=\"\"
					// count=\"").append(
					// order.getBuy_num()).append("\" pagenum=\"\"
					// nextpage=\"").append(
					// nextpage).append("\" continue=\"\"/>");
					tBuilder.append("</root>");

					// 将订单设置为正在打印状态
					order.setOrderStatus(3);
					order.setModifyTime(System.currentTimeMillis());
					orderService.updateOrder(order);
				}
			} else {
				tBuilder
						.append("<root><result code=\"-11")
						.append(
								"\" message=\"返回用户收藏的优惠劵\" count=\"2\" pagenum=\"1\" nextpage=\"2\" continue=\"0\"/>");

				// 获取用户所有收藏的指定商家
				tBuilder.append("<merchant id=\"1\" key=\"2\" name=\"用户收藏\"");
				tBuilder.append(" displayImg=\"null\" currentlyPage=\"0\" service=\"1\">");

				List<Order> orderList = orderService.queryUnusedCouponByUser(user);

				for (Order order : orderList) {
					OrderItem g = order.getOrderItemList().get(0);

					tBuilder.append("<coupon id=\"").append(g.getId()).append("\" title=\"")
							.append(g.getName()).append("\" remark=\"\"").append(" displayImg=\"")
							.append(fullAppContext).append("goods0/img/")
							.append(g.getDefault_pic()).append("\" printImg=\"").append(
									fullAppContext).append("goods/print_img.do?orderId=").append(
									order.getId()).append("\" enddate=\"").append(
									DateUtils.formatDate(new Date(goods.getEnd_time()),
											"yyyy-MM-dd")).append("\"").append(
									" service=\"1\" fee=\"10\" confirmurl=\"").append(
									sysParam.getSysParamValueByCode("terminal_printconfirm"))
							.append("\" isreport=\"1\"").append(
									" iscard=\"0\" browserImg=\"\" vouchertype=\"").append(
									g.getCat_type()).append("\"").append(
									" vbttcode=\"\" phonenum=\"\" psw=\"\" />");
				}

				tBuilder.append("</merchant>");
				tBuilder.append("</root>");
			}
		}

		try {
			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(tBuilder.toString());
			out.flush();
		} catch (IOException e) {
			logger.error("响应输出流失败", e);
		}
	}

	/**
	 * 打印结果
	 * 
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/cmd/printlog.do", method = RequestMethod.GET)
	public void printLog(@RequestParam(required = false, defaultValue = "")
	String method, @RequestParam(required = false, defaultValue = "0")
	String couponId, @RequestParam(required = false, defaultValue = "0")
	String serialnum, @RequestParam(required = false, defaultValue = "0")
	String result, @RequestParam(required = false, defaultValue = "")
	String cardno, @RequestParam(required = false, defaultValue = "0")
	int printType, HttpServletResponse response, HttpServletRequest request, Model model) {
		StringBuilder tBuilder = new StringBuilder(XmlUtils.XML_HEADER);

		User user = userService.getUserByCardNo(cardno);
		// 如果用户验证失败
		if (user == null) {
			tBuilder.append("<root><result code=\"-6\" message=\"用户卡号非法！\"/>");
			tBuilder.append("</root>");
		} else {
			Order order = orderService.getOrderbyOrderItem(NumberUtils.convertToLong(couponId));

			// 设置为已经打印完成
			order.setOrderStatus(4);
			order.setModifyTime(System.currentTimeMillis());
			orderService.updateOrder(order);

			tBuilder.append("<root><result code=\"0\" message=\"收到打印成功消息\"/>");
			tBuilder.append("</root>");
		}

		try {
			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(tBuilder.toString());
			out.flush();
		} catch (IOException e) {
			logger.error("响应输出流失败", e);
		}
	}
}