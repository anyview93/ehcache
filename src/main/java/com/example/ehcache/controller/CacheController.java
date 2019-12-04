package com.example.ehcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ehcache.service.CacheService;

/**
 * @author shizhiguo
 * @version 1.0.
 * @Description
 * @Date 2019/12/3
 */
@RestController
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/getData/{id}")
    public Object getData(@PathVariable String id){
        String name = cacheService.getData(id);
        return name;
    }
}
