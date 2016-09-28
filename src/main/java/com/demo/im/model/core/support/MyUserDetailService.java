package com.demo.im.model.core.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.im.entity.TUser;
import com.demo.im.model.dao.TUserMapper;

public class MyUserDetailService implements UserDetailsService{
	@Autowired
	private TUserMapper userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		TUser tu = new TUser();
		tu.setUsername(username);
		
		List<TUser> userLogs = userDao.selectByUserParam(tu);
		User user = null;
		if(userLogs!=null && userLogs.size()>0){
			TUser userLogin = userLogs.get(0);
			if("ADMIN".equalsIgnoreCase(userLogin.getUserRole())){
				auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			}
			if("USER".equalsIgnoreCase(userLogin.getUserRole())){
				auths.add(new SimpleGrantedAuthority("ROLE_USER"));
			}
			
			user = new User(userLogin.getUsername(),
	                userLogin.getPassword(), true, true, true, true, auths);
		}
		return user;
	}

}
