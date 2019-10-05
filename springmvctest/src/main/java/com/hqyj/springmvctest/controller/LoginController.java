package com.hqyj.springmvctest.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class LoginController {
	
	public LoginController(){
		System.out.println("LoginController构造函数");
	}
	@RequestMapping(value="static.do",method=RequestMethod.GET)
	public String statics(){
		
		return "redirect:/static/test.html";
	}
	@RequestMapping(value="index.do",method=RequestMethod.GET)
	public String index(){
		
		return "index";
	}
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login(String userName,String userPwd,RedirectAttributes rs){
		System.out.println("userName="+userName);
		System.out.println("userPwd="+userPwd);
		if(!userName.equals("admin")){
			rs.addAttribute("info", "用户名不正确");
			return "redirect:login.jsp";
		}
		return "index";
	}
	/**
	 * 
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	@RequestMapping(value="loginAjax.do",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> loginAjax(String userName,String userPwd){
		System.out.println("userName="+userName);
		System.out.println("userPwd="+userPwd);
		HashMap<String,Object> map = new HashMap<String,Object>();
		if(!userName.equals("admin")){
			
			 map.put("info", false);
		}else{
			map.put("info", true);
		}
		return map;
	}
	
	
}
