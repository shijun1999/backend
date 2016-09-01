//Auto Generated

package com.kootour.transfer;

import java.util.List;
import java.util.Map;

import com.kootour.mapper.entity.MessageEntity;
import com.kootour.mapper.entity.TouristEntity;

public class ChatTransfer {
	private Map<String, List<MessageEntity>> messageMap;
	private TouristEntity touristEntity;

	public Map<String, List<MessageEntity>> getMessageMap() {
		return messageMap;
	}

	public void setMessageMap(Map<String, List<MessageEntity>> messageMap) {
		this.messageMap = messageMap;
	}

	public TouristEntity getTouristEntity() {
		return touristEntity;
	}

	public void setTouristEntity(TouristEntity touristEntity) {
		this.touristEntity = touristEntity;
	}

}
