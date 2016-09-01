package com.kootour.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@ParentPackage("default")
public class BaseAction extends ActionSupport
		implements Preparable, ServletRequestAware, ServletResponseAware, ServletContextAware, SessionAware {
	/**
	 *
	 */
	private static final long serialVersionUID = 7720865502093820229L;

	private Map<String, Object> session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext context;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	@JSON(serialize = false)
	public Map<String, Object> getSession() {
		return session;
	}

	@JSON(serialize = false)
	public HttpServletRequest getRequest() {
		return request;
	}

	@JSON(serialize = false)
	public HttpServletResponse getResponse() {
		return response;
	}

	@JSON(serialize = false)
	public ServletContext getContext() {
		return context;
	}

	@Override
	public void prepare() throws Exception {
	}
}
