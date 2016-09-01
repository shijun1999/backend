package com.kootour.mapper;

import java.util.List;

import com.kootour.mapper.entity.CourseScheduleEntity;
import com.kootour.mapper.entity.CourseScheduleEntity;

public interface CourseScheduleMapper {
	List<CourseScheduleEntity> selectAll();

	List<CourseScheduleEntity> selectByPK(CourseScheduleEntity courseScheduleEntity);

	List<CourseScheduleEntity> selectByCondition(CourseScheduleEntity courseScheduleEntity);

	List<CourseScheduleEntity> selectDistinctWorkDate(CourseScheduleEntity courseScheduleEntity);

	void insertOne(CourseScheduleEntity courseScheduleEntity);

	void updateByPK(CourseScheduleEntity courseScheduleEntity);

}
