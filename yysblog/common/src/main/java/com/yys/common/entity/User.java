package com.yys.common.entity;
import com.yys.common.basics.AbstractObject;
import com.yys.common.entityView.VUser;

/**
 * User: 杨永生
 * Date: 10:09 2017/9/4
 * Email: 1095737364@qq.com
 */


public class User extends VUser{

    /** 用户Id */
    private Integer userId;
    /** 用户昵称 */
    private String userName="";
    /** 密码 */
    private String password="";

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

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}