package com.kootour.mapper;

import java.util.Date;
import java.util.List;
import com.kootour.mapper.entity.FavoriteEntity;
import com.kootour.mapper.entity.FavoriteEntity;
public interface FavoriteMapper {
List<FavoriteEntity> selectAll();
List<FavoriteEntity> selectByPK( FavoriteEntity favoriteEntity );
    List<FavoriteEntity> selectByCondition( FavoriteEntity favoriteEntity );

void insertOne( FavoriteEntity favoriteEntity );

void updateByPK( FavoriteEntity favoriteEntity );

int selectCountByCondition(FavoriteEntity favoriteEntity );
}
