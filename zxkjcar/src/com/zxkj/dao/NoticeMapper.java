package com.zxkj.dao;

/**
 * 公告发布dao
 * 
 * NoticeMapper.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月8日 下午5:40:06
 * @author liulong
 */
public interface NoticeMapper
{
    /**
     * 增加公告
     * 
     * @param context
     */
    void addNotice(String context);

    /**
     * 修改公告
     */
    void updateNotice();

    String findLastNotice();
}
