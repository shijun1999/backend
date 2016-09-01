package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.CourseDiscountEntity;

public interface CourseDiscountService4DB {
	List<CourseDiscountEntity> selectAll();

	List<CourseDiscountEntity> selectByPK(CourseDiscountEntity courseDiscountEntity);

	List<CourseDiscountEntity> selectByCondition(CourseDiscountEntity courseDiscountEntity);

	void insertOne(CourseDiscountEntity CourseDiscountEntity);

	void updateByPK(CourseDiscountEntity CourseDiscountEntity);

}
