package com.yys.common.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.yys.common.basics.AbstractObject;

/**
 *
 * 角色资源
 *
 */

public class RoleResource extends AbstractObject {


	/** 主键id */
	private Integer id;

	/** 角色id */
	private Integer roleId;

	/** 资源id */
	private Integer resourceId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
}
