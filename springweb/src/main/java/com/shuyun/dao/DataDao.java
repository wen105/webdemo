package com.shuyun.dao;

import com.shuyun.entity.UserData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shuyun on 2016/8/10.
 * 数据接口类
 */
@Repository
public interface DataDao {
    public List<UserData> queryData(int userId);
    public int saveUserData(int dataId,int userId,String dataTitle,String dataContent,String dataName);
}
