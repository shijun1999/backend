package com.kootour.mapper;

import java.util.Date;
import java.util.List;
import com.kootour.mapper.entity.LanguageMstEntity;
import com.kootour.mapper.entity.LanguageMstEntity;
public interface LanguageMstMapper {
List<LanguageMstEntity> selectAll();
List<LanguageMstEntity> selectByPK( LanguageMstEntity languageMstEntity );
    List<LanguageMstEntity> selectByCondition( LanguageMstEntity languageMstEntity );

void insertOne( LanguageMstEntity languageMstEntity );

void updateByPK( LanguageMstEntity languageMstEntity );

}
