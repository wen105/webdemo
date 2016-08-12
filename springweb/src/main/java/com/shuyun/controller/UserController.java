package com.shuyun.controller;

import com.shuyun.domain.User;
import com.shuyun.service.UserService;
import com.sun.net.httpserver.HttpContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by shuyun on 2016/8/9.
 * UserController
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public void userLogin(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String mark = request.getParameter("mark");
        User user = userService.handleLogin(name);
        if (user == null) {
            request.setAttribute("msg", "用户名不存在");
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
           // response.sendRedirect("/userLogin.jsp");
        } else if (user.getPassword().equals(password)) {
            if ("mark".equals(mark)) {
                Cookie autoCookie;
                String cookieValue = user.getId() + ":" + user.getName();
                autoCookie = new Cookie("autologin", cookieValue);
                response.addCookie(autoCookie);
            }
           // request.getSession().setAttribute("user", user);
            session.setAttribute("user",user);
            response.sendRedirect("/showData");
        } else {
            request.setAttribute("msg", "登录名和密码不匹配");
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
            response.sendRedirect("/userLogin.jsp");
        }
    }

    @RequestMapping(value ="/test",method = RequestMethod.GET)
    @ResponseBody
    public List<User> list() {
        List<User> list;
        list = userService.listAll();
        System.out.println(list);
        return list;
    }

}
