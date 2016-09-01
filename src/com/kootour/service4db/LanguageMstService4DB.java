package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.LanguageMstEntity;

public interface LanguageMstService4DB {
	List<LanguageMstEntity> selectAll();

	List<LanguageMstEntity> selectByPK(LanguageMstEntity languageMstEntity);

	List<LanguageMstEntity> selectByCondition(LanguageMstEntity languageMstEntity);

	void insertOne(LanguageMstEntity LanguageMstEntity);

	void updateByPK(LanguageMstEntity LanguageMstEntity);

}
