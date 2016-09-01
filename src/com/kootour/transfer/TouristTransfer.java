//Auto Generated

package com.kootour.transfer;

import java.util.List;

import com.kootour.mapper.entity.CourseEntity;
import com.kootour.mapper.entity.CourseInExclusionEntity;
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.ScheduleOptionEntity;

public class TouristTransfer {
	private CourseEntity courseEntity;
	private List<CoursePictureEntity> coursePictureEntityList;
	private List<ScheduleOptionEntity> scheduleOptionEntityList;
	private List<CourseInExclusionEntity> courseInExclusionEntityList;

	public CourseEntity getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}

	public List<CoursePictureEntity> getCoursePictureEntityList() {
		return coursePictureEntityList;
	}

	public void setCoursePictureEntityList(List<CoursePictureEntity> coursePictureEntityList) {
		this.coursePictureEntityList = coursePictureEntityList;
	}

	public List<ScheduleOptionEntity> getScheduleOptionEntityList() {
		return scheduleOptionEntityList;
	}

	public void setScheduleOptionEntityList(List<ScheduleOptionEntity> scheduleOptionEntityList) {
		this.scheduleOptionEntityList = scheduleOptionEntityList;
	}

	public List<CourseInExclusionEntity> getCourseInExclusionEntityList() {
		return courseInExclusionEntityList;
	}

	public void setCourseInExclusionEntityList(List<CourseInExclusionEntity> courseInExclusionEntityList) {
		this.courseInExclusionEntityList = courseInExclusionEntityList;
	}
}
