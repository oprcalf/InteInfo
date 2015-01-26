package com.inter.info.action;

import java.util.Map;

import org.apache.log4j.Logger;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.inter.info.model.User;
import com.inter.info.model.view.UserViewModel;
import com.inter.info.server.IUserService;
import com.inter.info.utils.HandleSessionInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/Login")
@Action(value = "loginAction")
@Results(value = { @Result(name = "returnToLogin", location = "/WEB-INF/login/Login.jsp"),
		@Result(name = "loginSuccessfully", location = "loginAction!Mian.action", type = "redirect"),
		@Result(name = "main", location = "/WEB-INF/main/main.jsp") })
public class LoginAction extends BaseAction implements ModelDriven<UserViewModel> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	private static final long serialVersionUID = 4173924159952461746L;
	private UserViewModel userViewModel = new UserViewModel();
	private IUserService userService;

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

	public String doNotNeedSession_ReturnLogin() throws Exception {

		if (!userViewModel.getLoginMessage().isEmpty() && !userViewModel.getLoginMessage().equals("")) {
			if (userViewModel.getLoginMessage().equals("returnToLogin")) {
				userViewModel.setReturnLoginMessage("");
			}
			if (userViewModel.getLoginMessage().equals("notExitStaffID")) {
				userViewModel.setReturnLoginMessage("用户名不存在");
			}
			if (userViewModel.getLoginMessage().equals("errorPassword")) {
				userViewModel.setReturnLoginMessage("密码错误");
			}
		}
		return "returnToLogin";
	}

	public String doNotNeedSession_LoginResult() throws Exception {
		User user = userService.getUserByStaffID(userViewModel.getStaffid());
		Boolean checkUser = userService.checkUser(userViewModel.getStaffid(), userViewModel.getUserpassword());
		if (user != null) {
			String needPassword = getProperties("NeedPassword");
			Boolean b = true;
			if (needPassword != null && needPassword != "") {
				b = Boolean.valueOf(needPassword).booleanValue();
			}
			if (b) {
				if (checkUser) {
					HandleSessionInfo sessionInfo = new HandleSessionInfo();
					sessionInfo.setUser(user);
					ActionContext.getContext().getSession().put("sessionInfo", sessionInfo);
					return "loginSuccessfully";
				} else {
					userViewModel.setLoginMessage("errorPassword");
					return doNotNeedSession_ReturnLogin();
				}
			} else {
				HandleSessionInfo sessionInfo = new HandleSessionInfo();
				sessionInfo.setUser(user);
				ActionContext.getContext().getSession().put("sessionInfo", sessionInfo);
				return "loginSuccessfully";
			}
		} else {
			userViewModel.setLoginMessage("notExitStaffID");
			return doNotNeedSession_ReturnLogin();
		}
	}

	public String logoutSession() throws Exception {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		if(session!=null){
			session.clear();
		}
		logger.info(session);
		return "returnToLogin";
	}

	public String Mian() throws Exception {
		return "main";
	}

}
