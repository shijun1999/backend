package com.kootour.mapper;

import java.util.List;

import com.kootour.mapper.entity.TouristEntity;

public interface TouristMapper {
	List<TouristEntity> selectAll();

	TouristEntity selectByPK(TouristEntity touristEntity);

	List<TouristEntity> selectByCondition(TouristEntity touristEntity);

	void insertOne(TouristEntity touristEntity);

	void updateByPK(TouristEntity touristEntity);

}
