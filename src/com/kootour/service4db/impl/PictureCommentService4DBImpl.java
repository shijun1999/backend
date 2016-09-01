package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.PictureCommentMapper;
import com.kootour.mapper.entity.PictureCommentEntity;
import com.kootour.mapper.entity.PictureCommentEntity;
import com.kootour.service4db.PictureCommentService4DB;

@Configuration
@Service
public class PictureCommentService4DBImpl implements PictureCommentService4DB {
	@Autowired
	private PictureCommentMapper pictureCommentMapper;

	@Override
	public List<PictureCommentEntity> selectAll() {
		List<PictureCommentEntity> lstPictureCommentEntity = new ArrayList<PictureCommentEntity>();
		lstPictureCommentEntity = pictureCommentMapper.selectAll();
		return lstPictureCommentEntity;
	}

	@Override
	public List<PictureCommentEntity> selectByPK(PictureCommentEntity tEntity) {
		List<PictureCommentEntity> lstPictureCommentEntity = new ArrayList<PictureCommentEntity>();

		lstPictureCommentEntity = pictureCommentMapper.selectByPK(tEntity);
		return lstPictureCommentEntity;
	}

	@Override
	public List<PictureCommentEntity> selectByCondition(PictureCommentEntity tEntity) {
		List<PictureCommentEntity> lstPictureCommentEntity = new ArrayList<PictureCommentEntity>();

		lstPictureCommentEntity = pictureCommentMapper.selectByCondition(tEntity);
		return lstPictureCommentEntity;
	}

	@Override
	public void insertOne(PictureCommentEntity pictureCommentEntity) {

		pictureCommentMapper.insertOne(pictureCommentEntity);
	}

	@Override
	public void updateByPK(PictureCommentEntity pictureCommentEntity) {

		pictureCommentMapper.updateByPK(pictureCommentEntity);
	}

}
