//Auto Generated

package com.kootour.transfer;

import java.util.ArrayList;
import java.util.List;

import com.kootour.mapper.entity.CourseEntity;
import com.kootour.mapper.entity.CoursePictureEntity;

public class CourseListTransfer {
	private CourseEntity courseEntity;
	private List<CoursePictureEntity> coursePictureEntityList = new ArrayList<CoursePictureEntity>();
	private boolean canDelete;

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

	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}
}
