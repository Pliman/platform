package net.intellizone.coupon.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.system.common.SysConstants;
import net.intellizone.coupon.system.model.Functions;
import net.intellizone.coupon.system.model.Roles;
import net.intellizone.coupon.system.model.Users;
import net.intellizone.coupon.system.service.FunctionsService;
import net.intellizone.coupon.system.service.RolesService;
import net.intellizone.coupon.system.service.UserManagerResult;
import net.intellizone.coupon.system.service.UsersService;
import net.intellizone.coupon.system.util.BeanUtil;
import net.intellizone.coupon.system.util.JsonUtil;
import net.intellizone.coupon.system.util.MenuTreeNode;
import net.intellizone.coupon.system.util.MyHelp;
import net.intellizone.coupon.verificationcode.model.AuthImg;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author： ljt
 * @modify:
 * @主要功能：
 * @see
 * @version 1.0
 */
@Controller
public class UsersController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8046815026246393052L;

	@Resource
	private UsersService usersService;

	@Resource
	private RolesService rolesService;

	@Resource
	private FunctionsService functionsService;

	/**
	 * 注销退出后返回会员用户默认主页
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/system/logout.html")
	public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		Object obj = request.getSession().getAttribute(SysConstants.SESSION_USER);
		if (null != obj) {
			Users onlineUser = (Users) obj;
			usersService.logout(onlineUser.getUser_id());
		}
		request.getSession().invalidate();
		System.out.println("---logout ");
		return "redirect:/system/adminlogin.html";
	}

	/**
	 * 在系统管理员后台管理登录 登录成功后到后台管理主页 失败则到adminlogin.htm
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/system/adminlogin.html")
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String validate = request.getParameter("validate");
		String forward = "admin/system/adminlogin";
		if (null == username || (null != username && "".equals(username))) {
			model.addAttribute("loginError", "请输入用户名，密码和验证码");
			model.addAttribute("user", "");
			model.addAttribute("pwd", "");
			return forward;
		}

		UserManagerResult umr = usersService.login(username, password);

		if (umr.getStatusCode() != SysConstants.EXCUTE_OK) {
			String msg = "User Error";
			if (umr.getStatusCode() == SysConstants.INVALID_USER) {
				msg = "用户不存在";
			} else if (umr.getStatusCode() == SysConstants.INVALID_PASSWORD) {
				msg = "密码错误";
			} else if (umr.getStatusCode() == SysConstants.USER_LOCKED) {
				msg = "用户已被锁定";
			}
			model.addAttribute("loginError", msg);
			model.addAttribute("user", null == username ? "" : username);
			model.addAttribute("pwd", null == password ? "" : password);
		} else {
			// 用户验证成功，核对验证码
			HttpSession session = request.getSession();
			AuthImg authImg = (AuthImg) session.getAttribute("authImg");
			String msg = "请输入验证码";
			if (validate == null || "".equals(validate)) {
				model.addAttribute("loginError", msg);
				model.addAttribute("user", null == username ? "" : username);
				model.addAttribute("pwd", null == password ? "" : password);
				model.addAttribute("validate", null == validate ? "" : validate);
				return forward;
			}
			
			if(!validate.equalsIgnoreCase(authImg.getContent())){
				msg = "验证码错误";
				model.addAttribute("loginError", msg);
				model.addAttribute("user", null == username ? "" : username);
				model.addAttribute("pwd", null == password ? "" : password);
				model.addAttribute("validate", null == validate ? "" : validate);
				return forward;
			}
			
			long current = System.currentTimeMillis();
			if ((current - authImg.getBornTime()) > Constants.AUTH_IMG_INVALID_TIME) {
				msg = "验证码已经过期";
				model.addAttribute("loginError", msg);
				model.addAttribute("user", null == username ? "" : username);
				model.addAttribute("pwd", null == password ? "" : password);
				model.addAttribute("validate", null == validate ? "" : validate);
				return forward;
			}

			// 成功登录
			forward = "admin/admin";
			request.getSession().setAttribute(SysConstants.SESSION_USER, umr.getUser());
			request.getSession().setAttribute(SysConstants.SESSION_USER_RESOURCE_LIST,
					umr.getResourceList());

			// 加载当前登录者所拥有有后台主菜单目录以及目录下菜单
			/**
			 * <li><a href="#">商户管理</a> <div class="top_sub_nav">
			 * <ul>
			 * <li><a href="#" target="main">目录管理</a></li>
			 * <li><a href="#" target="main">优惠劵管理</a></li>
			 * <li><a href="#" target="main">活动管理</a></li>
			 * </ul>
			 * </div> </li>
			 */
			List<Functions> mFList = this.functionsService.findNextLevelResources(
					Functions.ROOT_FUNCTIONS_ID, Functions.FUNCTION_TYPE_FOLDER);
			StringBuffer sb = new StringBuffer("");
			int i = 0;
			if (null != mFList) {

				List<String> urlList = umr.getResourceList();
				for (Functions mf : mFList) {
					// sb.append("");
					if (urlList.contains(mf.getUrl())) {
						sb
								.append("<dl class=\"bitem\">"
										+ "<div style=\"position: absolute;width:35px;height:27px;\"class=\"bitem"
										+ mf.getFunction_id() + "\"></div>"
										+ "<dt class=\"bitem\">" + "<b><a href='" + mf.getUrl()
										+ "'  target='main'>" + mf.getFunction_name()
										+ "</a></b></dt>");
						if (i == 0) {
							sb.append("<input id='defaultLeftMenuId' type='hidden' value='"
									+ mf.getFunction_id() + "' />");
						}
						List<Functions> sFList = this.functionsService.findNextLevelResources(mf
								.getFunction_id(), Functions.FUNCTION_TYPE_MENU);
						StringBuffer ssb = null;
						if (null != sFList && sFList.size() > 0) {
							ssb = new StringBuffer();
						}
						for (Functions sf : sFList) {
							if (urlList.contains(sf.getUrl())) {
								ssb.append("<li><a href='" + sf.getUrl() + "'  target='main' >"
										+ sf.getFunction_name() + "</a></li>");
							}
						}
						if (null != ssb) {
							if (i == 0) {
								sb.append("<dd id='items1_" + i + "' class=\"sitem"
										+ mf.getFunction_id()
										+ "\" style=\"display: block\" ><ul class=\"sitemu\" id='"
										+ mf.getFunction_id() + "'>");
							} else {
								sb.append("<dd id='items1_" + i + "' class=\"sitem"
										+ mf.getFunction_id()
										+ "\" style=\"display: none\" ><ul class=\"sitemu\" id='"
										+ mf.getFunction_id() + "'>");

							}
							sb.append(ssb.toString());
							sb.append("</ul></dd>");
						}

						sb.append("</dl>");
						// sb.append(" <li class='nav_seperate'>|</li>");
					}
					i++;
				}
				// sb.append("");
			}
			model.addAttribute("mainMenu", sb.toString());
			model.addAttribute("mFList", mFList);

		}
		return forward;
	}

	/**
	 * 到用户管理主页
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/system/to_user.html")
	public String toUserPage(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		System.out.println("---/system/to_user.html");
		return "admin/system/to_user";
	}

	/**
	 * 用户查操作 jquery easyui datagrid
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/system/userLis.html")
	public void userLis(Users users, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		String page = request.getParameter("page");// 当前页
		String rows = request.getParameter("rows");// 每页显示记录数
		int pageSize = (null == rows ? 10 : Integer.valueOf(rows));
		int currentPage = Integer.valueOf(page.toString());
		String order = request.getParameter("order");
		String sort = request.getParameter("sort");

		// 查询条件,顺序
		Cnd c = Cnd.where("1", "=", 1);
		if (null != order) {
			if (order.equals("asc")) {
				c.asc(sort);
			} else {
				c.desc(sort);
			}
		} else {
			// 默认顺序
			c.asc("show_order");
		}
		QueryResult qr = this.usersService.getPagination(c, currentPage, pageSize);
		String s = MyHelp.getDatagridJSON(qr, Users.class, new String[] { "roles" });

		System.out.println(s);

		MyHelp.ajaxResponseJson(response, s);

	}

	/**
	 * 用户增操作 jquery easyui datagrid
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/system/userAdd.html")
	public void userAdd(Users userForm, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Boolean jsonStatus = true;
		try {
			Users newUser = userForm;
			java.sql.Date date = new java.sql.Date(new Date().getTime());
			userForm.setReg_time(date);
			userForm.setModify_time(date);
			// 角色ID集合
			String roles = userForm.getRoleids();
			List<String> roleIds = null;
			if (null != roles && roles.length() > 0) {
				roleIds = new ArrayList<String>();
				String[] roleArray = roles.split("\\:");
				if (null != roleArray && roleArray.length > 0) {
					for (String s : roleArray) {
						roleIds.add(s);
					}
				}
			}
			newUser.setUser_id(MyHelp.getUUID());
			this.usersService.createUser(newUser, roleIds);
		} catch (Exception e) {
			jsonStatus = false;
			map.put("error", e.getMessage());
			e.printStackTrace();
		}
		map.put("result", jsonStatus);
		MyHelp.ajaxResponseJson(response, JsonUtil.mapToJson(map));

	}

	/**
	 * 用户删操作 jquery easyui datagrid ?id=xxx or ?id=xxx:yyy:zzz
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/system/userDel.html")
	public void userDel(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Boolean jsonStatus = true;
		try {
			String id = request.getParameter("id");
			System.out.println("delete id:" + id);
			if (null != id && id.contains(":")) {
				// String[] ids=id.split("\\:");
				// this.usersService.batchDelete("userId",ids);
			} else {
				this.usersService.deleteUser(id);
			}
		} catch (Exception e) {
			jsonStatus = false;
			map.put("error", e.getMessage());
			e.printStackTrace();
		}
		map.put("result", jsonStatus);
		MyHelp.ajaxResponseJson(response, JsonUtil.mapToJson(map));

	}

	/**
	 * 功能资源修改操作 jquery easyui datagrid ?id=xxx
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/system/userEdi.html")
	public void userEdi(Users userForm, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Boolean jsonStatus = true;
		try {
			String id = request.getParameter("id");
			Users user = this.usersService.findUser(id);
			String lastVisit = user.getLast_visit();
			BeanUtil.copyProperties(user, userForm);
			user.setUser_id(id);
			user.setShow_order(userForm.getShow_order());
			user.setModify_time(new java.sql.Date(new Date().getTime()));
			user.setLast_visit(lastVisit);
			// 资源ID集合
			String roles = userForm.getRoleids();
			List<String> roleIds = null;
			if (null != roles && roles.length() > 0) {
				roleIds = new ArrayList<String>();
				String[] roleArray = roles.split("\\:");
				if (null != roleArray && roleArray.length > 0) {
					for (String s : roleArray) {
						roleIds.add(s);
					}
				}
			}
			this.usersService.updateUser(user, roleIds);
		} catch (Exception e) {
			jsonStatus = false;
			map.put("error", e.getMessage());
			e.printStackTrace();
		}
		map.put("result", jsonStatus);
		MyHelp.ajaxResponseJson(response, JsonUtil.mapToJson(map));

	}

	/**
	 * 据用户 取得所有角色列表(属于用的Selected=true)
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/system/findRoleList.html")
	public void findRoleResourceList(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		// 总角色集
		List<Roles> roles = this.rolesService.getAll();
		// 据角色设选中的角色
		String userId = request.getParameter("userId");
		if (null != userId) {
			Users user = this.usersService.findUser(userId);
			List<Roles> selectRoles = user.getRoles();
			List<String> rIdList = null;
			if (null != selectRoles && selectRoles.size() > 0) {
				// 已有的角色ID集
				rIdList = new ArrayList<String>();
				for (Roles r : selectRoles) {
					rIdList.add(r.getRole_id().toString());
				}
				// 比较功能ID集 对有的设为选中
				if (null != roles && roles.size() > 0) {
					for (Roles rr : roles) {
						if (rIdList.contains(rr.getRole_id().toString())) {
							rr.setSelected(true);
						}
					}
				}
			}
		}
		// 生成JSON数据
		Map map = new HashMap();
		try {
			JSONArray jsonArray = new JSONArray();
			if (null != roles && roles.size() > 0) {
				for (Roles r : roles) {
					JSONObject jobj = new JSONObject();
					jobj.put("roleId", r.getRole_id());
					jobj.put("roleName", r.getRole_name());
					jobj.put("isSelected", r.getSelected());
					jsonArray.add(jobj);
				}
			}
			map.put("roleList", jsonArray);
			map.put("isSuccess", true);
		} catch (Exception e) {
			map.put("isSuccess", false);
			map.put("error", e.getMessage());
			e.printStackTrace();
		}
		MyHelp.ajaxResponseJson(response, JsonUtil.mapToJson(map));

	}

	/**
	 * 每个用户的功能菜单树
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/system/findFunctionsTree.html")
	public void findFunctionsTree(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		Users cuser = (Users) request.getSession().getAttribute(SysConstants.SESSION_USER);
		Users user = this.usersService.findUser(cuser.getUser_id());
		List<Functions> mfList = new ArrayList<Functions>();
		if (null != user) {
			List<Roles> rSet = user.getRoles();
			List<Functions> fSet = new ArrayList<Functions>();
			for (Roles r : rSet) {
				fSet.addAll(r.getFunctions());
			}
			for (Functions f : fSet) {
				if (!SysConstants.FUNCTION_TYPE_RESOURCE.equals(f.getFunction_type())) {
					mfList.add(f);
				}
			}
		}

		List<MenuTreeNode> menus = MenuTreeNode.installMenuTree("" + Functions.ROOT_FUNCTIONS_ID,
				mfList);
		String data = JsonUtil.listToJson(menus);

		MyHelp.ajaxResponseJson(response, data);

	}

	public static void main(String[] args) {
		// Create a JSONObject from scratch
		JSONObject object1 = new JSONObject();
		object1.element("name", "张三");
		object1.element("age", 24);
		object1.element("gendar", true);

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(object1);
		System.out.println(jsonArray.get(0).toString());
	}

}
