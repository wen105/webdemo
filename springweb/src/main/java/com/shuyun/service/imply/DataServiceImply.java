package com.shuyun.service.imply;

import com.shuyun.dao.DataDao;
import com.shuyun.entity.UserData;
import com.shuyun.service.DataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shuyun on 2016/8/10.
 * DataServiceImply
 */
@Service("dataService")
public class DataServiceImply implements DataService {
    @Resource
    private DataDao dataDao;
    @Override
    public List<UserData> queryData(int userId) {
        return this.dataDao.queryData(userId);
    }

    @Override
    public int saveUserData(UserData userData) {
        System.out.println("保存前输出");
        System.out.println(userData.getUserId()+userData.getDataTitle()+userData.getDataContent()+userData.getDataName());
        return this.dataDao.saveUserData(userData.getDataId(),userData.getUserId(),userData.getDataTitle(),userData.getDataContent(),userData.getDataName());
    }
}
