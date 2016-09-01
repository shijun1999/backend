package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.LocationMstEntity;

public interface LocationMstService4DB {

	List<LocationMstEntity> selectAll();

	List<LocationMstEntity> selectByPK(LocationMstEntity locationMstEntity);

	List<LocationMstEntity> selectByCondition(LocationMstEntity locationMstEntity);

	void insertOne(LocationMstEntity LocationMstEntity);

	void updateByPK(LocationMstEntity LocationMstEntity);

}
