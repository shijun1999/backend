package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.PictureEntity;

public interface PictureService4DB {

	List<PictureEntity> selectAll();

	List<PictureEntity> selectByPK(PictureEntity pictureEntity);

	List<PictureEntity> selectByCondition(PictureEntity pictureEntity);

	void insertOne(PictureEntity PictureEntity);

	void updateByPK(PictureEntity PictureEntity);

}
