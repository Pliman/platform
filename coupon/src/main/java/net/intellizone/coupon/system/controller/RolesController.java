package net.intellizone.coupon.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.system.model.Functions;
import net.intellizone.coupon.system.model.Roles;
import net.intellizone.coupon.system.model.Users;
import net.intellizone.coupon.system.service.FunctionsService;
import net.intellizone.coupon.system.service.RolesService;
import net.intellizone.coupon.system.service.UsersService;
import net.intellizone.coupon.system.util.BeanUtil;
import net.intellizone.coupon.system.util.JsonUtil;
import net.intellizone.coupon.system.util.MyHelp;
import net.intellizone.coupon.system.util.SelectTreeNode;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class RolesController{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7431766724199851659L;
	@Resource
	private RolesService rolesService;
	
	@Resource
	private FunctionsService functionsService;
	
	@Resource
	private UsersService usersService;
	
	/***
	 * 据角色 取得所有资源树
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/system/findRoleResourceList.html")
	public void findRoleResourceList(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception{
		//总功能资源集
		List<Functions> functions=this.functionsService.getAll();	
		//据角色设选中的资源
		String roleId=request.getParameter("roleId");
		if(null!=roleId){
			List<Functions> selectFuncs=this.rolesService.findFunctionsByRoleId(roleId);
			List<String> fIdList=null;
			if(null!=selectFuncs&&selectFuncs.size()>0){
				//已有的功能ID集
				fIdList=new ArrayList<String>();
				for(Functions f:selectFuncs){
					fIdList.add(""+f.getFunction_id());
				}
				//比较功能ID集　对有的设为选中
				if(null!=functions&&functions.size()>0){
					for(Functions ff:functions){
						if(fIdList.contains(""+ff.getFunction_id())){
							ff.setSelected(true);
						}
					}
				}
			}
		}
		//生成节点树
		List<SelectTreeNode> menus=SelectTreeNode.installSelectTree(""+Functions.ROOT_FUNCTIONS_ID,functions);	
		String s=JsonUtil.listToJson(menus);
		System.out.println(s);
		MyHelp.ajaxResponseJson(response,s);
		
	}
	
	/**
	 * 到角色管理主页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/system/to_role.html")
	public String toUserPage(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception{
		System.out.println("---/system/to_role.html");
		return "admin/system/to_role";
	}
	/**
	 * 角色查操作
	 *jquery easyui datagrid
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/system/roleLis.html")
	public void roleLis(Roles roleForm,HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception {
		String page = request.getParameter("page");// 当前页
		String rows = request.getParameter("rows");// 每页显示记录数	
		int pageSize = (null == rows ? 10 : Integer.valueOf(rows));
		int currentPage = Integer.valueOf(page.toString());
		String order = request.getParameter("order");
		String sort = request.getParameter("sort");
		
		 //查询条件,顺序
		Cnd c=Cnd.where("1","=",1);
	    if(null!=order){
	    	if(order.equals("asc")){
	    		c.asc(sort);
	    	}else{
	    		c.desc(sort);
	    	}
	    }else{
	    	 //默认顺序
		    c.asc("show_order");
	    }
	    QueryResult qr=this.rolesService.getPagination(c, currentPage, pageSize);
	    String s=MyHelp.getDatagridJSON(qr,Roles.class,null);
		
	    System.out.println(s);
		
		MyHelp.ajaxResponseJson(response, s);
		
	}
	/**
	 * 角色增操作
	 *jquery easyui datagrid
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/system/roleAdd.html")
	public void roleAdd(Roles roleForm,HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception {
			Map<String,Object> map=new HashMap<String,Object>();
			Boolean jsonStatus= true;
			try{
				Roles newRole=roleForm;
				//资源ID集合
				String resources=roleForm.getResources();
				List<String> functionIds=null;
				if(null!=resources&&resources.length()>0){
					functionIds=new ArrayList<String>();
					String[] resourceArray=resources.split("\\:");
					if(null!=resourceArray&&resourceArray.length>0){
						for(String s:resourceArray){
							functionIds.add(s);
						}
					}
				}
				newRole.setRole_id(MyHelp.getUUID());
				this.rolesService.createRole(newRole, functionIds);
			}catch(Exception e){
				jsonStatus=false;
				map.put("error", e.getMessage());
				e.printStackTrace();
			}
			map.put("result", jsonStatus);
			MyHelp.ajaxResponseJson(response, JsonUtil.mapToJson(map));

	}
	/**
	 * 角色删操作
	 *jquery easyui datagrid
	 *?id=xxx  or ?id=xxx:yyy:zzz
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/system/roleDel.html")
	public void roleDel(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception {
			Map<String,Object> map=new HashMap<String,Object>();
			Boolean jsonStatus= true;
			try{
				String id=request.getParameter("id");
				if(null!=id&&id.contains(":")){
					String[] ids=id.split("\\:");
					//this.rolesService.batchDelete("roleId",ids);
				}else{
					this.rolesService.deleteRole(id);
				}	
			}catch(Exception e){
				jsonStatus=false;
				map.put("error", e.getMessage());
				e.printStackTrace();
			}
			map.put("result", jsonStatus);
			MyHelp.ajaxResponseJson(response, JsonUtil.mapToJson(map));

	}
	/**
	 * 角色修改操作
	 *jquery easyui datagrid
	 *?id=xxx
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/system/roleEdi.html")
	public void roleEdi(Roles roleForm,HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception {
			Map<String,Object> map=new HashMap<String,Object>();
			Boolean jsonStatus= true;
			try{
				String id=request.getParameter("id");  //获取角色roles_id
				Roles role=this.rolesService.findRole(id); //根据ID查询信息
				BeanUtil.copyProperties(role, roleForm);
				role.setRole_id(id);
				//资源ID集合
				String resources=roleForm.getResources(); //得到资源列表,即获得当前用户所编辑使用的功能权限
				List<String> functionIds=null;
				if(null!=resources&&resources.length()>0){
					functionIds=new ArrayList<String>();
					String[] resourceArray=resources.split("\\:");//将资源列表字符串以：为分隔符，分割字符串
					if(null!=resourceArray&&resourceArray.length>0){
						for(String s:resourceArray){
							functionIds.add(s);  //将分割的字符串放入集合
						}
					}
				}
				this.rolesService.updateRole(role, functionIds); //更新用户功能权限
			}catch(Exception e){
				jsonStatus=false;
				map.put("error", e.getMessage());
				e.printStackTrace();
			}
			map.put("result", jsonStatus);
			MyHelp.ajaxResponseJson(response, JsonUtil.mapToJson(map));

	}
	
	/**
	 * 角色包含用户查操作
	 *jquery easyui datagrid
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/system/roleUserLis.html")
	public void roleUserLis(Roles roleForm,HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception {
//		String page = request.getParameter("page");// 当前页
//		String rows = request.getParameter("rows");// 每页显示记录数	
//		int pageSize = (null == rows ? 10 : Integer.valueOf(rows));
//		int currentPage = Integer.valueOf(page.toString());
//		String order = request.getParameter("order");
//		String sort = request.getParameter("sort");
//		
//		 //查询条件,顺序
//		String roleIds=request.getParameter("roleIds");
//		String sqlCase="exists(select * from iz_user_user_role t where t.user_id=user_id and user_role_id in ("+roleIds+") )";
//		String sqlOrder=" order by "+sort+" "+order;
//		
//		Condition con=Cnd.wrap(sqlCase+sqlOrder);
//		
//	    QueryResult qr=this.usersService.getPagination(con, currentPage, pageSize);
//	    String s=MyHelp.getDatagridJSON(qr,Users.class,null);
//		
//	    System.out.println(s);
//		
//		MyHelp.ajaxResponseJson(response, s);
		
	}

}
