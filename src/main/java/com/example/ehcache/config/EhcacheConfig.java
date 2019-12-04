package com.example.ehcache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

/**
 * @author shizhiguo
 * @version 1.0.
 * @Description
 * @Date 2019/12/3
 */
@Configuration
public class EhcacheConfig {

    @Bean
    public CacheManager getCacheManager(){
        CacheConfiguration config = new CacheConfiguration();
        //缓存名称
        config.setName("ehcache");
        //是否永不过期
        config.setEternal(false);
        //缓存清除策略，LFU清除最少使用
        config.setMemoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU.toString());
        //内存中存放的最大记录数
        config.setMaxEntriesLocalHeap(10000L);
        //硬盘中存放的最大记录数
        config.setMaxEntriesLocalDisk(100000L);
        config.setTimeToLiveSeconds(60);


        //设置ehcache配置文件，获取CacheManager
        net.sf.ehcache.config.Configuration configuration = new net.sf.ehcache.config.Configuration();
        configuration.addCache(config);
        CacheManager cacheManager = CacheManager.newInstance(configuration);
        //将CacheManager注册为bean，供缓存工具类使用
        return cacheManager;
    }
}
