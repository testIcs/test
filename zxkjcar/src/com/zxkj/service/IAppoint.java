package com.zxkj.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zxkj.model.Appointment;
import com.zxkj.util.PagerUtil;

public interface IAppoint
{
    /**
     * 预约事件添加
     * 
     * @param appointment
     */
    Integer addAppointment(Appointment appointment);

    /**
     * 预约大厅数据查询
     * 
     * @return
     */
    List<Map<String, Object>> listBookingHall(Map<String, String> paramsMap);

    /**
     * 预约数据明细
     * 
     * @return
     */
    List<Map<String, Object>> listAppointDetail(Map<String, String> paramsMap);

    List<Map<String, Object>> findEverySlotPeopleOneDay(Date appDate);

    /**
     * 查询某一个时间段内已经预约了多少事务
     * 
     * @param day
     * @param sort
     * @return
     */
    Integer queryAppointment(String day, Integer sort);

    /**
     * 查询登录用户在给定的日期内一周是否已经进行过申请，如果进行过申请返回1，否则返回0
     * 
     * @param day
     * @return
     */
    Integer queryUserIsAppHisThisWeek(String day, String userPhone);

    /**
     * 分页查询数据
     * 
     * @return
     */
    List<Appointment> pageList(PagerUtil pu);

    /**
     * 查询总数
     * 
     * @return
     */
    Integer queryTotal();

    /**
     * 删除预约
     * 
     * @param id
     */
    void deleteAppointment(Integer id);
}
