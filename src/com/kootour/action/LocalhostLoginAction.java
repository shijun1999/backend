//Auto Generated

package com.kootour.action;

import javax.annotation.Resource;

import com.kootour.common.KooConst;
import com.kootour.model.LocalhostLoginModel;
import com.kootour.service.LocalhostLoginService;

public class LocalhostLoginAction extends LocalhostLoginModel {

	@Resource
	LocalhostLoginService localhostLoginService;

	public String load() {
		getSession().clear();
		//TODO lang id hard code
		getSession().put(KooConst.LT_SESSION_KEY_LANGID, "en");
		return "success";
	}

	public String logout() {
		getSession().clear();
		//TODO lang id hard code
		getSession().put(KooConst.LT_SESSION_KEY_LANGID, "en");
		return "success";
	}
}
