package com.shuyun.mapper;

import com.shuyun.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shuyun on 2016/8/8.
 * 用户接口类
 */
@Repository
public interface UserMapper {
    public User findUserByName(String name);
    public User handleLogin(String name);
    public List<User> listAll();
}
