package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.CourseScheduleMapper;
import com.kootour.mapper.entity.CourseScheduleEntity;
import com.kootour.mapper.entity.CourseScheduleEntity;
import com.kootour.service4db.CourseScheduleService4DB;

@Configuration
@Service
public class CourseScheduleService4DBImpl implements CourseScheduleService4DB {
	@Autowired
	private CourseScheduleMapper courseScheduleMapper;

	@Override
	public List<CourseScheduleEntity> selectAll() {
		List<CourseScheduleEntity> lstCourseScheduleEntity = new ArrayList<CourseScheduleEntity>();
		lstCourseScheduleEntity = courseScheduleMapper.selectAll();
		return lstCourseScheduleEntity;
	}

	@Override
	public List<CourseScheduleEntity> selectByPK(CourseScheduleEntity tEntity) {
		List<CourseScheduleEntity> lstCourseScheduleEntity = new ArrayList<CourseScheduleEntity>();

		lstCourseScheduleEntity = courseScheduleMapper.selectByPK(tEntity);
		return lstCourseScheduleEntity;
	}

	@Override
	public List<CourseScheduleEntity> selectDistinctWorkDate(CourseScheduleEntity tEntity) {
		List<CourseScheduleEntity> lstCourseScheduleEntity = new ArrayList<CourseScheduleEntity>();

		lstCourseScheduleEntity = courseScheduleMapper.selectDistinctWorkDate(tEntity);
		return lstCourseScheduleEntity;
	}

	@Override
	public List<CourseScheduleEntity> selectByCondition(CourseScheduleEntity tEntity) {
		List<CourseScheduleEntity> lstCourseScheduleEntity = new ArrayList<CourseScheduleEntity>();

		lstCourseScheduleEntity = courseScheduleMapper.selectByCondition(tEntity);
		return lstCourseScheduleEntity;
	}

	@Override
	public void insertOne(CourseScheduleEntity courseScheduleEntity) {

		courseScheduleMapper.insertOne(courseScheduleEntity);
	}

	@Override
	public void updateByPK(CourseScheduleEntity courseScheduleEntity) {

		courseScheduleMapper.updateByPK(courseScheduleEntity);
	}

}
