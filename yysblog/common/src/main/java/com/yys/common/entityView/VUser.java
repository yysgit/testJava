package com.yys.common.entityView;


import com.yys.common.basics.AbstractObject;
import com.yys.common.entity.Role;
import com.yys.common.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.List;


/**
 * @description：UserVo
 * @author：zhixuan.wang
 * @date：2015/10/1 14:51
 */
public class VUser extends AbstractObject {
	private Integer userId;
	private String userName;
	private String password;

	private List<Role> rolesList;

	public VUser() {
	}

	public VUser(VUser vUser){
		BeanUtils.copyProperties(vUser,this);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<Role> rolesList) {
		this.rolesList = rolesList;
	}

	/**
	 * 比较vo和数据库中的用户是否同一个user，采用id比较
	 * @param user 用户
	 * @return 是否同一个人
	 */
	public boolean equalsUser(User user) {
		if (user == null) {
			return false;
		}
		Integer userId = user.getUserId();
		if (this.userId == null || userId == null) {
			return false;
		}
		return this.userId.equals(userId);
	}

	@Override
	public String toString() {
		return "VUser{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", rolesList=" + rolesList +
				'}';
	}
}