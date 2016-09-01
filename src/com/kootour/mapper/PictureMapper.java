package com.kootour.mapper;

import java.util.Date;
import java.util.List;
import com.kootour.mapper.entity.PictureEntity;
import com.kootour.mapper.entity.PictureEntity;
public interface PictureMapper {
List<PictureEntity> selectAll();
List<PictureEntity> selectByPK( PictureEntity pictureEntity );
    List<PictureEntity> selectByCondition( PictureEntity pictureEntity );

void insertOne( PictureEntity pictureEntity );

void updateByPK( PictureEntity pictureEntity );

}
