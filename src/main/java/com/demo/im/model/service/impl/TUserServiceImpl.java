package com.demo.im.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.demo.im.entity.TUser;
import com.demo.im.model.dao.TUserMapper;
import com.demo.im.model.service.TUserService;

@Service
public class TUserServiceImpl implements TUserService {
	
	@Autowired
	private TUserMapper tUserDao;
	
	/**
	 * 获取用户信息以及权限信息
	 */
	@Override
	public TUser getUserAndRole(Integer id) {
		// TODO Auto-generated method stub
		TUser user = null;
		if(id>0){
			user = tUserDao.selectUserRole(id);
		}
		return user;
	}
	/**
	 * 获取用户信息（不包含权限信息）
	 */
	@Override
	public TUser getUserById(Integer id) {
		// TODO Auto-generated method stub
		TUser user = null;
		if(id>0){
			user = tUserDao.selectByPrimaryKey(id);
		}
		return user;
	}
	@Override
	public List<TUser> getUserByParam(TUser user) {
		// TODO Auto-generated method stub
		return tUserDao.selectByUserParam(user);
	}
	
	

}
