package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.LocationMstMapper;
import com.kootour.mapper.entity.LocationMstEntity;
import com.kootour.mapper.entity.LocationMstEntity;
import com.kootour.service4db.LocationMstService4DB;

@Configuration
@Service
public class LocationMstService4DBImpl implements LocationMstService4DB {
	@Autowired
	private LocationMstMapper locationMstMapper;

	@Override
	public List<LocationMstEntity> selectAll() {
		List<LocationMstEntity> lstLocationMstEntity = new ArrayList<LocationMstEntity>();
		lstLocationMstEntity = locationMstMapper.selectAll();
		return lstLocationMstEntity;
	}

	@Override
	public List<LocationMstEntity> selectByPK(LocationMstEntity tEntity) {
		List<LocationMstEntity> lstLocationMstEntity = new ArrayList<LocationMstEntity>();

		lstLocationMstEntity = locationMstMapper.selectByPK(tEntity);
		return lstLocationMstEntity;
	}

	@Override
	public List<LocationMstEntity> selectByCondition(LocationMstEntity tEntity) {
		List<LocationMstEntity> lstLocationMstEntity = new ArrayList<LocationMstEntity>();

		lstLocationMstEntity = locationMstMapper.selectByCondition(tEntity);
		return lstLocationMstEntity;
	}

	@Override
	public void insertOne(LocationMstEntity locationMstEntity) {

		locationMstMapper.insertOne(locationMstEntity);
	}

	@Override
	public void updateByPK(LocationMstEntity locationMstEntity) {

		locationMstMapper.updateByPK(locationMstEntity);
	}

}
