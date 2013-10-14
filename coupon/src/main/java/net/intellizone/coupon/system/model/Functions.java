package net.intellizone.coupon.system.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;



/**
 * 
 * @author： ljt 
 * @modify: 
 * @主要功能：
 * @see 
 * @version 1.0
 */ 
@Table("iz_sys_functions")  
public class Functions implements Serializable {
	/**默认的最顶级根节点父ID 该节点不存放在后台数据库*/
	public static final String ROOT_FUNCTIONS_PARENT_ID="ROOT_PARENT";
	public static final String ROOT_FUNCTIONS_ID="ROOT";
	public static final String FUNCTION_TYPE_FOLDER="FOLDER";
	public static final String FUNCTION_TYPE_MENU="MENU";
	public static final String FUNCTION_TYPE_RESOURCE="RESOURCE";
	public static Functions rootFunction;
	
	@Column
	@Name
	private String function_id;
	
	@Column
	private String function_name;
	
	@Column
	private String function_desc;
	
	@Column
	private Boolean sysflag;

	@ManyMany(target = Roles.class, relation = "iz_role_function", from = "function_id", to = "role_id")
	private List<Roles> roles=new ArrayList<Roles>();

	@Column
	private Integer show_order;
	
	@Column
	private String parent_id;
	
	private String parent_name;
	
	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parentName) {
		parent_name = parentName;
	}

	/**功能类型 FOLDER MENU RESOURCE*/
	@Column
	private String function_type;
	
	/**功能代码*/
	@Column
	private String function_code;
	
	/**功能资源URL 程序中请求URL格式必需为: /功能路径/操作.html 如/system/user/userDel.html*/
	@Column
	private String url;
	
	private Boolean selected=false;
	
	public Integer getShow_order() {
		return show_order;
	}

	public void setShow_order(Integer showOrder) {
		show_order = showOrder;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parentId) {
		parent_id = parentId;
	}

	public String getFunction_type() {
		return function_type;
	}

	public void setFunction_type(String functionType) {
		function_type = functionType;
	}

	public String getFunction_code() {
		return function_code;
	}

	public void setFunction_code(String functionCode) {
		function_code = functionCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
	public Functions(){

	}
	public Functions(String parent_id,String function_id,String function_name,String function_type,String url){
		this.parent_id=parent_id;
		this.function_id=function_id;
		this.function_name=function_name;
		this.function_type=function_type;
		this.url=url;
	}
	
	public static Functions getRoot(){
		if(null==rootFunction){
			rootFunction=new Functions();
			rootFunction.setParent_id(ROOT_FUNCTIONS_PARENT_ID);
			rootFunction.setFunction_id(ROOT_FUNCTIONS_ID);
			rootFunction.setFunction_code(""+ROOT_FUNCTIONS_ID);
			rootFunction.setFunction_name(""+ROOT_FUNCTIONS_ID);
			rootFunction.setFunction_type(FUNCTION_TYPE_FOLDER);
		}		
		return rootFunction;
	}

	public String getFunction_id() {
		return function_id;
	}

	public void setFunction_id(String functionId) {
		function_id = functionId;
	}

	public String getFunction_name() {
		return function_name;
	}

	public void setFunction_name(String functionName) {
		function_name = functionName;
	}

	public String getFunction_desc() {
		return function_desc;
	}

	public void setFunction_desc(String functionDesc) {
		function_desc = functionDesc;
	}

	public Boolean getSysflag() {
		return sysflag;
	}

	public void setSysflag(Boolean sysflag) {
		this.sysflag = sysflag;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	
	
	
}
