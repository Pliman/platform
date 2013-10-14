package net.intellizone.coupon.system.service;

import java.util.List;

import net.intellizone.coupon.system.model.Users;



/**
 * 
 * @author： ljt 
 * @modify: 
 * @主要功能：
 * @see 
 * @version 1.0
 */
public class UserManagerResult {
	/**用户登录结果状态码*/
	private int statusCode;
	
	/**用户实体*/
	private Users user;
	
	/**可用权限功能资源列表 内容类似 /msg/add.html 的请求头*/
	private List<String> resourceList;

	public List<String> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<String> resourceList) {
		this.resourceList = resourceList;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
