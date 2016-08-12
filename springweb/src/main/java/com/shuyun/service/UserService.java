package com.shuyun.service;

import com.shuyun.domain.User;
import com.shuyun.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shuyun on 2016/8/8.
 */
@Service
@Transactional
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User handleLogin(String name){
        return this.userMapper.handleLogin(name);
    }
    public List<User> listAll(){return this.userMapper.listAll();}
}
