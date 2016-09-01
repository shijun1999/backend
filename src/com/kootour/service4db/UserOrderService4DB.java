package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.UserOrderEntity;

public interface UserOrderService4DB {

	List<UserOrderEntity> selectAll();

	List<UserOrderEntity> selectByPK(UserOrderEntity userOrderEntity);

	List<UserOrderEntity> selectByCondition(UserOrderEntity userOrderEntity);

	void insertOne(UserOrderEntity UserOrderEntity);

	void updateByPK(UserOrderEntity UserOrderEntity);

	int selectCountByCondition(UserOrderEntity userOrderEntity);

}
