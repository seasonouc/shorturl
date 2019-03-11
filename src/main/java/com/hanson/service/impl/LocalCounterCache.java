package com.hanson.service.impl;

import com.hanson.service.CounterCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hanson on 2019/3/10.
 */
public class LocalCounterCache implements CounterCache {

    private Map<String, AtomicLong> counterMap = new ConcurrentHashMap<>();

    @Override
    public long getVisitTimes(String shortUrl) {
        AtomicLong counter = counterMap.get(shortUrl);
        if (counter == null) {
            return 0;
        }
        return counter.longValue();
    }

    @Override
    public long increaseVisitTimes(String shortUrl, int times) {
        AtomicLong counter = counterMap.get(shortUrl);
        if (counter == null) {
            synchronized (this) {
                if (counter == null) {
                    counter = new AtomicLong(times);
                    counterMap.put(shortUrl,counter);
                    return times;
                }
            }
        }
        return counter.addAndGet(times);
    }
}
