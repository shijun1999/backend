package com.kootour.mapper;

import java.util.List;

import com.kootour.mapper.entity.ScheduleOptionEntity;
import com.kootour.mapper.entity.ScheduleOptionEntity;

public interface ScheduleOptionMapper {
	List<ScheduleOptionEntity> selectAll();

	List<ScheduleOptionEntity> selectByPK(ScheduleOptionEntity scheduleOptionEntity);

	List<ScheduleOptionEntity> selectByCondition(ScheduleOptionEntity scheduleOptionEntity);

	void insertOne(ScheduleOptionEntity scheduleOptionEntity);

	void updateByPK(ScheduleOptionEntity scheduleOptionEntity);

}
