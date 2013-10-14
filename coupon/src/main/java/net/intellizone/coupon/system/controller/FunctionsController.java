package net.intellizone.coupon.system.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.system.model.Functions;
import net.intellizone.coupon.system.service.FunctionsService;
import net.intellizone.coupon.system.util.BeanUtil;
import net.intellizone.coupon.system.util.JsonUtil;
import net.intellizone.coupon.system.util.MenuTreeNode;
import net.intellizone.coupon.system.util.MyHelp;

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
public class FunctionsController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5938554320114191287L;
	
	@Resource
	private FunctionsService functionsService;

	/**
	 * 所有父级菜单树 功能资源定义时供父级选择
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/system/findParentMenusTree.html")
	public void findParentMenusTree(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception{
		List<Functions> functions=this.functionsService.findAllParentMenus();
		//添加一个最顶层的默认的根父级 以便前台在定义功能时可选根目录
		if(null==functions){
			functions=new ArrayList<Functions>();
		}
		functions.add(Functions.getRoot());
		List<MenuTreeNode> menus=MenuTreeNode.installMenuTree(Functions.ROOT_FUNCTIONS_PARENT_ID,functions);
		if(null!=menus){
			for(MenuTreeNode node:menus){
				MenuTreeNode.setLeafNodeState(node);
			}
		}
		String data=JsonUtil.listToJson(menus);
		
		MyHelp.ajaxResponseJson(response,data);
		
	}
	
	/**
	 * 到功能资源管理主页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/system/to_function.html")
	public String toUserPage(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception{
		System.out.println("---/system/to_function.html");
		return "admin/system/to_function";
	}
	
	/**
	 * 功能资源查操作
	 *jquery easyui datagrid
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/system/functionLis.html")
	public void functionLis(Functions functionForm,HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception {

			String page = request.getParameter("page");// 当前页
			String rows = request.getParameter("rows");// 每页显示记录数	
			int pageSize = (null == rows ? 10 : Integer.valueOf(rows));
			int currentPage = Integer.valueOf(page.toString());
			String order = request.getParameter("order");
			String sort = request.getParameter("sort");
			
			 //查询条件,顺序
			
			
			
			Cnd c=Cnd.where("1","=",1);
			String function_code=request.getParameter("function_code");
			String function_name=request.getParameter("function_name");
			if(null!=function_code&&!function_code.equals("")){
				c.and("function_code","like","%"+function_code+"%");
			}
			if(null!=function_name&&!function_name.equals("")){
				c.and("function_name","like","%"+function_name+"%");
			}
			
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
		    QueryResult qr=this.functionsService.getPagination(c, currentPage, pageSize);
		    String s=MyHelp.getDatagridJSON(qr,Functions.class,null);
			
		    //System.out.println(s);
			
			MyHelp.ajaxResponseJson(response, s);
		
	}
	/**
	 * 功能资源增操作
	 *jquery easyui datagrid
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/system/functionAdd.html")
	public void functionAdd(Functions functionForm,HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception {
			Map<String,Object> map=new HashMap<String,Object>();
			Boolean jsonStatus= true;
			try{
				Functions newFun=functionForm;
				newFun.setFunction_id(MyHelp.getUUID());
				this.functionsService.save(newFun);	
			}catch(Exception e){
				jsonStatus=false;
				map.put("error", e.getMessage());
				e.printStackTrace();
			}
			map.put("result", jsonStatus);
			MyHelp.ajaxResponseJson(response, JsonUtil.mapToJson(map));

	}
	/**
	 * 功能资源删操作
	 *jquery easyui datagrid
	 *?id=xxx  or ?id=xxx:yyy:zzz
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/system/functionDel.html")
	public void functionDel(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception {
			Map<String,Object> map=new HashMap<String,Object>();
			Boolean jsonStatus= true;
			try{
				String id=request.getParameter("id");
				if(null!=id&&id.contains(":")){
					String[] ids=id.split("\\:");
					//this.functionsService.batchDelete("functionId",ids);
				}else{
					this.functionsService.deleteFunction(id);
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
	 * 功能资源修改操作
	 *jquery easyui datagrid
	 *?id=xxx
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/system/functionEdi.html")
	public void functionEdi(Functions functionForm,HttpServletRequest request,HttpServletResponse response, ModelMap model) throws Exception {
			Map<String,Object> map=new HashMap<String,Object>();
			Boolean jsonStatus= true;
			try{
				String id=request.getParameter("id");
				Functions func=this.functionsService.findFunction(id);
				BeanUtil.copyProperties(func, functionForm);
				func.setFunction_id(id);
				this.functionsService.updateFunction(func);
			}catch(Exception e){
				jsonStatus=false;
				map.put("error", e.getMessage());
				e.printStackTrace();
			}
			map.put("result", jsonStatus);
			MyHelp.ajaxResponseJson(response, JsonUtil.mapToJson(map));

	}

}
