package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.CoursePictureEntity;

public interface CoursePictureService4DB {

	List<CoursePictureEntity> selectAll();

	List<CoursePictureEntity> selectByPK(CoursePictureEntity coursePictureEntity);

	List<CoursePictureEntity> selectByCondition(CoursePictureEntity coursePictureEntity);

	void insertOne(CoursePictureEntity CoursePictureEntity);

	void updateByPK(CoursePictureEntity CoursePictureEntity);

}
