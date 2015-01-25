package com.InteInfo.server.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InteInfo.dao.IBaseDao;
import com.InteInfo.model.User;
import com.InteInfo.model.view.DataGrid;
import com.InteInfo.model.view.UserViewModel;
import com.InteInfo.server.IUserService;
import com.InteInfo.utils.HandleMD5;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	private IBaseDao<User> userDao;

	public IBaseDao<User> getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(IBaseDao<User> userDao) {
		this.userDao = userDao;
	}

	public void save() {
		logger.info("测试Spring+Hibernate");
		HandleMD5 md5 = new HandleMD5();

		User user = new User();
		user.setUserpassword(md5.getMDThirtytwo("123456"));
		user.setUsername("张三");
		user.setCreatedate(new Date());
		this.userDao.save(user);

	}

	public User getUser(User user) {
		return null;
	}

	public User getUserByStaffID(String staffid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffid", staffid);
		User user = userDao.get("from User t where t.staffid = :staffid", params);
		if (user != null) {
			return user;
		} else {
			return null;
		}

	}

	public Boolean checkUser(String staffid, String userpassword) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffid", staffid);
		params.put("userpassword", userpassword);
		User user = userDao.get("from User t where t.staffid = :staffid and t.userpassword = :userpassword", params);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	public DataGrid getUserList(UserViewModel uvm) {
		DataGrid dataGrid = new DataGrid();
		List<UserViewModel> userViewModelList = new ArrayList<UserViewModel>();
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "from User t ";
		hql = this.addWhere(uvm, hql, params);
		String totalHql = "select count(*)" + hql;
		if (uvm.getOrder() != null && uvm.getSort() != null) {
			hql = userDao.addOrder(uvm.getSort(), uvm.getOrder(), hql);
		}
		List<User> userList = (List<User>) userDao.find(hql, params, uvm.getPage(), uvm.getRows());
		userViewModelList = this.getListUserViewModel(userList);
		dataGrid.setTotal((userDao.count(totalHql, params)));
		dataGrid.setRows(userViewModelList);
		return dataGrid;
	}

	public String addWhere(UserViewModel userViewModel, String hql, Map<String, Object> params) {
		if (userViewModel.getUsername() != null && !userViewModel.getUsername().trim().equals("")) {
			hql += "where t.username like :name";
			params.put("name", "%" + userViewModel.getUsername().trim() + "%");
		}
		return hql;
	}

	public List<UserViewModel> getListUserViewModel(List<User> userList) {
		List<UserViewModel> userViewModelList = new ArrayList<UserViewModel>();
		UserViewModel userViewModel = null;
		for (User user : userList) {
			userViewModel = new UserViewModel();
			userViewModel.setUserid(user.getUserid());
			userViewModel.setUsername(user.getUsername());
			userViewModel.setCreatedate(user.getCreatedate());
			userViewModelList.add(userViewModel);
		}

		return userViewModelList;
	}

	public UserViewModel getUserByUserID(int userid) {

		String hql = "from User t where t.userid = :userid";
		User user = new User();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", userid);
		user = userDao.get(hql, params);
		UserViewModel userViewModel = null;
		if (user != null) {
			userViewModel = new UserViewModel();
			userViewModel.setUserid(userid);
			userViewModel.setUsername(user.getUsername());
			userViewModel.setStaffid(user.getStaffid());
			userViewModel.setEmail(user.getEmail());
		}
		return userViewModel;
	}

	public void editUserInfoByUserID(int userid, UserViewModel userViewModel) {
		String hql = "from User t where t.userid = :userid";
		User user = new User();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", userid);
		user = userDao.get(hql, params);
		if (userViewModel != null && user != null) {
			user.setUsername(userViewModel.getUsername());
			user.setEmail(userViewModel.getEmail());
			userDao.saveOrUpdate(user);
		}

	}

}
