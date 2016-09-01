package com.kootour.service;

import java.util.Map;

import com.kootour.common.KootourMessage;
public interface LocalhostMessageService {
	KootourMessage load(Map<String, Object> paraMap);
	KootourMessage fetchMessage(Map<String, Object> paraMap);
	KootourMessage fetchSeeMore(Map<String, Object> paraMap);
	KootourMessage fetchChat(Map<String, Object> paraMap);
	KootourMessage fetchNotification(Map<String, Object> paraMap);
	KootourMessage readNotification(Map<String, Object> paraMap);
	KootourMessage sendMessage(Map<String, Object> paraMap);
}
