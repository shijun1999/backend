package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.ScheduleOptionEntity;

public interface ScheduleOptionService4DB {
	List<ScheduleOptionEntity> selectAll();

	List<ScheduleOptionEntity> selectByPK(ScheduleOptionEntity scheduleOptionEntity);

	List<ScheduleOptionEntity> selectByCondition(ScheduleOptionEntity scheduleOptionEntity);

	void insertOne(ScheduleOptionEntity ScheduleOptionEntity);

	void updateByPK(ScheduleOptionEntity ScheduleOptionEntity);

}
