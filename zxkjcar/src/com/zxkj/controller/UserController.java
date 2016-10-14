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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.common.Constants;
import com.zxkj.model.User;
import com.zxkj.service.UserService;
import com.zxkj.util.MD5Util;

@Scope("prototype")
@Controller
@RequestMapping("/user")
public class UserController
{
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户Service
     */
    @Autowired(required = true)
    private UserService userService;

    /**
     * 用户登录
     * 
     * @param user
     *            用户登录信息
     * @return 用户登录状态
     * @throws IOException
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public @ResponseBody Object login(HttpServletRequest request, User user) throws IOException
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        int status = userService.login(user);
        if (status == Constants.STATUS_OK)
        {
            returnMap.put("user", user);
            request.getSession().setAttribute("user", user);
        }
        LOG.info("UserController>login->status:{}", status);
        returnMap.put("role", user.getRole());
        returnMap.put("status", status);
        return returnMap;
    }

    /**
     * 判断账号是否存在
     * 
     * @param request
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/judgeAccount.do", method = RequestMethod.POST)
    public String judgeAccount(HttpServletRequest request, User user)
    {
        boolean flag = userService.judgeAccount(user);
        return flag ? "SUCCESS" : "ERROR";
    }

    /**
     * 用户注册
     * 
     * @param request
     * @param user
     */
    @ResponseBody
    @RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
    public Object addUser(HttpServletRequest request, User user)
    {
        Integer status = Constants.DATA_INCORRECT;
        user.setState(Constants.USER_STATE_AUDITING);
        user.setPassword(MD5Util.generatePassword(user.getPassword()));
        status = userService.addUser(user);
        return status;
    }

    /**
     * 校验手机号是否已存在
     * 
     * @param userName
     * @return
     */
    @RequestMapping(value = "/judgePhone.do")
    public @ResponseBody Object judgePhone(String phoneNo)
    {
        // 如果手机号已存在，前台校验不通过
        if (userService.phoneExist(phoneNo))
        {
            return "{\"valid\": false  }";
        }
        else
        {
            return "{\"valid\": true  }";
        }
    }
}