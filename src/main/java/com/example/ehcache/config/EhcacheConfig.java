package com.example.ehcache.config;

import java.time.Duration;

import org.ehcache.CacheManager;
import org.ehcache.config.EvictionAdvisor;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ehcache.common.CacheEnum;


/**
 * @author shizhiguo
 * @version 1.0.
 * @Description
 * @Date 2019/12/3
 */
@Configuration
public class EhcacheConfig {

    /**
     * ehcache v2.10.x
     * @return
     */
   /* @Bean
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
    }*/

    /**
     *  chchache v3.8.1
     * @return
     */
   @Bean
   public CacheManager getCacheManager(){
       //返回一个CacheManagerBuilder实例
       CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
               //缓存名称
               .withCache(CacheEnum.EHEACHE.name(),
                       //缓存配置
                       CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, Object.class, ResourcePoolsBuilder.heap(1000000L))
                               //持续时间
                               .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(30)))
                               //调用build()返回一个完全实例化但未初始化的CacheManager,多个cache时，build()方法调用一次和多次都行
                                .build())
               .withCache(CacheEnum.TEST.name(),
                       //缓存配置
                       CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, Object.class, ResourcePoolsBuilder.heap(1000000L))
                               //持续时间
                               .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofMinutes(30)))
                               //调用build()返回一个完全实例化但未初始化的CacheManager,多个cache时，build()方法调用一次和多次都行
                               .build())
               //初始化CacheManager
               .build(true);

       return cacheManager;
   }
}
