//Auto Generated

package com.kootour.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;

import com.kootour.common.KooConst;
import com.kootour.model.LocalhostLoginModel;
import com.kootour.service.LocalhostLoginService;

@Results({@Result(name = "gotohome", value = "localhostLogin!load", type = ServletActionRedirectResult.class)})
public class LocalhostChangePasswordAction extends LocalhostLoginModel {

	@Resource
	LocalhostLoginService localhostLoginService;

	public String load() {
		Map<String, Object> session = getSession();
		if (session == null || getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY) == null || session.get(KooConst.LT_SESSION_KEY_LANGID) == null) {
			return "gotohome";
		}
		return "success";
	}
}
