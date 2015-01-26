package com.inter.info.utils;

/**
 * @author OprCalf
 * @Date 2014/01/06
 * 
 */

import org.apache.log4j.Logger;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;

public class HandleJson {
	
	private static final Logger logger = Logger.getLogger(HandleJson.class);

	public static void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}

}
