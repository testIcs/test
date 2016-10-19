package com.zxkj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zxkj.common.Constants;
import com.zxkj.model.User;
import com.zxkj.service.NoticeService;
import com.zxkj.service.UserService;
import com.zxkj.util.MD5Util;

/**
 * 后台管理控制器
 * 
 * AdminController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016年8月29日 上午9:37:13
 * @author liulong
 */
@Scope("prototype")
@Controller
@RequestMapping("/admin")
public class AdminController
{
    /**
     * 用户Service
     */
    @Autowired(required = true)
    private UserService userService;

    /**
     * 公告Service
     */
    @Autowired(required = true)
    private NoticeService noticeService;

    /**
     * 跳转到后台管理首页
     * 
     * @return
     */
    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/home");
        return mv;
    }

    /**
     * 跳转到公告发布页面
     * 
     * @return
     */

    @RequestMapping(value = "/notice.do", method = RequestMethod.GET)
    public ModelAndView notice()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/releaseNotice");
        return mv;
    }

    /**
     * 跳转到公告发布页面
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/releaseNotice.do", method = RequestMethod.POST)
    public Object releaseNotice(String noticeContext)
    {
        try
        {
            noticeService.releaseNotice(noticeContext);
            return "{\"result\":\"success\"}";
        }
        catch (Exception e)
        {
            return "{\"result\":\"error\",\"msg\":\"" + e.getMessage() + "\"}";
        }

    }

    /**
     * 查询审核用户
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryBeAuditedUser.do", method = RequestMethod.POST)
    public Object queryBeAuditedUser()
    {
        return userService.queryBeAuditedUser();
    }

    /**
     * 查询审核通过的用户
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryAuditedUser.do", method = RequestMethod.POST)
    public Object queryAuditedUser()
    {
        return userService.queryAuditedUser();
    }

    /**
     * 审核用户
     * 
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/auditUser.do", method = RequestMethod.POST)
    public Object auditUser(HttpServletRequest request, User user)
    {
        try
        {
            userService.updateUser(user);
            return "0";
        }
        catch (Exception e)
        {
            return "1";
        }

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
        user.setState(Constants.USER_STATE_AUDITED);
        user.setPassword(MD5Util.generatePassword(user.getPassword()));
        status = userService.addUser(user);
        return status;
    }

    /**
     * 删除用户
     * 
     * @param request
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUser.do", method = RequestMethod.POST)
    public Object deleteUser(HttpServletRequest request, Integer id)
    {
        try
        {
            userService.deleteUser(id);
            return "0";
        }
        catch (Exception e)
        {
            return "1";
        }
    }

    /**
     * 展示用户详细信息
     * 
     * @return
     */

    @RequestMapping(value = "/showUserInfo.do", method = RequestMethod.GET)
    public ModelAndView showUserInfo(Integer userId)
    {
        ModelAndView mv = new ModelAndView();
        User user = userService.queryUserById(userId);
        mv.getModelMap().put("user", user);
        mv.setViewName("admin/user_detail");
        return mv;
    }

}
