package com.kootour.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class KooInterceptor implements Interceptor {

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//TODO pre
		Map<String, Object> session = invocation.getInvocationContext().getSession();


		if (session.isEmpty()) {

//			String langId = "ja";
//			getSession().put(KooConst.ST_LANGID, langId);
//			setLangId(langId);
//
//			String state = "日本";
//			getSession().put(KooConst.ST_STATE, state);
//
//			String city = "横浜";
//			getSession().put(KooConst.ST_CITY, city);
//
//			getSession().put(KooConst.ST_RELOAD, KooConst.STR_RELOAD_DIV_NO);
//
//			getSession().put(KooConst.ST_TOURISTID, "B00000000001");

			//String langId = "ja";
			//session.put(KooConst.ST_LANGID, langId);
//			setLangId(langId);

			//String state = "日本";
			//session.put(KooConst.ST_STATE, state);

			//String city = "横浜";
			//session.put(KooConst.ST_CITY, city);

			//session.put(KooConst.ST_RELOAD, KooConst.STR_RELOAD_DIV_NO);

			//session.put(KooConst.ST_TOURISTID, "B00000000001");




		}


		if ("loginIndex".equals(invocation.getProxy().getActionName())) {
			// session.clear();
			// return ("success");
		}

		final String res = invocation.invoke();

		//TODO post
		return res;
	}

}
