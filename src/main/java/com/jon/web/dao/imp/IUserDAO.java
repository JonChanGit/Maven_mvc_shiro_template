package com.jon.web.dao.imp;

import java.util.List;

import com.jon.web.entity.SysUser;

/**
 * 接口
 * 由于Spring需要使用代理类来调用方，所以需要声明接口
 * @author jon75
 *
 */
public interface IUserDAO {
	public void addUser(SysUser user) ;
	
	public List<SysUser> getAllUser();
	
	/**
	 * 删除
	 * @param userId
	 * @return
	 */
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
