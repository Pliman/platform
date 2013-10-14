package net.intellizone.coupon.system.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;


@Table("iz_role_function") 
public class RoleFunction {

	@Column
	@Name
	private String role_function_id; //唯一标识
	@Column
	private String role_id;
	@Column
	private String function_id;
	public String getRole_function_id() {
		return role_function_id;
	}
	public void setRole_function_id(String roleFunctionId) {
		role_function_id = roleFunctionId;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String roleId) {
		role_id = roleId;
	}
	public String getFunction_id() {
		return function_id;
	}
	public void setFunction_id(String functionId) {
		function_id = functionId;
	}
}
