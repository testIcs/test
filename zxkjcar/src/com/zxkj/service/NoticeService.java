package com.zxkj.service;

/**
 * 公告发布接口
 * 
 * NoticeService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月8日 下午5:37:26
 * @author liulong
 */
public interface NoticeService
{
    /**
     * 发布公告
     * 
     * @param context
     */
    void releaseNotice(String context);

    /**
     * 获取公告
     * 
     * @return
     */
    String getLastNotice();
}
