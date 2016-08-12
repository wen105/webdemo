package com.shuyun.controller;

import com.shuyun.domain.User;
import com.shuyun.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
    public void userLogin(@RequestParam String name, @RequestParam String password, @RequestParam String mark, HttpServletResponse response, HttpSession session) throws IOException {
        User user = userService.handleLogin(name);
        if (user == null) {
            session.setAttribute("msg", "用户名不存在");
            response.sendRedirect("/userLogin.jsp");
        } else if (user.getPassword().equals(password)) {
            if ("mark".equals(mark)) {
                Cookie autoCookie;
                String cookieValue = user.getId() + ":" + user.getName();
                autoCookie = new Cookie("autologin", cookieValue);

                response.addCookie(autoCookie);
            }
            session.setAttribute("user", user);
            response.sendRedirect("/showData");
        } else {
            session.setAttribute("msg", "登录名和密码不匹配");
            response.sendRedirect("/userLogin.jsp");
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public List<User> list() {
        List<User> list;
        list = userService.listAll();
        System.out.println(list);
        return list;
    }

}
