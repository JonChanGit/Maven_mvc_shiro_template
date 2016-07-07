package com.jon.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_sys_user")
public class SysUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 32)
	private String email;

	@Column(length = 32)
	private String pwd;
	private String usercode;

	private String username;

	private String password;

	/**
	 * 盐
	 */
	private String salt;

	/**
	 * 账号是否锁定，1：锁定，0未锁定
	 */
	private String locked;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	/**
	 * 
	 * @Title: getEmail 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	public String getPwd() {
		return pwd;
	}

	/**
	 * 
	 * @Title: setEmail 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
