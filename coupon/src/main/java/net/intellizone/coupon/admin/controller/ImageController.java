package net.intellizone.coupon.admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.coupon.model.GoodsImages;
import net.intellizone.coupon.coupon.services.GoodsService;
import net.intellizone.coupon.shop.model.Shop;
import net.intellizone.coupon.shop.model.ShopPic;
import net.intellizone.coupon.shop.services.ShopService;
import net.intellizone.coupon.util.web.Constant;
import net.intellizone.coupon.util.web.ImageCompress;
import net.intellizone.coupon.util.web.RCCreator;
import net.intellizone.utils.DateUtils;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
public class ImageController {
	 @Resource
	 private ShopService shopService;
	 @Resource
	 private GoodsService goodsService;
	 
	 private String getError(String message) {
			JSONObject obj = new JSONObject();
			obj.put("error", 1);
			obj.put("message", message);
			return obj.toString();
		}
	 
	 @RequestMapping(value="/admin/upload_json",method=RequestMethod.POST) 
	 public void upload_json(Shop shop,Goods goods,String begin_time1,String end_time1,@RequestParam(required = false, defaultValue = "1")int upType,@RequestParam(required = false, defaultValue = "500")int width,@RequestParam(required = false, defaultValue = "1") int p,@RequestParam(required = false, defaultValue = "0") int a,String upImg,HttpServletRequest request,HttpServletResponse response,String path1,String path2,Model model) throws IOException, FileUploadException {   
		 {
			 response.setContentType("text/html; charset=UTF-8");
			 PrintWriter out = response.getWriter(); 
			 
			//文件保存目录路径
			 String savePath = request.getSession().getServletContext().getRealPath("/") + "attached/";

			 //文件保存目录URL
			 String saveUrl  = request.getContextPath() + "/attached/";

			 //定义允许上传的文件扩展名
			 HashMap<String, String> extMap = new HashMap<String, String>();
			 extMap.put("image", "gif,jpg,jpeg,png,bmp");
			 extMap.put("flash", "swf,flv");
			 extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
			 extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

			 //最大文件大小
			 long maxSize = 1000000;

			

			 if(!ServletFileUpload.isMultipartContent(request)){
			 	out.println(getError("请选择文件。"));
			 	return;
			 }
			 //检查目录
			 File uploadDir = new File(savePath);
			 if(!uploadDir.isDirectory()){
			 	out.println(getError("上传目录不存在。"));
			 	return;
			 }
			 //检查目录写权限
			 if(!uploadDir.canWrite()){
			 	out.println(getError("上传目录没有写权限。"));
			 	return;
			 }

			 String dirName = request.getParameter("dir");
			 if (dirName == null) {
			 	dirName = "image";
			 }
			 if(!extMap.containsKey(dirName)){
			 	out.println(getError("目录名不正确。"));
			 	return;
			 }
			 //创建文件夹
			 savePath += dirName + "/";
			 saveUrl += dirName + "/";
			 File saveDirFile = new File(savePath);
			 if (!saveDirFile.exists()) {
			 	saveDirFile.mkdirs();
			 }
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			 String ymd = sdf.format(new Date());
			 savePath += ymd + "/";
			 saveUrl += ymd + "/";
			 File dirFile = new File(savePath);
			 if (!dirFile.exists()) {
			 	dirFile.mkdirs();
			 }

			 FileItemFactory factory = new DiskFileItemFactory();
			 ServletFileUpload upload = new ServletFileUpload(factory);
			 upload.setHeaderEncoding("UTF-8");
			 
			 //转型为MultipartHttpRequest(重点的所在)   
	         MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;   
	         //  获得第1张图片（根据前台的name名称得到上传的文件）    
	         List<MultipartFile> imgFileList  =  multipartRequest.getFiles("imgFile");
	           
	         //定义一个数组，用于保存可上传的文件类型   

			// List items = upload.parseRequest(request);
	         List items=imgFileList;
			 Iterator itr = items.iterator();
		    for(MultipartFile imgFile:imgFileList){
			 	//FileItem item = (FileItem) itr.next();
			 	String fileName = imgFile.getOriginalFilename();
			 	long fileSize = imgFile.getSize();
	
			 		//检查文件大小
			 		if(imgFile.getSize() > maxSize){
			 			out.println(getError("上传文件大小超过限制。"));
			 			return;
			 		}
			 		//检查扩展名
			 		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
			 		if(!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
			 			out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
			 			return;
			 		}

			 		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			 		String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
			 		try{
			 			File uploadedFile = new File(savePath, newFileName);
			 			imgFile.transferTo(uploadedFile); 
			 		}catch(Exception e){
			 			out.println(getError("上传文件失败。"));
			 			return;
			 		}

			 		JSONObject obj = new JSONObject();
			 		obj.put("error", 0);
			 		obj.put("url", saveUrl + newFileName);
			 		out.println(obj.toString());
			 
			 }
		 }
		
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value="/admin/fileManger",method=RequestMethod.POST) 
	 public void fileManger(Shop shop,Goods goods,String begin_time1,String end_time1,@RequestParam(required = false, defaultValue = "1")int upType,@RequestParam(required = false, defaultValue = "500")int width,@RequestParam(required = false, defaultValue = "1") int p,@RequestParam(required = false, defaultValue = "0") int a,String upImg,HttpServletRequest request,HttpServletResponse response,String path1,String path2,Model model) throws IOException {   
	        
	 PrintWriter out = response.getWriter();
	//根目录路径，可以指定绝对路径，比如 /var/www/attached/
	 String rootPath = request.getSession().getServletContext().getRealPath("/") + "attached/";
	 //根目录URL，可以指定绝对路径，比如 http://www.yoursite.com/attached/
	 String rootUrl  = request.getContextPath() + "/attached/";
	 //图片扩展名
	 String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};

	 String dirName = request.getParameter("dir");
	 if (dirName != null) {
	 	if(!Arrays.<String>asList(new String[]{"image", "flash", "media", "file"}).contains(dirName)){
	 		out.println("Invalid Directory name.");
	 		return ;
	 	}
	 	rootPath += dirName + "/";
	 	rootUrl += dirName + "/";
	 	File saveDirFile = new File(rootPath);
	 	if (!saveDirFile.exists()) {
	 		saveDirFile.mkdirs();
	 	}
	 }
	 //根据path参数，设置各路径和URL
	 String path = request.getParameter("path") != null ? request.getParameter("path") : "";
	 String currentPath = rootPath + path;
	 String currentUrl = rootUrl + path;
	 String currentDirPath = path;
	 String moveupDirPath = "";
	 if (!"".equals(path)) {
	 	String str = currentDirPath.substring(0, currentDirPath.length() - 1);
	 	moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0, str.lastIndexOf("/") + 1) : "";
	 }

	 //排序形式，name or size or type
	 String order = request.getParameter("order") != null ? request.getParameter("order").toLowerCase() : "name";

	 //不允许使用..移动到上一级目录
	 if (path.indexOf("..") >= 0) {
	 	out.println("Access is not allowed.");
	 	return;
	 }
	 //最后一个字符不是/
	 if (!"".equals(path) && !path.endsWith("/")) {
	 	out.println("Parameter is not valid.");
	 	return;
	 }
	 //目录不存在或不是目录
	 File currentPathFile = new File(currentPath);
	 if(!currentPathFile.isDirectory()){
	 	out.println("Directory does not exist.");
	 	return;
	 }

	 //遍历目录取的文件信息
	 List<Hashtable> fileList = new ArrayList<Hashtable>();
	 if(currentPathFile.listFiles() != null) {
	 	for (File file : currentPathFile.listFiles()) {
	 		Hashtable<String, Object> hash = new Hashtable<String, Object>();
	 		String fileName = file.getName();
	 		if(file.isDirectory()) {
	 			hash.put("is_dir", true);
	 			hash.put("has_file", (file.listFiles() != null));
	 			hash.put("filesize", 0L);
	 			hash.put("is_photo", false);
	 			hash.put("filetype", "");
	 		} else if(file.isFile()){
	 			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	 			hash.put("is_dir", false);
	 			hash.put("has_file", false);
	 			hash.put("filesize", file.length());
	 			hash.put("is_photo", Arrays.<String>asList(fileTypes).contains(fileExt));
	 			hash.put("filetype", fileExt);
	 		}
	 		hash.put("filename", fileName);
	 		hash.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
	 		fileList.add(hash);
	 	}
	 }

	 
	 class NameComparator implements Comparator {
			public int compare(Object a, Object b) {
				Hashtable hashA = (Hashtable)a;
				Hashtable hashB = (Hashtable)b;
				if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
					return -1;
				} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
					return 1;
				} else {
					return ((String)hashA.get("filename")).compareTo((String)hashB.get("filename"));
				}
			}
		}
		class SizeComparator implements Comparator {
			public int compare(Object a, Object b) {
				Hashtable hashA = (Hashtable)a;
				Hashtable hashB = (Hashtable)b;
				if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
					return -1;
				} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
					return 1;
				} else {
					if (((Long)hashA.get("filesize")) > ((Long)hashB.get("filesize"))) {
						return 1;
					} else if (((Long)hashA.get("filesize")) < ((Long)hashB.get("filesize"))) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		}
		class TypeComparator implements Comparator {
			public int compare(Object a, Object b) {
				Hashtable hashA = (Hashtable)a;
				Hashtable hashB = (Hashtable)b;
				if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
					return -1;
				} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
					return 1;
				} else {
					return ((String)hashA.get("filetype")).compareTo((String)hashB.get("filetype"));
				}
			}
		}
	 if ("size".equals(order)) {
	 	Collections.sort(fileList, new SizeComparator());
	 } else if ("type".equals(order)) {
	 	Collections.sort(fileList, new TypeComparator());
	 } else {
	 	Collections.sort(fileList, new NameComparator());
	 }
	 JSONObject result = new JSONObject();
	 result.put("moveup_dir_path", moveupDirPath);
	 result.put("current_dir_path", currentDirPath);
	 result.put("current_url", currentUrl);
	 result.put("total_count", fileList.size());
	 result.put("file_list", fileList);

	 response.setContentType("application/json; charset=UTF-8");
	 out.println(result.toString());
	 
	 }
		/**
		 * 图片批量上传新增 接口
		 * @param request
		 * @param response
		 * @param path1
		 * @param path2
		 * @param upType 1为商户 2为GOODS
		 * @throws IOException
		 */
	 
	 @RequestMapping(value="/admin/shopaddupload",method=RequestMethod.POST)
	 public String addNewImageList(Shop shop,Goods goods,String begin_time1,String end_time1,@RequestParam(required = false, defaultValue = "1")int upType,@RequestParam(required = false, defaultValue = "500")int width,@RequestParam(required = false, defaultValue = "1") int p,@RequestParam(required = false, defaultValue = "0") int a,String upImg,HttpServletRequest request,HttpServletResponse response,String path1,String path2,Model model) throws IOException {   
	        
		 
		 //转型为MultipartHttpRequest(重点的所在)   
	         MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;   
	         //  获得第1张图片（根据前台的name名称得到上传的文件）    
	         List<MultipartFile> imgFileList  =  multipartRequest.getFiles("UpImgId");
	           
	         //定义一个数组，用于保存可上传的文件类型   
	         List fileTypes = new ArrayList();   
	         fileTypes.add("jpg");   
	         fileTypes.add("jpeg");   
	         fileTypes.add("bmp");   
	         fileTypes.add("gif");   
	       if(upType==1){
	    	       String pathnew= request.getSession().getServletContext().getRealPath("/")+"goods";
			        List<ShopPic> shopPicList=new ArrayList<ShopPic>();
			        for(MultipartFile imgFile1:imgFileList){
				        File file1 =null;  
			         //保存第一张图片   
				         if(!(imgFile1.getOriginalFilename() ==null || "".equals(imgFile1.getOriginalFilename()))) {   
				           ShopPic shopPic=new ShopPic();
				           file1 = this.getFile(imgFile1,pathnew,"img",fileTypes,width); 
				           shopPic.setShop_id((int)shop.getId());
				           shopPic.setUrl(file1.getName());
				           shopPicList.add(shopPic);
				       
				         }  
			        }
		
			         shop.setShopPicList(shopPicList);
			        
		
			         model.addAttribute("a", a);
			 		 model.addAttribute("p",p);
		
			 		 if(a==3){//编辑
						shop=shopService.getShopById((int)shop.getId());
						model.addAttribute("shop",shop);
						return "admin/shop_edit";
					}else if(a==1){//插入
						shopService.insertObj(shop);
						shopService.insertLink(shop);
						return "redirect:shopadmin.html";
					}
					
			 		 
			     	return "redirect:/coupon/admin/shopAction.html";

	       }else  if(upType==2){
	    	      String pathnew= request.getSession().getServletContext().getRealPath("/")+"goods";
	    	      List<GoodsImages> goodsImgList=new ArrayList<GoodsImages>();
	    	      for(MultipartFile imgFile1:imgFileList){
				        File file1 =null;  
			         //获取图片URL
				         if(!(imgFile1.getOriginalFilename() ==null || "".equals(imgFile1.getOriginalFilename()))) {   
				        	   GoodsImages goodsPic=new GoodsImages();
					           file1 = this.getFile(imgFile1,pathnew,"img",fileTypes,width); 
					           goodsPic.setGoods_id(goods.getId());
					           goodsPic.setUrl(file1.getName());
					           goodsImgList.add(goodsPic);
				       
				         }  
			        }
		
			         goods.setGoodsImages(goodsImgList);
			        
		
			         model.addAttribute("a", a);
			 		 model.addAttribute("p",p);
			 		 
			 		if(a==3){//编辑
						goods=goodsService.getGoodsById(goods.getId());
						model.addAttribute("goods",goods);
						return "admin/goods_edit";
					}else if(a==1){//插入
						goods.setBegin_time(DateUtils.converToDateTime(begin_time1).getTime());
						goods.setEnd_time(DateUtils.converToDateTime(end_time1).getTime());
						goods.setCreate_time(System.currentTimeMillis());
						goods.setModify_time(System.currentTimeMillis());
						goods.setBegin_time(System.currentTimeMillis());
						goods=goodsService.insertObj(goods);
						if(goods!=null){//
						    String erweiName="erwei_"+String.valueOf(System.currentTimeMillis())+".jpg";
							String path=request.getSession().getServletContext().getRealPath("/")+Constant.RC_PIC_PATH+"/"+erweiName;
							File file=RCCreator.createRC(goods.getName(), String.valueOf(goods.getId()), path);
							
							if(file!=null){
								goods.setErcode(file.getName());
								goodsService.updateObj(goods);
							}
						}
						goodsService.insertLink(goods);
						return "redirect:goodsadmin.html";
					}
			 		return "goodsAction.html";
	       } else{
	    	   		return "goodsAction.html";
	       }
	           
	   }
	
	 
	 
		/**
		 * 图片批量上传 接口
		 * @param request
		 * @param response
		 * @param path1
		 * @param path2
		 * @throws IOException
		 */
	 
	 @RequestMapping(value="/admin/shopupload",method=RequestMethod.POST)
	 public String updateImageList(Shop shop,Goods goods,@RequestParam(required = false, defaultValue = "1")int upType,@RequestParam(required = false, defaultValue = "500")int width,@RequestParam(required = false, defaultValue = "1") int p,@RequestParam(required = false, defaultValue = "0") int a,String upImg,HttpServletRequest request,HttpServletResponse response,String path1,String path2,Model model) throws IOException {   
	        
		 
		 //转型为MultipartHttpRequest(重点的所在)   
	         MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;   
	         //  获得第1张图片（根据前台的name名称得到上传的文件）    
	         List<MultipartFile> imgFileList  =  multipartRequest.getFiles("UpImgId");
	           
	         //定义一个数组，用于保存可上传的文件类型   
	         List fileTypes = new ArrayList();   
	         fileTypes.add("jpg");   
	         fileTypes.add("jpeg");   
	         fileTypes.add("bmp");   
	         fileTypes.add("gif");   
	       if(upType==1){
		        String pathnew= request.getSession().getServletContext().getRealPath("/")+"goods";
		        List<ShopPic> shopPicList=new ArrayList<ShopPic>();
		        for(MultipartFile imgFile1:imgFileList){
			        File file1 =null;  
		         //保存第一张图片   
			         if(!(imgFile1.getOriginalFilename() ==null || "".equals(imgFile1.getOriginalFilename()))) {   
			           ShopPic shopPic=new ShopPic();
			           file1 = this.getFile(imgFile1,pathnew,"img",fileTypes,width); 
			           shopPic.setShop_id((int)shop.getId());
			           shopPic.setUrl(file1.getName());
			           shopPicList.add(shopPic);
			       
			         }  
		        }
	
		         shop.setShopPicList(shopPicList);
		         shopService.insertLink(shop);
	
		         model.addAttribute("a", a);
		 		 model.addAttribute("p",p);
	
		 		if(a==1){//添加
					shopService.insertObj(shop);
					return "redirect:shopadmin.html";
				}else if(a==5){//删除
					shopService.deleteShopById(shop.getId());
					return "redirect:shopadmin.html";
				}else if(a==2){
					shopService.updateObj(shop);
					return "redirect:shopadmin.html";
				}else if(a==3){//编辑
					shop=shopService.getShopById((int)shop.getId());
					model.addAttribute("shop",shop);
					return "admin/shop_edit";
				}else if(a==4){//添加
					return "admin/shop_edit";
				}
				
		 		 
		     	return "redirect:/coupon/admin/shopAction.html";
	       }else  if(upType==2){
	    	      String pathnew= request.getSession().getServletContext().getRealPath("/")+"goods";
	    	      List<GoodsImages> goodsImgList=new ArrayList<GoodsImages>();
	    	      for(MultipartFile imgFile1:imgFileList){
				        File file1 =null;  
			         //获取图片URL
				         if(!(imgFile1.getOriginalFilename() ==null || "".equals(imgFile1.getOriginalFilename()))) {   
				        	   GoodsImages goodsPic=new GoodsImages();
					           file1 = this.getFile(imgFile1,pathnew,"img",fileTypes,width); 
					           goodsPic.setGoods_id(goods.getId());
					           goodsPic.setUrl(file1.getName());
					           goodsImgList.add(goodsPic);
				       
				         }  
			        }
	    	      	 model.addAttribute("id", goods.getId());
	    	      	 model.addAttribute("a", a);
			 		 model.addAttribute("p",p);
			         goods.setGoodsImages(goodsImgList);
			         goodsService.insertLink(goods);
			         if(a==3){//编辑
							goods=goodsService.getGoodsById(goods.getId());
							model.addAttribute("goods",goods);
							return "admin/goods_edit";
			          }else if(a==1){
			        	  model.addAttribute("goods",goods);
						  return "admin/goods_edit"; 
			          }
			         return "redirect:goodsAction.html";
			       
	       }
	       return "redirect:goodsAction.html";
	            
	           
	   }
	
	
	
	/**
	 * 图片上传 接口
	 * @param request
	 * @param response
	 * @param path1
	 * @param path2
	 * @throws IOException
	 */
	 @RequestMapping(value="/admin/goods/upload",method=RequestMethod.POST)
	 public void addImage(String upImg,@RequestParam(required = true, defaultValue = "500")int width,HttpServletRequest request,HttpServletResponse response,String path1,String path2) throws IOException {   
	        //转型为MultipartHttpRequest(重点的所在)   
	         MultipartHttpServletRequest multipartRequest  =  (MultipartHttpServletRequest) request;   
	         //  获得第1张图片（根据前台的name名称得到上传的文件）    
	         MultipartFile imgFile1  =  multipartRequest.getFile("Filedata");   
	           
	         //定义一个数组，用于保存可上传的文件类型   
	         List fileTypes = new ArrayList();   
	         fileTypes.add("jpg");   
	         fileTypes.add("jpeg");   
	         fileTypes.add("bmp");   
	         fileTypes.add("gif");   
	        File file1 =null;  
	    
	        String pathnew= request.getSession().getServletContext().getRealPath("/")+"goods";
	         //保存第一张图片   
	         if(!(imgFile1.getOriginalFilename() ==null || "".equals(imgFile1.getOriginalFilename()))) {   
	  
	           file1 = this.getFile(imgFile1,pathnew,"img",fileTypes,width); 
	           
	               
	         }  
	         PrintWriter writer = null;
			 writer = response.getWriter();
			 if(file1!=null){
		         writer.print("{success: true,picname:'" + file1.getName()+"',upImg:'"+upImg+ "',imageId:"
							+ "0" + "}");
			 }else{
				 writer.print("{success: false}");
			 }
	            
	           
	   }
	 
	 
	 @SuppressWarnings("deprecation")
	private File getFile(MultipartFile imgFile,String basePath,String brandName,List fileTypes,int width) throws IOException {  
		 
		 
			int companyId = 1;
		
			Date date = new Date();
			String secondDir = String.valueOf(date.getYear())
					+ String.valueOf(date.getMonth())
					+ String.valueOf(date.getDate());
			long mypath = 0;
			if (companyId / 1000 < 1) {
				mypath = 0;
			} else {
				mypath = (long) Math.floor(companyId / 1000);
			}
			basePath+=mypath;
	        String fileName = imgFile.getOriginalFilename(); 
	        
	        String imgName = String.valueOf(companyId) + "_" + secondDir + "_"
			+ String.valueOf(date.getTime()) + "_"+String.valueOf(new Random().nextLong());
	        
	        
	        //获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名   
	         String ext = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());   
	    
	 
	            
	         File file = null;   
	         if(fileTypes.contains(ext)) {                      //如果扩展名属于允许上传的类型，则创建文件   
	             //对扩展名进行小写转换   
		         ext = "."+ext.toLowerCase();	         
		         String saveName=imgName+ext;
	             file = this.creatFolder(basePath, brandName, saveName);   
	             try {  
	            	 imgFile.transferTo(file); 
	            	 ImageCompress.ImageScale(file.getAbsolutePath(),width, 1000); 
	            	 File subFolder = new File(basePath+"/img/small/"+imgName+"_m.jpg"); 
	            	 File subFolder2 = new File(basePath+"/img/small/"+imgName+"_s.jpg");
	            	 if(!subFolder.exists()){
	            		 subFolder.mkdirs(); //创建子文件夹
	            	 }
	            	 if(!subFolder2.exists()){
	            		 subFolder2.mkdirs(); //创建子文件夹
	            	 }
	            	 ImageCompress.ImageScale(basePath+"/img/",saveName,"small",imgName+"_m.jpg",width/2, 1000); 
	            	 ImageCompress.ImageScale(basePath+"/img/",saveName,"small",imgName+"_s.jpg", width/3,1000); //保存上传的文件   
	            	 ImageCompress.ImageScale(basePath+"/img/",saveName,"small",imgName+"_s.jpg", 120,120); 
	            } catch (IllegalStateException e) {   
	                e.printStackTrace();   
	            }   
	         }   
	         return file;   
	    }   
	       
	      
	    private File creatFolder(String basePath,String brandName,String fileName) {   
	         File file = null;   
	         basePath = basePath.replaceAll("/", "");               //去掉"/"   
//	         typeName = typeName.replaceAll(" ", "");               //替换半角空格   
//	         typeName = typeName.replaceAll(" ", "");               //替换全角空格   
	           
	         brandName = brandName.replaceAll("/", "");             //去掉"/"   
//	         brandName = brandName.replaceAll(" ", "");             //替换半角空格   
//	         brandName = brandName.replaceAll(" ", "");             //替换全角空格   
	           
	         File firstFolder = new File(basePath);         //一级文件夹   
	         if(firstFolder.exists()) {                             //如果一级文件夹存在，则检测二级文件夹   
	             File secondFolder = new File(firstFolder,brandName);   
	             if(secondFolder.exists()) {                        //如果二级文件夹也存在，则创建文件   
	                 file = new File(secondFolder,fileName);   
	             }else {                                            //如果二级文件夹不存在，则创建二级文件夹   
	                 secondFolder.mkdir();   
	                 file = new File(secondFolder,fileName);        //创建完二级文件夹后，再合建文件   
	             }   
	         }else {                                                //如果一级不存在，则创建一级文件夹   
	             firstFolder.mkdirs();   
	             File secondFolder = new File(firstFolder,brandName);   
	             if(secondFolder.exists()) {                        //如果二级文件夹也存在，则创建文件   
	                 file = new File(secondFolder,fileName);   
	             }else {                                            //如果二级文件夹不存在，则创建二级文件夹   
	                 secondFolder.mkdirs();   
	                 file = new File(secondFolder,fileName);   
	             }   
	         }   
	         return file;   
	    }
}
