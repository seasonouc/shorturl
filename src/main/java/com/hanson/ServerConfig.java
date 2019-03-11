package com.hanson;

import com.hanson.service.CounterCache;
import com.hanson.service.UrlStoreService;
import com.hanson.service.impl.LocalCounterCache;
import com.hanson.service.impl.LocalUrlStoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by hanson on 2019/3/10.
 */
@Component
public class ServerConfig {

    @Value("${server.counterCache}")
    private String counterCache;

    @Value("${server.urlStore}")
    private String urlStore;

    @Bean
    public CounterCache counterCache(){
        //suppose to support redis counter
        if("redis".equalsIgnoreCase(counterCache)){
            return null;
        }else{
            return new LocalCounterCache();
        }
    }

    @Bean
    public UrlStoreService urlStoreService(){
        if("redis".equalsIgnoreCase(urlStore)){
            return null;
        }else if("mysql".equalsIgnoreCase(urlStore)){
            return null;
        }
        return new LocalUrlStoreService();
    }
}
