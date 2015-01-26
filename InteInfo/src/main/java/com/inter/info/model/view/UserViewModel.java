package com.inter.info.model.view;

/**
 * @author OprCalf
 * @Date 2014/01/06
 * 
 */

import java.util.Date;

public class UserViewModel implements java.io.Serializable {

	private static final long serialVersionUID = -1661992445541018385L;
	private int userid;
	private String staffid;
	private String username;
	private String userpassword;
	private Date createdate;
	private String createby;
	private Date updatedate;
	private String updateby;
	private String email;
	private String hiddenUserId;

	//Additional Attribute
	private String LoginMessage;
	private String returnLoginMessage;
	



	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public String getReturnLoginMessage() {
		return returnLoginMessage;
	}

	public void setReturnLoginMessage(String returnLoginMessage) {
		this.returnLoginMessage = returnLoginMessage;
	}

	public String getLoginMessage() {
		return LoginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		LoginMessage = loginMessage;
	}

	private int page;
	private int rows;
	private String sort;
	private String order;
	private String ids;


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHiddenUserId() {
		return hiddenUserId;
	}

	public void setHiddenUserId(String hiddenUserId) {
		this.hiddenUserId = hiddenUserId;
	}
	
	
	

}
