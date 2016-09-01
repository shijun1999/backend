package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.CourseDiscountMapper;
import com.kootour.mapper.entity.CourseDiscountEntity;
import com.kootour.mapper.entity.CourseDiscountEntity;
import com.kootour.service4db.CourseDiscountService4DB;

@Configuration
@Service
public class CourseDiscountService4DBImpl implements CourseDiscountService4DB {
	@Autowired
	private CourseDiscountMapper courseDiscountMapper;

	@Override
	public List<CourseDiscountEntity> selectAll() {
		List<CourseDiscountEntity> lstCourseDiscountEntity = new ArrayList<CourseDiscountEntity>();
		lstCourseDiscountEntity = courseDiscountMapper.selectAll();
		return lstCourseDiscountEntity;
	}

	@Override
	public List<CourseDiscountEntity> selectByPK(CourseDiscountEntity tEntity) {
		List<CourseDiscountEntity> lstCourseDiscountEntity = new ArrayList<CourseDiscountEntity>();

		lstCourseDiscountEntity = courseDiscountMapper.selectByPK(tEntity);
		return lstCourseDiscountEntity;
	}

	@Override
	public List<CourseDiscountEntity> selectByCondition(CourseDiscountEntity tEntity) {
		List<CourseDiscountEntity> lstCourseDiscountEntity = new ArrayList<CourseDiscountEntity>();

		lstCourseDiscountEntity = courseDiscountMapper.selectByCondition(tEntity);
		return lstCourseDiscountEntity;
	}

	@Override
	public void insertOne(CourseDiscountEntity courseDiscountEntity) {

		courseDiscountMapper.insertOne(courseDiscountEntity);
	}

	@Override
	public void updateByPK(CourseDiscountEntity courseDiscountEntity) {

		courseDiscountMapper.updateByPK(courseDiscountEntity);
	}

}
