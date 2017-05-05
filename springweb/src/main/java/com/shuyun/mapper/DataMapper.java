package com.shuyun.mapper;

import com.shuyun.domain.UserData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shuyun on 2016/8/10.
 * 数据接口类
 */
@Repository
public interface DataMapper {
    List<UserData> queryData(int userId);

    int saveUserData(@Param("dataId") int dataId, @Param("userId") int userId, @Param("dataTitle") String dataTitle, @Param("dataContent") String dataContent, @Param("dataName") String dataName);
}
