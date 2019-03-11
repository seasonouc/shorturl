package com.hanson.vo;

/**
 * Created by hanson on 2019/3/10.
 */
public class CreateUrlResponseVO {

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    private String longUrl;

    private String shortUrl;

}
