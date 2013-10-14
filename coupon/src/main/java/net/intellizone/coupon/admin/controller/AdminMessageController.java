package net.intellizone.coupon.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.intellizone.coupon.admin.services.AdminMsgTemplateService;
import net.intellizone.coupon.msg.template.model.MsgTemplate;
import net.intellizone.coupon.shop.model.ShopPic;
import net.intellizone.coupon.util.web.DateUtil;
import net.intellizone.coupon.util.web.ImageCompress;
import net.intellizone.utils.DateUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
public class AdminMessageController {
	@Resource
	private AdminMsgTemplateService adminMsgTemplateService;

	/**
	 * 短信列表
	 * @param p
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/sms",method=RequestMethod.GET)
	public  String sms(@RequestParam(required = false, defaultValue = "1") int p,HttpServletResponse response,HttpServletRequest request, Model model){
		List<MsgTemplate> msgTemplateList=adminMsgTemplateService.getMsgTemplates(p,0);//0为短信 2为彩信
		model.addAttribute("msgTemplateList",msgTemplateList);
		
		return "admin/sms";
	}
	
	
	/***
	 * 编辑短信跳转
	 * @param id
	 * @param p
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/tosmsEdit",method=RequestMethod.GET)
	public  String smsEdit(@RequestParam(required = false, defaultValue = "0") int id,@RequestParam(required = false, defaultValue = "1") int p,HttpServletResponse response,HttpServletRequest request, Model model){
		MsgTemplate msgTemplate=adminMsgTemplateService.getMsgTemplateById((int)id);
		model.addAttribute("msgTemplate",msgTemplate);
		
		return "admin/smsEdit";
	}
	/***
	 * 删除短信模板
	 * @prarm id
	 * @prarm p
	 */
	@RequestMapping(value = "/admin/smsDel", method = RequestMethod.GET)
	public String smsDel(MsgTemplate msgTemplate,@RequestParam(required = false,defaultValue="0")int id,HttpServletResponse response,HttpServletRequest request, Model model){
		adminMsgTemplateService.deleteMsgTemplate(msgTemplate);
		
		return "redirect:/admin/sms.html";
	}
	
	

	
	/**
	 * 保存短信模版
	 * @param id
	 * @param p
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/smsSave",method=RequestMethod.GET)
	public  String smsSaveGet(MsgTemplate msgTemplate,@RequestParam(required = false, defaultValue = "1") int p,
												   @RequestParam(required = false, defaultValue = "0") int a,
													HttpServletResponse response,HttpServletRequest request, Model model){
		if(a==4){
			return "admin/smsEdit";
		}
		
		if(null!=msgTemplate){
			msgTemplate.setModifyTime(DateUtils.converToDateTime(DateUtil.nowDate(DateUtils.DATE_TIME_24_FORMAT)).getTime());
			if(0!=msgTemplate.getId()){
				adminMsgTemplateService.updateMsgTemplate(msgTemplate);
			}else{
				adminMsgTemplateService.insertMsgTemplate(msgTemplate);
			}
		}
		model.addAttribute("msgTemplate",msgTemplate);
		model.addAttribute("p", p);
		model.addAttribute("a",a);
		
		return "redirect:/admin/sms.html";
	}
	
	@RequestMapping(value="/admin/smsSave",method=RequestMethod.POST)
	public  String smsSave(MsgTemplate msgTemplate,int [] id_list,@RequestParam(required = false, defaultValue = "1") int p,
												   @RequestParam(required = false, defaultValue = "0") int a,
													HttpServletResponse response,HttpServletRequest request, Model model){
		if(a==4){
			return "admin/smsEdit";
		}
		if(a==8){
			if(id_list != null &&id_list.length>0){
				adminMsgTemplateService.deleteAllMsg(id_list);
			}
			return "redirect:/admin/sms.html";
		}
		if(null!=msgTemplate){
			msgTemplate.setModifyTime(DateUtils.converToDateTime(DateUtil.nowDate(DateUtils.DATE_TIME_24_FORMAT)).getTime());
			if(0!=msgTemplate.getId()){
				adminMsgTemplateService.updateMsgTemplate(msgTemplate);
			}else{
				adminMsgTemplateService.insertMsgTemplate(msgTemplate);
			}
		}
		model.addAttribute("msgTemplate",msgTemplate);
		model.addAttribute("p", p);
		model.addAttribute("a",a);
		
		return "redirect:/admin/sms.html";
	}
	
	

	/**
	 *彩信列表
	 * @param p
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/mms",method=RequestMethod.GET)
	public  String mms(@RequestParam(required = false, defaultValue = "1") int p,HttpServletResponse response,HttpServletRequest request, Model model){
		List<MsgTemplate> msgTemplateList=adminMsgTemplateService.getMsgTemplates(p,2);//2为彩信
		model.addAttribute("msgTemplateList",msgTemplateList);
		
		return "admin/mms";
	}
	
	
	/***
	 * 删除彩信模板
	 * @prarm id
	 * @prarm p
	 */
	@RequestMapping(value = "/admin/mmsDel", method = RequestMethod.GET)
	public String mmsDel(MsgTemplate msgTemplate,@RequestParam(required = false,defaultValue="0")int id,HttpServletResponse response,HttpServletRequest request, Model model){
		adminMsgTemplateService.deleteMsgTemplate(msgTemplate);
		
		return "redirect:/admin/mms.html";
	}
	/***
	 * 编辑彩信跳转
	 * @param id
	 * @param p
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/tommsEdit",method=RequestMethod.GET)
	public  String mmsEdit(@RequestParam(required = false, defaultValue = "0") int id,@RequestParam(required = false, defaultValue = "1") int p,HttpServletResponse response,HttpServletRequest request, Model model){
		MsgTemplate msgTemplate=adminMsgTemplateService.getMsgTemplateById((int)id);
		/**截取图片名*/
		/**Pattern mmsPat = Pattern.compile("<@(.*?)@>");
		Matcher mmsMat = mmsPat.matcher(msgTemplate.getTemplateContent());
		List<String> mmsList = new ArrayList<String>();
		while(mmsMat.find()){
			mmsList.add(mmsMat.group(1));
		}
		/**将图片名还原成常量*/
		/**String[] content=msgTemplate.getTemplateContent().split("<@(.*?)@>");
		String outContent="";
		for(int i=0 ;i<content.length;i++){
			if(i<content.length-1){
			 outContent+=content[i]+"<@"+(i+1)+"@>";
			}else{
				outContent+=content[i];
				 if(msgTemplate.getTemplateContent().endsWith("@>")){
						outContent+="<@"+(i+1)+"@>";
				 	}
			}
		}
		msgTemplate.setTemplateContent(outContent);
		model.addAttribute("mmsList",mmsList);**/
		model.addAttribute("msgTemplate",msgTemplate);
		return "admin/mmsEdit";
	}
	
	
	/**
	 * 保存彩信模版
	 * @param id
	 * @param p
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/mmsSave",method=RequestMethod.POST)
	public  String mmsSave(MsgTemplate msgTemplate,@RequestParam(required = false, defaultValue = "") String[] id_mms,@RequestParam(required = false, defaultValue = "1") int p,@RequestParam(required = false, defaultValue = "500")int width,HttpServletResponse response,HttpServletRequest request, Model model){
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
 
		       /** String pathnew= request.getSession().getServletContext().getRealPath("/")+"goods";
		        List<ShopPic> shopPicList=new ArrayList<ShopPic>();
		        int i=0;
		        for(MultipartFile imgFile1:imgFileList){
		        	i++;
		        	 File file1 =null; 
			         if(!(imgFile1.getOriginalFilename() ==null || "".equals(imgFile1.getOriginalFilename()))) {
							file1 = this.getFile(imgFile1,pathnew,"img",fileTypes,width);
							if(null!=msgTemplate){
						           if(null!=msgTemplate.getTemplateContent()&&!"".equals(msgTemplate.getTemplateContent())){
						        	 String content= msgTemplate.getTemplateContent().replaceAll("<@"+i+"@>", "<@"+file1.getName()+"@>");
						      
						        	 msgTemplate.setTemplateContent(content);
						           }
						     }
						
			         }
				
		        }**/
				if(null!=msgTemplate){
					msgTemplate.setModifyTime(DateUtils.converToDateTime(DateUtil.nowDate(DateUtils.DATE_TIME_24_FORMAT)).getTime());
					if(0!=msgTemplate.getId()){					
						adminMsgTemplateService.updateMsgTemplate(msgTemplate);
					}else{
						
						adminMsgTemplateService.insertMsgTemplate(msgTemplate);
					}
				}
				model.addAttribute("msgTemplate",msgTemplate);
				model.addAttribute("p", p);
	   
		return "redirect:/admin/mms.html";
	}
	
	
	
	/***
	 * 添加彩信跳转
	 * @param id
	 * @param p
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/tommsAdd",method=RequestMethod.GET)
	public  String mmsAdd(@RequestParam(required = false, defaultValue = "0") int id,@RequestParam(required = false, defaultValue = "1") int p,HttpServletResponse response,HttpServletRequest request, Model model){
		
		
		return "admin/mmsEdit";
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
