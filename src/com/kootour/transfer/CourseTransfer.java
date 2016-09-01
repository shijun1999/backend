//Auto Generated

package com.kootour.transfer;

import java.util.List;

import com.kootour.mapper.entity.CourseEntity;
import com.kootour.mapper.entity.CourseInExclusionEntity;
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.ExtraOptionEntity;
import com.kootour.mapper.entity.ScheduleOptionEntity;

public class CourseTransfer {
	private CourseEntity courseEntity;
	private ScheduleOptionEntity scheduleOptionEntity;
	private List<ExtraOptionEntity> extraOptionEntityList;
	private List<CoursePictureEntity> coursePictureEntityList;
	// private List<ScheduleOptionEntity> scheduleOptionEntityList;
	private List<CourseInExclusionEntity> courseInExclusionEntityList;

	public CourseEntity getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}

	public ScheduleOptionEntity getScheduleOptionEntity() {
		return scheduleOptionEntity;
	}

	public void setScheduleOptionEntity(ScheduleOptionEntity scheduleOptionEntity) {
		this.scheduleOptionEntity = scheduleOptionEntity;
	}

	public List<ExtraOptionEntity> getExtraOptionEntityList() {
		return extraOptionEntityList;
	}

	public void setExtraOptionEntityList(List<ExtraOptionEntity> extraOptionEntityList) {
		this.extraOptionEntityList = extraOptionEntityList;
	}

	public List<CoursePictureEntity> getCoursePictureEntityList() {
		return coursePictureEntityList;
	}

	public void setCoursePictureEntityList(List<CoursePictureEntity> coursePictureEntityList) {
		this.coursePictureEntityList = coursePictureEntityList;
	}

	public List<CourseInExclusionEntity> getCourseInExclusionEntityList() {
		return courseInExclusionEntityList;
	}

	public void setCourseInExclusionEntityList(List<CourseInExclusionEntity> courseInExclusionEntityList) {
		this.courseInExclusionEntityList = courseInExclusionEntityList;
	}

}
