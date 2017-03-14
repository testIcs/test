package com.zxkj.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zxkj.model.Notice;
import com.zxkj.service.NoticeService;

/**
 * 公告控制器
 * 
 * NoticeController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasoftinc on 2017年2月4日 下午4:38:56
 * @author liulong
 */
@Controller
@RequestMapping("/notice")
public class NoticeController
{
    /**
     * 公告Service
     */
    @Autowired(required = true)
    private NoticeService noticeService;

    /**
     * 跳转到公告列表页面
     * 
     * @return
     */
    @RequestMapping(value = "/list.do", method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("notice");
        return mv;
    }

    /**
     * 加载最新公告
     * 
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getLastNotice.do", method = RequestMethod.POST)
    public @ResponseBody Object getNotice()
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String notice = noticeService.getLastNotice();
        returnMap.put("notice", notice);
        return returnMap;
    }

    /**
     * 往期公告
     * 
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/historyNotice.do", method = RequestMethod.POST)
    public @ResponseBody Object historyNotice()
    {
        List<Notice> noticeList = noticeService.getAllNotice();
        return noticeList;
    }

    /**
     * 根据id查看详情
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/showDetail.do", method = RequestMethod.POST)
    public @ResponseBody Object showDetail(Integer id)
    {
        Notice notice = noticeService.queryById(id);
        return notice;
    }
}
