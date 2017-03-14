package com.zxkj.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.dao.SystemConfigMapper;
import com.zxkj.model.AppointSetting;
import com.zxkj.service.SystemConfigService;

/**
 * 系统配置接口实现
 * 
 * SystemConfigServiceImpl.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasoftinc on 2017年1月18日 下午3:00:09
 * @author liulong
 */
@Scope("prototype")
@Service("systemConfigService")
public class SystemConfigServiceImpl implements SystemConfigService
{

    @Resource
    private SystemConfigMapper systemconfigMapper;

    @Override
    public List<AppointSetting> getAppointSetting()
    {
        return systemconfigMapper.getAppointSetting();
    }

    @Override
    public AppointSetting queryById(Integer id)
    {
        return systemconfigMapper.queryById(id);
    }

    @Override
    public void updateAppointSetting(AppointSetting appointSetting)
    {
        systemconfigMapper.updateAppointSetting(appointSetting);
    }

    @Override
    public Map<Integer, Integer> getAppointShow()
    {
        Map<Integer, Integer> resMap = new HashMap<Integer, Integer>();
        List<AppointSetting> result = systemconfigMapper.getAppointSetting();
        if (null == result || result.size() == 0)
        {
            return resMap;
        }
        for (AppointSetting appointSetting : result)
        {
            resMap.put(appointSetting.getId(), appointSetting.getAppointShow());
        }
        return resMap;
    }
}
