package com.kootour.service4db;

import java.util.List;

import com.kootour.mapper.entity.MessageEntity;

public interface MessageService4DB {
	List<MessageEntity> selectAll();

	List<MessageEntity> selectByPK(MessageEntity messageEntity);

	List<MessageEntity> selectByCondition(MessageEntity messageEntity);

	List<MessageEntity> selectByConditionForChat(MessageEntity messageEntity);

	void insertOne(MessageEntity MessageEntity);

	void updateByPK(MessageEntity MessageEntity);

	int selectCountByCondition(MessageEntity messageEntity);

}
