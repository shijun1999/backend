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
import com.kootour.mapper.entity.CoursePictureEntity;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.model.BaseModel;
import com.kootour.model.LocalhostCourseModel;
import com.kootour.model.UploadImageModel;
import com.kootour.service.CourseService;

@ParentPackage("json-default")
@Results({
    @Result(name = "json", type="json", params={"root", "jsonStr"})
})
public class LocalhostCourseEditAjaxAction extends BaseModel {

	@Resource
	CourseService courseService;

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
	
	@Action(value="editCoursePicturesPrev")
    public String editCoursePicturesPrev() {
		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		Map<String, Object> session = getSession();
		if (this.getCourseIdentiNo() == null || session == null || getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY) == null || session.get(KooConst.LT_SESSION_KEY_LANGID) == null) {
			jsonMap.put("result", "error");
			jsonStr = gson.toJson(jsonMap);
			return rtnStr;
		}
		
		this.setLangId((String) session.get(KooConst.LT_SESSION_KEY_LANGID));
		this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));

		Map<String, Object> paraMap = new HashMap<String, Object> ();
		paraMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);
		
		List<CoursePictureEntity> pictureNameList =  courseService.findCoursePictures(paraMap);
		List<String> previewFileNameList = new ArrayList<String>();
		if ( pictureNameList != null && pictureNameList.size() > 0 ) {
			for (CoursePictureEntity coursePicture : pictureNameList) {
				previewFileNameList.add(coursePicture.getFullName());
			}
		}
		if (getSession().get(KooConst.LT_SESSION_KEY_UPLOADED_IMAGE_NAME_LIST) != null) {
			for (String imageName : (List<String>)getSession().get(KooConst.LT_SESSION_KEY_UPLOADED_IMAGE_NAME_LIST)) {
				previewFileNameList.add(imageName);
			}
		}

//		this.setLangId((String) session.get(KooConst.LT_SESSION_KEY_LANGID));
//		this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));
//
//		Map<String, Object> paraMap = new HashMap<String, Object> ();
//		paraMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);
		
//		try {
//			KootourMessage retMsg = courseService.editCourseInit(paraMap);
//
//			if (retMsg.isHasError()) {
//				jsonMap.put("result", "error");
//				jsonMap.put("message", retMsg.getMessage());
//				jsonStr = gson.toJson(jsonMap);
//			} else {
//				jsonMap.put("result", "success");
//				jsonMap.put("message", retMsg.getMessage());
//				jsonMap.put("data", retMsg.getData());
//				jsonStr = gson.toJson(jsonMap);
//			}
//		} catch (Exception e) {
//			jsonMap.put("result", "error");
//			jsonMap.put("message", this.getClass().getName() + ":<br>" + e.getMessage());
//			jsonStr = gson.toJson(jsonMap);
//		}
		
		jsonMap.put("result", "success");
		jsonMap.put("message", "");
		jsonMap.put("data", previewFileNameList);
		jsonStr = gson.toJson(jsonMap);
		
		return rtnStr;
    }

	@Action(value="editCourseInit")
    public String editCourseInit() {
		String rtnStr = "json";
		Map<String, Object> jsonMap = new HashMap<String, Object> ();
		Gson gson = new Gson();

		Map<String, Object> session = getSession();
		if (this.getCourseIdentiNo() == null || session == null || getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY) == null || session.get(KooConst.LT_SESSION_KEY_LANGID) == null) {
			jsonMap.put("result", "error");
			jsonStr = gson.toJson(jsonMap);
			return rtnStr;
		}

		this.setLangId((String) session.get(KooConst.LT_SESSION_KEY_LANGID));
		this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));

		Map<String, Object> paraMap = new HashMap<String, Object> ();
		paraMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);

		try {
			KootourMessage retMsg = courseService.editCourseInit(paraMap);

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

	@SuppressWarnings("unchecked")
	@Action(value="updateCourse")
    public String updateCourse() {
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
			LocalhostCourseModel inModel = gson.fromJson(jsonFromWeb, LocalhostCourseModel.class);
			UploadImageModel inUploadImageModel = new UploadImageModel();
			inModel.setLangId((String) session.get(KooConst.LT_SESSION_KEY_LANGID));
			inModel.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));
			if (getSession().get(KooConst.LT_SESSION_KEY_UPLOADED_IMAGE_NAME_LIST) != null) {
				inUploadImageModel.setUploadedFileName((List<String>) getSession().get(KooConst.LT_SESSION_KEY_UPLOADED_IMAGE_NAME_LIST));
			}
			Map<String, Object> paraMap = new HashMap<String, Object> ();
			paraMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, inModel);
			paraMap.put(KooConst.LT_IN_PARAM_UPLOAD_IMAGE_KEY, inUploadImageModel);

			KootourMessage retMsg = courseService.updateCourse(paraMap);

			if (retMsg.isHasError()) {
				jsonMap.put("result", "error");
				jsonMap.put("message", retMsg.getMessage());
				jsonStr = gson.toJson(jsonMap);
			} else {
				if (getSession().get(KooConst.LT_SESSION_KEY_UPLOADED_IMAGE_NAME_LIST) != null) {
					getSession().remove(KooConst.LT_SESSION_KEY_UPLOADED_IMAGE_NAME_LIST);
				}
				jsonMap.put("result", "success");
				jsonMap.put("message", retMsg.getMessage());
				jsonStr = gson.toJson(jsonMap);

			}
		} catch (Exception e) {
			jsonMap.put("result", "error");
			jsonStr = gson.toJson(jsonMap);
		}
		return rtnStr;
    }
}
