//Auto Generated

package com.kootour.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;

import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.model.LocalhostCourseListModel;
import com.kootour.service.CourseListService;
import com.kootour.transfer.CourseListTransfer;

@Results({@Result(name = "gotohome", value = "localhostLogin!load", type = ServletActionRedirectResult.class)})
public class LocalhostCourseListAction extends LocalhostCourseListModel {

	@Resource
	CourseListService courseListService;

	@SuppressWarnings("unchecked")
	public String load() {
		Map<String, Object> session = getSession();
		if (session == null || getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY) == null || session.get(KooConst.LT_SESSION_KEY_LANGID) == null) {
			return "gotohome";
		}

		this.setLangId((String) session.get(KooConst.LT_SESSION_KEY_LANGID));
		this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));

		Map<String, Object> paraMap = new HashMap<String, Object> ();
		paraMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);

		KootourMessage retMsg = courseListService.load(paraMap);
		if (retMsg.isHasError()) {
			this.setCourseList(null);
		} else {
			this.setCourseList((List<CourseListTransfer>) retMsg.getData());
		}
		return "success";
	}
}
