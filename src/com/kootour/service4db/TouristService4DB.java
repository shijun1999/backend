package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.TouristEntity;

public interface TouristService4DB {

	List<TouristEntity> selectAll();

	TouristEntity selectByPK(TouristEntity touristEntity);

	List<TouristEntity> selectByCondition(TouristEntity touristEntity);

	void insertOne(TouristEntity TouristEntity);

	void updateByPK(TouristEntity TouristEntity);

}
