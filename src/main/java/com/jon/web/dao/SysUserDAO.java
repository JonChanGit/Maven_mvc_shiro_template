package com.jon.web.dao;

import java.util.List;

import com.jon.web.entity.SysUser;
import com.jon.web.entity.dto.SysUserExample;

public interface SysUserDAO {

	List<SysUser> selectByExample(String userCode);

}
