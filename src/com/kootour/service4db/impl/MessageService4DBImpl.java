package com.kootour.service4db.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.mapper.MessageMapper;
import com.kootour.mapper.entity.MessageEntity;
import com.kootour.service4db.MessageService4DB;

@Configuration
@Service
public class MessageService4DBImpl implements MessageService4DB {
	@Autowired
	private MessageMapper messageMapper;

	@Override
	public List<MessageEntity> selectAll() {
		List<MessageEntity> lstMessageEntity = new ArrayList<MessageEntity>();
		lstMessageEntity = messageMapper.selectAll();
		return lstMessageEntity;
	}

	@Override
	public List<MessageEntity> selectByPK(MessageEntity tEntity) {
		List<MessageEntity> lstMessageEntity = new ArrayList<MessageEntity>();

		lstMessageEntity = messageMapper.selectByPK(tEntity);
		return lstMessageEntity;
	}

	@Override
	public List<MessageEntity> selectByCondition(MessageEntity tEntity) {
		List<MessageEntity> lstMessageEntity = new ArrayList<MessageEntity>();

		lstMessageEntity = messageMapper.selectByCondition(tEntity);
		return lstMessageEntity;
	}

	@Override
	public List<MessageEntity> selectByConditionForChat(MessageEntity tEntity) {
		List<MessageEntity> lstMessageEntity = new ArrayList<MessageEntity>();

		lstMessageEntity = messageMapper.selectByConditionForChat(tEntity);
		return lstMessageEntity;
	}

	@Override
	public void insertOne(MessageEntity messageEntity) {

		messageMapper.insertOne(messageEntity);
	}

	@Override
	public void updateByPK(MessageEntity messageEntity) {

		messageMapper.updateByPK(messageEntity);
	}

	@Override
	public int selectCountByCondition(MessageEntity tEntity) {
		int rtnCount;
		rtnCount = messageMapper.selectCountByCondition(tEntity);
		return rtnCount;
	}
}
