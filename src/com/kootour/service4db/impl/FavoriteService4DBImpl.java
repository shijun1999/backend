package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.FavoriteMapper;
import com.kootour.mapper.entity.FavoriteEntity;
import com.kootour.mapper.entity.FavoriteEntity;
import com.kootour.service4db.FavoriteService4DB;

@Configuration
@Service
public class FavoriteService4DBImpl implements FavoriteService4DB {
	@Autowired
	private FavoriteMapper favoriteMapper;

	@Override
	public List<FavoriteEntity> selectAll() {
		List<FavoriteEntity> lstFavoriteEntity = new ArrayList<FavoriteEntity>();
		lstFavoriteEntity = favoriteMapper.selectAll();
		return lstFavoriteEntity;
	}

	@Override
	public List<FavoriteEntity> selectByPK(FavoriteEntity favoriteEntity) {
		List<FavoriteEntity> lstFavoriteEntity = new ArrayList<FavoriteEntity>();

		lstFavoriteEntity = favoriteMapper.selectByPK(favoriteEntity);
		return lstFavoriteEntity;
	}

	@Override
	public List<FavoriteEntity> selectByCondition(FavoriteEntity favoriteEntity) {
		List<FavoriteEntity> lstFavoriteEntity = new ArrayList<FavoriteEntity>();

		lstFavoriteEntity = favoriteMapper.selectByCondition(favoriteEntity);
		return lstFavoriteEntity;
	}

	@Override
	public void insertOne(FavoriteEntity FavoriteEntity) {
		favoriteMapper.insertOne(FavoriteEntity);
	}

	@Override
	public void updateByPK(FavoriteEntity FavoriteEntity) {
		favoriteMapper.updateByPK(FavoriteEntity);
	}

	@Override
	public int selectCountByCondition(FavoriteEntity favoriteEntity) {
		int rtnCount;
		rtnCount = favoriteMapper.selectCountByCondition(favoriteEntity);
		return rtnCount;
	}

	// @Override
	// public FavoriteEntity load(FavoriteEntity favoriteEntity, Map<String,
	// Object> paraMap) {
	//
	// FavoriteEntity rtnResult = new FavoriteEntity();
	// List<ErrorInfo> tList = new ArrayList<ErrorInfo>();
	// FavoriteEntity favoriteEntity = new FavoriteEntity();
	// favoriteEntity.setLangId(favoriteEntity.getLangId());
	// favoriteEntity.setTouristIdentiNo(favoriteEntity.getTouristIdentiNo());
	// favoriteEntity.setObjIdentiNo(favoriteEntity.getObjIdentiNo());
	// List<FavoriteEntity> favoriteEntityList =
	// favoriteMapper.selectByCondition(favoriteEntity);
	//
	// if (favoriteEntityList.isEmpty()) {
	//
	// String strSysDate = paraMap.get(KooConst.ST_SYSDATE).toString();
	// String strFavoriteIdentiNo = "";
	// rtnResult.setLangId(favoriteEntity.getLangId());
	// rtnResult.setTouristIdentiNo(favoriteEntity.getTouristIdentiNo());
	// rtnResult.setObjType("1");
	// rtnResult.setObjIdentiNo(favoriteEntity.getObjIdentiNo());
	// rtnResult.setDeleteStatus("0");
	// rtnResult.setOpDate(strSysDate);
	//
	// try {
	//
	// strFavoriteIdentiNo = createSequence();
	// rtnResult.setFavoriteIdentiNo(strFavoriteIdentiNo);
	// } catch (Exception e) {
	//
	// ErrorInfo tErrorInfo = new ErrorInfo();
	// tErrorInfo.setItemName(KooConst.INFO_MSG_PARAM016);
	// tErrorInfo.setErrKbn(KooConst.INT_ERROR_KBN);
	// tErrorInfo.setErrMsg(KooConst.INFO_MSG_004);
	// tErrorInfo.setDispOrder(1);
	// tList.add(tErrorInfo);
	// paraMap.put(KooConst.ST_ERRORINFO, tList);
	// logger.error(KooConst.INFO_MSG_004);
	// return (rtnResult);
	// }
	// try {
	//
	// favoriteMapper.insertOne(rtnResult);
	// ErrorInfo tErrorInfo = new ErrorInfo();
	// tErrorInfo.setItemName(KooConst.INFO_MSG_PARAM014);
	// tErrorInfo.setErrKbn(KooConst.INT_INFO_KBN);
	// tErrorInfo.setErrMsg(KooConst.INFO_MSG_003);
	// tErrorInfo.setDispOrder(1);
	// tList.add(tErrorInfo);
	// } catch (Exception e) {
	//
	// ErrorInfo tErrorInfo = new ErrorInfo();
	// tErrorInfo.setItemName(KooConst.INFO_MSG_PARAM014 + "[" +
	// favoriteEntity.getLangId() + "," + strFavoriteIdentiNo + "]");
	// tErrorInfo.setErrKbn(KooConst.INT_ERROR_KBN);
	// tErrorInfo.setErrMsg(KooConst.INFO_MSG_005);
	// tErrorInfo.setDispOrder(1);
	// tList.add(tErrorInfo);
	// logger.error(KooConst.INFO_MSG_005);
	// }
	// } else {
	//
	// FavoriteEntity favoriteE = favoriteEntityList.get(0);
	//
	// if(favoriteE.getDeleteStatus().equals("0")) {
	// favoriteE.setDeleteStatus("1");
	// } else {
	// favoriteE.setDeleteStatus("0");
	// }
	// try {
	//
	// favoriteMapper.updateByPK(favoriteE);
	// } catch (Exception e) {
	//
	// ErrorInfo tErrorInfo = new ErrorInfo();
	// tErrorInfo.setItemName(KooConst.INFO_MSG_PARAM014 + "[" +
	// favoriteEntity.getLangId() + "," + favoriteE.getFavoriteIdentiNo() +
	// "]");
	// tErrorInfo.setErrKbn(KooConst.INT_ERROR_KBN);
	// tErrorInfo.setErrMsg(KooConst.INFO_MSG_007);
	// tErrorInfo.setDispOrder(1);
	// tList.add(tErrorInfo);
	// logger.error(KooConst.INFO_MSG_007);
	// }
	// }
	//
	// paraMap.put(KooConst.ST_ERRORINFO, tList);
	// return (rtnResult);
	// }

}
