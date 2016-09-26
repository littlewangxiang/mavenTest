package com.demo.im.model.core.support;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.im.entity.Role;
import com.demo.im.entity.TResource;
import com.demo.im.entity.TUser;
import com.demo.im.model.core.SecurityManager;
import com.demo.im.model.service.TResourceService;
import com.demo.im.model.service.TUserService;

public class SecurityManagerSupport implements UserDetailsService,SecurityManager {
	@Autowired
	TUserService userService;
	@Autowired
	TResourceService resService;
	
	@Override
	public UserDetails loadUserByUsername(String data)
			throws UsernameNotFoundException {
		String[] list = data.split(",");
		String userName = list[0];
		String loginRole = "user";
		if(list.length==2){
			loginRole = list[1];
		}
		//查询用户
		TUser user = new TUser();
		user.setUsername(userName);
		List<TUser> users = userService.getUserByParam(user);
		if (users.isEmpty()) {
			throw new UsernameNotFoundException("User " + userName
					+ " has no GrantedAuthority");
		}
		TUser user1 = users.get(0);
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		if(user1!=null && user1.getRoles()!=null){
			
			Iterator<Role> roleIterator = user.getRoles().iterator();
			
			while (roleIterator.hasNext()) {
				Role role = roleIterator.next();
				
				if (loginRole.equalsIgnoreCase("ADMIN")) {//超级管理员只加载admin权限
					if("ADMIN".equals(role.getType())){
						GrantedAuthority grantedAuthority = new GrantedAuthorityImpl(
								role.getRolecode().toUpperCase());
						authorities.add(grantedAuthority);
					}
				}
				if (loginRole.equalsIgnoreCase("USER")) {// 普通买家登录，不加载商家和管理员权限
					if("USER".equals(role.getType())){
						GrantedAuthority grantedAuthority = new GrantedAuthorityImpl(
								role.getRolecode().toUpperCase());
						authorities.add(grantedAuthority);
					}
				}
			}
			
		}
		GrantedAuthority[] auths = new GrantedAuthority[authorities.size()];
		user.setAuthorities(authorities);
		return user;
	}

	@Override
	public Map<String, String> loadUrlAuthorities() {

		Map<String, String> urlAuthorities = new HashMap<String, String>();
		TResource res = new TResource();
		res.setType("URL");
		List<TResource> resList = resService.getResByParam(res);
		for (TResource resTemp : resList) {
			urlAuthorities.put(res.getValue(), res.getRoleAuthorities());
		}
		return urlAuthorities;
	}

}
