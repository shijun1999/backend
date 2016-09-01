package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.PictureMapper;
import com.kootour.mapper.entity.PictureEntity;
import com.kootour.mapper.entity.PictureEntity;
import com.kootour.service4db.PictureService4DB;

@Configuration
@Service
public class PictureService4DBImpl implements PictureService4DB {
	@Autowired
	private PictureMapper pictureMapper;

	@Override
	public List<PictureEntity> selectAll() {
		List<PictureEntity> lstPictureEntity = new ArrayList<PictureEntity>();
		lstPictureEntity = pictureMapper.selectAll();
		return lstPictureEntity;
	}

	@Override
	public List<PictureEntity> selectByPK(PictureEntity tEntity) {
		List<PictureEntity> lstPictureEntity = new ArrayList<PictureEntity>();

		lstPictureEntity = pictureMapper.selectByPK(tEntity);
		return lstPictureEntity;
	}

	@Override
	public List<PictureEntity> selectByCondition(PictureEntity tEntity) {
		List<PictureEntity> lstPictureEntity = new ArrayList<PictureEntity>();

		lstPictureEntity = pictureMapper.selectByCondition(tEntity);
		return lstPictureEntity;
	}

	@Override
	public void insertOne(PictureEntity pictureEntity) {

		pictureMapper.insertOne(pictureEntity);
	}

	@Override
	public void updateByPK(PictureEntity pictureEntity) {

		pictureMapper.updateByPK(pictureEntity);
	}

}
