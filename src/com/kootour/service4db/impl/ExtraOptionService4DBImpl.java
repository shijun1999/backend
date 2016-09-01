package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.ExtraOptionMapper;
import com.kootour.mapper.entity.ExtraOptionEntity;
import com.kootour.service4db.ExtraOptionService4DB;

@Configuration
@Service
public class ExtraOptionService4DBImpl implements ExtraOptionService4DB {
	@Autowired
	private ExtraOptionMapper extraOptionMapper;

	@Override
	public List<ExtraOptionEntity> selectAll() {
		List<ExtraOptionEntity> lstExtraOptionEntity = new ArrayList<ExtraOptionEntity>();
		lstExtraOptionEntity = extraOptionMapper.selectAll();
		return lstExtraOptionEntity;
	}

	@Override
	public List<ExtraOptionEntity> selectByPK(ExtraOptionEntity tParamEntity) {
		List<ExtraOptionEntity> lstExtraOptionEntity = new ArrayList<ExtraOptionEntity>();

		lstExtraOptionEntity = extraOptionMapper.selectByPK(tParamEntity);
		return lstExtraOptionEntity;
	}

	@Override
	public List<ExtraOptionEntity> selectByCondition(ExtraOptionEntity tParamEntity) {
		List<ExtraOptionEntity> lstExtraOptionEntity = new ArrayList<ExtraOptionEntity>();

		lstExtraOptionEntity = extraOptionMapper.selectByCondition(tParamEntity);
		return lstExtraOptionEntity;
	}

	@Override
	public void insertOne(ExtraOptionEntity extraOptionEntity) {

		extraOptionMapper.insertOne(extraOptionEntity);
	}

	@Override
	public void updateByPK(ExtraOptionEntity extraOptionEntity) {

		extraOptionMapper.updateByPK(extraOptionEntity);
	}

}