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
import com.kootour.model.LocalhostBankInformationModel;
import com.kootour.service.LocalhostBankInformationService;

@ParentPackage("json-default")
@Results({
    @Result(name = "json", type="json", params={"root", "jsonStr"})
})
public class LocalhostBankInformationAjaxAction extends BaseModel {

	@Resource
	LocalhostBankInformationService localhostBankInformationService;

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

	@Action(value="updateBankInformation")
    public String updateBankInformation() {
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
			LocalhostBankInformationModel inModel = gson.fromJson(jsonFromWeb, LocalhostBankInformationModel.class);
			inModel.setLangId((String) session.get(KooConst.LT_SESSION_KEY_LANGID));
			inModel.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));
			Map<String, Object> paraMap = new HashMap<String, Object> ();
			paraMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, inModel);

			KootourMessage result = localhostBankInformationService.updateBankInformation(paraMap);

			if (!result.isHasError()) {
				jsonMap.put("result", "success");
				jsonMap.put("data", "");
				jsonMap.put("message", result.getMessage());
				jsonStr = gson.toJson(jsonMap);
			} else {
				jsonMap.put("result", "error");
				jsonMap.put("data", "");
				jsonMap.put("message", result.getMessage());
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
