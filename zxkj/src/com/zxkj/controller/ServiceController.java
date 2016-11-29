package com.zxkj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scope("prototype")
@Controller
@RequestMapping("/service")
public class ServiceController 
{
	private static final Logger LOG = LoggerFactory.getLogger(ServiceController.class);
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toServiceIndexPage.do", method = RequestMethod.GET)
	public String toServiceIndexPage(ModelMap modelMap){
		return "service_manage/service_index";
	}
}