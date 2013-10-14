package net.intellizone.coupon.util.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import net.intellizone.coupon.activity.model.Activity;
import net.intellizone.coupon.admin.model.HomePage;
import net.intellizone.coupon.coupon.model.Goods;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;



public class BuildHtmlFile {
 
 public static void createProducttypeHtml(List<HomePage> homePageList, File saveDir,String loaderPath,int type){
  try {
	// 创建引擎     
   VelocityEngine ve=new VelocityEngine(); 
   ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, loaderPath); 
   //进行初始化操作     
   ve.init(); 
   if(!saveDir.exists()) saveDir.mkdirs();
   VelocityContext context = new VelocityContext();
   context.put("homePageList", homePageList);
   // 模板保存在WebRoot/web-inf/product目录下
   Template template = ve.getTemplate("bk"+String.valueOf(type)+".htm","UTF-8");
   System.out.println(template.getName());
   FileOutputStream outStream = new FileOutputStream(new File(saveDir, "bk"+String.valueOf(type)+".htm"));
   OutputStreamWriter writer =  new OutputStreamWriter(outStream,"UTF-8");
   BufferedWriter sw = new BufferedWriter(writer);
   template.merge(context, sw);
   sw.flush();
   sw.close();
   outStream.close();
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
 
 
 public static void createProductGoodsHtml(List<Goods> goodsList, File saveDir,String loaderPath){
	  try {
		// 创建引擎     
	   VelocityEngine ve=new VelocityEngine(); 
	   
	   ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, loaderPath); //设置模板加载路径
	   //进行初始化操作     
	   ve.init(); 
	   if(!saveDir.exists()) saveDir.mkdirs();//创建此抽象路径名指定的目录
	   
	   //设置初始化数据
	   VelocityContext context = new VelocityContext();
	   context.put("goodsList", goodsList);
	   //加载模板，设置编码格式， 模板保存在WebRoot/web-inf/product目录下
	   Template template = ve.getTemplate("goodsList.htm","UTF-8");
	   System.out.println(template.getName());
	   FileOutputStream outStream = new FileOutputStream(new File(saveDir, "goodsList.htm")); //写入文件
	   OutputStreamWriter writer =  new OutputStreamWriter(outStream,"UTF-8");//将字节流转换为字符流写入
	   BufferedWriter sw = new BufferedWriter(writer); //写入缓冲区
	   template.merge(context, sw); //讲数据转化输出
	   sw.flush();
	   sw.close();
	   outStream.close();
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 }


public static void createProductActHtml(List<Activity> listAct, File saveDir,
		String loaderPath) {
	try {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, loaderPath);
		
			ve.init();
			if(!saveDir.exists()){
				saveDir.mkdirs();
			}
			VelocityContext context = new VelocityContext();
			context.put("listAct", listAct);
			Template template = ve.getTemplate("actList.htm","utf-8");
			FileOutputStream outStream = new FileOutputStream(new File(saveDir,"actList.htm"));
			OutputStreamWriter wirter = new OutputStreamWriter(outStream,"utf-8");
			BufferedWriter sw = new BufferedWriter(wirter);
			template.merge(context, sw);
			sw.flush();
			sw.close();
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
}

}