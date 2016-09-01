package com.kootour.mapper;

import java.util.List;

import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.mapper.entity.LocalhostEntity;

public interface LocalhostMapper {
	List<LocalhostEntity> selectAll();

	List<LocalhostEntity> selectByPK(LocalhostEntity localhostEntity);

	List<LocalhostEntity> selectByCondition(LocalhostEntity localhostEntity);

	void insertOne(LocalhostEntity localhostEntity);

	void updateByPK(LocalhostEntity localhostEntity);

}
