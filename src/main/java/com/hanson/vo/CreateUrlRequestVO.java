package com.hanson.vo;

import com.hanson.util.UrlUtils;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by hanson on 2019/3/10.
 */

public class CreateUrlRequestVO {
    /**
     * long url
     */
    @NotNull
    @Pattern(regexp= UrlUtils.httpRegex)
    private String longUrl;

    /**
     * define it by user ,can be null
     */

    private String shortUrl;
    /**
     * define it by user ,can be null
     */
    @DecimalMax(value = "100")
    private int length;

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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


}
