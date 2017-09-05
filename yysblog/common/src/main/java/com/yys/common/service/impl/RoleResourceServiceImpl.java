package com.yys.common.service.impl;

import com.yys.common.dao.RoleResourceDao;
import com.yys.common.entity.RoleResource;
import com.yys.common.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * User: 杨永生
 * Date: 10:08 2017/9/4
 * Email: 1095737364@qq.com
 */
@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    private RoleResourceDao roleResourceDao;

    @Override
    public void updateRoleResource(Integer roleId, String resourceIds) {
        // 先删除后添加,有点爆力
        RoleResource roleResource = new RoleResource();
        roleResource.setRoleId(roleId);
        try {
            roleResourceDao.update("deleteRoleResource",roleResource);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] resourceIdArray = resourceIds.split(",");
        for (String resourceId : resourceIdArray) {
            roleResource = new RoleResource();
            roleResource.setRoleId(roleId);
            roleResource.setResourceId(Integer.parseInt(resourceId));
            try {
                roleResourceDao.save("insert",roleResource);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}