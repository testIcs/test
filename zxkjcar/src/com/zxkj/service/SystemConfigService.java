package com.zxkj.service;

import java.util.List;
import java.util.Map;

import com.zxkj.model.AppointSetting;

/**
 * 系统配置接口
 * 
 * SystemConfigService.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasoftinc on 2017年1月18日 下午2:55:36
 * @author liulong
 */
public interface SystemConfigService
{
    /**
     * 获取预约设置数据
     * 
     * @return
     */
    List<AppointSetting> getAppointSetting();

    /**
     * 根据id查找配置
     * 
     * @param id
     * @return
     */
    AppointSetting queryById(Integer id);

    /**
     * 更改预约配置
     * 
     * @param appointSetting
     */
    void updateAppointSetting(AppointSetting appointSetting);

    /**
     * 获取预约大厅中展示的预约日期
     * 
     * @return
     */
    Map<Integer, Integer> getAppointShow();
}
