package com.shuyun.service;

import com.shuyun.entity.User;

/**
 * Created by shuyun on 2016/8/8.
 */
public interface UserService {
    public User findUserByName(String name);
    public User handleLogin(String name);
}
