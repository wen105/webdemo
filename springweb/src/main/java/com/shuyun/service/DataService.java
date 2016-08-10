package com.shuyun.service;

import com.shuyun.entity.UserData;

import java.util.List;

/**
 * Created by shuyun on 2016/8/10.
 * DataService
 */
public interface DataService {
    public List<UserData> queryData(int userId);
    public int saveUserData(UserData userData);
}
