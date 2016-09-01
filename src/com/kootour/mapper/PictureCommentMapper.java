package com.kootour.mapper;

import java.util.Date;
import java.util.List;
import com.kootour.mapper.entity.PictureCommentEntity;
import com.kootour.mapper.entity.PictureCommentEntity;
public interface PictureCommentMapper {
List<PictureCommentEntity> selectAll();
List<PictureCommentEntity> selectByPK( PictureCommentEntity pictureCommentEntity );
    List<PictureCommentEntity> selectByCondition( PictureCommentEntity pictureCommentEntity );

void insertOne( PictureCommentEntity pictureCommentEntity );

void updateByPK( PictureCommentEntity pictureCommentEntity );

}
