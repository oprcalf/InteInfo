package com.InteInfo.dao.impl;

import org.apache.log4j.Logger;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.InteInfo.dao.IUserDao;
import com.InteInfo.model.User;
import com.InteInfo.utils.HandleMD5;

@SuppressWarnings("unchecked")
@Repository("userDaoImpl")
public class UserDaoImpl implements IUserDao {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}

	public Boolean getUser(User user) {
		logger.info("进入dao");
		HandleMD5 md5 = new HandleMD5();
		String MDPassword = md5.getMDThirtytwo(user.getUserpassword());
		List<User> listUser = (List<User>)this.sessionFactory.getCurrentSession().createCriteria("from User where staffid = " + user.getStaffid() + " and userpassword = " + MDPassword + ";").list();
		logger.info(listUser.size());
		if (listUser.size() > 0 && listUser.size() == 1) {
			return true;

		} else {
			return false;
		}
	}

}
