package com.demo.im.model.dao;

import com.demo.im.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}