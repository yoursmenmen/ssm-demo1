package com.mingming.service;

import com.mingming.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用户服务测试
 *
 * @author h
 * @date 2022/08/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void getById(){
        System.out.println(service.selectByUsername("mingming"));
    }
}
