package com.hanson.service.impl;

import com.hanson.service.UrlStoreService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hanson on 2019/3/10.
 */
public class LocalUrlStoreService implements UrlStoreService{

    private Map<String,String> urlCache = new ConcurrentHashMap<>();

    @Override
    public void put(String shortUrl, String longUrl) {
        urlCache.put(shortUrl,longUrl);
    }

    @Override
    public String getLongUrl(String shortUrl) {
        return urlCache.get(shortUrl);
    }
}
