package com.shuyun.service.imply;

import com.shuyun.dao.UserDao;
import com.shuyun.service.UserService;
import com.shuyun.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by shuyun on 2016/8/8.
 * UserServiceImply
 */
@Service("userService")
public class UserServiceImply implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public User findUserByName(String name){
        return this.userDao.findUserByName(name);
    }

    @Override
    public User handleLogin(String name) {
        return this.userDao.handleLogin(name);
    }
}
