package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.CourseCommentEntity;

public interface CourseCommentService4DB {

	List<CourseCommentEntity> selectAll();

	List<CourseCommentEntity> selectByPK(CourseCommentEntity courseCommentEntity);

	List<CourseCommentEntity> selectByCondition(CourseCommentEntity courseCommentEntity);

	void insertOne(CourseCommentEntity CourseCommentEntity);

	void updateByPK(CourseCommentEntity CourseCommentEntity);

	int selectCountByCondition(CourseCommentEntity courseCommentEntity);
}
