package com.zxkj.service.impl;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.common.Constants;
import com.zxkj.dao.UserMapper;
import com.zxkj.model.User;
import com.zxkj.service.IUser;

/**
 * {@inheritDoc}
 * @author
 */
@Scope("prototype")
@Service("userService")
public class UserServiceImpl implements IUser 
{
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired(required = true)
	private UserMapper userMapper;

	@Override
	/**
	 * {@inheritDoc}
	 */
	public int login(User user) 
	{
		User userDB = userMapper.findUserByUser(user);
		if(null != userDB)
		{
			if(userDB.getPassword().equals(user.getPassword()))
			{
				return Constants.STATUS_OK;
			}
			else
			{
				return Constants.DATA_INCORRECT;
			}
		}
		else 
		{
			return Constants.DATA_INCORRECT;
		}
	}

	@Override
	public Integer saveIdCardInfo(User user) 
	{
		user.setAddTime(new Date(System.currentTimeMillis()));
		userMapper.saveIdCardInfo(user);
		return user.getUserId();
	}

	@Override
	public User findUserByUser(User user) 
	{
		return userMapper.findUserByUser(user);
	}
}
