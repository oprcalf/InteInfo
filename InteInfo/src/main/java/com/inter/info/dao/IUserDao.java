package com.inter.info.dao;

import com.inter.info.model.User;

public interface IUserDao {
	
	public void save(User user);
	public Boolean getUser(User user);

}
