package com.test.demo.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.im.entity.TUser;
import com.demo.im.model.service.TUserService;

public class TUserTest {
	@Autowired
	TUserService userService;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"
				,"classpath:spring-mybatis.xml"});
		userService = (TUserService) context.getBean("tUserService");
	}
	//哈哈
	@Test
	public void testGetUser(){
		TUser user = new TUser();
		user.setUsername("zhanglei");
		List<TUser> u = userService.getUserByParam(user);
		System.out.println(u.size());
	}
}
