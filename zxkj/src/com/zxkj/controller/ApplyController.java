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
@RequestMapping("/apply")
public class ApplyController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ApplyController.class);

	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 申请注册页面名称
	 */
	@RequestMapping(value = "/toApplyRegisterPage.do", method = RequestMethod.GET)
	public String toApplyRegisterPage(ModelMap modelMap){
		return "apply_manage/apply_register";
	}
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 贷款利率确认页面名称
	 */
	@RequestMapping(value = "/toRateconfirm.do", method = RequestMethod.GET)
	public String toRateconfirm(ModelMap modelMap){
		return "apply_manage/rate_confirm";
	}
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 贷款利率确认页面名称
	 */
	@RequestMapping(value = "/toWarrantPage.do", method = RequestMethod.GET)
	public String toWarrantPage(ModelMap modelMap){
		return "apply_manage/warrant";
	}
	
	/**
	 * 跳转到上传贷款申请页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/toUploadLoanApplication.do", method = RequestMethod.GET)
	public String toLoanApplication(ModelMap modelMap){
		return "apply_manage/toUploadLoanApplication";
	}
	
	/**
	 * 跳转到上传贷款申请页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/toFrameNum.do", method = RequestMethod.GET)
	public String toFrameNum(ModelMap modelMap){
		return "apply_manage/frame_num";
	}
	
	/**
	 * 跳转到上传贷款申请页面
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/toReviewTips.do", method = RequestMethod.GET)
	public String toReviewTips(ModelMap modelMap){
		return "apply_manage/review_tips";
	}	
}