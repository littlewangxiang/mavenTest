package com.demo.im.model.core.support;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.im.entity.TUser;
import com.demo.im.model.core.SecurityManager;
import com.demo.im.model.service.TUserService;

public class SecurityManagerSupport implements UserDetailsService,SecurityManager {
	@Autowired
	TUserService userService;
	
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
		
		if(user1!=null){
			//获取用户的权限
			
		}
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		
		
		return null;
	}

	@Override
	public Map<String, String> loadUrlAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
