package com.example.ehcache.cacge;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shizhiguo
 * @version 1.0.
 * @Description
 * @Date 2019/12/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheTest {

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testCacheManager(){
        Collection<String> cacheNames = cacheManager.getCacheNames();
        System.out.println(cacheNames);
    }
}
