package com.demo.im.model.service;

import com.demo.im.entity.User;

public interface UserService {
	public User selectByPrimaryKey(Integer uid);
}
