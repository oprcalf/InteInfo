package com.inter.info.server;

import com.inter.info.model.User;
import com.inter.info.model.view.DataGrid;
import com.inter.info.model.view.UserViewModel;

public interface IUserService {
	
	public void save();
	public User getUser(User user);
	public User getUserByStaffID(String staffid);
	public Boolean checkUser(String staffid, String userpassword);
	public DataGrid getUserList(UserViewModel userViewModel);
	public UserViewModel getUserByUserID(int userid);
	public void editUserInfoByUserID(int userid, UserViewModel userViewModel);

}
