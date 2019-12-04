package com.example.ehcache.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.ehcache.service.CacheService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shizhiguo
 * @version 1.0.
 * @Description
 * @Date 2019/12/3
 */
@Slf4j
@Service
public class CacheServiceImpl implements CacheService {

    private static final Map<String,String> users = new HashMap<>();

    static {
        users.put("1","zhangsan");
        users.put("2","lisi");
        users.put("3","wangwu");
    }

    @Override
    @Cacheable(key = "#id",cacheNames = "ehcache")
    public String getData(String id) {
        log.info("service方法执行，id：【{}】",id);
        String name = users.get(id);
        return name;
    }
}
