package com.demo.im.model.dao;

import com.demo.im.entity.ResRole;

public interface ResRoleMapper {
    int insert(ResRole record);

    int insertSelective(ResRole record);
}