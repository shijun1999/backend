package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.LanguageMatrixEntity;

public interface LanguageMatrixService4DB {
	List<LanguageMatrixEntity> selectAll();

	List<LanguageMatrixEntity> selectByPK(LanguageMatrixEntity languageMatrixEntity);

	List<LanguageMatrixEntity> selectByCondition(LanguageMatrixEntity languageMatrixEntity);

	void insertOne(LanguageMatrixEntity LanguageMatrixEntity);

	void updateByPK(LanguageMatrixEntity LanguageMatrixEntity);

}
