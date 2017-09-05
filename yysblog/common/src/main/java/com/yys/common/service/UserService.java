package com.yys.common.service;

import com.yys.common.entity.User;
/**
 *  User 用户表服务接口
 * User: 杨永生
 * Date: 15:12 2017/9/1
 * Email: 1095737364@qq.com
 */
public interface UserService {
    /**
     * 保存用户信息，自动设置保存对象的userid
     * @param user
     * @return
     * @throws Exception
     */
   public int saveUser(User user) throws Exception;
    /**
     * 根据用户id查询用户信息
     * @param name
     * @return
     */
   public User findUserByUserName(String name);

}