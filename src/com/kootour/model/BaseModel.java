//Auto Generated

package com.kootour.model;

import java.util.ArrayList;
import java.util.List;

import com.kootour.action.BaseAction;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.mapper.entity.LocationMstEntity;

import static org.apache.struts2.ServletActionContext.getServletContext;

public class BaseModel extends BaseAction {
	private String langId;
	private LocalhostEntity localhostEntity;
	private String courseIdentiNo;
	private List<LocationMstEntity> locationMstList = new ArrayList<LocationMstEntity>();

	static public String projectRoot = getServletContext().getRealPath("/");

	public String getLangId() {
		return langId;
	}

	public void setLangId(String langId) {
		this.langId = langId;
	}

	public LocalhostEntity getLocalhostEntity() {
		return localhostEntity;
	}

	public void setLocalhostEntity(LocalhostEntity localhostEntity) {
		this.localhostEntity = localhostEntity;
	}

	public String getCourseIdentiNo() {
		return courseIdentiNo;
	}

	public void setCourseIdentiNo(String courseIdentiNo) {
		this.courseIdentiNo = courseIdentiNo;
	}

	public List<LocationMstEntity> getLocationMstList() {
		return locationMstList;
	}

	public void setLocationMstList(List<LocationMstEntity> locationMstList) {
		this.locationMstList = locationMstList;
	}

}
