package com.zxkj.service;

import java.util.List;
import java.util.Map;

import com.zxkj.model.Appointment;

public interface IAppoint 
{
	/**
	 * 预约事件添加
	 * @param appointment
	 */
	Integer addAppointment(Appointment appointment);
	
	/**
	 * 预约大厅数据查询
	 * @return
	 */
	List<Map<String, Object>> listBookingHall(Map<String, String> paramsMap);
	
	/**
	 * 预约数据明细
	 * @return
	 */
	List<Map<String, Object>> listAppointDetail(Map<String, String> paramsMap);
	
	List<Map<String, Object>> findEverySlotPeopleOneDay(String appDate); 
}
