package com.demo.im.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.im.entity.TResource;
import com.demo.im.model.dao.TResourceMapper;
import com.demo.im.model.service.TResourceService;

@Service(value = "tResourceService")
public class TResourceServiceImp implements TResourceService {
	@Autowired
	TResourceMapper resDao;

	@Override
	public List<TResource> getResByParam(TResource res) {
		List<TResource> resList = null;
		if (res != null) {
			resList = resDao.selectByParam(res);
		}
		// TODO Auto-generated method stub
		return resList;
	}

}
