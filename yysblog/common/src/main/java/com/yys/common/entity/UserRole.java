package com.yys.common.entity;


import com.yys.common.basics.AbstractObject;

/**
 *
 * 角色资源
 *
 */

public class UserRole extends AbstractObject {


	/** 主键id */
	private Long id;

	/** 角色id */
	private Long roleId;

	/** 资源id */
	private Long userId;


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
