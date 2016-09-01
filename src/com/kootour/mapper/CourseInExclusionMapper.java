package com.kootour.mapper;

import java.util.List;

import com.kootour.mapper.entity.CourseInExclusionEntity;
import com.kootour.mapper.entity.CourseInExclusionEntity;

public interface CourseInExclusionMapper {
	List<CourseInExclusionEntity> selectAll();

	List<CourseInExclusionEntity> selectByPK(CourseInExclusionEntity courseInExclusionEntity);

	List<CourseInExclusionEntity> selectByCondition(CourseInExclusionEntity courseInExclusionEntity);

	void insertOne(CourseInExclusionEntity courseInExclusionEntity);

	void updateByPK(CourseInExclusionEntity courseInExclusionEntity);

}
