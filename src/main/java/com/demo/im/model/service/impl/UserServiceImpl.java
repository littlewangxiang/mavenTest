package com.demo.im.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.im.entity.User;
import com.demo.im.model.dao.UserMapper;
import com.demo.im.model.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userDao;
	
	@Override
	public User selectByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(uid);
	}

}
