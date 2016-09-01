package com.kootour.mapper;

import java.util.Date;
import java.util.List;
import com.kootour.mapper.entity.CourseDiscountEntity;
import com.kootour.mapper.entity.CourseDiscountEntity;
public interface CourseDiscountMapper {
List<CourseDiscountEntity> selectAll();
List<CourseDiscountEntity> selectByPK( CourseDiscountEntity courseDiscountEntity );
    List<CourseDiscountEntity> selectByCondition( CourseDiscountEntity courseDiscountEntity );

void insertOne( CourseDiscountEntity courseDiscountEntity );

void updateByPK( CourseDiscountEntity courseDiscountEntity );

}
