package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.PictureCommentEntity;

public interface PictureCommentService4DB {

	List<PictureCommentEntity> selectAll();

	List<PictureCommentEntity> selectByPK(PictureCommentEntity pictureCommentEntity);

	List<PictureCommentEntity> selectByCondition(PictureCommentEntity pictureCommentEntity);

	void insertOne(PictureCommentEntity PictureCommentEntity);

	void updateByPK(PictureCommentEntity PictureCommentEntity);

}
