package net.intellizone.coupon.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.intellizone.sysparam.model.SystemParam;
import net.intellizone.sysparam.services.SystemParamService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminSysParamController {
	@Resource
	private SystemParamService sysParamService;
	
	@RequestMapping(value = "/admin/systemMsg", method = RequestMethod.GET)
	public String SysAdmin( @RequestParam(required = false, defaultValue = "1")
			int p, HttpServletResponse response, HttpServletRequest request, Model model){
		List<SystemParam> sysList = sysParamService.getSysParam();
		model.addAttribute("sysList",sysList);
		model.addAttribute("p",p);
		return "admin/systemMsg";
	}
	@RequestMapping(value="/admin/sysUpdate" , method = RequestMethod.GET)
	public String sysUpadteGet(SystemParam sysParam,@RequestParam(required = false, defaultValue = "0") int id,@RequestParam(required = false, defaultValue = "0") int a,HttpServletResponse response, HttpServletRequest request, Model model){
		
		if(a==4){
			SystemParam sysParams = sysParamService.getSysById(id);
			model.addAttribute("sysParams",sysParams);
			return "admin/sysMsg_edit";
		}
		if(a==2){
			sysParamService.updateSys(sysParam);
			return "redirect:/admin/systemMsg.html";
		}
			return null;
	}
	@RequestMapping(value="/admin/sysUpdate" , method = RequestMethod.POST)
	public String sysUpadte(SystemParam sysParam,@RequestParam(required = false, defaultValue = "0") int id,@RequestParam(required = false, defaultValue = "0") int a,HttpServletResponse response, HttpServletRequest request, Model model){
		
		if(a==4){
			SystemParam sysParams = sysParamService.getSysById(id);
			model.addAttribute("sysParams",sysParams);
			return "admin/sysMsg_edit";
		}
		if(a==2){
			sysParamService.updateSys(sysParam);
			return "redirect:/admin/systemMsg.html";
		}
			return null;
	}
	
	@RequestMapping(value = "/admin/sysDel" , method = RequestMethod.GET)
	public String sysDelGet(SystemParam sysParam,int[] sysId_list,@RequestParam(required = false,defaultValue = "0") int id,
						 @RequestParam(required = false,defaultValue = "0") int a,
						 HttpServletResponse response, HttpServletRequest request, Model model){
		
		if(a==3){
			sysParamService.deleteSys(sysParam);
			return "redirect:/admin/systemMsg.html";
		}if(a==8){
			if(sysId_list!=null && sysId_list.length>0){
				sysParamService.deleteAllSys(sysId_list);
			}
			return "redirect:/admin/systemMsg.html";
		}
		model.addAttribute("a",a);
		return null;
	}
	@RequestMapping(value = "/admin/sysDel" , method = RequestMethod.POST)
	public String sysDel(SystemParam sysParam,int[] sysId_list,@RequestParam(required = false,defaultValue = "0") int id,
						 @RequestParam(required = false,defaultValue = "0") int a,
						 HttpServletResponse response, HttpServletRequest request, Model model){
		
		if(a==3){
			sysParamService.deleteSys(sysParam);
			return "redirect:/admin/systemMsg.html";
		}if(a==8){
			if(sysId_list!=null && sysId_list.length>0){
				sysParamService.deleteAllSys(sysId_list);
			}
			return "redirect:/admin/systemMsg.html";
		}
		model.addAttribute("a",a);
		return null;
	}
}
