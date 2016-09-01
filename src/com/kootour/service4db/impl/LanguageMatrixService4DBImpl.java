package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.LanguageMatrixMapper;
import com.kootour.mapper.entity.LanguageMatrixEntity;
import com.kootour.mapper.entity.LanguageMatrixEntity;
import com.kootour.service4db.LanguageMatrixService4DB;

@Configuration
@Service
public class LanguageMatrixService4DBImpl implements LanguageMatrixService4DB {
	@Autowired
	private LanguageMatrixMapper languageMatrixMapper;

	@Override
	public List<LanguageMatrixEntity> selectAll() {
		List<LanguageMatrixEntity> lstLanguageMatrixEntity = new ArrayList<LanguageMatrixEntity>();
		lstLanguageMatrixEntity = languageMatrixMapper.selectAll();
		return lstLanguageMatrixEntity;
	}

	@Override
	public List<LanguageMatrixEntity> selectByPK(LanguageMatrixEntity tEntity) {
		List<LanguageMatrixEntity> lstLanguageMatrixEntity = new ArrayList<LanguageMatrixEntity>();

		lstLanguageMatrixEntity = languageMatrixMapper.selectByPK(tEntity);
		return lstLanguageMatrixEntity;
	}

	@Override
	public List<LanguageMatrixEntity> selectByCondition(LanguageMatrixEntity tEntity) {
		List<LanguageMatrixEntity> lstLanguageMatrixEntity = new ArrayList<LanguageMatrixEntity>();

		lstLanguageMatrixEntity = languageMatrixMapper.selectByCondition(tEntity);
		return lstLanguageMatrixEntity;
	}

	@Override
	public void insertOne(LanguageMatrixEntity languageMatrixEntity) {

		languageMatrixMapper.insertOne(languageMatrixEntity);
	}

	@Override
	public void updateByPK(LanguageMatrixEntity languageMatrixEntity) {

		languageMatrixMapper.updateByPK(languageMatrixEntity);
	}
}
