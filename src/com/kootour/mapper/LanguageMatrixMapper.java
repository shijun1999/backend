package com.kootour.mapper;

import java.util.Date;
import java.util.List;
import com.kootour.mapper.entity.LanguageMatrixEntity;
import com.kootour.mapper.entity.LanguageMatrixEntity;
public interface LanguageMatrixMapper {
List<LanguageMatrixEntity> selectAll();
List<LanguageMatrixEntity> selectByPK( LanguageMatrixEntity languageMatrixEntity );
    List<LanguageMatrixEntity> selectByCondition( LanguageMatrixEntity languageMatrixEntity );

void insertOne( LanguageMatrixEntity languageMatrixEntity );

void updateByPK( LanguageMatrixEntity languageMatrixEntity );

}
