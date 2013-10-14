package net.intellizone.coupon.system.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.intellizone.coupon.system.model.Functions;




public class MenuTreeNode {
	private String id;
	private String text;
	private String iconCls;
	private String state="closed";//open/closed
	private NodeAttributes attributes;//属性
	private List<MenuTreeNode> children;
	
	public List<MenuTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<MenuTreeNode> children) {
		this.children = children;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public NodeAttributes getAttributes() {
		return attributes;
	}
	public void setAttributes(NodeAttributes attributes) {
		this.attributes = attributes;
	}

	/**根据List<Functions> 组装成菜单树
	 * beginRootId为开始遍历的最顶级根节点
	 * */
	public static List<MenuTreeNode> installMenuTree(String beginRootId,List<Functions> menus) throws Exception{
		 List<MenuTreeNode> menuTreeList=null;
		 if(null!=menus&&menus.size()>0){
			 menuTreeList=new ArrayList<MenuTreeNode>();
			 Iterator<Functions> itr = menus.iterator();
			 while(itr.hasNext()){
				 Functions f=itr.next();
				 if(beginRootId.equals(""+f.getParent_id())){//最顶级菜单
					 MenuTreeNode node=new MenuTreeNode();
					 node.setId(""+f.getFunction_id());
					 node.setText(f.getFunction_name());
					 if("MENU".equals(f.getFunction_type())){
						 node.setAttributes(new NodeAttributes(f.getUrl()));
						 node.setState("open");
					 }
					 menuTreeList.add(node);
					 itr.remove();
				 }
			 }
			 if(menuTreeList.size()>0){
				 for(MenuTreeNode node:menuTreeList){
					 dealSubMenuTress(node, menus);
				 }
			 }
			 
		 }
		 return menuTreeList;
	}
	/**递归装配子菜单到父节点*/
	private static void dealSubMenuTress(MenuTreeNode parentNode,List<Functions> restMenus){
		List<MenuTreeNode> menuTreeList=new ArrayList<MenuTreeNode>();
		Iterator<Functions> itr = restMenus.iterator();
		 while(itr.hasNext()){
			 Functions f=itr.next();
			 if(parentNode.getId().equals(""+f.getParent_id())){
				 MenuTreeNode node=new MenuTreeNode();
				 node.setId(""+f.getFunction_id());
				 node.setText(f.getFunction_name());
				 if("MENU".equals(f.getFunction_type())){
					 node.setAttributes(new NodeAttributes(f.getUrl()));
					 node.setState("open");
				 }
				 menuTreeList.add(node);
				 itr.remove();
			 }
		 }
		 if(menuTreeList.size()>0){
			 parentNode.setChildren(menuTreeList);
		 }
		 if(restMenus.size()>0){
			 for(MenuTreeNode node:menuTreeList){
				 dealSubMenuTress(node, restMenus);
			 }
		 }
	}
	
	/**递归设置所有叶节点状态为open**/
	public static void setLeafNodeState(MenuTreeNode node){
		List<MenuTreeNode> children=node.getChildren();
		if(null==children){
			node.setState("open");
		}else{
			if(children.size()>0){
				for(MenuTreeNode n:children){
					setLeafNodeState(n);
				}
			}
		}
		
	}
	
	public static void printTree(MenuTreeNode node){
		if(null!=node){
			System.out.println(node.getId()+" "+node.getText()+" "+node.getState());
			if(null!=node.children&&node.children.size()>0){
				for(MenuTreeNode n:node.children){
					printTree(n);
				}
			}
		}
	}
	
	public static void main(String[] args){
		List<Functions> functions=new ArrayList<Functions>();
		//String parentFunctionId,String functionId,String functionName,String functionType,String resourceAssembly
		functions.add(new Functions("0","1","系统管理","FOLDER",null));
		functions.add(new Functions("1","11","权限管理","FOLDER",null));
		functions.add(new Functions("11","111","用户管理","MENU","/user.do"));
		functions.add(new Functions("11","112","角色管理","MENU","/role.do"));
		functions.add(new Functions("11","113","资源管理","MENU","/resource.do"));
		
		functions.add(new Functions("1","12","字典管理","FOLDER",null));
//		functions.add(new Functions("1007","012_1","信息管理","MENU","/msg.do"));
		
		functions.add(new Functions("0","2","信息管理","FOLDER",null));
		//functions.add(new Functions("ROOT","ROOT","根目录","FOLDER",null));
		functions.add(Functions.getRoot());
		
		try {
			List<MenuTreeNode> nodes=installMenuTree("0",functions);
			
			for(MenuTreeNode n:nodes){
				 printTree(n);
			}
			System.out.println(JsonUtil.listToJson(nodes));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
