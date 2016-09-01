package com.kootour.mapper;

import java.util.Date;
import java.util.List;
import com.kootour.mapper.entity.KootourMstEntity;
import com.kootour.mapper.entity.KootourMstEntity;
public interface KootourMstMapper {
List<KootourMstEntity> selectAll();
List<KootourMstEntity> selectByPK( KootourMstEntity kootourMstEntity );
    List<KootourMstEntity> selectByCondition( KootourMstEntity kootourMstEntity );

void insertOne( KootourMstEntity kootourMstEntity );

void updateByPK( KootourMstEntity kootourMstEntity );

}
