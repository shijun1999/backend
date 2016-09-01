package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.LocalhostEntity;

public interface LocalhostService4DB {

	List<LocalhostEntity> selectAll();

	List<LocalhostEntity> selectByPK(LocalhostEntity localhostEntity);

	List<LocalhostEntity> selectByCondition(LocalhostEntity localhostEntity);

	void insertOne(LocalhostEntity LocalhostEntity);

	void updateByPK(LocalhostEntity LocalhostEntity);

}
