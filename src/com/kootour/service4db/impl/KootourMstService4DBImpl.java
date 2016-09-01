package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.KootourMstMapper;
import com.kootour.mapper.entity.KootourMstEntity;
import com.kootour.mapper.entity.KootourMstEntity;
import com.kootour.service4db.KootourMstService4DB;

@Configuration
@Service
public class KootourMstService4DBImpl implements KootourMstService4DB {
	@Autowired
	private KootourMstMapper kootourMstMapper;

	@Override
	public List<KootourMstEntity> selectAll() {
		List<KootourMstEntity> lstKootourMstEntity = new ArrayList<KootourMstEntity>();
		lstKootourMstEntity = kootourMstMapper.selectAll();
		return lstKootourMstEntity;
	}

	@Override
	public List<KootourMstEntity> selectByPK(KootourMstEntity tEntity) {
		List<KootourMstEntity> lstKootourMstEntity = new ArrayList<KootourMstEntity>();

		lstKootourMstEntity = kootourMstMapper.selectByPK(tEntity);
		return lstKootourMstEntity;
	}

	@Override
	public List<KootourMstEntity> selectByCondition(KootourMstEntity tEntity) {
		List<KootourMstEntity> lstKootourMstEntity = new ArrayList<KootourMstEntity>();

		lstKootourMstEntity = kootourMstMapper.selectByCondition(tEntity);
		return lstKootourMstEntity;
	}

	@Override
	public void insertOne(KootourMstEntity kootourMstEntity) {

		kootourMstMapper.insertOne(kootourMstEntity);
	}

	@Override
	public void updateByPK(KootourMstEntity kootourMstEntity) {

		kootourMstMapper.updateByPK(kootourMstEntity);
	}
}
