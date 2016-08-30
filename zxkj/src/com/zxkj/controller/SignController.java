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
@RequestMapping("/sign")
public class SignController 
{
	private static final Logger LOG = LoggerFactory.getLogger(SignController.class);
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toUserNotePage.do", method = RequestMethod.GET)
	public String toUserNotePage(ModelMap modelMap){
		return "sign_manage/user_note";
	}
	
	/**
	 * @param modelMap 返回到人脸识别页面
	 * @return String 人脸识别页面
	 */
	@RequestMapping(value = "/toFaceRecPage.do", method = RequestMethod.GET)
	public String toFaceRecPage(ModelMap modelMap)
	{
		return "sign_manage/face_rec";
	}

	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toFingerEnterPage.do", method = RequestMethod.GET)
	public String toFingerEnterPage(ModelMap modelMap)
	{
		return "sign_manage/finger_enter";
	}
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toContractPage.do", method = RequestMethod.GET)
	public String toContractPage(ModelMap modelMap)
	{
		return "sign_manage/contract";
	}
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toContractComparison.do", method = RequestMethod.GET)
	public String toContractComparison(ModelMap modelMap)
	{
		return "sign_manage/contract_comparison";
	}
	
	/**
	 * @param modelMap 返回到签约模块-用户须知页面
	 * @return String 首页名称
	 */
	@RequestMapping(value = "/toSignFinish.do", method = RequestMethod.GET)
	public String toSignFinish(ModelMap modelMap)
	{
		return "sign_manage/sign_finish";
	}
}