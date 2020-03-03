package com.example.ehcache.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ehcache.bean.TUser;

/**
 * @author shizhiguo
 * @version 1.0.
 * @Description
 * @Date 2019/12/7
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TUserMapperTest {

    @Autowired
    private TUserMapper userMapper;

    @Test
    public void test(){
        List<TUser> users = userMapper.selectAll();
        System.out.println(users);
    }

    @Test
    public void testSelectByName(){
        List<TUser> users = userMapper.selectByName("张三");
        System.out.println(users);
    }
}
