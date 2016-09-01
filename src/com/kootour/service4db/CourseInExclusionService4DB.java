package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.CourseInExclusionEntity;

public interface CourseInExclusionService4DB {
	List<CourseInExclusionEntity> selectAll();

	List<CourseInExclusionEntity> selectByPK(CourseInExclusionEntity courseInExclusionEntity);

	List<CourseInExclusionEntity> selectByCondition(CourseInExclusionEntity courseInExclusionEntity);

	void insertOne(CourseInExclusionEntity CourseInExclusionEntity);

	void updateByPK(CourseInExclusionEntity CourseInExclusionEntity);

}
