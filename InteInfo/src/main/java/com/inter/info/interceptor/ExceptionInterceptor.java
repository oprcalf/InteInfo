package com.inter.info.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -2201948906384053916L;

	private static final Logger logger = Logger
			.getLogger(ExceptionInterceptor.class);

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String actionName = actionInvocation.getInvocationContext().getName();
		try {
			String result = actionInvocation.invoke();
			return result;
		} catch (Exception e) {
			logger.error(actionName, e);
			return "error";
		}
	}

}
