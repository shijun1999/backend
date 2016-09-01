package com.kootour.service;

import java.util.Map;

import com.kootour.common.KootourMessage;

public interface CourseScheduleService {
	KootourMessage receivedBookingInit(Map<String, Object> paraMap);

	KootourMessage fetchOrderBookingDetail(Map<String, Object> paraMap);

	KootourMessage exclusiveDateInit(Map<String, Object> paraMap);

	KootourMessage exclusiveDateClickEvent(Map<String, Object> paraMap);
}
