package com.test.demo.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.im.entity.TResource;
import com.demo.im.model.service.TResourceService;
import com.demo.im.model.service.TUserService;

public class TestResource {

	@Autowired
	private TResourceService resService;

	@Before
	public void before() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring.xml",
						"classpath:spring-mybatis.xml" });
		resService = (TResourceService) context.getBean("tResourceService");
	}

	@Test
	public void tResourceService() {
		TResource res = new TResource();
		res.setType("URL");
		List<TResource> listRes = resService.getResByParam(res);
		if (listRes != null && listRes.size() > 0) {
			for(int i=0; i<listRes.size();i++){
				System.out.println(listRes.get(i));
			}
		}
	}
}
