package com.yys.common.service;

/**
 *  Resource 和 Role 关联表
 * User: 杨永生
 * Date: 15:12 2017/9/1
 * Email: 1095737364@qq.com
 */
public interface RoleResourceService {
    /**
     * 更新角色的资源
     * @param roleId
     * @param resourceIds
     */
    void updateRoleResource(Integer roleId, String resourceIds);
}