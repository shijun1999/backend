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
import com.kootour.model.LocalhostMessageModel;
import com.kootour.service.LocalhostMessageService;

@ParentPackage("json-default")
@Results({
    @Result(name = "json", type="json", params={"root", "jsonStr"})
})
public class LocalhostMessageAjaxAction extends LocalhostMessageModel {

	@Resource
	LocalhostMessageService localhostMessageService;

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

	@Action(value="fetchMessage")
	public String fetchMessage() {
		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		try {
			this.setLangId((String) getSession().get(KooConst.LT_SESSION_KEY_LANGID));
			this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));
			Map<String, Object> inParamMap = new HashMap<String, Object> ();
			inParamMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);
			KootourMessage retMsg = localhostMessageService.fetchMessage(inParamMap);
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

	@Action(value="fetchSeeMore")
	public String fetchSeeMore() {
		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		try {
			this.setLangId((String) getSession().get(KooConst.LT_SESSION_KEY_LANGID));
			this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));
			Map<String, Object> inParamMap = new HashMap<String, Object> ();
			inParamMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);
			KootourMessage retMsg = localhostMessageService.fetchSeeMore(inParamMap);
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

	@Action(value="fetchNotification")
	public String fetchNotification() {
		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		try {
			this.setLangId((String) getSession().get(KooConst.LT_SESSION_KEY_LANGID));
			this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));
			Map<String, Object> inParamMap = new HashMap<String, Object> ();
			inParamMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);
			KootourMessage retMsg = localhostMessageService.fetchNotification(inParamMap);
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

	@Action(value="readNotification")
	public String readNotification() {
		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		try {
			this.setLangId((String) getSession().get(KooConst.LT_SESSION_KEY_LANGID));
			this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));
			Map<String, Object> inParamMap = new HashMap<String, Object> ();
			inParamMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);
			KootourMessage retMsg = localhostMessageService.readNotification(inParamMap);
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
