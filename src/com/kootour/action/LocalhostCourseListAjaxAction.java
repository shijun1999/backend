//Auto Generated

package com.kootour.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.google.gson.Gson;
import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.model.BaseModel;
import com.kootour.service.CourseListService;

@ParentPackage("json-default")
@Results({
    @Result(name = "json", type="json", params={"root", "jsonStr"})
})
public class LocalhostCourseListAjaxAction extends BaseModel {

	@Resource
	CourseListService courseListService;

	private String jsonStr;

    public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	@Action(value="updateCourseStatus")
    public String updateCourseStatus() {
		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		Map<String, Object> session = getSession();
		if (session == null || getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY) == null || session.get(KooConst.LT_SESSION_KEY_LANGID) == null) {
			jsonMap.put("result", "error");
			jsonMap.put("data", "");
			jsonMap.put("message", "Session invaild.<br>Please re-login.");
			jsonStr = gson.toJson(jsonMap);
			return rtnStr;
		}

		try {
			this.setLangId((String) session.get(KooConst.LT_SESSION_KEY_LANGID));
			this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));
			Map<String, Object> paraMap = new HashMap<String, Object> ();
			paraMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);

			KootourMessage retMsg = courseListService.updateCourseStatus(paraMap);

			if (retMsg.isHasError()) {
				jsonMap.put("result", "error");
				jsonMap.put("message", retMsg.getMessage());
				jsonStr = gson.toJson(jsonMap);
			} else {
				jsonMap.put("result", "success");
				jsonMap.put("message", retMsg.getMessage());
				jsonMap.put("data", retMsg.getData());
				jsonStr = gson.toJson(jsonMap);
			}
		} catch (Exception e) {
			jsonMap.put("result", "error");
			jsonMap.put("message", this.getClass().getName() + ":<br>" + e.getMessage());
			jsonStr = gson.toJson(jsonMap);
		}
		return rtnStr;
    }
}
