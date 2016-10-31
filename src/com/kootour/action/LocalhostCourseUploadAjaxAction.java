//Auto Generated

package com.kootour.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.kootour.model.UploadImageModel;
import com.kootour.service.CourseService;
import com.kootour.service.LocalhostAccountService;

import static org.apache.struts2.ServletActionContext.getServletContext;

@ParentPackage("json-default")
@Results({
    @Result(name = "json", type="json", params={"root", "jsonStr"})
})
public class LocalhostCourseUploadAjaxAction extends UploadImageModel {

	@Resource
	CourseService courseService;

	@Resource
	LocalhostAccountService localhostAccountService;

	private String jsonStr;

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	@SuppressWarnings("unchecked")
	@Action(value="uploadImage")
    public String uploadImage() {
		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		Map<String, Object> session = getSession();
		if (session == null || getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY) == null || session.get(KooConst.LT_SESSION_KEY_LANGID) == null) {
			jsonMap.put("result", "error");
			jsonStr = gson.toJson(jsonMap);
			return rtnStr;
		}

		this.setLangId((String) session.get(KooConst.LT_SESSION_KEY_LANGID));
		this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));

		Map<String, Object> paraMap = new HashMap<String, Object> ();
		paraMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);

		try {
			KootourMessage retMsg = courseService.uploadImage(paraMap);

			if (retMsg.isHasError()) {
				jsonMap.put("result", "error");
				jsonMap.put("message", retMsg.getMessage());
				jsonStr = gson.toJson(jsonMap);
			} else {
				jsonMap.put("result", "success");
				jsonMap.put("message", retMsg.getMessage());
				jsonStr = gson.toJson(jsonMap);
				if ((getSession().get(KooConst.LT_SESSION_KEY_UPLOADED_IMAGE_NAME_LIST)) == null) {
					List<String> imageNameList = new ArrayList<String> ();
					imageNameList.add(String.valueOf(retMsg.getData()));
					getSession().put(KooConst.LT_SESSION_KEY_UPLOADED_IMAGE_NAME_LIST, imageNameList);
				} else {
					List<String> imageNameList = (List<String>) getSession().get(KooConst.LT_SESSION_KEY_UPLOADED_IMAGE_NAME_LIST);
					imageNameList.add(String.valueOf(retMsg.getData()));
					getSession().put(KooConst.LT_SESSION_KEY_UPLOADED_IMAGE_NAME_LIST, imageNameList);
				}
			}
		} catch (Exception e) {
			jsonMap.put("result", "error");
			jsonMap.put("message", this.getClass().getName() + ":<br>" + e.getMessage());
			jsonStr = gson.toJson(jsonMap);
		}
		return rtnStr;
    }

	@Action(value="uploadAvatar")
    public String uploadAvatar() {
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

			KootourMessage retMsg = localhostAccountService.uploadAvatar(paraMap);

			if (!retMsg.isHasError()) {
				LocalhostEntity newEntity = (LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY);
				newEntity.setPhoto(String.valueOf(retMsg.getData()));
				getSession().replace(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY, newEntity);
				jsonMap.put("result", "success");
				jsonMap.put("data", retMsg.getData());
				jsonMap.put("message", retMsg.getMessage());
				jsonStr = gson.toJson(jsonMap);
			} else {
				jsonMap.put("result", "error");
				jsonMap.put("data", "");
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

	@Action(value="deleteImage")
    public String deleteImage() {
		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		Map<String, Object> session = getSession();
		if (session == null || getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY) == null || session.get(KooConst.LT_SESSION_KEY_LANGID) == null) {
			jsonMap.put("result", "error");
			jsonStr = gson.toJson(jsonMap);
			return rtnStr;
		}

		try {
			this.setLangId((String) session.get(KooConst.LT_SESSION_KEY_LANGID));
			this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));

			Map<String, Object> paraMap = new HashMap<String, Object> ();
			paraMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);

			KootourMessage retMsg = courseService.deleteImage(paraMap);

			if (retMsg.isHasError()) {
				jsonMap.put("result", "error");
				jsonMap.put("message", retMsg.getMessage());
				jsonStr = gson.toJson(jsonMap);
			} else {
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
