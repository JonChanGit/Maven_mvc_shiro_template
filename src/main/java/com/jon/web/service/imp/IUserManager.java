package com.jon.web.service.imp;

import java.util.List;

import com.jon.web.entity.SysUser;

public interface IUserManager {
	public void addUser(SysUser user);
	
	public List<SysUser> getAllUser();
	
	public boolean deleteUser(long userId);
	
	/**
	 * 查找一个具体的User
	 * @param id
	 * @return
	 */
	public SysUser getUser(long id);
	
	/**
	 * 更新
	 * @param user
	 * @return
	 */
	public boolean updateUser(SysUser user);
}
