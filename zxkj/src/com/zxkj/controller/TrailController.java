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
@RequestMapping("/trial")
public class TrailController 
{
	private static final Logger LOG = LoggerFactory.getLogger(TrailController.class);
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toTrialIndexPage.do", method = RequestMethod.GET)
	public String toTrialIndexPage(ModelMap modelMap){
		return "/trial_manage/trial_index";
	}
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toJianYiDaiPage.do", method = RequestMethod.GET)
	public String toJianYiDaiPage(ModelMap modelMap){
		return "/trial_manage/jian_yi_dai";
	}
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toDiShouFu.do", method = RequestMethod.GET)
	public String toDiShouFu(ModelMap modelMap){
		return "/trial_manage/di_shou_fu";
	}
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toDiLiXi.do", method = RequestMethod.GET)
	public String toDiLiXi(ModelMap modelMap){
		return "/trial_manage/di_li_xi";
	}
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toDiYueGong.do", method = RequestMethod.GET)
	public String toDiYueGong(ModelMap modelMap){
		return "/trial_manage/di_yue_gong";
	}
	
}