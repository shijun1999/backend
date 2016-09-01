package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.CourseInExclusionMapper;
import com.kootour.mapper.entity.CourseInExclusionEntity;
import com.kootour.mapper.entity.CourseInExclusionEntity;
import com.kootour.service4db.CourseInExclusionService4DB;

@Configuration
@Service
public class CourseInExclusionService4DBImpl implements CourseInExclusionService4DB {
	@Autowired
	private CourseInExclusionMapper courseInExclusionMapper;

	@Override
	public List<CourseInExclusionEntity> selectAll() {
		List<CourseInExclusionEntity> lstCourseInExclusionEntity = new ArrayList<CourseInExclusionEntity>();
		lstCourseInExclusionEntity = courseInExclusionMapper.selectAll();
		return lstCourseInExclusionEntity;
	}

	@Override
	public List<CourseInExclusionEntity> selectByPK(CourseInExclusionEntity tEntity) {
		List<CourseInExclusionEntity> lstCourseInExclusionEntity = new ArrayList<CourseInExclusionEntity>();

		lstCourseInExclusionEntity = courseInExclusionMapper.selectByPK(tEntity);
		return lstCourseInExclusionEntity;
	}

	@Override
	public List<CourseInExclusionEntity> selectByCondition(CourseInExclusionEntity tEntity) {
		List<CourseInExclusionEntity> lstCourseInExclusionEntity = new ArrayList<CourseInExclusionEntity>();

		lstCourseInExclusionEntity = courseInExclusionMapper.selectByCondition(tEntity);
		return lstCourseInExclusionEntity;
	}

	@Override
	public void insertOne(CourseInExclusionEntity courseInExclusionEntity) {

		courseInExclusionMapper.insertOne(courseInExclusionEntity);
	}

	@Override
	public void updateByPK(CourseInExclusionEntity courseInExclusionEntity) {

		courseInExclusionMapper.updateByPK(courseInExclusionEntity);
	}
}
