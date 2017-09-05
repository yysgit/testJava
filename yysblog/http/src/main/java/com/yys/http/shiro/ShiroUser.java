package com.yys.http.shiro;

import java.io.Serializable;
import java.util.List;
/**
 * User: 杨永生
 * Date: 10:08 2017/9/4
 * Email: 1095737364@qq.com
 */

public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;
    public Integer id;
    public String name;
    public List<Integer> roleList;

    public ShiroUser(Integer id, String name, List<Integer> roleList) {
        this.id = id;
        this.name = name;
        this.roleList = roleList;
    }

    public String getName() {
        return name;
    }

    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return name;
    }
}