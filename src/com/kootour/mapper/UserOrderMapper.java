package com.kootour.mapper;

import java.util.List;

import com.kootour.mapper.entity.UserOrderEntity;
import com.kootour.mapper.entity.UserOrderEntity;

public interface UserOrderMapper {
	List<UserOrderEntity> selectAll();

	List<UserOrderEntity> selectByPK(UserOrderEntity userOrderEntity);

	List<UserOrderEntity> selectByCondition(UserOrderEntity userOrderEntity);

	void insertOne(UserOrderEntity userOrderEntity);

	void updateByPK(UserOrderEntity userOrderEntity);

	int selectCountByCondition(UserOrderEntity userOrderEntity);
}
