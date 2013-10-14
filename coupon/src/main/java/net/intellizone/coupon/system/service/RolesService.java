package net.intellizone.coupon.system.service;

import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import net.intellizone.coupon.system.common.SysConstants;
import net.intellizone.coupon.system.model.Functions;

import net.intellizone.coupon.system.model.Roles;
import net.intellizone.coupon.system.model.Users;

import net.intellizone.db.MysqlDataSourceManager;


import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

@Service
public class RolesService {
	// nutz dao
	private Dao dao;
	

	// 初始化数据源
	public RolesService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	//添加用户到角色中
	public int addUserToRole(List<String> roleIds,List<String> userIds) throws Exception{
		if(null!=userIds&&userIds.size()>0){
			if(null!=roleIds){
				for(String roleId:roleIds){
					Roles r=this.findRole(roleId);
					this.dao.fetchLinks(r, "users");
					List<Users> r_users=r.getUsers();
					if(r_users.size()==0){//如果角色没有用户
						for(String userId:userIds){
							r_users.add(this.dao.fetch(Users.class, userId));
						}
						r.setUsers(r_users);
						this.dao.insertRelation(r,"users");//插入关联表
					}else{
						//如果没加则加入 
						for(Users ru:r_users){//过滤已存在的
							if(userIds.contains(ru.getUser_id())){
								userIds.remove(ru.getUser_id());
							}
						}
						//剩下未加入的　则加入
						List<Users> new_r_users=new ArrayList<Users>();
						for(String userId:userIds){
							new_r_users.add(this.dao.fetch(Users.class, userId));
						}
						r.setUsers(new_r_users);
						this.dao.insertRelation(r,"users");//插入关联表
					}
				}
			}
		}
		
		return SysConstants.EXCUTE_OK;
	}
	
	//从角色中移除用户
	public int removeUserFromRole(List<String> roleIds,List<String> userIds) throws Exception{
		if(null!=userIds&&userIds.size()>0){
			if(null!=roleIds){
				for(String roleId:roleIds){
					Roles r=this.findRole(roleId);
					this.dao.fetchLinks(r, "users");
					List<Users> r_users=r.getUsers();
					List<Users> remove_r_users=new ArrayList<Users>();
					for(Users ru:r_users){//从角色中收集存在的需要移除的用户
						if(userIds.contains(ru.getUser_id())){
							userIds.remove(ru.getUser_id());
							remove_r_users.add(ru);
						}
					}
					if(remove_r_users.size()>0){
						r.setUsers(remove_r_users);
						this.dao.clearLinks(r,"users");//从关联表清除
					}
				}
			}
		}
		
		return SysConstants.EXCUTE_OK;
	}
	
	
	public int createRole(Roles role, List<String> functionIds) throws Exception {
		Roles r=this.findRoleByName(role.getRole_name());
		if(null!=r)
			return SysConstants.NAME_EXIST;
		this.addRoleFunctionSet(role, functionIds);
		this.dao.insert(role);
		this.dao.insertRelation(role, "functions");
		return SysConstants.EXCUTE_OK;
		
	}

	public void deleteRole(String roleId) throws Exception {
		Roles r=this.dao.fetch(Roles.class, roleId);//this.get(userId);
		this.dao.delete(Roles.class,roleId);
		this.dao.clearLinks(r, "functions");
	}

	public Roles findRole(String roleId) throws Exception {
		Roles r=this.dao.fetch(Roles.class, roleId);
		this.dao.fetchLinks(r, "functions");
		return r;
		
	}

	/**
	 * 修改角色功能权限
	 * */
	public int updateRole(Roles role, List<String> functionIds) throws Exception {
		Roles r=this.findRoleByName(role.getRole_name());  //根据用户名查询
		if(null!=r&&!r.getRole_id().equals(role.getRole_id())) //如果信息不为空，并且查询出来的ID与传过来的对象ID不相等,则返回-1
			return SysConstants.NAME_EXIST;   //系统模块公共状态吗 -1：失败   0成功
		this.addRoleFunctionSet(role, functionIds); //将原有功能权限先清除，然后根据功能ID将新功能权限赋值给用户 
		this.dao.update(role);//更新
		
		//先清除关联表　再重新插入关联表
		this.dao.clearLinks(r, "functions");
		this.dao.insertRelation(role,"functions");
		
		return SysConstants.EXCUTE_OK;//返回1 : 成功编辑
		
	}

	private void addRoleFunctionSet(Roles role, List<String> functionIds) throws Exception {
		List<Functions> roleFunctionSet = role.getFunctions(); //得到功能点ID
		roleFunctionSet.clear();//将当前用户功能权限清除
		if (functionIds != null) {
			for (String functionId : functionIds) {
				Functions function = this.dao.fetch(Functions.class, functionId);//根据功能ID查询功能,
				roleFunctionSet.add(function); //将新赋值的权限放入集合
			}
		}
		role.setFunctions(roleFunctionSet);//将新获取的功能权限赋值给编辑用户
	}

	public Roles findRoleByName(String roleName) throws Exception {
		Roles r=null;
		List<Roles> roleList= dao.query(Roles.class, Cnd.where("role_name", "=",roleName), null);
		if(null!=roleList&&roleList.size()>0){
			r=roleList.get(0);
		}
		return r;
		
	}
	
	/**根据ID查找角色资源*/
	public List<Functions> findFunctionsByRoleId(String roleId) throws Exception{
		 List<Functions> functions=null;
		 Roles r=this.findRole(roleId);
		 List<Functions> roleFuncs=r.getFunctions();
		 if(null!=roleFuncs&&roleFuncs.size()>0){
			 functions=new ArrayList<Functions>();
			 for(Functions rf:roleFuncs){
				 functions.add(rf);
			 }
		 }
		return functions;
	}
	public QueryResult getPagination(Condition c, int pageNumber, int pageSize) {
		List<Roles> list = null;
		Pager pager = dao.createPager(pageNumber, pageSize);
		list = dao.query(Roles.class, c, pager);
		if (list == null) {
			return null;
		}
		for(Roles r:list){
		    dao.fetchLinks(r, "functions");
		}
		pager.setRecordCount(dao.count(Roles.class));
		
		return new QueryResult(list, pager);
	}
	public List<Roles> getAll(){
		Condition condition1 = Cnd.where("1", "=", 1);
		return dao.query(Roles.class, condition1, null);
	}
}
