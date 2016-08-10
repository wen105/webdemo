package com.shuyun.controller;

import com.shuyun.entity.User;
import com.shuyun.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shuyun on 2016/8/9.
 * UserController
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String mark = request.getParameter("mark");
        User user = userService.handleLogin(name);
        if (user == null) {
            request.setAttribute("msg", "用户名不存在");
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
        } else if (user.getPassword().equals(password)) {
            if ("mark".equals(mark)) {
                Cookie autoCookie;
                String cookieValue = user.getId() + ":" + user.getName();
                autoCookie = new Cookie("autologin", cookieValue);
                response.addCookie(autoCookie);
            }
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/showData");
        } else {
            request.setAttribute("msg", "登录名和密码不匹配");
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
        }
    }

    @RequestMapping("/test11")
    @ResponseBody
    public User test11(User user) {
        User users = new User();
        users.setName("wenjia");
        return user;
    }

}
