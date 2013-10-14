package net.intellizone.coupon.system.model;

import java.io.Serializable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

/**
 * 用户表
 * @author： ljt 
 * @modify: 
 * @主要功能：
 * @see 
 * @version 1.0
 */ 
@Table("iz_admin")  
public class Users implements Serializable{
	/**用户级别(会员:P，商户:B,管理人员:M)**/
	public static final String TYPE_P="P";
	public static final String TYPE_B="B";
	public static final String TYPE_M="M";
	@Column
	@Name
	private String user_id;
	@Column
	private String user_name;
	@Column
	private String password;
	@Column
	private String nick_name;
	@Column
	private Boolean sex;
	@Column
	private String email;
	@Column
	private String mobile;
	@Column
	private String tel;
	@Column
	private String address_id;
	@Column
	private Date reg_time;
	@Column
	private Date modify_time;
	@Column
	private String last_visit;
	@Column
	private Boolean sysflag=false;
	
	@ManyMany(target = Roles.class, relation = "iz_user_user_role", from = "user_id", to = "user_role_id")
	private List<Roles> roles = new ArrayList<Roles>();

	@Column
	private String user_type;
	@Column
	private Integer show_order;
	@Column
	private Boolean disabled=false;
	

	/**角色ID集合　id1:id2:id3*/
	private String roleids;
	
	
	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String userType) {
		user_type = userType;
	}

	public Integer getShow_order() {
		return show_order;
	}

	public void setShow_order(Integer showOrder) {
		show_order = showOrder;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getRoleids() {
		return roleids;
	}

	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nickName) {
		nick_name = nickName;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String addressId) {
		address_id = addressId;
	}

	public Date getReg_time() {
		return reg_time;
	}

	public void setReg_time(Date regTime) {
		reg_time = regTime;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modifyTime) {
		modify_time = modifyTime;
	}

	public String getLast_visit() {
		return last_visit;
	}

	public void setLast_visit(String lastVisit) {
		last_visit = lastVisit;
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

	

}
