package com.hanson.service;

/**
 * Created by hanson on 2019/3/10.
 */
public interface CounterCache {

    long getVisitTimes(String shortUrl);

    long increaseVisitTimes(String shortUrl,int times);
}
