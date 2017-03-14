package com.zxkj.model;

import java.io.Serializable;

/**
 * 预约设置实体(每周为单位)
 * 
 * WeekAppointSetting.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasoftinc on 2017年1月19日 下午4:21:25
 * @author liulong
 */
public class AppointSetting implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 周几id
     */
    private int id;

    /**
     * 周几名称
     */
    private String value;

    /**
     * 是否显示在预约大厅1否 2是
     */
    private int appointShow;

    /**
     * 当天是否可以进行预约操作1否 2是
     */
    private int operateAppoint;

    /**
     * 是否可以预约当天的1否 2是
     */
    private int allowAppoint;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public int getAppointShow()
    {
        return appointShow;
    }

    public void setAppointShow(int appointShow)
    {
        this.appointShow = appointShow;
    }

    public int getOperateAppoint()
    {
        return operateAppoint;
    }

    public void setOperateAppoint(int operateAppoint)
    {
        this.operateAppoint = operateAppoint;
    }

    public int getAllowAppoint()
    {
        return allowAppoint;
    }

    public void setAllowAppoint(int allowAppoint)
    {
        this.allowAppoint = allowAppoint;
    }
}
