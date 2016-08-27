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

import com.zxkj.util.idcard.JnaUtil;

@Scope("prototype")
@Controller
@RequestMapping("/apply")
public class ApplyController 
{
	private static final Logger LOG = LoggerFactory.getLogger(ApplyController.class);
	
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
	
	@RequestMapping(value = "/toApplyRegisterPage.do", method = RequestMethod.GET)
	public String toApplyRegisterPage(ModelMap modelMap){
		return "apply_manage/apply_register";
	}

	@RequestMapping(value = "/toRateconfirm.do", method = RequestMethod.GET)
	public String toRateconfirm(ModelMap modelMap){
		return "apply_manage/rate_confirm";
	}

	@RequestMapping(value = "/toWarrantPage.do", method = RequestMethod.GET)
	public String toWarrantPage(ModelMap modelMap){
		return "apply_manage/warrant";
	}

	@RequestMapping(value = "/toFrameNum.do", method = RequestMethod.GET)
	public String toFrameNum(ModelMap modelMap){
		return "apply_manage/frame_num";
	}
	
	@RequestMapping(value = "/toReviewTips.do", method = RequestMethod.GET)
	public String toReviewTips(ModelMap modelMap){
		return "apply_manage/review_tips";
	}	

	@RequestMapping(value = "/readIdCard.do", method = RequestMethod.GET)
	public void readIdCard(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String pjtPath = request.getSession().getServletContext().getRealPath("");
		pjtPath += "\\id_card_images";
		String idCardInfo = JnaUtil.readIdCardInfo(pjtPath);
		response.setHeader("Content-type", "text/html;charset=GBK");  
		response.setCharacterEncoding("GBK");
		response.getWriter().write(idCardInfo); 
	}	
}