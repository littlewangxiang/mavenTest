package com.demo.im.model.service;

import java.util.List;

import com.demo.im.entity.TUser;

public interface TUserService {
	
	public TUser getUserAndRole(Integer id);
	
	public TUser getUserById(Integer id);
	
	public List<TUser> getUserByParam(TUser user);
}
