package com.yys.common.service.impl;


import com.yys.common.dao.UserDao;
import com.yys.common.entity.User;
import com.yys.common.service.UserService;
import com.yys.common.util.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * User: 杨永生
 * Date: 10:08 2017/9/4
 * Email: 1095737364@qq.com
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public int saveUser(User user) throws Exception {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
       return userDao.save("saveUser",user);
    }

    @Override
    public User findUserByUserName(String username) {
        return userDao.selectOne("findUserByUserName",username);
    }
}
