package com.hanson.util;

import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hanson on 2019/3/10.
 */
public class UrlUtils {

    public final static String httpRegex = "(http(s)?:\\/\\/)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*([\\?&]\\w+=\\w*)*$";
    public final static String shortKeyRegex = "^[a-z0-9A-Z]{8,100}$";
    /**
     * MD5加密(32位大写)
     * @param src
     * @return
     */
    public static String md5ByHex(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = src.getBytes();
            md.reset();
            md.update(b);
            byte[] hash = md.digest();
            String hs = "";
            String stmp = "";
            for (int i = 0; i < hash.length; i++) {
                stmp = Integer.toHexString(hash[i] & 0xFF);
                if (stmp.length() == 1)
                    hs = hs + "0" + stmp;
                else {
                    hs = hs + stmp;
                }
            }
            return hs.toUpperCase();
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean isHttpAddress(String url){
        Pattern pattern = Pattern.compile(httpRegex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

    public static boolean isShortKey(String shortUrl){
        Pattern pattern = Pattern.compile(shortKeyRegex);
        Matcher matcher = pattern.matcher(shortUrl);
        return matcher.matches();
    }
}
