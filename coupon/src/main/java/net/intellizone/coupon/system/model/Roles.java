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
@Table("iz_user_roles")  
public class Roles implements Serializable{

	@Column
	@Name
	private String role_id;
	@Column
	private String role_name;
	@Column
	private String role_desc;
	@Column
	private Boolean sysflag;
		
	@ManyMany(target = Functions.class, relation = "iz_role_function", from = "role_id", to = "function_id")
	private List<Functions> functions=new ArrayList<Functions>();
	
	@ManyMany(target = Users.class, relation = "iz_user_user_role", from = "role_id", to = "user_id")
	private List<Users> users= new ArrayList<Users>();
	
	@Column
	private Integer show_order;
	/**资源列表  id1:id2:id3*/
	private String resources;
	public Integer getShow_order() {
		return show_order;
	}

	public void setShow_order(Integer showOrder) {
		show_order = showOrder;
	}

	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	private Boolean selected=false;

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String roleId) {
		role_id = roleId;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String roleDesc) {
		role_desc = roleDesc;
	}

	public Boolean getSysflag() {
		return sysflag;
	}

	public void setSysflag(Boolean sysflag) {
		this.sysflag = sysflag;
	}

	public List<Functions> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Functions> functions) {
		this.functions = functions;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	
	
}
