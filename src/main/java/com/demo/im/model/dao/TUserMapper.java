package com.demo.im.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.im.entity.TUser;

@Repository(value="tUserDao")
public interface TUserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    TUser selectUserRole(Integer uId);
    
    List<TUser> selectByUserParam(TUser user);
}