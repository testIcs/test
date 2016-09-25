package com.zxkj.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.service.IDic;

@Scope("prototype")
@Controller
@RequestMapping("/dic")
public class DicController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DicController.class);

	@Autowired
	private IDic dicService;
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 申请注册页面名称
	 */
	@ResponseBody 
	@RequestMapping(value = "/findFinancialProducts.do", method = RequestMethod.POST)
	public List<Map<Integer, String>> findFinancialProducts(ModelMap modelMap){
		return dicService.findFinancialProducts();
	}
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 贷款利率确认页面名称
	 */
	@ResponseBody
	@RequestMapping(value = "/findLendingRate.do", method = RequestMethod.POST)
	public List<Map<Integer, String>> findLendingRate(ModelMap modelMap){
		return dicService.findLendingRate();
	}
	
	/**
	 * @param modelMap 返回到页面的信息
	 * @return String 申请注册页面名称
	 */
	@ResponseBody
	@RequestMapping(value = "/findLoanTerm.do", method = RequestMethod.POST)
	public List<Map<Integer, String>> findLoanTerm(ModelMap modelMap){
		return dicService.findLoanTerm();
	}
}