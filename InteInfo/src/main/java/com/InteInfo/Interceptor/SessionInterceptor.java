package com.InteInfo.Interceptor;

import org.apache.struts2.ServletActionContext;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2938872709489831965L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {

		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();

		if (request.getRequestURI().contains("doNotNeedSession_") || request.getRequestURI().endsWith("doNotNeedSessionAndSecurity_")) {
			return actionInvocation.invoke();
		} else {
			if (session.get("sessionInfo") == null) {
				return "noSession";
			} else {
				return actionInvocation.invoke();
			}
		}
	}

}
