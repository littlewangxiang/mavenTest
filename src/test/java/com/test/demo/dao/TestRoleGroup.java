package com.test.demo.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.im.entity.RoleGroup;
import com.demo.im.model.dao.RoleGroupMapper;

public class TestRoleGroup {
	
	private RoleGroupMapper roleGroupDao;
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"
				,"classpath:spring-mybatis.xml"});
		roleGroupDao = (RoleGroupMapper) context.getBean("roleGroupDao");
	}
	@Test
	public void getRoleGroup(){
		RoleGroup roleG = roleGroupDao.selectByPrimaryKey(1);
		
		System.out.println(roleG.getRgName());
	}
}
