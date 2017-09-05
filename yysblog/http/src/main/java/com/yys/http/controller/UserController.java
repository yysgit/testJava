package com.yys.http.controller;


import com.yys.common.entity.User;
import com.yys.common.service.UserService;
import com.yys.common.util.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * 用户操作表
 * User: 杨永生
 * Date: 15:09 2017/9/1
 * Email: 1095737364@qq.com
 */
@Controller
public class UserController {

    @Autowired
    private UserService userSerivce;

    /**
     * 首页get请求
     * @return
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public String index() {
        //判断 是否 已经登陆认证: 认证成功就跳转到index 页面
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "index";
        }
        return "redirect:/login";
    }
    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index2() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "index";
        }
        return "redirect:/login";
    }

    /**
     * GET 登录
     * @return {String}
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "login";
    }
    /**
     * 登陆
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public String login(User user) {
        Subject userShiro = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),DigestUtils.md5Hex(user.getUserName()).toCharArray());
        // 默认设置为记住密码，你可以自己在表单中加一个参数来控制
        token.setRememberMe(true);
        try {
            userShiro.login(token);
            return "success!";
        } catch (UnknownAccountException e) {
            throw new RuntimeException("账号不存在！", e);
        } catch (DisabledAccountException e) {
            throw new RuntimeException("账号未启用！", e);
        } catch (IncorrectCredentialsException e) {
            throw new RuntimeException("密码错误！", e);
        } catch (Throwable e) {
            throw new RuntimeException("未知错误,请联系管理员！", e);
        }

    }
    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    @ResponseBody
    public String register(User user) {
        System.out.println(user);
        try {
         int issuccess= userSerivce.saveUser(user);
            return "success!";
        } catch (Exception e) {
            return "fail!";
        }
    }
    /**
     * 字段管理页
     *
     * @return
     */
    @RequestMapping(value = "/manager", method = {RequestMethod.GET})
    public String manager() {
        return "success";
    }

    @RequestMapping(value = "/dataGrid", method = {RequestMethod.GET})
    public Object dataGrid(Integer page, Integer rows, String sort, String order) {
        return "success";
    }

    @RequestMapping(value = "/addPage", method = {RequestMethod.GET})
    public String addPage() {
        return "success";
    }

    /**
     * 添加字段
     *
     * @return
     */
    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public Object add() {
            return "success";
    }
    /**
     * 未授权
     * @return {String}
     */
    @RequestMapping(value = "/unauth", method = {RequestMethod.GET})
    public String unauth() {
        if (SecurityUtils.getSubject().isAuthenticated() == false) {
            return "redirect:/login";
        }
        return "unauth";
    }
    /**
     * 退出
     * @return {Result}
     */
    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public Object logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
