package net.intellizone.coupon.system.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.system.model.Users;

import org.nutz.dao.QueryResult;


public class MyHelp {
	/**
	 * 生成唯一标识主键
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	/**
	 * jquery easyui datagrid json
	 * @param pager 分页对象
	 * @param jqgridColumns 对应的实体id属性名及要显示的其它属性名
	 * @return
	 * @throws Exception
	 */
	public static String getDatagridJSON(QueryResult pager,Class obj,String[] filters) throws Exception {
		Field[] fs=obj.getDeclaredFields();
		List<String> jqgridColumns=null;
		if(null!=fs&&fs.length>0){
			jqgridColumns=new ArrayList<String>();
			boolean isFilter=false;
			for(Field f:fs){
				if(null!=filters){
					for(String s:filters){
						if(s.equals(f.getName())){
							isFilter=true;
							break;
						}
					}
				}
				if(!isFilter){
					jqgridColumns.add(f.getName());
				}
				isFilter=false;
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{\"total\":").append(pager.getPager().getRecordCount()).append(",\"rows\":[");  
		List list=pager.getList();
		if(null!=list&&list.size()>0) {
			for(Object model : list) {
				sb.append("{");
				for(String column : jqgridColumns) {
					sb.append("\"").append(column).append("\":");
					sb.append("\"").append(BeanUtil.getPropertyValue(model,column)).append("\"").append(",");
				}
				if(sb.charAt(sb.length()-1)==',')sb.deleteCharAt(sb.length()-1);
				sb.append("},");
			}
		}
		if(sb.charAt(sb.length()-1)==',')sb.deleteCharAt(sb.length()-1);
		sb.append("]}");
		return sb.toString();
	}
	
	
	/**
	 * 页面地下响应请求 将数据输出到页面
	 * @param response
	 * @param contentType  text/plain 或 text/html 或 text/xml 或 application/json
	 * @param content 响应结果数据
	 */
	private static void ajaxResponse(HttpServletResponse response,final String contentType, final String content){
		response.setContentType(contentType + ";charset=UTF-8");
		response.addHeader("Cache-Control", "no-store, no-cache, must-revalidate");   
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
		response.setHeader("Pragma", "No-cache");				
		response.setDateHeader("Expires", 0);	
		try {
			response.getWriter().write(content);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 异步响应为text文本
	 * @param response
	 * @param content
	 */
	public static void ajaxResponseText(HttpServletResponse response,final String content){
		ajaxResponse(response, "text/plain", content);
	}
	

	/**
	 * 异步响应为html  如 要运行javascript  可封装到该html
	 * @param response
	 * @param content
	 */
	public static void ajaxResponseHtml(HttpServletResponse response,final String content){
		ajaxResponse(response, "text/html", content);
	}
	

	/**
	 * 异步响应为xml文本
	 * @param response
	 * @param content
	 */
	public static void ajaxResponseXml(HttpServletResponse response,final String content){
		ajaxResponse(response, "text/xml", content);
	}
	

	/**
	 * 异步响应为JSON  返回为JSON 对象 可供js解释
	 * @param response
	 * @param content
	 */
	public static void ajaxResponseJson(HttpServletResponse response,final String content){
		ajaxResponse(response, "application/json", content);
	}
}
