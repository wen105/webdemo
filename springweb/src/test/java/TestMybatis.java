import com.shuyun.entity.User;
import com.shuyun.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by shuyun on 2016/8/8.
 * Mybatis Test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMybatis {
    private final Logger logger = LoggerFactory.getLogger(TestMybatis.class);

    @Resource
    private UserService userService;

    @Test
    public void test1() {
        User user = userService.findUserByName("wen");
        logger.info("-->:{}", user);
    }

}
