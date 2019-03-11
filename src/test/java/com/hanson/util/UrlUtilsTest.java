package com.hanson.util;

import org.junit.Test;
import org.testng.Assert;

/**
 * Created by hanson on 2019/3/10.
 */
public class UrlUtilsTest {
    @Test
    public void md5ByHex() throws Exception {
        String hash = UrlUtils.md5ByHex("hahahahhahah");

        Assert.assertEquals("DBFE0B3AC75B6ECDB7F1428DD12F2D8B",hash);
        Assert.assertEquals(32,hash.length());
    }

    @Test
    public void testIsHttpAddress(){
        boolean res1 =  UrlUtils.isHttpAddress("http://www.tetet.com/index.html?q=1&m=test");
        Assert.assertTrue(res1);
        boolean res2 =  UrlUtils.isHttpAddress("www.tetet.com/index.html?q=1&m=test");
        Assert.assertTrue(res2);
        boolean res3 =  UrlUtils.isHttpAddress("tetet.com/index.html?q=1&m=test");
        Assert.assertTrue(res3);

        boolean res4 =  UrlUtils.isHttpAddress("tetet432com/index.html?q=1&m=test");
        Assert.assertFalse(res4);
    }

    @Test
    public void testIsShortKey(){
        boolean res1 = UrlUtils.isShortKey("123fdsFDD");
        Assert.assertTrue(res1);

        boolean res2 = UrlUtils.isShortKey("123fdsfdsfdsdf");
        Assert.assertTrue(res2);

        boolean res3 = UrlUtils.isShortKey("123fDf");
        Assert.assertFalse(res3);
    }

}