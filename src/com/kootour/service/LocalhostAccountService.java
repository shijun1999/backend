package com.kootour.service;

import java.util.Map;

import com.kootour.common.KootourMessage;

public interface LocalhostAccountService {
	KootourMessage updateAccount(Map<String, Object> paraMap);
	KootourMessage uploadAvatar(Map<String, Object> paraMap);
	KootourMessage changePassword(Map<String, Object> paraMap);
}
