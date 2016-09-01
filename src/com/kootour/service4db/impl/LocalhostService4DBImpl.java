package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.LocalhostMapper;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.service4db.LocalhostService4DB;

@Configuration
@Service
public class LocalhostService4DBImpl implements LocalhostService4DB {

	@Resource
	private LocalhostMapper localhostMapper;

	@Override
	public List<LocalhostEntity> selectAll() {
		List<LocalhostEntity> lstLocalhostEntity = new ArrayList<LocalhostEntity>();
		lstLocalhostEntity = localhostMapper.selectAll();
		return lstLocalhostEntity;
	}

	@Override
	public List<LocalhostEntity> selectByPK(LocalhostEntity tEntity) {
		List<LocalhostEntity> lstLocalhostEntity = new ArrayList<LocalhostEntity>();

		lstLocalhostEntity = localhostMapper.selectByPK(tEntity);
		return lstLocalhostEntity;
	}

	@Override
	public List<LocalhostEntity> selectByCondition(LocalhostEntity tEntity) {
		List<LocalhostEntity> lstLocalhostEntity = new ArrayList<LocalhostEntity>();

		lstLocalhostEntity = localhostMapper.selectByCondition(tEntity);
		return lstLocalhostEntity;
	}

	@Override
	public void insertOne(LocalhostEntity localhostEntity) {
		localhostMapper.insertOne(localhostEntity);
	}

	@Override
	public void updateByPK(LocalhostEntity localhostEntity) {

		localhostMapper.updateByPK(localhostEntity);
	}

}
