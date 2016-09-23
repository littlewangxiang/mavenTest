package com.demo.im.model.dao;

import org.springframework.stereotype.Repository;

import com.demo.im.entity.RoleGroup;

@Repository(value="roleGroupDao")
public interface RoleGroupMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(RoleGroup record);

    int insertSelective(RoleGroup record);

    RoleGroup selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(RoleGroup record);

    int updateByPrimaryKey(RoleGroup record);
}