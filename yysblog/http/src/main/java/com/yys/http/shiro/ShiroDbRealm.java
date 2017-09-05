package com.yys.http.shiro;

import com.yys.common.entity.User;
import com.yys.common.service.RoleService;
import com.yys.common.service.UserRoleService;
import com.yys.common.service.UserService;
import com.yys.common.util.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * User: 杨永生
 * Date: 10:08 2017/9/4
 * Email: 1095737364@qq.com
 */
public class ShiroDbRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        LOGGER.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.findUserByUserName(token.getUsername());//查询可以自己设置个值模拟数据库查询
        // 账号不存在
        if (user == null) {
            return null;
        }
        // 账号未启用
//        if (user.getStatus() == 1) {
//            return null;
//        }
        List<Integer> roleList = userRoleService.findRoleIdListByUserId(user.getUserId());//查询可以自己设置个值模拟数据库查询
        ShiroUser shiroUser = new ShiroUser(user.getUserId(),  user.getUserName(), roleList);
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(), getName());

    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        LOGGER.info("Shiro权限认证");
      ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        List<Integer> roleList = shiroUser.roleList;
        Set<String> urlSet = new HashSet<String>();
        for (Integer roleId : roleList) {
            List<Map<Integer, String>> roleResourceList = roleService.findRoleResourceListByRoleId(roleId);//查询可以自己设置个值模拟数据库查询
            if (roleResourceList != null) {
                for (Map<Integer, String> map : roleResourceList) {
                    if (!StringUtils.isNullOrEmpty(map.get("url"))) {
                        urlSet.add(map.get("url"));
                    }
                }
            }
        }
        //添加角色
//        Set<String> roles=new HashSet<String>();
//        roles.add("admin");
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        //不添加角色 ,只添加资源
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(urlSet);
        return info;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public UserRoleService getUserRoleService() {
        return userRoleService;
    }

    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}
