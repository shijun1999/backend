//Auto Generated

package com.kootour.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;

import com.kootour.common.KooConst;
import com.kootour.model.BaseModel;
import com.kootour.service.CourseService;

@Results({@Result(name = "gotohome", value = "localhostLogin!load", type = ServletActionRedirectResult.class),
	@Result(name = "gotoback", value = "localhostCourseList!load", type = ServletActionRedirectResult.class)})
public class LocalhostCourseCloneAction extends BaseModel {

	@Resource
	CourseService courseService;

	public String load() {
		Map<String, Object> session = getSession();
		if (session == null || getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY) == null || session.get(KooConst.LT_SESSION_KEY_LANGID) == null) {
			return "gotohome";
		}
		
		this.setLocationMstList(courseService.getLocationMstEntityList((String)session.get(KooConst.LT_SESSION_KEY_LANGID)));
		
		return "success";
	}
}
