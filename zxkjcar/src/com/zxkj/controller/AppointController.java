package com.zxkj.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.common.Constants;
import com.zxkj.model.Appointment;
import com.zxkj.service.IAppoint;

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
	 * 添加预约事件
	 * @param request
	 * @param appointment
	 */
	@ResponseBody
	@RequestMapping(value = "/addAppointment.do", method = RequestMethod.POST)
	public Object addAppointment(HttpServletRequest request, Appointment appointment) {
		Integer status = Constants.DATA_INCORRECT;
		if(null != appointment){
			 status = appointService.addAppointment(appointment);
		}
		return status;
	}
	
	/**
	 * 预约大厅
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/listBookingHall.do", method = RequestMethod.POST)
	public @ResponseBody Object listBookingHall(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, String> paramsMap = new HashMap<String, String>();
		String dateStr = request.getParameter("dateStr");
		paramsMap.put("datestr", dateStr+" 00:00:00");
		List<Map<String, Object>> returnList = appointService.listBookingHall(paramsMap);
		returnMap.put("bookingHallList", returnList);
		return returnMap;
	}
	

	/**
	 * 预约数据明细
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/listAppointDetail.do", method = RequestMethod.POST)
	public @ResponseBody Object listAppointDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, String> paramsMap = new HashMap<String, String>();
		String dateStr = request.getParameter("dateStr");
		paramsMap.put("datestr", dateStr+" 00:00:00");
		List<Map<String, Object>> returnList = appointService.listAppointDetail(paramsMap);
		returnMap.put("appointDetail", returnList);
		return returnMap;
	}
	
	@RequestMapping(value = "/findEverySlotPeopleOneDay.do", method = RequestMethod.POST)
	public @ResponseBody Object findEverySlotPeopleOneDay(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String appDate = request.getParameter("appDate");
		List<Map<String, Object>> mapList = appointService.findEverySlotPeopleOneDay(appDate);
		returnMap.put("slotUsers", mapList);
		return returnMap;
	}
}