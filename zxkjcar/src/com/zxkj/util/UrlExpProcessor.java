package com.zxkj.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * url格式匹配 UrlExpProcessor.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年5月24日 下午5:57:16
 * @author liulong
 */
public class UrlExpProcessor
{
    private Pattern pattern;

    /**
     * 默认的格式
     */
    public static final String STYLE_EXP = "\\.css$|\\.js$|\\.jpg$|\\.gif$|\\.png$|\\.gzjs$|\\.gzcss|\\.mp4|\\.html|\\.htm|\\.ttf$|\\.woff$|\\.woff2$|\\.svg$|\\.eot$";

    /**
     * 扩展的格式
     */
    private String patterns;

    public UrlExpProcessor()
    {
        this(null);
    }

    public UrlExpProcessor(String patterns)
    {
        if (!StringUtils.isEmpty(patterns))
        {
            StringBuffer sb = new StringBuffer();
            sb.append(STYLE_EXP).append("|").append(patterns);
            this.patterns = sb.toString();
        }
        else
        {
            this.patterns = STYLE_EXP;
        }
        this.pattern = Pattern.compile(this.patterns);
    }

    public boolean match(String url)
    {
        if ((url == null) || (url.trim().equals("")))
        {
            return false;
        }
        Matcher matcher = this.pattern.matcher(url);
        return matcher.find();
    }

    public String toString()
    {
        return "UrlExpProcessor[" + this.patterns + "]";
    }
}
