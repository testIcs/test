package com.zxkj.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告实体
 * 
 * Notice.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasoftinc on 2017年2月4日 下午4:33:00
 * @author liulong
 */
public class Notice implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private int id;

    /**
     * 内容
     */
    private String context;

    /**
     * 发布时间
     */
    private Date releaseTime;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getContext()
    {
        return context;
    }

    public void setContext(String context)
    {
        this.context = context;
    }

    public Date getReleaseTime()
    {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime)
    {
        this.releaseTime = releaseTime;
    }

}
