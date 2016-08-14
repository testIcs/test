package com.zxkj.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.chrono.JapaneseChronology;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.common.Constants;
import com.zxkj.dao.AppointMapper;
import com.zxkj.dao.DicMapper;
import com.zxkj.model.Appointment;
import com.zxkj.service.IAppoint;

@Scope("prototype")
@Service("appointService")
public class AppointServiceImpl implements IAppoint 
{
	private static final Logger LOG = LoggerFactory.getLogger(AppointServiceImpl.class);
	
	@Autowired
	private AppointMapper appointMapper;
	
	@Autowired
	private DicMapper dicMapper;
	
	@Override
	public Integer addAppointment(Appointment appointment) 
	{
		Integer result = appointMapper.addAppointment(appointment);
		Integer check = Constants.STATUS_OK;
		if (result == null) {
			check = Constants.STATUS_ERROR;
		}
		return check;
		
	}
	
	@Override
	public List<Map<String, Object>> listBookingHall(Map<String, String> paramsMap) 
	{
		List<Map<String, Object>> resultMap = appointMapper.listBookingHall(paramsMap);
		return resultMap;
	}

	@Override
	public List<Map<String, Object>> listAppointDetail(
			Map<String, String> paramsMap) {
		List<Map<String, Object>> resultMap = appointMapper.listAppointDetail(paramsMap);
		return resultMap;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Map<String, Object>> findEverySlotPeopleOneDay(String appDate) 
	{
		List<Map<String, Object>> slotUserMapList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> slotMaps = dicMapper.findTimeSlots();
		if(CollectionUtils.isNotEmpty(slotMaps))
		{
			for (Map<String, Object> map : slotMaps) 
			{
				Map<String, Object> appointUserMaps = new HashMap<String, Object>();
				appointUserMaps.put("slotName", map.get("name"));
				Map<String, Object> mapArg = new HashMap<String, Object>();
				mapArg.put("timeSlot", (Integer)map.get("value"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					mapArg.put("appDate", (java.util.Date)sdf.parse(appDate+" 00:00:00"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				appointUserMaps.put("userNames", appointMapper.findUsersBySlot(mapArg));
				slotUserMapList.add(appointUserMaps);
			}
		}
		return slotUserMapList;
	}
}
