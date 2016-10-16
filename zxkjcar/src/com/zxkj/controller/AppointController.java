package com.zxkj.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.common.Constants;
import com.zxkj.model.Appointment;
import com.zxkj.service.IAppoint;
import com.zxkj.service.NoticeService;

@Scope("prototype")
@Controller
@RequestMapping("/appoint")
public class AppointController
{
    private static final Logger LOG = LoggerFactory.getLogger(AppointController.class);

    /**
     * 用户Service
     */
    @Autowired(required = true)
    private IAppoint appointService;

    /**
     * 公告Service
     */
    @Autowired(required = true)
    private NoticeService noticeService;

    /**
     * 添加预约事件
     * 
     * @param request
     * @param appointment
     */
    @ResponseBody
    @RequestMapping(value = "/addAppointment.do", method = RequestMethod.POST)
    public Object addAppointment(HttpServletRequest request, Appointment appointment, Date appDate)
    {
        Integer status = Constants.DATA_INCORRECT;
        if (null != appointment)
        {
            appointment.setAppDate(appDate);
            status = appointService.addAppointment(appointment);
        }
        return status;
    }

    /**
     * 预约大厅
     * 
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/listBookingHall.do", method = RequestMethod.POST)
    public @ResponseBody Object listBookingHall(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Map<String, String> paramsMap = new HashMap<String, String>();
        String dateStr = request.getParameter("dateStr");
        paramsMap.put("datestr", dateStr + " 00:00:00");
        List<Map<String, Object>> returnList = appointService.listBookingHall(paramsMap);
        returnMap.put("bookingHallList", returnList);
        return returnMap;
    }

    /**
     * 预约数据明细
     * 
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/listAppointDetail.do", method = RequestMethod.POST)
    public @ResponseBody Object listAppointDetail(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Map<String, String> paramsMap = new HashMap<String, String>();
        String dateStr = request.getParameter("dateStr");
        paramsMap.put("datestr", dateStr + " 00:00:00");
        List<Map<String, Object>> returnList = appointService.listAppointDetail(paramsMap);
        returnMap.put("appointDetail", returnList);
        return returnMap;
    }

    @RequestMapping(value = "/findEverySlotPeopleOneDay.do", method = RequestMethod.POST)
    public @ResponseBody Object findEverySlotPeopleOneDay(HttpServletRequest request, HttpServletResponse response,
            Date appDate) throws IOException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        List<Map<String, Object>> mapList = appointService.findEverySlotPeopleOneDay(appDate);
        returnMap.put("slotUsers", mapList);
        return returnMap;
    }

    // 日期绑定
    @InitBinder
    protected void initBinder(WebDataBinder binder) throws ServletException
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    /**
     * 加载公告
     * 
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getNotice.do", method = RequestMethod.POST)
    public @ResponseBody Object getNotice() throws IOException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String notice = noticeService.getLastNotice();
        returnMap.put("notice", notice);
        return returnMap;
    }

    /**
     * 申请检查
     * 查询某一个时间段内已经预约了多少事务
     * 
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/checkAppointment.do", method = RequestMethod.POST)
    public @ResponseBody Object checkAppointment(String day, Integer sort) throws IOException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Integer num = appointService.queryAppointment(day, sort);
        if(null == num) num = 0;
        returnMap.put("num", 60 - num);
        return returnMap;
    }
    
    /**
     * 申请检查
     * 查询登录用户在给定的日期内一周是否已经进行过申请，如果进行过申请返回1，否则返回0
     * 
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/queryUserIsAppHisThisWeek.do", method = RequestMethod.POST)
    public @ResponseBody Object queryUserIsAppHisThisWeek(String day) throws IOException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Integer num = appointService.queryUserIsAppHisThisWeek(day);
        if(null == num) num = 0;
        returnMap.put("num", num);
        return returnMap;
    }
    
}