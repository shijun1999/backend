//Auto Generated

package com.kootour.action;

import java.util.Map;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;

import com.kootour.common.KooConst;
import com.kootour.model.LocalhostExclusiveDateModel;

@Results({@Result(name = "gotohome", value = "localhostLogin!load", type = ServletActionRedirectResult.class)})
public class LocalhostExclusiveDateAction extends LocalhostExclusiveDateModel {

	public String load() {
		Map<String, Object> session = getSession();
		if (session == null || getSession().get(KooConst.LT_SESSION_KEY_LOCALHOSTENTITY) == null || session.get(KooConst.LT_SESSION_KEY_LANGID) == null) {
			return "gotohome";
		}
		return "success";
	}
}
