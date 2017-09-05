package com.yys.common.service.impl;


import com.yys.common.dao.UserRoleDao;
import com.yys.common.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * User: 杨永生
 * Date: 10:08 2017/9/4
 * Email: 1095737364@qq.com
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public List<Integer> findRoleIdListByUserId(Integer userId) {
        return userRoleDao.selectList("findRoleIdListByUserId",userId);
    }

}