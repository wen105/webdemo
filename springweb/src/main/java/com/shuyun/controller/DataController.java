package com.shuyun.controller;

import com.shuyun.domain.User;
import com.shuyun.domain.UserData;
import com.shuyun.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by shuyun on 2016/8/10.
 * DataController
 */
@Controller
@SessionAttributes("user")
public class DataController {
    @Resource
    private DataService dataService;
    @RequestMapping("/showData")
    public ModelAndView showData(@ModelAttribute("user") User user) {
        List<UserData> userDataList = dataService.queryData(user.getId());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userDataList",userDataList);
        modelAndView.setViewName("showUserData");
        return modelAndView;
    }
    @RequestMapping("/saveUserData")
    public String saveUserData(UserData userData) throws IOException {
        dataService.saveUserData(userData);
        return "redirect:/showData";
    }
}

