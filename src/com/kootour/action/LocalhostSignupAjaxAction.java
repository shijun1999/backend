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
import com.kootour.model.BaseModel;
import com.kootour.model.LocalhostLoginModel;
import com.kootour.service.LocalhostSignService;

@ParentPackage("json-default")
@Results({
    @Result(name = "json", type="json", params={"root", "jsonStr"})
})
public class LocalhostSignupAjaxAction extends BaseModel {

	@Resource
	LocalhostSignService localhostSignService;

	private String jsonStr;
	private String jsonFromWeb;

    public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	public String getJsonFromWeb() {
		return jsonFromWeb;
	}

	public void setJsonFromWeb(String jsonFromWeb) {
		this.jsonFromWeb = jsonFromWeb;
	}

	@Action(value="regWithEmail")
	public String regWithEmail() {

		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		try {
			LocalhostLoginModel inModel = gson.fromJson(jsonFromWeb, LocalhostLoginModel.class);
			inModel.setLangId((String) getSession().get(KooConst.LT_SESSION_KEY_LANGID));
			Map<String, Object> inParamMap = new HashMap<String, Object> ();
			inParamMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, inModel);
			KootourMessage retMsg = localhostSignService.regWithEmail(inParamMap);
			if (retMsg.isHasError()) {
				jsonMap.put("result", "error");
				jsonMap.put("message", retMsg.getMessage());
				jsonStr = gson.toJson(jsonMap);
			} else {
				getSession().put(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY, retMsg.getData());
				jsonMap.put("result", "success");
				jsonMap.put("message", retMsg.getMessage());
				jsonStr = gson.toJson(jsonMap);
			}
		} catch (Exception e) {
			jsonMap.put("result", "error");
			jsonMap.put("message", this.getClass().getName() + ":<br>" + e.getMessage());
			jsonStr = gson.toJson(jsonMap);
		}
		return rtnStr;
	}

	@Action(value="regWithFb")
	public String regWithFb() {

		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		try {
			LocalhostLoginModel inModel = gson.fromJson(jsonFromWeb, LocalhostLoginModel.class);
			inModel.setLangId((String) getSession().get(KooConst.LT_SESSION_KEY_LANGID));
			Map<String, Object> inParamMap = new HashMap<String, Object> ();
			inParamMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, inModel);
			KootourMessage retMsg = localhostSignService.regWithFb(inParamMap);
			if (retMsg.isHasError()) {
				jsonMap.put("result", "error");
				jsonMap.put("message", retMsg.getMessage());
				jsonStr = gson.toJson(jsonMap);
			} else {
				getSession().put(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY, retMsg.getData());
				jsonMap.put("result", "success");
				jsonMap.put("message", retMsg.getMessage());
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
