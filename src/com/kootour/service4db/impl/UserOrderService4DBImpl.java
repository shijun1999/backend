package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.UserOrderMapper;
import com.kootour.mapper.entity.UserOrderEntity;
import com.kootour.mapper.entity.UserOrderEntity;
import com.kootour.service4db.UserOrderService4DB;

@Configuration
@Service
public class UserOrderService4DBImpl implements UserOrderService4DB {
	@Autowired
	private UserOrderMapper userOrderMapper;

	@Override
	public List<UserOrderEntity> selectAll() {
		List<UserOrderEntity> lstUserOrderEntity = new ArrayList<UserOrderEntity>();
		lstUserOrderEntity = userOrderMapper.selectAll();
		return lstUserOrderEntity;
	}

	@Override
	public List<UserOrderEntity> selectByPK(UserOrderEntity tEntity) {
		List<UserOrderEntity> lstUserOrderEntity = new ArrayList<UserOrderEntity>();

		lstUserOrderEntity = userOrderMapper.selectByPK(tEntity);
		return lstUserOrderEntity;
	}

	@Override
	public List<UserOrderEntity> selectByCondition(UserOrderEntity tEntity) {
		List<UserOrderEntity> lstUserOrderEntity = new ArrayList<UserOrderEntity>();

		lstUserOrderEntity = userOrderMapper.selectByCondition(tEntity);
		return lstUserOrderEntity;
	}

	@Override
	public void insertOne(UserOrderEntity userOrderEntity) {

		userOrderMapper.insertOne(userOrderEntity);
	}

	@Override
	public void updateByPK(UserOrderEntity userOrderEntity) {

		userOrderMapper.updateByPK(userOrderEntity);
	}

	@Override
	public int selectCountByCondition(UserOrderEntity tEntity) {
		int rtnCount;
		rtnCount = userOrderMapper.selectCountByCondition(tEntity);
		return rtnCount;
	}
}
