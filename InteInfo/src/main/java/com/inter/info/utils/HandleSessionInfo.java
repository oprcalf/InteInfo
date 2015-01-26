package com.inter.info.utils;

import com.inter.info.model.User;

/**
 * sessionInfo模型，只要登录成功，就需要设置到session里面，便于系统使用
 * 模型驱动的设计，设置原因参考了.NET MVC设计方式
 * @author OprCalf
 * @Date 2013/12/27
 * 
 */
@SuppressWarnings("serial")
public class HandleSessionInfo implements java.io.Serializable {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return user.getUsername();
	}

}
