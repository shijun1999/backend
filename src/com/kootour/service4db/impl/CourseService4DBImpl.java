package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.CourseMapper;
import com.kootour.mapper.entity.CourseEntity;
import com.kootour.mapper.entity.CourseEntity;
import com.kootour.service4db.CourseService4DB;

@Configuration
@Service
public class CourseService4DBImpl implements CourseService4DB {
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<CourseEntity> selectAll() {
		List<CourseEntity> lstCourseEntity = new ArrayList<CourseEntity>();
		lstCourseEntity = courseMapper.selectAll();
		return lstCourseEntity;
	}

	@Override
	public CourseEntity selectByPK(CourseEntity tEntity) {
		CourseEntity outCourseEntity = courseMapper.selectByPK(tEntity);
		return outCourseEntity;
	}

	@Override
	public List<CourseEntity> selectByCondition(CourseEntity tEntity) {
		List<CourseEntity> lstCourseEntity = new ArrayList<CourseEntity>();

		lstCourseEntity = courseMapper.selectByCondition(tEntity);
		return lstCourseEntity;
	}

	@Override
	public void insertOne(CourseEntity courseEntity) {

		courseMapper.insertOne(courseEntity);
	}

	@Override
	public void updateByPK(CourseEntity courseEntity) {

		courseMapper.updateByPK(courseEntity);
	}

	@Override
	public int selectCountByCondition(CourseEntity courseEntity) {
		int rtnCount;
		rtnCount = courseMapper.selectCountByCondition(courseEntity);
		return rtnCount;
	}

}
