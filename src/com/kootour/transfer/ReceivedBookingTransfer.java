//Auto Generated

package com.kootour.transfer;

import java.util.List;

import com.kootour.mapper.entity.CourseEntity;
import com.kootour.mapper.entity.CourseInExclusionEntity;
import com.kootour.mapper.entity.TouristEntity;
import com.kootour.mapper.entity.UserOrderEntity;

public class ReceivedBookingTransfer {

	private List<String> workDayList;

	private List<UserOrderEntity> userOrderEntityList;

	private CourseEntity courseEntity;

	private List<CourseInExclusionEntity> courseInExclusionEntityList;

	private TouristEntity touristEntity;

	public List<String> getWorkDayList() {
		return workDayList;
	}

	public void setWorkDayList(List<String> workDayList) {
		this.workDayList = workDayList;
	}

	public List<UserOrderEntity> getUserOrderEntityList() {
		return userOrderEntityList;
	}

	public void setUserOrderEntityList(List<UserOrderEntity> userOrderEntityList) {
		this.userOrderEntityList = userOrderEntityList;
	}

	public CourseEntity getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}

	public List<CourseInExclusionEntity> getCourseInExclusionEntityList() {
		return courseInExclusionEntityList;
	}

	public void setCourseInExclusionEntityList(List<CourseInExclusionEntity> courseInExclusionEntityList) {
		this.courseInExclusionEntityList = courseInExclusionEntityList;
	}

	public TouristEntity getTouristEntity() {
		return touristEntity;
	}

	public void setTouristEntity(TouristEntity touristEntity) {
		this.touristEntity = touristEntity;
	}

}
