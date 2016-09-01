package com.kootour.mapper;

import java.util.List;

import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.CoursePictureEntity;

public interface CoursePictureMapper {
	List<CoursePictureEntity> selectAll();

	List<CoursePictureEntity> selectByPK(CoursePictureEntity coursePictureEntity);

	List<CoursePictureEntity> selectByCondition(CoursePictureEntity coursePictureEntity);

	void insertOne(CoursePictureEntity coursePictureEntity);

	void updateByPK(CoursePictureEntity coursePictureEntity);

}
