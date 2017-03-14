package com.zxkj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zxkj.model.AppointSetting;
import com.zxkj.service.SystemConfigService;

/**
 * 系统配置管理
 * 
 * SystemConfigController.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasoftinc on 2017年1月17日 下午1:58:45
 * @author liulong
 */
@Controller
@RequestMapping("/admin/config")
public class SystemConfigController
{
    /**
     * 系统设置service
     */
    @Resource
    private SystemConfigService systemConfigService;

    /**
     * 跳转到配置首页
     * 
     * @return ModelAndView
     */
    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/system_config");
        return mv;
    }

    /**
     * 获取预约设置数据
     * 
     * @return
     */
    @RequestMapping(value = "/getAppointSeting.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AppointSetting> getAppointSeting()
    {
        List<AppointSetting> result = systemConfigService.getAppointSetting();
        return result;
    }

    /**
     * 配置更改
     * 
     * @param id
     * @param appointSetting
     * @return
     */
    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    @ResponseBody
    public Object updateConfig(Integer id, AppointSetting appointSetting)
    {
        try
        {
            systemConfigService.updateAppointSetting(appointSetting);
            return "0";
        }
        catch (Exception e)
        {
            return "1";
        }
    }
}
