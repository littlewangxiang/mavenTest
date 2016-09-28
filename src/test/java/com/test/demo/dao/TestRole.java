package com.test.demo.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.im.entity.Role;
import com.demo.im.model.dao.RoleMapper;

public class TestRole {
	
	private RoleMapper roleDao;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"
				,"classpath:spring-mybatis.xml"});
		roleDao = (RoleMapper) context.getBean("roleDao");
	}
	@Test
	public void getRole(){
		Role role = roleDao.selectByPrimaryKey(1);
		System.out.println(role.getRgId().getRgName());
	}
	@Test
	public void getRolebyParam(){
		List<Role> role= roleDao.selectAllRoleByParam(new Role());
		System.out.println(role);
	}
}
