package com.yys.common.service;

import java.util.List;

/**
 *  user 和 Role 关联表
 * User: 杨永生
 * Date: 15:12 2017/9/1
 * Email: 1095737364@qq.com
 */
public interface UserRoleService {
     /**
      * 通过用户名得到角色列表
      * @param userId
      * @return
      */
     public List<Integer> findRoleIdListByUserId(Integer userId);

}