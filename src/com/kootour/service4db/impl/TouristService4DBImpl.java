package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.TouristMapper;
import com.kootour.mapper.entity.TouristEntity;
import com.kootour.service4db.TouristService4DB;

@Configuration
@Service
public class TouristService4DBImpl implements TouristService4DB {
	@Autowired
	private TouristMapper touristMapper;

	@Override
	public List<TouristEntity> selectAll() {
		List<TouristEntity> lstTouristEntity = new ArrayList<TouristEntity>();
		lstTouristEntity = touristMapper.selectAll();
		return lstTouristEntity;
	}

	@Override
	public TouristEntity selectByPK(TouristEntity tEntity) {
		TouristEntity lstTouristEntity = new TouristEntity();

		lstTouristEntity = touristMapper.selectByPK(tEntity);
		return lstTouristEntity;
	}

	@Override
	public List<TouristEntity> selectByCondition(TouristEntity tEntity) {
		List<TouristEntity> lstTouristEntity = new ArrayList<TouristEntity>();

		lstTouristEntity = touristMapper.selectByCondition(tEntity);
		return lstTouristEntity;
	}

	@Override
	public void insertOne(TouristEntity touristEntity) {

		touristMapper.insertOne(touristEntity);
	}

	@Override
	public void updateByPK(TouristEntity touristEntity) {

		touristMapper.updateByPK(touristEntity);
	}

}
