package com.shuyun.controller;

import com.shuyun.entity.User;
import com.shuyun.entity.UserData;
import com.shuyun.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by shuyun on 2016/8/10.
 * DataController
 */
@Controller
public class DataController {
    @Resource
    private DataService dataService;

    @RequestMapping("/showData")
    public String showData(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<UserData> userDataList = dataService.queryData(user.getId());
        request.getSession().setAttribute("userDataList", userDataList);
        return "showUserData";
    }

    @RequestMapping("/saveUserData")
    public String saveUserData(HttpServletRequest request) throws IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String dataTitle = request.getParameter("dataTitle");
        String dataContent = request.getParameter("dataContent");
        String dataName = request.getParameter("dataName");
        UserData userData = new UserData(userId, dataTitle, dataContent, dataName);
        dataService.saveUserData(userData);
            return "redirect:/showData";
    }

}

