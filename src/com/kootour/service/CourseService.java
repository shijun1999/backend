package com.kootour.service;

import java.util.List;
import java.util.Map;

import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.LocationMstEntity;

public interface CourseService {
	KootourMessage save(Map<String, Object> paraMap);

	 public List<CoursePictureEntity> findCoursePictures(Map<String, Object> paraMap);
	
	KootourMessage editCourseInit(Map<String, Object> paraMap);

	KootourMessage updateCourse(Map<String, Object> paraMap);

	KootourMessage deleteCourse(Map<String, Object> paraMap);

	KootourMessage uploadImage(Map<String, Object> paraMap);

	KootourMessage deleteImage(Map<String, Object> paraMap);
	
	List<LocationMstEntity> getLocationMstEntityList(String langId);
}
