package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.CourseEntity;

public interface CourseService4DB {

	List<CourseEntity> selectAll();

	CourseEntity selectByPK(CourseEntity courseEntity);

	List<CourseEntity> selectByCondition(CourseEntity courseEntity);

	void insertOne(CourseEntity CourseEntity);

	void updateByPK(CourseEntity CourseEntity);

	int selectCountByCondition(CourseEntity courseEntity);

}
