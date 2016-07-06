package com.jon.web.dao.imp;

import org.hibernate.SessionFactory;

import com.jon.web.dao.SysUserDAO;

public class SysUserDAOImp implements SysUserDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
