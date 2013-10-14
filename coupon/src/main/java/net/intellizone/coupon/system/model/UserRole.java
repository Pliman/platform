package net.intellizone.coupon.system.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * 用户表
 * @author： ljt 
 * @modify: 
 * @主要功能：
 * @see 
 * @version 1.0
 */ 
@Table("iz_user_user_role")
public class UserRole {
	@Column
	@Name
	private String use_user_role_id; //唯一标识
	@Column
	private String user_id;
	@Column
	private String user_role_id;
	public String getUse_user_role_id() {
		return use_user_role_id;
	}
	public void setUse_user_role_id(String useUserRoleId) {
		use_user_role_id = useUserRoleId;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}
	public String getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(String userRoleId) {
		user_role_id = userRoleId;
	}
}
