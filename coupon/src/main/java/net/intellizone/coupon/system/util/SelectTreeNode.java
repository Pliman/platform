package net.intellizone.coupon.system.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.intellizone.coupon.system.model.Functions;


/**
 * 菜单树
 * @author： ljt 
 * @since： 2010-1-13 下午05:25:04
 * @modify: 
 * @主要功能：
 * @see 
 * @version 1.0
 */
public class SelectTreeNode {
	/**节点ID*/
	private String id;
	/**节点名称*/
	private String text;
	/**节点功能url*/
	private String url;
	/**节点值*/
	private String value;
	/**是否有子节点*/
	private Boolean hasChildren;
	/**节点图标样式是否展开*/
	private Boolean isexpand;
	/**节点图标样式是否最后一个节点*/
	private Boolean complete;
	/**节点图标样式是否显示选择框*/
	private Boolean showcheck;
	/**CHECKBOX 状态 0:不选中 1:选中 2:半选中*/
	private Integer checkstate=0;
	/**子节点集合*/
	private List<SelectTreeNode> childNodes;
	public SelectTreeNode(){
		
	}
	public SelectTreeNode(String id, String text, String url, String value, Boolean hasChildren, Boolean isexpand, Boolean complete, Boolean showcheck,Integer checkstate) {
		this();
		this.id = id;
		this.text = text;
		this.url = url;
		this.value = value;
		this.hasChildren = hasChildren;
		this.isexpand = isexpand;
		this.complete = complete;
		this.showcheck = showcheck;
		this.checkstate=checkstate;
	}
	public List<SelectTreeNode> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<SelectTreeNode> childNodes) {
		this.childNodes = childNodes;
	}
	public Boolean getComplete() {
		return complete;
	}
	public void setComplete(Boolean complete) {
		this.complete = complete;
	}
	public Boolean getHasChildren() {
		return hasChildren;
	}
	public void setHasChildren(Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getIsexpand() {
		return isexpand;
	}
	public void setIsexpand(Boolean isexpand) {
		this.isexpand = isexpand;
	}
	public Boolean getShowcheck() {
		return showcheck;
	}
	public void setShowcheck(Boolean showcheck) {
		this.showcheck = showcheck;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getCheckstate() {
		return checkstate;
	}
	public void setCheckstate(Integer checkstate) {
		this.checkstate = checkstate;
	}
	/**根据List<Functions> 组装成菜单树
	 * beginRootId为开始遍历的最顶级根节点
	 * */
	public static List<SelectTreeNode> installSelectTree(String beginRootId,List<Functions> resources) throws Exception{
		 List<SelectTreeNode> menuTreeList=null;
		 if(null!=resources&&resources.size()>0){
			 menuTreeList=new ArrayList<SelectTreeNode>();
			 Iterator<Functions> itr = resources.iterator();
			 while(itr.hasNext()){
				 Functions f=itr.next();
				 if(beginRootId.equals(""+f.getParent_id())){//最顶级菜单
					 SelectTreeNode node=new SelectTreeNode();
					 node.setId(""+f.getFunction_id());
					 node.setText(f.getFunction_name());
					 //菜单节点选中状态设置
					 if(f.getSelected()){
						 node.setCheckstate(1);//选中
					 }
					 menuTreeList.add(node);
					 itr.remove();
				 }
			 }
			 if(menuTreeList.size()>0){
				 for(SelectTreeNode node:menuTreeList){
					 dealSubSelectTrees(node, resources);
				 }
			 }
			 
		 }
		 return menuTreeList;
	}
	/**递归装配子菜单到父节点*/
	private static void dealSubSelectTrees(SelectTreeNode parentNode,List<Functions> restMenus){
		 List<SelectTreeNode> menuTreeList=new ArrayList<SelectTreeNode>();	
		 Iterator<Functions> itr = restMenus.iterator();
		 while(itr.hasNext()){
			 Functions f=itr.next();
			 if(parentNode.getId().equals(""+f.getParent_id())){
				 SelectTreeNode node=new SelectTreeNode();
				 node.setId(""+f.getFunction_id());
				 node.setText(f.getFunction_name());
				 node.setHasChildren(false);
				 node.setShowcheck(true);
				 node.setComplete(true);
				 node.setIsexpand(false);
				 //菜单节点选中状态设置
				 if(f.getSelected()){
					 node.setCheckstate(1);//选中
				 }
				 menuTreeList.add(node);
				 itr.remove();
			 }
		 }
		 if(menuTreeList.size()>0){
			 parentNode.setChildNodes(menuTreeList);
			 parentNode.setHasChildren(true);
			 parentNode.setShowcheck(true);
			 parentNode.setComplete(false);
			 parentNode.setIsexpand(true);
			 
			 //父节点半选中处理(当子节点不是所有选中但有部分选中时　修改父节点状态为半选中)
			 int selectCount=0;
			 for(SelectTreeNode sn:menuTreeList){
				 if(sn.checkstate!=0){
					 selectCount++;
				 }
			 }
			 if(selectCount>0&&selectCount<menuTreeList.size()){
				 parentNode.setCheckstate(2);
			 }
			 //parentNode.setText(parentNode.text+":"+selectCount);
			 
		 }else{
			 parentNode.setHasChildren(false);
			 parentNode.setShowcheck(true);
			 parentNode.setComplete(true);
			 parentNode.setIsexpand(false);
		 }
		
		 if(restMenus.size()>0){
			 for(SelectTreeNode node:menuTreeList){
				 dealSubSelectTrees(node, restMenus);
			 }
		 }
	}

}
