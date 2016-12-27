package com.zxkj.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
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
import com.zxkj.model.User;
import com.zxkj.service.IAppoint;
import com.zxkj.service.NoticeService;
import com.zxkj.util.DateUtil;

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
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Integer checkNum = 0;
        Integer total = 60;// 每个时间段默认可预约的总数
        if (null != appointment)
        {
            // 得到系统当前时间是周几
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            int w = cal.get(Calendar.DAY_OF_WEEK);
            int h = cal.get(Calendar.HOUR_OF_DAY);// 当前小时数字

            // 所选时间是周几
            cal.setTime(appDate);
            int selDate = cal.get(Calendar.DAY_OF_WEEK);
            // 如果是元旦(暂时加上)
            if (judgeNewYearDay())
            {
                status = Constants.NEW_YEAR_DAY;
            }
            // 如果选择了周六周日，提示不能预约
            else if (selDate == Constants.WEEK_SUNDAY || selDate == Constants.WEEK_SATURDAY)
            {
                status = Constants.REST_DAY;
            }
            else if (!(Constants.WEEK_WEDNESDAY == w && h >= 12 && h < 17))
            {// 每周的周三的12：00-17:00才能进行预约
                status = Constants.VALIDATE_EXPIRES;
            }
            else if (selDate == Constants.WEEK_WEDNESDAY)
            {// 只能预约每周的周一、周二、周四和周五
                status = Constants.STATUS_ERROR;
            }
            else
            {
                // 格式化日期
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                // 查询登录用户在给定的日期内一周是否已经进行过申请
                User user = (User) request.getSession().getAttribute("user");
                Integer weekNum = appointService.queryUserIsAppHisThisWeek(format.format(appDate), user.getPhoneNo());
                // 查询预约的时间所在的周是否已经有预约，即每周只能预约一次并且不能超过30个
                if (null != weekNum && weekNum == 0)
                {
                    // 查询某一个时间段内已经预约了多少事务
                    checkNum = appointService.queryAppointment(format.format(appDate),
                            appointment.getAppTimeSlotValue());
                    if (null == checkNum)
                        checkNum = 0;
                    // 11：30-12:00为30个，其他为60个，超过不能预约
                    if (appointment.getAppTimeSlotValue().intValue() == 5)
                    {
                        total = 30;
                    }

                    if ((total - checkNum) >= appointment.getAppAffair())
                    {

                        appointment.setAppDate(appDate);
                        appointment.setAppPhoneNo(user.getPhoneNo());
                        appointment.setAppUserName(user.getUserName());
                        status = appointService.addAppointment(appointment);
                    }
                    else
                    {
                        status = Constants.DATA_NOT_COMPLETE;
                    }
                }
                else
                {
                    status = Constants.DATA_ALREADY_EXIST;
                }
            }
        }
        returnMap.put("status", status);
        returnMap.put("num", (total - checkNum));
        return returnMap;
    }

    /**
     * 判断元旦
     * 
     * @return
     */
    private boolean judgeNewYearDay()
    {
        // 当前时间
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());

        Calendar before = Calendar.getInstance();
        before.set(2016, 11, 31);

        Calendar after = Calendar.getInstance();
        after.set(2017, 0, 2);

        return now.compareTo(before) >= 0 && now.compareTo(before) <= 1;
    }

    /**
     * 预约大厅
     * 
     * @return
     * @throws IOException
     * @throws ParseException
     */
    @RequestMapping(value = "/listBookingHall.do", method = RequestMethod.POST)
    public @ResponseBody Object listBookingHall(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ParseException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String dateStr = request.getParameter("dateStr");
        int week = DateUtil.dayForWeek(dateStr);
        if (week == Constants.WEEK_WEDNESDAY)
        {
            returnMap.put("forbid", "true");
            return returnMap;
        }

        Date seleteDate = DateUtil.getDate(dateStr, "yyyy-MM-dd");
        if (seleteDate.compareTo(DateUtil.getDate("2017-01-02", "yyyy-MM-dd")) == 0)
        {
            returnMap.put("newYear", "true");
            return returnMap;
        }
        Map<String, String> paramsMap = new HashMap<String, String>();
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
     * 申请检查 查询某一个时间段内已经预约了多少事务
     * 
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/checkAppointment.do", method = RequestMethod.POST)
    public @ResponseBody Object checkAppointment(String day, Integer sort) throws IOException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Integer num = appointService.queryAppointment(day, sort);
        if (null == num)
            num = 0;
        if (sort == 5)
        {
            returnMap.put("num", (30 - num < 0 ? 0 : 30 - num));
        }
        else
        {
            returnMap.put("num", 60 - num);
        }
        return returnMap;
    }

    /**
     * 废弃暂时不用 申请检查 查询登录用户在给定的日期内一周是否已经进行过申请，如果进行过申请返回1，否则返回0
     * 
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/queryUserIsAppHisThisWeek.do", method = RequestMethod.POST)
    public @ResponseBody Object queryUserIsAppHisThisWeek(HttpServletRequest request, String day) throws IOException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        User user = (User) request.getSession().getAttribute("user");
        Integer num = appointService.queryUserIsAppHisThisWeek(day, user.getPhoneNo());
        if (null == num)
            num = 0;
        returnMap.put("numCount", num);
        return returnMap;
    }

    /**
     * 获取可预约的日期
     * 
     * @return
     */
    @RequestMapping(value = "/getAppointmentDate.do", method = RequestMethod.POST)
    public @ResponseBody Object getAppointmentDate()
    {
        List<String> dateList = new ArrayList<String>();

        // 两天后开始预约
        int afterDay = Constants.AFTER_APPOINTMENT_DAY;
        while (dateList.size() < 5)
        {
            Date date = DateUtil.getDateAfter(new Date(), afterDay);
            Calendar c = Calendar.getInstance();
            c.setTime(date);

            // 排除周六周日
            if (c.get(Calendar.DAY_OF_WEEK) != Constants.WEEK_SATURDAY
                    && c.get(Calendar.DAY_OF_WEEK) != Constants.WEEK_SUNDAY)
            {

                dateList.add(DateUtil.getWeekByDateStr(c.get(Calendar.DAY_OF_WEEK)) + "_"
                        + DateFormatUtils.format(date, "yyyy-MM-dd"));
            }

            afterDay++;
        }
        return dateList;
    }
}