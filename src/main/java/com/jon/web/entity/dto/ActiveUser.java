package com.jon.web.entity.dto;

import java.io.Serializable;
import java.util.List;

import com.jon.web.entity.SysPermission;

/**
 * 
 *
 * @Title: ActiveUser.java
 * @Package com.jon.web.entity.dto
 * @Description: 用户身份信息，存入session 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 * @author JonChan
 * @date 2016年5月22日 上午8:26:08
 * @version V1.0
 *
 */
public class ActiveUser implements Serializable {

	private String userid;// 用户id（主键）
	private String usercode;// 用户账号
	private String username;// 用户名称
	private String useremail;// 用户邮箱
	private List<SysPermission> menus;// 菜单

	private List<SysPermission> permissions;// 权限

	public List<SysPermission> getMenus() {
		return menus;
	}
	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public String getUsercode() {
		return usercode;
	}

	public String getUseremail() {
		return useremail;
	}

	public String getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public void setMenus(List<SysPermission> menus) {
		this.menus = menus;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
