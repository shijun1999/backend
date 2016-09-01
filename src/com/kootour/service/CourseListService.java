package com.kootour.service;

import java.util.Map;

import com.kootour.common.KootourMessage;
public interface CourseListService {
	KootourMessage load(Map<String, Object> paraMap);
	KootourMessage updateCourseStatus(Map<String, Object> paraMap);
}
