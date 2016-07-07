package com.jon.web.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jon.web.entity.SysPermission;
import com.jon.web.entity.SysUser;
import com.jon.web.entity.dto.ActiveUser;
import com.jon.web.service.SysService;

/**
 * 
 *
 * @Title: CustomRealm.java
 * @Package com.jon.web.shiro
 * @Description 自定义realm
 * @author JonChan
 * @date 2016年5月21日 上午11:01:44
 * @version V1.0
 *
 */
public class CustomRealm extends AuthorizingRealm {

	/**
	 * 注入SysService
	 */
	private SysService sysService;
	

	/**
	 * 设置realm的名称
	 */
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	/**
	 * 用于授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// 获取主身份信息
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();

		// 获取权限信息
		List<SysPermission> permissions = null;
		try {
			permissions = sysService.findPermissionListByUserId(activeUser.getUsercode());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> percodeList = new ArrayList<String>();
		
		for (SysPermission item : permissions) {
			percodeList.add(item.getPercode());
		}

		// 查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(percodeList);

		return simpleAuthorizationInfo;
	}

	/**
	 * 用于认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		// token是用户输入的
		// 第一步从token中取出身份信息
		String userCode = (String) token.getPrincipal();

		// 第二步：根据用户输入的userCode从数据库查询
		SysUser sysUser = null;
		try {
			sysUser = sysService.findSysUserByUserCode(userCode);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 如果查询不到返回null
		// 数据库中用户账号是759282337
		if (sysUser == null) {//
			return null;
		}

		// 模拟从数据库查询到密码
		String password = sysUser.getPassword();

		// 如果查询到返回认证信息AuthenticationInfo

		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid("ID:"+sysUser.getId());
		activeUser.setUsercode(sysUser.getUsercode());
		activeUser.setUsername(sysUser.getUsername());
		activeUser.setUseremail(sysUser.getEmail());
		// 根据ID取菜单
		List<SysPermission> menuList = null;
		try {
			menuList = sysService.findMenuListByUserId("759282337");
		} catch (Exception e) {
			e.printStackTrace();
		}
		activeUser.setMenus(menuList);

		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(activeUser, password,ByteSource.Util.bytes(sysUser.getSalt()),this.getName());

		return simpleAuthenticationInfo;
	}

	public SysService getSysService() {
		return sysService;
	}

	public void setSysService(SysService sysService) {
		this.sysService = sysService;
	}

}
