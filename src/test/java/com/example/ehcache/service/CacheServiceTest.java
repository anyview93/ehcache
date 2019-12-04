package com.example.ehcache.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shizhiguo
 * @version 1.0.
 * @Description
 * @Date 2019/12/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheServiceTest {

    @Autowired
    private CacheService cacheService;

    @Test
    public void testGetData(){
        String data = cacheService.getData("1");
        System.out.println(data);
    }
}
