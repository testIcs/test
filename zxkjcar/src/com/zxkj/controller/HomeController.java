package com.zxkj.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scope("prototype")
@Controller
@RequestMapping("/home")
public class HomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

	/**
	 * 用户登录
	 * @param user 用户登录信息
	 * @return 用户登录状态
	 * @throws IOException
	 */
	@RequestMapping(value = "/toApplyPage.do", method = RequestMethod.GET)
	public String toApplyPage(ModelMap modelMap) throws IOException {
		return "apply_manage/apply";
	}
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String toHomePage(ModelMap modelMap){
		return "home";
	}
}