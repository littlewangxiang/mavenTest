package com.demo.im.model.core.support;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAccessDecisionManager implements AccessDecisionManager{

	/**
	 * 1、configAttributes  装载了从数据库读取出来的url允许的角色数据。这里是从mysecurityMetadatasource里的loadResourceDefine方法里的atts对象取出的角色数据赋予了configattributes对象
	 * 2、authentication  装载了从数据库读出来的角色数据。这里是从myuserdetailService里的loadUserByUsername方法里的auths对象的值传递过来的authentication对象
	 */
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		
		if(configAttributes == null){
			return ;
		}
		
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		
		while(ite.hasNext()){
			
			ConfigAttribute ca = ite.next();
			String needRole = ca.getAttribute();
			
			for(GrantedAuthority ga : authentication.getAuthorities()){
				//判断两个请求的url页面的权限和用户的权限是否相同，如相同，允许
				if(needRole.equals(ga.getAuthority())){
					return;
				}
			}
		}
		//如果上面的needRole和ga.getauthority两个权限没有匹配
		throw new AccessDeniedException("Access Denied");
		
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
