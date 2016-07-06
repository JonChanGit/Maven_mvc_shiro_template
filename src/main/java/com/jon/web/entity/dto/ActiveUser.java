package com.jon.web.entity.dto;

import java.io.Serializable;

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
public class ActiveUser implements Serializable{

	private String userid;//用户id（主键）
	private String usercode;// 用户账号
	private String username;// 用户名称
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	/*private List<SysPermission> menus;// 菜单
	private List<SysPermission> permissions;// 权限*/
	
}
