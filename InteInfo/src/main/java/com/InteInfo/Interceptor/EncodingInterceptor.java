package com.InteInfo.Interceptor;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 字符集编码拦截器
 * 
 * @author OprCalf
 * 
 */
public class EncodingInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -8441343158350795397L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {

		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		return actionInvocation.invoke();

	}
}
