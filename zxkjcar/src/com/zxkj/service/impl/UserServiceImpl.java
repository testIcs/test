package com.zxkj.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.icss.lighttowersystem.util.MD5Util;
import com.zxkj.common.Constants;
import com.zxkj.dao.UserMapper;
import com.zxkj.model.User;
import com.zxkj.service.UserService;

/**
 * {@inheritDoc}
 * 
 * @author
 */
@Scope("prototype")
@Service("userService")
public class UserServiceImpl implements UserService
{
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired(required = true)
    private UserMapper userMapper;

    @Override
    /**
     * {@inheritDoc}
     */
    public Map<String, Object> login(User user)
    {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        User u = userMapper.login(user.getPhoneNo());
        Integer check = Constants.STATUS_OK;
        if (u == null)
        {
            check = Constants.STATUS_ERROR;
            returnMap.put("status", check);
            returnMap.put("userBean", u);
            return returnMap;
        }
        else if (u.getState() == Constants.USER_STATE_AUDITING)
        {
            check = Constants.DATA_AUDITING;
            returnMap.put("status", check);
            returnMap.put("userBean", u);
            return returnMap;
        }
        else if (!u.getPassword().equals(MD5Util.generatePassword(user.getPassword())))
        {

            check = Constants.DATA_INCORRECT;
            returnMap.put("status", check);
            returnMap.put("userBean", u);
            return returnMap;
        }
        returnMap.put("status", check);
        returnMap.put("userBean", u);
        return returnMap;
    }

    @Override
    public boolean judgeAccount(User user)
    {
        boolean flag = false;
        if (null != user)
        {
            String userName = user.getUserName();// 获取用户注册时的账号
            // 根据账号查询数据库内是否存在相同的数据
            Integer returnResult = userMapper.judgeAccount(userName);
            if (returnResult == 1)
            {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public Integer addUser(User user)
    {
        Integer result = Constants.STATUS_OK;
        result = userMapper.addUser(user);
        if (result == null)
        {
            result = Constants.STATUS_ERROR;
        }
        else
        {
            result = Constants.STATUS_OK;
        }
        return result;
    }

    @Override
    public void updateUser(User user)
    {
        userMapper.updateUser(user);

    }

    @Override
    public List<User> queryBeAuditedUser()
    {
        return userMapper.queryBeAuditedUser();
    }

    @Override
    public List<User> queryAuditedUser()
    {
        return userMapper.queryAuditedUser();
    }

    @Override
    public void deleteUser(Integer id)
    {
        userMapper.deleteUser(id);
    }

    @Override
    public Boolean phoneExist(String phone)
    {
        Integer count = userMapper.phoneExist(phone);
        // 数量大于0 标示已存在
        if (count > 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public User queryUserById(Integer userId)
    {
        return userMapper.queryUserById(userId);
    }

}
