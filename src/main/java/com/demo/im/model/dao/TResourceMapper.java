package com.demo.im.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.im.entity.TResource;

@Repository(value="rResourceDao")
public interface TResourceMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(TResource record);

    int insertSelective(TResource record);

    TResource selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(TResource record);

    int updateByPrimaryKey(TResource record);
    
    List<TResource> selectByParam(TResource res);
}