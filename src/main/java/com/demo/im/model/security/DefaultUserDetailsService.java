package com.demo.im.model.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.demo.im.entity.Role;
import com.demo.im.entity.TUser;
import com.demo.im.model.dao.TUserMapper;
@Service
public class DefaultUserDetailsService implements UserDetailsService {
	@Autowired
	TUserMapper userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("userDetail********");
		Collection <GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		TUser userParam = new TUser();
		TUser user =null;
		if(!StringUtils.isEmpty(username)){
			userParam.setUsername(username);
			List<TUser> users = userDao.selectByUserParam(userParam);
			if(users!=null && users.size()>0){
				user = users.get(0);
				if(user.getRoles()!=null && user.getRoles().size()>0){
					for(Role role : user.getRoles()){
						GrantedAuthority auth2 = new GrantedAuthorityImpl(role.getRolecode());
						auths.add(auth2);
					}
					user.setAuthorities(auths);
				}
			}
		}
		return user;
	}

}
