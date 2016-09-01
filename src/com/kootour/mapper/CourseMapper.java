package com.kootour.mapper;

import java.util.List;

import com.kootour.mapper.entity.CourseEntity;
import com.kootour.mapper.entity.CourseEntity;

public interface CourseMapper {
	List<CourseEntity> selectAll();

	CourseEntity selectByPK(CourseEntity courseEntity);

	List<CourseEntity> selectByCondition(CourseEntity courseEntity);

	void insertOne(CourseEntity courseEntity);

	void updateByPK(CourseEntity courseEntity);

	int selectCountByCondition(CourseEntity courseEntity);

}
