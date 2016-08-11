package com.shuyun.filter;

import com.shuyun.entity.User;
import com.shuyun.service.UserService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shuyun on 2016/8/9.
 * 登陆过滤类
 */
public class LoginFilter extends HandlerInterceptorAdapter {
    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute("user");
        if (object != null) {
            System.out.println("不为空");
            return true;
        }
        System.out.println("为空");
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
            //如果autoCookie不为null，则根据cookie值到数据库查找用户
            String value = autoCookie.getValue();
            String[] temp = value.split(":");
            String userName = temp[1];
            User user = userService.handleLogin(userName);
            if (user == null) {
                request.getRequestDispatcher("userLogin.jsp").forward(request, response);
                return false;
            }
            request.getSession().setAttribute("user", user);
            return true;
        } else {
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
            return false;
        }
    }
}

