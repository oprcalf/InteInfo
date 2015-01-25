package com.InteInfo.action;

import org.apache.log4j.Logger;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.InteInfo.model.view.UserViewModel;
import com.InteInfo.server.IUserService;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/User")
@Action(value = "userAction")
@Results(value = { @Result(name = "userList", location = "/WEB-INF/systemManager/userManager/userList.jsp") })
public class UserAction extends BaseAction implements ModelDriven<UserViewModel>{

	private static final long serialVersionUID = 2587043010755557556L;

	private static final Logger logger = Logger.getLogger(UserAction.class);

	private IUserService userService;
	private UserViewModel userViewModel = new UserViewModel();

	public IUserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public UserViewModel getModel() {
		return userViewModel;
	}
	

	public void test() {
		logger.info("进入Action");
		this.userService.save();
	}

	public String userList() throws Exception{
		return "userList";
	}
	
	public void getUserList(){
		super.writeJson(userService.getUserList(userViewModel));
	}
	
	public void getUserInfo(){
		super.writeJson(userService.getUserByUserID(this.userViewModel.getUserid()));
	}
	
	public void editUserInfo(){
		userService.editUserInfoByUserID(userViewModel.getUserid(),userViewModel);
	}


}
