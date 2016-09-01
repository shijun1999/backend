package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.CourseScheduleEntity;

public interface CourseScheduleService4DB {

	List<CourseScheduleEntity> selectAll();

	List<CourseScheduleEntity> selectByPK(CourseScheduleEntity courseScheduleEntity);

	List<CourseScheduleEntity> selectByCondition(CourseScheduleEntity courseScheduleEntity);

	List<CourseScheduleEntity> selectDistinctWorkDate(CourseScheduleEntity courseScheduleEntity);

	void insertOne(CourseScheduleEntity CourseScheduleEntity);

	void updateByPK(CourseScheduleEntity CourseScheduleEntity);

}
