package com.jon.web.dao;

import java.util.List;

import com.jon.web.entity.SysPermission;

public interface SysPermissionDAO {
	// 根据用户id查询菜单
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception;

	// 根据用户id查询权限url
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception;
}
