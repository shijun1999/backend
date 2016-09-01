//Auto Generated

package com.kootour.action;

import javax.annotation.Resource;

import com.kootour.common.KooConst;
import com.kootour.model.LocalhostLoginModel;
import com.kootour.service.LocalhostLoginService;

public class LocalhostSignupAction extends LocalhostLoginModel {

	@Resource
	LocalhostLoginService localhostLoginService;

	public String load() {
		//TODO lang id hard code
		getSession().put(KooConst.LT_SESSION_KEY_LANGID, "en");
		return "success";
	}
}
