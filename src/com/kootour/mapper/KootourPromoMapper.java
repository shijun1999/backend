package com.kootour.mapper;

import java.util.Date;
import java.util.List;
import com.kootour.mapper.entity.KootourPromoEntity;
import com.kootour.mapper.entity.KootourPromoEntity;
public interface KootourPromoMapper {
List<KootourPromoEntity> selectAll();
List<KootourPromoEntity> selectByPK( KootourPromoEntity kootourPromoEntity );
    List<KootourPromoEntity> selectByCondition( KootourPromoEntity kootourPromoEntity );

void insertOne( KootourPromoEntity kootourPromoEntity );

void updateByPK( KootourPromoEntity kootourPromoEntity );

}
