package com.zxkj.service;

import java.util.List;

import com.zxkj.model.Notice;

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
     * 获取最新公告
     * 
     * @return
     */
    String getLastNotice();

    /**
     * 获取所有公告
     * 
     * @return
     */
    List<Notice> getAllNotice();

    /**
     * 根据id查询
     * 
     * @param id
     * @return
     */
    Notice queryById(Integer id);
}
