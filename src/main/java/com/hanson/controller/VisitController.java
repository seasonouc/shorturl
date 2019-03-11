package com.hanson.controller;

import com.hanson.service.CounterCache;
import com.hanson.service.UrlStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanson on 2019/3/10.
 */
@RestController
public class VisitController {

    private final static String jumpScript = "<script>window.location.href='%s';</script>";

    private final static String error = "page not found!";
    @Autowired
    private CounterCache counterCache;

    @Autowired
    private UrlStoreService urlStoreService;



    @RequestMapping(value="/{path}",method = RequestMethod.GET)
    public String visit(@PathVariable(name = "path")String path){
        String longUrl = urlStoreService.getLongUrl(path);
        if(StringUtils.isEmpty(longUrl)){
            return error;
        }
        counterCache.increaseVisitTimes(path,1);
        String page =  String.format(jumpScript,longUrl);
        return page;
    }

}
