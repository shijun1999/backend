package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.ScheduleOptionMapper;
import com.kootour.mapper.entity.ScheduleOptionEntity;
import com.kootour.mapper.entity.ScheduleOptionEntity;
import com.kootour.service4db.ScheduleOptionService4DB;

@Configuration
@Service
public class ScheduleOptionService4DBImpl implements ScheduleOptionService4DB {
	@Autowired
	private ScheduleOptionMapper scheduleOptionMapper;

	@Override
	public List<ScheduleOptionEntity> selectAll() {
		List<ScheduleOptionEntity> lstScheduleOptionEntity = new ArrayList<ScheduleOptionEntity>();
		lstScheduleOptionEntity = scheduleOptionMapper.selectAll();
		return lstScheduleOptionEntity;
	}

	@Override
	public List<ScheduleOptionEntity> selectByPK(ScheduleOptionEntity tEntity) {
		List<ScheduleOptionEntity> lstScheduleOptionEntity = new ArrayList<ScheduleOptionEntity>();

		lstScheduleOptionEntity = scheduleOptionMapper.selectByPK(tEntity);
		return lstScheduleOptionEntity;
	}

	@Override
	public List<ScheduleOptionEntity> selectByCondition(ScheduleOptionEntity tEntity) {
		List<ScheduleOptionEntity> lstScheduleOptionEntity = new ArrayList<ScheduleOptionEntity>();

		lstScheduleOptionEntity = scheduleOptionMapper.selectByCondition(tEntity);
		return lstScheduleOptionEntity;
	}

	@Override
	public void insertOne(ScheduleOptionEntity scheduleOptionEntity) {

		scheduleOptionMapper.insertOne(scheduleOptionEntity);
	}

	@Override
	public void updateByPK(ScheduleOptionEntity scheduleOptionEntity) {

		scheduleOptionMapper.updateByPK(scheduleOptionEntity);
	}
}
