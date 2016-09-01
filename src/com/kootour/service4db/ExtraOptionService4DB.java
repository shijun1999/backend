package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.ExtraOptionEntity;

public interface ExtraOptionService4DB {
	List<ExtraOptionEntity> selectAll();

	List<ExtraOptionEntity> selectByPK(ExtraOptionEntity extraOptionParamEntity);

	List<ExtraOptionEntity> selectByCondition(ExtraOptionEntity extraOptionParamEntity);

	void insertOne(ExtraOptionEntity ExtraOptionEntity);

	void updateByPK(ExtraOptionEntity ExtraOptionEntity);
}
