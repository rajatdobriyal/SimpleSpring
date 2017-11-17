package com.netgear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netgear.service.impl.SaveInDbServiceImpl;

@Controller
public class StartController {

	@Autowired
	private SaveInDbServiceImpl saveService;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(@RequestParam("userName") String userName, @RequestParam("password") String password ,Model model) {
		System.out.println(userName);
		System.out.println(password);
		saveService.saveInDb(userName,password);
		model.addAttribute("name", userName);
		return "welcome";
	}
//	@RequestMapping(path= "/greet/{name}",method=RequestMethod.GET)    
//	public String greet(@PathVariable String name, ModelMap model){
//		String greet =" Hello !!!" + name + " How are You?";
//		model.addAttribute("greet", greet);
//		System.out.println(greet);
//
//		return "greet";
//	}
}
