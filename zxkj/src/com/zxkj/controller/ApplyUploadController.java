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
@RequestMapping("/applyUpload")
public class ApplyUploadController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ApplyUploadController.class);

	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 申请注册页面名称
	 */
	@RequestMapping(value = "/toApplyUploadList.do", method = RequestMethod.GET)
	public String toApplyUploadList(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_id_card";
	}
	
	@RequestMapping(value = "/toApplyUploadListLess.do", method = RequestMethod.GET)
	public String toApplyUploadListLess(ModelMap modelMap){//add by wlh
		return "apply_manage/upload_manage/upload_id_card_less";
	}
	
	/**
	 * 上传贷款申请页面
	 * @param modelMap 返回到页面的信息
	 * @return String 
	 */
	@RequestMapping(value = "/toUploadLoan.do", method = RequestMethod.GET)
	public String toUploadLoan(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_loan";
	}	
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 申请注册页面名称
	 */
	@RequestMapping(value = "/toLoanSubmit.do", method = RequestMethod.GET)
	public String toLoanSubmit(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_loan_s";
	}	
	
	/**
	 * 上传身份证页面
	 * @param modelMap 返回到页面的信息
	 * @return String
	 */
	@RequestMapping(value = "/toUploadIdCard.do", method = RequestMethod.GET)
	public String toUploadIdCard(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_id_card";
	}	
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 申请注册页面名称
	 */
	@RequestMapping(value = "/toIdCardSubmit.do", method = RequestMethod.GET)
	public String toIdCardSubmit(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_id_card_s";
	}	
	
	/**
	 * 上传车辆信息页面
	 * @param modelMap 返回到页面的信息
	 * @return String 
	 */
	@RequestMapping(value = "/toUploadCar.do", method = RequestMethod.GET)
	public String toUploadCar(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_car";
	}	
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 申请注册页面名称
	 */
	@RequestMapping(value = "/toCarSubmit.do", method = RequestMethod.GET)
	public String toCarSubmit(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_car_s";
	}	
	
	/**
	 * 上传银行流水页面
	 * @param modelMap 返回到页面的信息
	 * @return String 
	 */
	@RequestMapping(value = "/toUploadBank.do", method = RequestMethod.GET)
	public String toUploadBank(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_bank";
	}	
	
	/**
	 * 
	 * @param modelMap 返回到页面的信息
	 * @return String
	 */
	@RequestMapping(value = "/toBankSubmit.do", method = RequestMethod.GET)
	public String toBankSubmit(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_bank_s";
	}	
	
	/**
	 * 上传授权书页面
	 * @param modelMap 返回到页面的信息
	 * @return String 
	 */
	@RequestMapping(value = "/toUploadAuth.do", method = RequestMethod.GET)
	public String toUploadAuth(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_auth";
	}	
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 
	 */
	@RequestMapping(value = "/toAuthSubmit.do", method = RequestMethod.GET)
	public String toAuthSubmit(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_auth_s";
	}	
	
	/**
	 * 上传收入证明页面
	 * @param modelMap 返回到页面的信息
	 * @return String 
	 */
	@RequestMapping(value = "/toUploadIncome.do", method = RequestMethod.GET)
	public String toUploadIncome(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_income";
	}	
	
	/**
	 * 上传房产信息页面
	 * @param modelMap 返回到页面的信息
	 * @return String 
	 */
	@RequestMapping(value = "/toUploadHouse.do", method = RequestMethod.GET)
	public String toUploadHouse(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_house";
	}
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 申请注册页面名称
	 */
	@RequestMapping(value = "/toHouseSubmit.do", method = RequestMethod.GET)
	public String toHouseSubmit(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_house_s";
	}
	
	/**
	 * 上传其他补充页面
	 * @param modelMap 返回到页面的信息
	 * @return String
	 */
	@RequestMapping(value = "/toUploadOther.do", method = RequestMethod.GET)
	public String toUploadOther(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_other";
	}
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 申请注册页面名称
	 */
	@RequestMapping(value = "/toOtherSubmit.do", method = RequestMethod.GET)
	public String toOtherSubmit(ModelMap modelMap){
		return "apply_manage/upload_manage/upload_other_s";
	}
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 申请注册页面名称
	 */
	@RequestMapping(value = "/toBankCard.do", method = RequestMethod.GET)
	public String toBankCard(ModelMap modelMap){
		return "apply_manage/bank_card";
	}
}