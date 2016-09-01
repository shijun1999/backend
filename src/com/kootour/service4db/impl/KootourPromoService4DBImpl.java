package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.KootourPromoMapper;
import com.kootour.mapper.entity.KootourPromoEntity;
import com.kootour.mapper.entity.KootourPromoEntity;
import com.kootour.service4db.KootourPromoService4DB;

@Configuration
@Service
public class KootourPromoService4DBImpl implements KootourPromoService4DB {
	@Autowired
	private KootourPromoMapper kootourPromoMapper;

	@Override
	public List<KootourPromoEntity> selectAll() {
		List<KootourPromoEntity> lstKootourPromoEntity = new ArrayList<KootourPromoEntity>();
		lstKootourPromoEntity = kootourPromoMapper.selectAll();
		return lstKootourPromoEntity;
	}

	@Override
	public List<KootourPromoEntity> selectByPK(KootourPromoEntity tEntity) {
		List<KootourPromoEntity> lstKootourPromoEntity = new ArrayList<KootourPromoEntity>();

		lstKootourPromoEntity = kootourPromoMapper.selectByPK(tEntity);
		return lstKootourPromoEntity;
	}

	@Override
	public List<KootourPromoEntity> selectByCondition(KootourPromoEntity tEntity) {
		List<KootourPromoEntity> lstKootourPromoEntity = new ArrayList<KootourPromoEntity>();

		lstKootourPromoEntity = kootourPromoMapper.selectByCondition(tEntity);
		return lstKootourPromoEntity;
	}

	@Override
	public void insertOne(KootourPromoEntity kootourPromoEntity) {

		kootourPromoMapper.insertOne(kootourPromoEntity);
	}

	@Override
	public void updateByPK(KootourPromoEntity kootourPromoEntity) {

		kootourPromoMapper.updateByPK(kootourPromoEntity);
	}
}
