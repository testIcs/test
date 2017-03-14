package com.zxkj.dao;

import java.util.List;

import com.zxkj.model.Notice;

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

    /**
     * 查找最新公告
     * 
     * @return
     */
    String findLastNotice();

    /**
     * 获取历史公告
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
