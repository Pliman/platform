/*
 * PersonController.java 2011-12-28
 * 智域工作室
 */
package net.intellizone.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.intellizone.demo.model.Person;
import net.intellizone.demo.services.PersonService;

/**
 * 用户控制器
 * 
 * @author Pliman
 * @version 1.0
 * @since demo 1.0
 */
@Controller
public class PersonController {
	// 用户服务
	@Autowired
	private PersonService personService;

	/**
	 * 获取人员
	 * 
	 * @param type
	 *            类型
	 * @param id
	 *            id
	 * @param person
	 *            人员
	 * @param request
	 *            请求
	 * @param model
	 *            前端数据对象
	 * @return 前端页面代码
	 */
	@RequestMapping(value = "/demo/person/{type}/{id}", method = RequestMethod.GET)
	public String addCart(@PathVariable
	String type, @PathVariable
	int id, Person person, HttpServletRequest request, Model model) {
		if (type != null) {
			if (type.equals("list")) {// 查询所有人
				List<Person> personList = personService.getAllPerson();
				model.addAttribute("personList", personList);
				return "list";
			} else if (type.equals("edit")) {
				if (person != null) {
					personService.updatePerson(person);
				}
			}
		}

		// List<Person> personList=new ArrayList<Persion>();
		return "list";
	}

}
