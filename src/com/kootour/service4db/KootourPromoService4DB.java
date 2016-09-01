package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.KootourPromoEntity;

public interface KootourPromoService4DB {
	List<KootourPromoEntity> selectAll();

	List<KootourPromoEntity> selectByPK(KootourPromoEntity kootourPromoEntity);

	List<KootourPromoEntity> selectByCondition(KootourPromoEntity kootourPromoEntity);

	void insertOne(KootourPromoEntity KootourPromoEntity);

	void updateByPK(KootourPromoEntity KootourPromoEntity);

}
