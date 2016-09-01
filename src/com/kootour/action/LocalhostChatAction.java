//Auto Generated

package com.kootour.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;

import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.model.LocalhostChatModel;
import com.kootour.service.LocalhostMessageService;

@Results({@Result(name = "gotohome", value = "localhostLogin!load", type = ServletActionRedirectResult.class)})
public class LocalhostChatAction extends LocalhostChatModel {

	@Resource
	LocalhostMessageService localhostMessageService;

	public String load() {
		Map<String, Object> session = getSession();
		if (session == null || getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY) == null || session.get(KooConst.LT_SESSION_KEY_LANGID) == null) {
			return "gotohome";
		}

		this.setLangId((String) session.get(KooConst.LT_SESSION_KEY_LANGID));
		this.setLocalhostEntity((LocalhostEntity) getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY));

		Map<String, Object> paraMap = new HashMap<String, Object> ();
		paraMap.put(KooConst.LT_IN_PARAM_MODEL_KEY, this);

		KootourMessage retMsg = localhostMessageService.load(paraMap);
		if (retMsg.isHasError()) {
		} else {
			LocalhostChatModel outModel = (LocalhostChatModel) retMsg.getData();
			this.setLoginType(outModel.getLoginType());
			this.setFirstName(outModel.getFirstName());
			this.setPicture(outModel.getPicture());
			this.setLocation(outModel.getLocation());
			this.setCreateTime(outModel.getCreateTime());
		}
		return "success";
	}
}
