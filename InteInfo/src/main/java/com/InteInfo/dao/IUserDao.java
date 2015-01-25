package com.InteInfo.dao;

import com.InteInfo.model.User;

public interface IUserDao {
	
	public void save(User user);
	public Boolean getUser(User user);

}
