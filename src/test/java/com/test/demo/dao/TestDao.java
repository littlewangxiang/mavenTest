package com.test.demo.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.im.entity.TUser;
import com.demo.im.model.dao.TUserMapper;

public class TestDao {
	@Autowired
	private TUserMapper tUserDao;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"
				,"classpath:spring-mybatis.xml"});
		tUserDao = (TUserMapper) context.getBean("tUserDao");
	}
	
	@Test
	public void getUser(){
		TUser user= tUserDao.selectUserRole(4);
		System.out.println(user.getUsername());
	}
	
	@Test
	public void getUserByParam(){
		TUser u = new TUser();
		u.setUsername("zhanglei");
		List<TUser> user= tUserDao.selectByUserParam(u);
		System.out.println(user.get(0).getUsername());
	}
	
}
