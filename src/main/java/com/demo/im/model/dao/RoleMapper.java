package com.demo.im.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.im.entity.Role;

@Repository(value="roleDao")
public interface RoleMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectAllRoleByParam(Role role);
}