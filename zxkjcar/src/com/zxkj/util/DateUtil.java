package com.zxkj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期相关工具列
 * 
 * DateUtil.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年11月17日 下午2:19:03
 * @author liulong
 */
public class DateUtil
{
    private static final Map<Integer, String> WEEKMAP = new HashMap<Integer, String>();
    static
    {
        WEEKMAP.put(1, "周日");
        WEEKMAP.put(2, "周一");
        WEEKMAP.put(3, "周二");
        WEEKMAP.put(4, "周三");
        WEEKMAP.put(5, "周四");
        WEEKMAP.put(6, "周五");
        WEEKMAP.put(7, "周六");
    }

    /**
     * 获取指定之后的天数
     * 
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day)
    {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * 获取周几的字符串
     * 
     * @param week
     * @return
     */
    public static String getWeekByDateStr(int week)
    {
        return WEEKMAP.get(week);
    }

    /**
     * 获取日期是周几
     * 
     * @param pTime
     * @return
     * @throws ParseException
     * @throws Throwable
     */
    public static int dayForWeek(String pTime) throws ParseException
    {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date tmpDate = format.parse(pTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(tmpDate);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

}
