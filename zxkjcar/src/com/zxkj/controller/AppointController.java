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

import net.sf.json.JSONObject;

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
import com.zxkj.model.AppointSetting;
import com.zxkj.model.Appointment;
import com.zxkj.model.User;
import com.zxkj.service.IAppoint;
import com.zxkj.service.SystemConfigService;
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
     * 系统配置接口
     */
    @Autowired(required = true)
    private SystemConfigService systemConfigService;

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
        JSONObject result = new JSONObject();
        /**
         * 1、判断当前是否能进行预约操作
         */
        // 如果不能预约
        if (!checkAppointOperate())
        {
            // 获取每周哪天都可以进行预约操作，前台页面提示
            List<AppointSetting> setttingList = systemConfigService.getAppointSetting();
            StringBuilder sb = new StringBuilder();
            if (null != setttingList && setttingList.size() > 0)
            {
                for (AppointSetting appointSetting : setttingList)
                {
                    if (appointSetting.getOperateAppoint() == Constants.APPOINTMENT_ALLOW)
                    {
                        sb.append(" ").append(appointSetting.getValue()).append("，");
                    }
                }
            }
            result.put("result", "fail");
            result.put("msg", "每周的" + sb.toString() + "12:00~17:00进行预约");
            return result;
        }

        /**
         * 2、判断所选日期是否能预约
         */
        if (!checkAllowAppoint(appDate))
        {
            result.put("result", "fail");
            result.put("msg", "所选日期不能预约");
            return result;
        }

        /**
         * 3、判断是否已预约
         */
        // 格式化日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 查询登录用户在给定的日期内一周是否已经进行过申请
        User user = (User) request.getSession().getAttribute("user");
        Integer weekNum = appointService.queryUserIsAppHisThisWeek(format.format(appDate),
                user.getPhoneNo());
        if ((null != weekNum && weekNum > 0))
        {
            result.put("result", "fail");
            result.put("msg", "一周只能申请一次，所选日期所在周已经进行过申请，请选择其他时间段（周）进行申请");
            return result;
        }

        Integer total = 60;// 每个时间段默认可预约的总数
        // 查询预约的时间所在的周是否已经有预约，即每周只能预约一次并且不能超过30个
        // 查询某一个时间段内已经预约了多少事务
        Integer checkNum = appointService.queryAppointment(format.format(appDate),
                appointment.getAppTimeSlotValue());
        if (null == checkNum)
        {
            checkNum = 0;
        }
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
            appointService.addAppointment(appointment);
            result.put("result", "success");
            return result;
        }
        else
        {
            result.put("result", "fail");
            result.put("msg", "该时间段已经预约满");
            return result;
        }
    }

    /**
     * 判断预约操作
     * 
     * @return
     */
    private boolean checkAppointOperate()
    {
        // 得到系统当前时间是周几
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int w = cal.get(Calendar.DAY_OF_WEEK);
        int h = cal.get(Calendar.HOUR_OF_DAY);// 当前小时数字
        AppointSetting operateSetting = systemConfigService.queryById(w);
        // 当天不允许预约，并且不是12~17点，禁止预约操作
        if (!(operateSetting.getOperateAppoint() == Constants.APPOINTMENT_ALLOW && h >= 12 && h < 17))
        {
            return false;
        }

        return true;
    }

    /**
     * 判断所选日期是否允许预约
     * 
     * @param appDate
     * @return
     */
    private boolean checkAllowAppoint(Date appDate)
    {
        /**
         * 1、所选日期是否在预约范围之内，防止自己构造数据
         */
        // 预约开始时间(三天之后)
        Date startDate = DateUtil.getDateAfter(new Date(), Constants.AFTER_APPOINTMENT_DAY);
        // 预约结束时间(开始时间起一周时间)
        Date endDate = DateUtil.getDateAfter(new Date(), Constants.AFTER_APPOINTMENT_DAY + 6);
        // 从页面传递过来的时间没有时分秒，所以与起始时间同一天时，因为时分秒的关系会判定在其实时间之前，所以忽略其实时间的时分秒
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);

        Calendar app = Calendar.getInstance();
        app.setTime(appDate);

        if (app.before(start) || appDate.after(endDate))
        {
            return false;
        }

        /**
         * 2、所选时间是周几，周几是否允许预约
         */
        Calendar cal = Calendar.getInstance();
        cal.setTime(appDate);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        AppointSetting allowSetting = systemConfigService.queryById(week);
        // 所选日期不允许预约
        if (allowSetting.getAllowAppoint() == Constants.APPOINTMENT_FORBID)
        {
            return false;
        }

        return true;
    }

    /**
     * 预约大厅
     * 
     * @return
     * @throws IOException
     * @throws ParseException
     */
    @RequestMapping(value = "/listBookingHall.do", method = RequestMethod.POST)
    public @ResponseBody Object listBookingHall(HttpServletRequest request,
            HttpServletResponse response, String dateStr) throws IOException, ParseException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        int week = DateUtil.dayForWeek(dateStr);
        AppointSetting allowSetting = systemConfigService.queryById(week);
        if (allowSetting.getAllowAppoint() == Constants.APPOINTMENT_FORBID)
        {
            returnMap.put("forbid", "true");
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
    public @ResponseBody Object listAppointDetail(HttpServletRequest request,
            HttpServletResponse response) throws IOException
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
    public @ResponseBody Object findEverySlotPeopleOneDay(HttpServletRequest request,
            HttpServletResponse response, Date appDate) throws IOException
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
    public @ResponseBody Object queryUserIsAppHisThisWeek(HttpServletRequest request, String day)
            throws IOException
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
     * 显示可预约的日期
     * 
     * @return
     */
    @RequestMapping(value = "/getAppointmentDate.do", method = RequestMethod.POST)
    public @ResponseBody Object getAppointmentDate()
    {
        List<String> dateList = new ArrayList<String>();
        // 获取预约大厅中展示的预约日期
        Map<Integer, Integer> result = systemConfigService.getAppointShow();
        // 三天后开始预约
        int afterDay = Constants.AFTER_APPOINTMENT_DAY;
        // 循环计数器，只取一周的数据
        int count = 0;
        while (count < 7)
        {
            Date date = DateUtil.getDateAfter(new Date(), afterDay);
            Calendar c = Calendar.getInstance();
            c.setTime(date);

            // 展示的预约日期
            if (result.get(c.get(Calendar.DAY_OF_WEEK)).intValue() == Constants.APPOINTMENT_ALLOW)
            {

                dateList.add(DateUtil.getWeekByDateStr(c.get(Calendar.DAY_OF_WEEK)) + "_"
                        + DateFormatUtils.format(date, "yyyy-MM-dd"));
            }

            afterDay++;
            count++;
        }
        return dateList;
    }
}