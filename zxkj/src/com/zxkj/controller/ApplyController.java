package com.zxkj.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zxkj.model.User;
import com.zxkj.service.IUser;
import com.zxkj.service.IUserLoan;
import com.zxkj.util.idcard.JnaUtil;
import com.zxkj.vo.UserLoanVO;

@Scope("prototype")
@Controller
@RequestMapping("/apply")
public class ApplyController 
{
	private static final Logger LOG = LoggerFactory.getLogger(ApplyController.class);
	
	@Resource
	private IUser userService;
	
	@Resource
	private IUserLoan userLoanService;
	
	/**
	 * 用户登录
	 * @param user 用户登录信息
	 * @return 用户登录状态
	 * @throws IOException
	 */
	@RequestMapping(value = "/toApplyPage.do", method = RequestMethod.GET)
	public String toApplyPage(ModelMap modelMap) throws IOException 
	{
		return "apply_manage/apply";
	}
	
	@RequestMapping(value = "/toApplyRegisterPage.do", method = RequestMethod.GET)
	public String toApplyRegisterPage(ModelMap modelMap)
	{
		return "apply_manage/apply_register";
	}

	@RequestMapping(value = "/saveIdCardInfo.do", method = RequestMethod.POST)
	public @ResponseBody Integer saveIdCardInfo(@ModelAttribute("user") User user) throws IOException
	{
		return userService.saveIdCardInfo(user);
	}

	@RequestMapping(value = "/saveLoanInfo.do", method = RequestMethod.POST)
	public @ResponseBody Integer saveLoanInfo(HttpServletRequest hsr,
			@ModelAttribute("userLoanVO") UserLoanVO userLoanVO
			)
	{
		User user = (User) hsr.getSession().getAttribute("user");
		userLoanVO.setUserId(user.getUserId());
		return userLoanService.saveUserLoanInfo(userLoanVO);
	}
	
	@RequestMapping(value = "/toRateconfirm.do", method = RequestMethod.GET)
	public String toRateconfirm(ModelMap modelMap)
	{
		return "apply_manage/rate_confirm";
	}
	
	@RequestMapping(value = "/toWarrantPage.do", method = RequestMethod.GET)
	public String toWarrantPage(ModelMap modelMap)
	{
		return "apply_manage/warrant";
	}
	
	@RequestMapping(value = "/toWarrantPageForLessInfo.do", method = RequestMethod.GET)
	public String toWarrantPageLess(ModelMap modelMap)
	{//add by wlh
		return "apply_manage/warrantLess";
	}

	@RequestMapping(value = "/toFrameNum.do", method = RequestMethod.GET)
	public String toFrameNum(ModelMap modelMap)
	{
		return "apply_manage/frame_num";
	}
	
	@RequestMapping(value = "/toReviewTips.do", method = RequestMethod.GET)
	public String toReviewTips(ModelMap modelMap)
	{
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