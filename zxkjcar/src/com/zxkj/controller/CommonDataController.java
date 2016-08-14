package com.zxkj.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.service.DicService;

@Scope("prototype")
@Controller
@RequestMapping("/commonData")
public class CommonDataController 
{
	@Autowired
	private DicService dicService; 
	
	/**
	 * 预约时间段数据
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findTimeSlots.do", method = RequestMethod.GET)
	public @ResponseBody Object findTimeSlots() throws IOException {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String, Object>> returnList = dicService.findTimeSlots();
		returnMap.put("bookingHallList", returnList);
		return returnMap;
	}
}
