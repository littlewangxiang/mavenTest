package com.test.demo.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.im.entity.User;
import com.demo.im.model.service.UserService;

public class UserTest {
	
	private UserService userService;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"
				,"classpath:spring-mybatis.xml"});
		userService = (UserService) context.getBean("userService");
	}
	//哈哈
	@Test
	public void testGetUser(){
		User u = userService.selectByPrimaryKey(1);
		System.out.println(u.getuUsername());
	}
}
