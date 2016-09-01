package com.kootour.mapper;

import java.util.Date;
import java.util.List;
import com.kootour.mapper.entity.CourseCommentEntity;
import com.kootour.mapper.entity.CourseCommentEntity;
public interface CourseCommentMapper {
List<CourseCommentEntity> selectAll();
List<CourseCommentEntity> selectByPK( CourseCommentEntity courseCommentEntity );
    List<CourseCommentEntity> selectByCondition( CourseCommentEntity courseCommentEntity );

void insertOne( CourseCommentEntity courseCommentEntity );

void updateByPK( CourseCommentEntity courseCommentEntity );

int selectCountByCondition( CourseCommentEntity courseCommentEntity );

}
