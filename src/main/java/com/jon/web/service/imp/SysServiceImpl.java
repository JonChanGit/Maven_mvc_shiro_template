package com.jon.web.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jon.web.dao.SysPermissionDAO;
import com.jon.web.dao.SysUserDAO;
import com.jon.web.entity.SysPermission;
import com.jon.web.entity.SysUser;
import com.jon.web.entity.dto.ActiveUser;
import com.jon.web.service.SysService;

public class SysServiceImpl implements SysService {

	private SysUserDAO sysUserDAO;

	private SysPermissionDAO sysPermissionDAO;

	@Override
	public ActiveUser authenticat(String userCode, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception {
		return sysPermissionDAO.findMenuListByUserId(userid);
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysUser findSysUserByUserCode(String userCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public SysPermissionDAO getSysPermissionDAO() {
		return sysPermissionDAO;
	}

	public SysUserDAO getSysUserDAO() {
		return sysUserDAO;
	}

	public void setSysPermissionDAO(SysPermissionDAO sysPermissionDAO) {
		this.sysPermissionDAO = sysPermissionDAO;
	}

	public void setSysUserDAO(SysUserDAO sysUserDAO) {
		this.sysUserDAO = sysUserDAO;
	}
	
	//@Autowired
	//private SysPermissionMapperCustom sysPermissionMapperCustom;

	 


}
