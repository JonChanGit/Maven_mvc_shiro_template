package com.jon.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 *
 * @Title: SysPermission.java 
 * @Package com.jon.web.entity 
 * @Description: 权限 --- 菜单
 * @author JonChan
 * @date 2016年5月22日 上午8:44:03 
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sys_permission")
public class SysPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 资源名称
	 */
	private String name;

	/**
	 * 资源类型：menu,button,
	 */
	private String type;

	/**
	 * 访问url地址
	 */
	private String url;

	/**
	 * 权限代码字符串
	 */
	private String percode;

	/**
	 * 父结点id
	 */
	private Long parentid;

	/**
	 * 父结点id列表串
	 */
	private String parentids;

	/**
	 * 排序号
	 */
	private String sortstring;

	/**
	 * 是否可用,1：可用，0不可用
	 */
	private String available;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getParentids() {
		return parentids;
	}

	public void setParentids(String parentids) {
		this.parentids = parentids;
	}

	public String getSortstring() {
		return sortstring;
	}

	public void setSortstring(String sortstring) {
		this.sortstring = sortstring;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}
}
