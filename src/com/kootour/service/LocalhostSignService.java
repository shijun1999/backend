package com.kootour.service;

import java.util.Map;

import com.kootour.common.KootourMessage;
public interface LocalhostSignService {
	KootourMessage regWithEmail(Map<String, Object> paraMap);
	KootourMessage regWithFb(Map<String, Object> paraMap);
}
