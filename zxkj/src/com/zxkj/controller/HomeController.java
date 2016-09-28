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
@RequestMapping("/home")
public class HomeController
{

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    /**
     * @param modelMap
     *            返回到页面的信息
     * @return String 首页名称
     */
    @RequestMapping(value = "/home.do", method = RequestMethod.GET)
    public String toHomePage(ModelMap modelMap)
    {
        return "home";
    }

    /**
     * @param modelMap
     *            跳转到测一测页面
     * @return String 测一测名称
     */
    @RequestMapping(value = "/test.do", method = RequestMethod.GET)
    public String toTest(ModelMap modelMap)
    {
        return "test/test";
    }

}