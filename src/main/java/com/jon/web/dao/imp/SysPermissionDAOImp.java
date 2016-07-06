package com.jon.web.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;

import com.jon.web.dao.SysPermissionDAO;
import com.jon.web.entity.SysPermission;

public class SysPermissionDAOImp implements SysPermissionDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
