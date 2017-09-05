package com.yys.common.service;

import java.util.List;
import java.util.Map;
 /**
 *  Role 表数据服务层接口
 * User: 杨永生
 * Date: 15:12 2017/9/1
 * Email: 1095737364@qq.com
 */
public interface RoleService  {
   public List<Map<Integer, String>> findRoleResourceListByRoleId(Integer roleId);
}