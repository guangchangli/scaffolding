package com.aladdin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.aladdin.entity.User;
import com.aladdin.mapper.UserMapper;

import java.util.List;

/**
 * @author lgc
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MpTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.selectUser();
        System.out.println(users.size());
        Assert.assertEquals(5,users.size());
    }
}
