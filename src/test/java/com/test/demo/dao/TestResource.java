package com.test.demo.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.im.entity.TResource;
import com.demo.im.model.dao.TResourceMapper;

public class TestResource {
	
	private TResourceMapper resDao;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"
				,"classpath:spring-mybatis.xml"});
		resDao = (TResourceMapper) context.getBean("rResourceDao");
	}
	@Test
	public void testSelect(){
		TResource res = resDao.selectByPrimaryKey(1);
		System.out.println(res.getResname());
	}
	@Test
	public void testByParam(){
		TResource res = new TResource();
		res.setType("URL");
		List<TResource> resList= resDao.selectByParam(res);
		if(resList!=null && resList.size()>0){
			for(int i =0; i<resList.size();i++){
				System.out.println(resList.get(i));
			}
		}
		
	}
}
