package com.shuyun.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shuyun on 2016/8/9.
 * 登陆过滤类
 */
public class LoginFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("启动过滤器了");
        Object object = request.getSession().getAttribute("user");
        if (object != null) {
            return true;
        }
        //如果session中没有用户，则判断cookie
        Cookie autoCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("autologin".equals(cookie.getName())) {
                    autoCookie = cookie;
                }
            }
            //判断cookie是否为空，如果为空则跳转到登录页面
            if (autoCookie == null) {
                //如果cookie为空则继续执行userLogin.jsp页面
                request.getRequestDispatcher("userLogin.jsp").forward(request, response);
                return false;
            }
        }else {
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
            return false;
        }
        return false;
        }
    }

