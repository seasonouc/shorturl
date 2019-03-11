package com.hanson.service;

/**
 * Created by hanson on 2019/3/10.
 */
public interface UrlStoreService {

    void put(String shortUrl,String longUrl);

    String getLongUrl(String shortUrl);
}
