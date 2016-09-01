package com.kootour.mapper;

import java.util.List;

import com.kootour.mapper.entity.MessageEntity;

public interface MessageMapper {
	List<MessageEntity> selectAll();

	List<MessageEntity> selectByPK(MessageEntity messageParamEntity);

	List<MessageEntity> selectByCondition(MessageEntity messageParamEntity);

	List<MessageEntity> selectByConditionForChat(MessageEntity messageParamEntity);

	void insertOne(MessageEntity messageEntity);

	void updateByPK(MessageEntity messageEntity);

	int selectCountByCondition(MessageEntity messageParamEntity);
}
