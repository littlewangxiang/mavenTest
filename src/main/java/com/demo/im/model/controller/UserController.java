package com.demo.im.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.im.entity.User;
import com.demo.im.model.service.UserService;

@Controller
@RequestMapping("/UserManager")
public class UserController {
	@Autowired
	private UserService userService;
	private static final Logger log = LoggerFactory.getLogger(User.class);
	
	@RequestMapping("/getUser")
	public String getUser(Model model){
		log.info("<<<<开始获取用户>>>>", "<<<UserManager,getUser>>>");
		User u = userService.selectByPrimaryKey(1);
		model.addAttribute("u", u);
		log.info("<<<<获取用户结束>>>>", "<<<UserManager,getUser>>>");
		return "demo/index";
		
	}
}
