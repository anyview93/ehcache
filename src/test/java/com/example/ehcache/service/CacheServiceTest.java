package com.example.ehcache.service;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ehcache.common.CacheEnum;

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
    private CacheManager cacheManager;
    @Autowired
    private CacheService cacheService;

    @Test
    public void testGetData(){
        String data = cacheService.getData("1");
        System.out.println(data);
    }

    @Test
    public void testCacheManager(){
        Cache<String, Object> chcache = cacheManager.getCache(CacheEnum.EHEACHE.name(), String.class, Object.class);
        Cache<String, Object> test = cacheManager.getCache(CacheEnum.TEST.name(), String.class, Object.class);
        test.put("test","12344");
        Object test1 = test.get("test");
        chcache.put("cache","9797978979");
        Object cache = chcache.get("cache");
        System.out.println(test1);
        System.out.println(cache);
    }
}
