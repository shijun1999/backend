package com.kootour.mapper;

import java.util.Date;
import java.util.List;
import com.kootour.mapper.entity.LocationMstEntity;
import com.kootour.mapper.entity.LocationMstEntity;
public interface LocationMstMapper {
List<LocationMstEntity> selectAll();
List<LocationMstEntity> selectByPK( LocationMstEntity locationMstEntity );
    List<LocationMstEntity> selectByCondition( LocationMstEntity locationMstEntity );

void insertOne( LocationMstEntity locationMstEntity );

void updateByPK( LocationMstEntity locationMstEntity );

}
