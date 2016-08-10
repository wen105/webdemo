package com.shuyun;

import com.shuyun.entity.User;
import com.shuyun.service.UserService;
import com.shuyun.service.imply.UserServiceImply;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * Created by shuyun on 2016/8/8.
 * test
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Main {
    @Resource
    private static  UserService userService=null;
    public static void main(String[] args) {
        userService=new UserServiceImply();
        User user=userService.findUserByName("wen");
        System.out.println(user);
    }
}
