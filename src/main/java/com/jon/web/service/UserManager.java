package com.jon.web.service;

import java.util.List;

import com.jon.web.dao.imp.IUserDAO;
import com.jon.web.entity.SysUser;
import com.jon.web.service.imp.IUserManager;

public class UserManager implements IUserManager {

	private IUserDAO userDAO;
	
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}



	@Override
	public void addUser(SysUser user) {
		userDAO.addUser(user);
	}



	@Override
	public List<SysUser> getAllUser() {
		
		return userDAO.getAllUser();
	}



	@Override
	public boolean deleteUser(long userId) {
		return userDAO.deleteUser(userId);
	}



	@Override
	public SysUser getUser(long id) {
		return userDAO.getUser(id);
	}



	@Override
	public boolean updateUser(SysUser user) {
		return userDAO.updateUser(user);
	}

}
