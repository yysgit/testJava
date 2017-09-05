package com.yys.common.service.impl;

import com.yys.common.dao.RoleDao;
import com.yys.common.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
/**
 * User: 杨永生
 * Date: 10:08 2017/9/4
 * Email: 1095737364@qq.com
 */
@Service
public class RoleServiceImpl  implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Map<Integer, String>> findRoleResourceListByRoleId(Integer roleId) {
        return roleDao.selectList("findRoleResourceListByRoleId",roleId);
    }

}