package com.zxkj.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.model.User;
import com.zxkj.service.UserService;
import com.zxkj.util.DesEncrypt;
import com.zxkj.util.EncryptKey;


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
		String pwd = user.getPassword();
		DesEncrypt encrypt = new DesEncrypt(KEY_STR);
		user.setPassword(encrypt.decrypt(pwd));
		int status = userService.login(user);
		returnMap.put("status", status);
		returnMap.put("user", user);
		request.getSession().setAttribute("user", user);
		return returnMap;
	}
}