package com.zxkj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.service.IUserLoan;
import com.zxkj.util.SmsHandle;

@Scope("prototype")
@Controller
@RequestMapping("/trial")
public class TrailController
{
    private static final Logger LOG = LoggerFactory.getLogger(TrailController.class);

    @Resource
    private IUserLoan userLoanService;

    /**
     * @param modelMap
     *            跳转到贷款试算页面
     * @return String 贷款试算页面名称
     */
    @RequestMapping(value = "/toTrialIndexPage.do", method = RequestMethod.GET)
    public String toTrialIndexPage(ModelMap modelMap)
    {
        return "/trial_manage/loan_trial";
    }

    /**
     * @param modelMap
     *            跳转到简易贷页面
     * @return String 简易贷页面名称
     */
    @RequestMapping(value = "/toJianYiDaiPage.do", method = RequestMethod.GET)
    public String toJianYiDaiPage(ModelMap modelMap)
    {
        return "/trial_manage/jian_yi_dai";
    }

    /**
     * 获得计算计算发送短信
     * 
     * @param phoneNo
     *            手机号
     * @param firstpayment
     *            首付
     * @param deposit
     *            保证金额
     * @param rent
     *            每月租金
     * @param dailyrent
     *            每日租金
     * @param periods
     *            每时租金
     * @return
     */
    @RequestMapping(value = "/loanlimitresult.do", method = RequestMethod.POST)
    public @ResponseBody Object loanlimitresult(String phoneNo, String firstpayment, String deposit, String rent,
            String dailyrent, String periods)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        try
        {
            // 不存在改手机号，存储起来
            if (!userLoanService.judgePhoneExist(phoneNo))
            {
                userLoanService.addPhone(phoneNo);
            }
            new SmsHandle().smsSend(phoneNo, "您的测试结果为:首付金额：" + firstpayment + "元，保证金额：" + deposit + "元，每月租金：" + rent
                    + "元，每日租金：" + dailyrent + "元，每时租金：" + periods+ "元");

            result.put("result", "0");
        }
        catch (Exception e)
        {
            result.put("result", "1");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * @param modelMap
     *            跳转到低首付页面
     * @return String 低首付页面名称
     */
    @RequestMapping(value = "/toDiShouFu.do", method = RequestMethod.GET)
    public String toDiShouFu(ModelMap modelMap)
    {
        return "/trial_manage/di_shou_fu";
    }

    /**
     * @param modelMap
     *            跳转到低利息页面
     * @return String 低利息页面名称
     */
    @RequestMapping(value = "/toDiLiXi.do", method = RequestMethod.GET)
    public String toDiLiXi(ModelMap modelMap)
    {
        return "/trial_manage/di_li_xi";
    }

    /**
     * @param modelMap
     *            跳转到低月供
     * @return String 低月供页面名称
     */
    @RequestMapping(value = "/toDiYueGong.do", method = RequestMethod.GET)
    public String toDiYueGong(ModelMap modelMap)
    {
        return "/trial_manage/di_yue_gong";
    }
}