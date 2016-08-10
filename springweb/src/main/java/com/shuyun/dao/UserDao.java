package com.shuyun.dao;

import com.shuyun.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by shuyun on 2016/8/8.
 * 用户接口类
 */
@Repository
public interface UserDao {
    public User findUserByName(String name);
    public User handleLogin(String name);
}
