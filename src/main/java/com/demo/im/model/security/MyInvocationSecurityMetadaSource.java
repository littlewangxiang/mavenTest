package com.demo.im.model.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.demo.im.entity.TResource;
import com.demo.im.model.dao.TResourceMapper;
@Service
public class MyInvocationSecurityMetadaSource 
	implements FilterInvocationSecurityMetadataSource{

//	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	private static Map<String,Collection<ConfigAttribute>> resourceMap = null;
	@Autowired
	private TResourceMapper resDao;
	
	public MyInvocationSecurityMetadaSource(){
		loadResourceDefine();
	}
	
	private void loadResourceDefine(){
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
		
//		ConfigAttribute ca = new SecurityConfig("ROLE_ADMIN");
//		
//		atts.add(ca);
//		resourceMap.put("/user.jsp", atts);
//		resourceMap.put("/admin.jsp", atts);
//		resourceMap.put("/index.jsp",atts);
		
	}
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String url = ((FilterInvocation)object).getRequestUrl();
		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();

		List<TResource> resList = resDao.selectByParam(null);
		if(resList!=null && resList.size()>0){
			for(TResource res : resList){
				if(url.equalsIgnoreCase(res.getValue())){
					String role = res.getRoles().get(0).getRolecode();
					atts.add(new SecurityConfig(role));
					return atts;
				}
			}
		}
		
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
