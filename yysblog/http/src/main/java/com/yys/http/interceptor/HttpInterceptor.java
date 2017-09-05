package com.yys.http.interceptor;

import com.mysql.jdbc.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * User: 杨永生
 * Date: 15:05 2017/9/1
 * Email: 1095737364@qq.com
 */
public class HttpInterceptor extends HandlerInterceptorAdapter {
    public final static Logger logger= LoggerFactory.getLogger(HttpInterceptor.class);

    //是否只能yysblog用户访问:此处是的默认值为false,就是所有请求都可访问,如果spring-mvc.xml的过滤器配置参数为true,则此处被修改为true
    private boolean isYysblogAccess=false;
    public void setIsYysblogAccess(boolean isYysblogAccess) {  this.isYysblogAccess = isYysblogAccess; }
    private String[] allowUrls;
    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        //得到请求头Header中的参数User-Agent
        String userAgent=request.getHeader("User-Agent");
        //得到请求地址的相对路径
        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
        //如果请求地址为"/",则不进行任何处理,可能会直接到下一个过滤器,ruturn 可以不要;
        if("/".equals(requestUrl)){
            System.out.println("测试 '/' 访问......");
            return true;
        }
        if(!isYysblogAccess){
            //处理yysblog用户的访问和非此用户的访问,比如做了一个移动端的APP, 分享后的访问不一定是App里面的请求,此时要做一些处理,ruturn 可以不要;
            return true;
        }
        if(!StringUtils.isNullOrEmpty(userAgent)){
            //对请求头进行处理,ruturn 可以不要;
            return true;
        }
        //如果请求中包含以下路径，则不进行拦截
        if(null != allowUrls && allowUrls.length>=1) {
            for(String url : allowUrls) {
                if(!"/".equals(url) && requestUrl.contains(url)) {
                    return true;
                }
            }
        }
        logger.error("非客户端访问",userAgent);
        response.getWriter().write("Not Yysblog");
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}