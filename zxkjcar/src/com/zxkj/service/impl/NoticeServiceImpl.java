package com.zxkj.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.dao.NoticeMapper;
import com.zxkj.service.NoticeService;

/**
 * 公告发布实现
 * 
 * NoticeServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年9月8日 下午5:38:15
 * @author liulong
 */
@Scope("prototype")
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService
{

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    @Transactional
    public void releaseNotice(String context)
    {
        // 先更新，把之前的公告置为过期
        noticeMapper.updateNotice();

        // 增加公告
        noticeMapper.addNotice(context);
    }

    @Override
    public String getLastNotice()
    {
        return noticeMapper.findLastNotice();
    }

}
