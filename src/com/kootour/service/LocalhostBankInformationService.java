package com.kootour.service;

import java.util.Map;

import com.kootour.common.KootourMessage;
public interface LocalhostBankInformationService {
	KootourMessage updateBankInformation(Map<String, Object> paraMap);
}
