package com.hanson.service.impl;

import org.junit.Test;
import org.testng.Assert;

import static org.junit.Assert.*;

/**
 * Created by hanson on 2019/3/10.
 */
public class GenerateUrlServiceTest {
    @Test
    public void generate() throws Exception {
        GenerateUrlService generateUrlService = new GenerateUrlService();
        String shortUrl = generateUrlService.generate("www.dsafdafdaf.com/adafd/fdaf/fdsafd");
        System.out.println(shortUrl);
    }

    @Test
    public void testGenerateConf(){
        GenerateUrlService generateUrlService = new GenerateUrlService();
        String shortUrl = generateUrlService.generate("www.dsafdafdaf.com/adafd/fdaf/fdsafd",12);
        System.out.println(shortUrl);
        Assert.assertEquals(shortUrl.length(),12);

        String shortUrl1 = generateUrlService.generate("www.dsafdafdaf.com/adafd/fdaf/fdsafd",14);
        System.out.println(shortUrl1);
        Assert.assertEquals(shortUrl1.length(),14);

        String shortUrl2 = generateUrlService.generate("www.dsafdafdaf.com/adafd/fdaf/fdsafd",20);
        System.out.println(shortUrl2);
        Assert.assertEquals(shortUrl2.length(),20);

        String shortUrl3 = generateUrlService.generate("www.dsafdafdaf.com/adafd/fdaf/fdsafd",30);
        System.out.println(shortUrl3);
        Assert.assertEquals(shortUrl3.length(),30);

        String shortUrl4 = generateUrlService.generate("www.dsafdafdaf.com/adafd/fdaf/fdsafd",100);
        System.out.println(shortUrl4);
        Assert.assertEquals(shortUrl4.length(),100);
    }



}