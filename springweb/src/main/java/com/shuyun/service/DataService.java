package com.shuyun.service;

import com.shuyun.domain.UserData;
import com.shuyun.mapper.DataMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shuyun on 2016/8/10.
 * DataService
 */
@Service
@Transactional
public class DataService {
    @Resource
    private DataMapper dataMapper;
    public List<UserData> queryData(int userId){
        return this.dataMapper.queryData(userId);
    }
    public int saveUserData(UserData userData){
        return this.dataMapper.saveUserData(userData.getDataId(),userData.getUserId(),userData.getDataTitle(),userData.getDataContent(),userData.getDataName());
    }
}
