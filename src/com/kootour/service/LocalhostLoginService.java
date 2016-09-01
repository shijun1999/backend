package com.kootour.service;

import java.util.Map;

import com.kootour.common.KootourMessage;
public interface LocalhostLoginService {
	KootourMessage loginWithEmail(Map<String, Object> paraMap);
	KootourMessage loginWithFb(Map<String, Object> paraMap);
	KootourMessage checkUserExist(Map<String, Object> paraMap);
}
