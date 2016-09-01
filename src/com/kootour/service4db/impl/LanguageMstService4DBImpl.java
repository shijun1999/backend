package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.LanguageMstMapper;
import com.kootour.mapper.entity.LanguageMstEntity;
import com.kootour.mapper.entity.LanguageMstEntity;
import com.kootour.service4db.LanguageMstService4DB;

@Configuration
@Service
public class LanguageMstService4DBImpl implements LanguageMstService4DB {
	@Autowired
	private LanguageMstMapper languageMstMapper;

	@Override
	public List<LanguageMstEntity> selectAll() {
		List<LanguageMstEntity> lstLanguageMstEntity = new ArrayList<LanguageMstEntity>();
		lstLanguageMstEntity = languageMstMapper.selectAll();
		return lstLanguageMstEntity;
	}

	@Override
	public List<LanguageMstEntity> selectByPK(LanguageMstEntity tEntity) {
		List<LanguageMstEntity> lstLanguageMstEntity = new ArrayList<LanguageMstEntity>();

		lstLanguageMstEntity = languageMstMapper.selectByPK(tEntity);
		return lstLanguageMstEntity;
	}

	@Override
	public List<LanguageMstEntity> selectByCondition(LanguageMstEntity tEntity) {
		List<LanguageMstEntity> lstLanguageMstEntity = new ArrayList<LanguageMstEntity>();

		lstLanguageMstEntity = languageMstMapper.selectByCondition(tEntity);
		return lstLanguageMstEntity;
	}

	@Override
	public void insertOne(LanguageMstEntity languageMstEntity) {

		languageMstMapper.insertOne(languageMstEntity);
	}

	@Override
	public void updateByPK(LanguageMstEntity languageMstEntity) {

		languageMstMapper.updateByPK(languageMstEntity);
	}
}
