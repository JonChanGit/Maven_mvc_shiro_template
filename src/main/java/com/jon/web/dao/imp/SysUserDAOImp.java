package com.jon.web.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.jon.web.dao.SysUserDAO;
import com.jon.web.entity.SysUser;
import com.jon.web.entity.dto.SysUserExample;
import com.jon.web.entity.dto.SysUserExample.Criteria;

public class SysUserDAOImp implements SysUserDAO {
	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<SysUser> selectByExample(String userCode) {
		
		String hql = "from SysUser where usercode = '"+userCode +"'";
		Query createQuery = sessionFactory.getCurrentSession().createQuery(hql);
		
		return createQuery.list();
	}
}
