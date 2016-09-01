package com.kootour.mapper;

import java.util.List;

import com.kootour.mapper.entity.ExtraOptionEntity;

public interface ExtraOptionMapper {
	List<ExtraOptionEntity> selectAll();

	List<ExtraOptionEntity> selectByPK(ExtraOptionEntity extraOptionParamEntity);

	List<ExtraOptionEntity> selectByCondition(ExtraOptionEntity extraOptionParamEntity);

	void insertOne(ExtraOptionEntity extraOptionEntity);

	void updateByPK(ExtraOptionEntity extraOptionEntity);

}
