package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.KootourMstEntity;

public interface KootourMstService4DB {
	List<KootourMstEntity> selectAll();

	List<KootourMstEntity> selectByPK(KootourMstEntity kootourMstEntity);

	List<KootourMstEntity> selectByCondition(KootourMstEntity kootourMstEntity);

	void insertOne(KootourMstEntity KootourMstEntity);

	void updateByPK(KootourMstEntity KootourMstEntity);

}
