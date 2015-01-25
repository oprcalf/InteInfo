package com.InteInfo.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.InteInfo.utils.HandleEmail;
import com.InteInfo.utils.HandleJson;
import com.InteInfo.utils.HandleProperties;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction extends ActionSupport {

	private static final Logger logger = Logger.getLogger(BaseAction.class);

	private static final long serialVersionUID = 6883203228535458267L;

	public void writeJson(Object object) {
		HandleJson.writeJson(object);
	}

	public void writeException(String ex) {
		logger.error(ex);
	}

	public void sendEmail(String Host, String[] FromAddress, String[] ToAddress, String Subject, String Content,
			String[] FileAddress) {
		HandleEmail sc = new HandleEmail();
		sc.Send(Host, FromAddress, ToAddress, Subject, Content, FileAddress);
	}

	public String getProperties(String str) {
		HandleProperties getProperties = new HandleProperties();
		return getProperties.getProps(str);
	}
}
