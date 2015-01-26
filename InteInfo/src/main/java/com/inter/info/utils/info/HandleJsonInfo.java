package com.inter.info.utils.info;

import java.util.ArrayList;
import java.util.List;

public class HandleJsonInfo {

	private String success = "";
	private String disMegs = "";
	private Object obj = null;
	private List<Object> objs = new ArrayList<Object>();

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getDisMegs() {
		return disMegs;
	}

	public void setDisMegs(String disMegs) {
		this.disMegs = disMegs;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public List<Object> getObjs() {
		return objs;
	}

	public void setObjs(List<Object> objs) {
		this.objs = objs;
	}

}
