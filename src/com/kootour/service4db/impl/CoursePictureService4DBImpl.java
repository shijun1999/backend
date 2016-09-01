package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.CoursePictureMapper;
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.service4db.CoursePictureService4DB;

@Configuration
@Service
public class CoursePictureService4DBImpl implements CoursePictureService4DB {
	@Autowired
	private CoursePictureMapper coursePictureMapper;

	@Override
	public List<CoursePictureEntity> selectAll() {
		List<CoursePictureEntity> lstCoursePictureEntity = new ArrayList<CoursePictureEntity>();
		lstCoursePictureEntity = coursePictureMapper.selectAll();
		return lstCoursePictureEntity;
	}

	@Override
	public List<CoursePictureEntity> selectByPK(CoursePictureEntity tEntity) {
		List<CoursePictureEntity> lstCoursePictureEntity = new ArrayList<CoursePictureEntity>();

		lstCoursePictureEntity = coursePictureMapper.selectByPK(tEntity);
		return lstCoursePictureEntity;
	}

	@Override
	public List<CoursePictureEntity> selectByCondition(CoursePictureEntity tEntity) {
		List<CoursePictureEntity> lstCoursePictureEntity = new ArrayList<CoursePictureEntity>();

		lstCoursePictureEntity = coursePictureMapper.selectByCondition(tEntity);
		return lstCoursePictureEntity;
	}

	@Override
	public void insertOne(CoursePictureEntity coursePictureEntity) {

		coursePictureMapper.insertOne(coursePictureEntity);
	}

	@Override
	public void updateByPK(CoursePictureEntity coursePictureEntity) {

		coursePictureMapper.updateByPK(coursePictureEntity);
	}

}
