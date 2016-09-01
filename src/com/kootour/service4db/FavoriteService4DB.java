package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.FavoriteEntity;

public interface FavoriteService4DB {
	List<FavoriteEntity> selectAll();

	List<FavoriteEntity> selectByPK(FavoriteEntity favoriteEntity);

	List<FavoriteEntity> selectByCondition(FavoriteEntity favoriteEntity);

	void insertOne(FavoriteEntity FavoriteEntity);

	void updateByPK(FavoriteEntity FavoriteEntity);

	int selectCountByCondition(FavoriteEntity favoriteEntity);

}
