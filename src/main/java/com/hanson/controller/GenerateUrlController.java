package com.hanson.controller;

import com.hanson.service.CounterCache;
import com.hanson.service.UrlStoreService;
import com.hanson.service.impl.GenerateUrlService;
import com.hanson.util.UrlUtils;
import com.hanson.vo.CreateUrlRequestVO;
import com.hanson.vo.CreateUrlResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * Created by hanson on 2019/3/10.
 */
@RestController
@RequestMapping("/v1")
public class GenerateUrlController {

    @Autowired
    private UrlStoreService urlStoreService;

    @Autowired
    private GenerateUrlService generateUrlService;

    @Autowired
    private CounterCache counterCache;

    @Value("${server.domainName}")
    private String domainName;


    @RequestMapping("/generateConf")
    public CreateUrlResponseVO generateShortUrl(@RequestBody @Valid CreateUrlRequestVO requestVO) {
        CreateUrlResponseVO createUrlResponseVO = new CreateUrlResponseVO();
        String longUrl = requestVO.getLongUrl();
        if (!longUrl.startsWith("http")) {
            longUrl = "http://" + longUrl;
        }
        createUrlResponseVO.setLongUrl(longUrl);
        if (!StringUtils.isEmpty(requestVO.getShortUrl())) {
            if (!UrlUtils.isShortKey(requestVO.getShortUrl())) {
                return createUrlResponseVO;
            }
            urlStoreService.put(requestVO.getShortUrl(), longUrl);
            createUrlResponseVO.setShortUrl(domainName + requestVO.getShortUrl());
            return createUrlResponseVO;
        } else {
            String shortUrl;
            if (requestVO.getLength() >= 8) {
                shortUrl = generateUrlService.generate(longUrl, requestVO.getLength());
            } else {
                shortUrl = generateUrlService.generate(longUrl);
            }
            urlStoreService.put(shortUrl, longUrl);
            createUrlResponseVO.setShortUrl(domainName + shortUrl);
        }

        return createUrlResponseVO;
    }

    @RequestMapping("/generate")
    public CreateUrlResponseVO generateShortUrl(String longUrl) {
        CreateUrlResponseVO createUrlResponseVO = new CreateUrlResponseVO();
//        if (!UrlUtils.isHttpAddress(longUrl)) {
//            return createUrlResponseVO;
//        }
        if (!longUrl.startsWith("http")) {
            longUrl = "http://" + longUrl;
        }
        String shortUrl = generateUrlService.generate(longUrl);
        urlStoreService.put(shortUrl, longUrl);


        createUrlResponseVO.setLongUrl(longUrl);
        createUrlResponseVO.setShortUrl(domainName + shortUrl);

        return createUrlResponseVO;
    }

    @RequestMapping("/getVisitTimes")
    public long getVisitedTimes(String shortUrl) {
        return counterCache.getVisitTimes(shortUrl);
    }

}
