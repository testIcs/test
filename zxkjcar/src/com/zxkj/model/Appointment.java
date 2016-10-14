package com.zxkj.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 预约时间段基本信息
 * 
 * @author guo
 *
 */
@Data
public class Appointment implements Serializable
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2594421769042776738L;

    private Integer id;

    /**
     * 预约人姓名
     */
    private String appUserName;

    /**
     * 预约人电话
     */
    private String appPhoneNo;

    /**
     * 预约事务数量
     */
    private Integer appAffair;

    /**
     * 预约日期
     */
    private Date appDate;

    /**
     * 预约时间段value
     */
    private Integer appTimeSlotValue;

    /**
     * 预约时间段name
     */
    private String appTimeSlotName;

    private Integer appStatus;

}
