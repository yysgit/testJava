package com.yys.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.yys.common.basics.AbstractObject;

/**
 *
 * 资源
 *
 */
public class Resource extends AbstractObject {



	/** 主键 */
	private Long id;

	/** 资源名称 */
	private String name;

	/** 资源路径 */
	private String url;

	/** 资源介绍 */
	private String description;

	/** 资源图标 */
	private String icon;

	/** 父级资源id */
	private Long pid;

	/** 排序 */
	private Integer seq;

	/** 状态 */
	private Integer status;

	/** 资源类别 */
	private Integer resourceType;

	/** 创建时间 */
	private Date createTime;
	/** 操作权限对应的角色 */
	private List<Role> roles;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
