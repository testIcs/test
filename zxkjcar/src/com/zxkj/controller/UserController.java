package com.zxkj.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




import com.zxkj.common.Constants;
import com.zxkj.model.Appointment;
import com.zxkj.model.User;
import com.zxkj.service.UserService;
import com.zxkj.util.DesEncrypt;
import com.zxkj.util.EncryptKey;
import com.zxkj.util.MD5Util;


@Scope("prototype")
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	/**
	 * 加密key
	 */
	private static final String KEY_STR = EncryptKey.getKey();
	/**
	 * 用户Service
	 */
	@Autowired(required = true)
	private UserService userService;

	/**
	 * 用户登录
	 * @param user 用户登录信息
	 * @return 用户登录状态
	 * @throws IOException
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public @ResponseBody Object login(HttpServletRequest request,User user) throws IOException {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		int status = userService.login(user);
		if(status == Constants.STATUS_OK)
		{
			returnMap.put("user", user);
			request.getSession().setAttribute("user", user);
		}
		returnMap.put("status", status);
		return returnMap;
	}
	
	/**
	 * 判断账号是否存在
	 * @param request
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/judgeAccount.do", method = RequestMethod.POST)
	public String judgeAccount(HttpServletRequest request,User user) {
		boolean flag = userService.judgeAccount(user);
		return flag?"SUCCESS":"ERROR";
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @param user
	 */
	@ResponseBody
	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
	public Object addUser(HttpServletRequest request,User user) {
		Integer status = Constants.DATA_INCORRECT;
		//单点登录过来增加的用户没有密码，做一个非空判断
		if(user.getPassword()!=null){
			user.setPassword(MD5Util.generatePassword(user.getPassword()));
		}
		status = userService.addUser(user);
		System.out.println(status);
		return status;
	}
}