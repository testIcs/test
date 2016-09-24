package com.zxkj.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.util.ZWUtils;
import com.zxkj.util.idcard.JnaUtil;

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
	 * @throws IOException 
	 */
	@RequestMapping(value = "/gainZWInfo.do", method = RequestMethod.GET)
	public @ResponseBody String gainZWInfo(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String pjtPath = request.getSession().getServletContext().getRealPath("");
		pjtPath += "\\id_card_images";
		ZWUtils.makeZWImg(pjtPath);
		
		return pjtPath + "\\fingerprint.bmp"; 
	}
	
	@RequestMapping(value = "/toContractPage.do", method = RequestMethod.GET)
	public String toContractPage() throws IOException
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