package com.jon.web.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.jon.web.dao.SysPermissionDAO;
import com.jon.web.entity.SysPermission;

/**
 * 对数据库 t_sys_permission 表的操作集合
 * 控制访问权限
 * @author jon75
 *
 */

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
		String hql = "from SysPermission where type = 'menu' and id in"+
						" (select sysPermissionId from SysRolePermission where sysRoleId in "+
							"(select sysRoleId from SysUserRole where sysUserId = '"+userid+"'))";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return (List<SysPermission>)query.list();
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
