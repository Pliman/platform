package net.intellizone.coupon.system.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.system.common.SysConstants;
import net.intellizone.coupon.system.model.Functions;
import net.intellizone.coupon.system.model.Roles;
import net.intellizone.coupon.system.model.Users;
import net.intellizone.coupon.system.util.DESUtil;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	// nutz dao
	private Dao dao;
	
	// 初始化数据源
	public UsersService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	public int createUser(Users user, List<String> roleIds) throws Exception {
		Users u=this.findUserByName(user.getUser_name());
		if(null!=u)
			return SysConstants.NAME_EXIST;
		//写角色表
		this.addUserRoleSet(user, roleIds);
		user.setPassword(DESUtil.encrypt(user.getPassword()));
		//this.save(user);
		this.dao.insert(user);
		this.dao.insertRelation(user,"roles");
		return SysConstants.EXCUTE_OK;
		
	}

	public int deleteUser(String userId) throws Exception {
		Users u=this.dao.fetch(Users.class, userId);//this.get(userId);
		if(null==u)
			return SysConstants.USER_NOT_EXIST;
		this.dao.delete(Users.class,userId);
		this.dao.clearLinks(u, "roles");
		return SysConstants.EXCUTE_OK;
		
	}

	public Users findUser(String userId) throws Exception {
		Users user =this.dao.fetch(Users.class, userId);// this.get(userId);
		dao.fetchLinks(user, "roles");
		return user;
		
	}

	public Users findUserByName(String username) throws Exception {
		Users u=null;//this.findUniqueByProperty("username", username);
		List<Users> userList = dao.query(Users.class, Cnd.where("user_name", "=",username), null);
		if(null!=userList&&userList.size()>0){
			u=userList.get(0);
			dao.fetchLinks(u, "roles");
		}
		return u;
		
	}

	
	public UserManagerResult login(String username, String password) throws Exception {
		int statusCode=SysConstants.EXCUTE_OK;
		Users user=this.findUserByName(username);
		//用户验证
		if(null==user){
			statusCode=SysConstants.INVALID_USER;
		}else{
			if(user.getDisabled()){
				statusCode=SysConstants.USER_LOCKED;
			}else{
				if(!user.getPassword().equals(DESUtil.encrypt(password))){
					statusCode=SysConstants.INVALID_PASSWORD;
				}
			}
		}
		//准备返回结果对象
		UserManagerResult managerResult = new UserManagerResult();
		managerResult.setStatusCode(statusCode);
		//验证不通过立即返回
		if(statusCode!=SysConstants.EXCUTE_OK){	
			return managerResult;
		}
		//验证通过
		//更新用户最后登录时间及状态
		user.setLast_visit(new Date().toString());
		
		this.dao.update(user);
		//获取当前用户信息
		List<String> resourceList=null;
		//取得当前用户的所有角色下的资源集
		List<Roles> roles=user.getRoles();
		if(null!=roles){
				resourceList=new ArrayList<String>();
				Set<Functions> fSet=new HashSet<Functions>();
				for(Roles r:roles){
					this.dao.fetchLinks(r, "functions");
					fSet.addAll(r.getFunctions());
				}
				for(Functions f:fSet){
						resourceList.add(f.getUrl());
				}
		}
		//装配用户信息并返回
		managerResult.setResourceList(resourceList);
		managerResult.setUser(user);
		return managerResult;
		
	}

	public void logout(String userId) throws Exception {
//		Users u=this.findUser(userId);
//		if (null!=u){
//			u.setOnline(false);
//			this.merge(u);
//		}	
	}

	public int modifyPassword(String userId, String oldPassword, String newPassword) throws Exception {
		Users u=this.findUser(userId);
		if(null==u)
			return SysConstants.USER_NOT_EXIST;
		if (!u.getPassword().equals(DESUtil.encrypt(oldPassword))) {
			return SysConstants.INVALID_PASSWORD;
		}else{
			u.setPassword(DESUtil.encrypt(newPassword));
			u.setModify_time(new java.sql.Date(new Date().getTime()));
			this.dao.update(u);
		}
		return SysConstants.EXCUTE_OK;
		
	}

	public int resetPassword(String userId, String newPassword) throws Exception {
		Users u=this.findUser(userId);
		if(null!=u){
			u.setPassword(DESUtil.encrypt(newPassword));
			this.dao.update(u);
		}
		return SysConstants.EXCUTE_OK;
		
	}

	public int updateUser(Users user, List<String> roleIds) throws Exception {
		Users u = this.findUserByName(user.getUser_name());
		if (u != null && !u.getUser_id().equals(user.getUser_id()))
			return SysConstants.USER_NOT_EXIST;
		if(null!=roleIds)
			this.addUserRoleSet(user, roleIds);
		user.setPassword(DESUtil.encrypt(user.getPassword()));
		this.dao.update(user);
		
		//先清除关联表　再重新插入关联表
		this.dao.clearLinks(u, "roles");
		this.dao.insertRelation(user,"roles");
		return SysConstants.EXCUTE_OK;
		
	}

	private void addUserRoleSet(Users user, List<String> roleIds) throws Exception {
		List<Roles> userRoleSet = user.getRoles();
		userRoleSet.clear();
		if (roleIds != null) {
			for (String roleId : roleIds) {
				Roles role = this.dao.fetch(Roles.class, roleId);
				userRoleSet.add(role);
			}
		}
		user.setRoles(userRoleSet);
	}
	
	public QueryResult getPagination(Condition c, int pageNumber, int pageSize) {
		List<Users> list = null;
		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Users.class, c, pager);
		if (list == null) {
			return null;
		}
		// 循环设置关联表信息  
        for (Users u : list) {  
            dao.fetchLinks(u, "roles");  
            try {
				u.setPassword(DESUtil.decrypt(u.getPassword()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }  
		
		pager.setRecordCount(dao.count(Users.class));
		
		return new QueryResult(list, pager);
	}
	
}
