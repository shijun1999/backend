package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.CourseCommentMapper;
import com.kootour.mapper.entity.CourseCommentEntity;
import com.kootour.mapper.entity.CourseCommentEntity;
import com.kootour.service4db.CourseCommentService4DB;

@Configuration
@Service
public class CourseCommentService4DBImpl implements CourseCommentService4DB {
	@Autowired
	private CourseCommentMapper courseCommentMapper;

	@Override
	public List<CourseCommentEntity> selectAll() {
		List<CourseCommentEntity> lstCourseCommentEntity = new ArrayList<CourseCommentEntity>();
		lstCourseCommentEntity = courseCommentMapper.selectAll();
		return lstCourseCommentEntity;
	}

	@Override
	public List<CourseCommentEntity> selectByPK(CourseCommentEntity tEntity) {
		List<CourseCommentEntity> lstCourseCommentEntity = new ArrayList<CourseCommentEntity>();

		lstCourseCommentEntity = courseCommentMapper.selectByPK(tEntity);
		return lstCourseCommentEntity;
	}

	@Override
	public List<CourseCommentEntity> selectByCondition(CourseCommentEntity tEntity) {
		List<CourseCommentEntity> lstCourseCommentEntity = new ArrayList<CourseCommentEntity>();

		lstCourseCommentEntity = courseCommentMapper.selectByCondition(tEntity);
		return lstCourseCommentEntity;
	}

	@Override
	public void insertOne(CourseCommentEntity courseCommentEntity) {

		courseCommentMapper.insertOne(courseCommentEntity);
	}

	@Override
	public void updateByPK(CourseCommentEntity courseCommentEntity) {

		courseCommentMapper.updateByPK(courseCommentEntity);
	}

	@Override
	public int selectCountByCondition(CourseCommentEntity tEntity) {
		int rtnCount;
		rtnCount = courseCommentMapper.selectCountByCondition(tEntity);
		return rtnCount;
	}

}
