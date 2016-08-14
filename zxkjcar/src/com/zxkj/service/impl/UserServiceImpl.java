package com.zxkj.service.impl;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.icss.lighttower.consts.CacheConst;
import com.icss.lighttowersystem.model.UserBase;
import com.icss.lighttowersystem.util.MD5Util;
import com.zxkj.common.Constants;
import com.zxkj.dao.UserMapper;
import com.zxkj.model.Appointment;
import com.zxkj.model.User;
import com.zxkj.service.UserService;

/**
 * {@inheritDoc}
 * @author
 */
@Scope("prototype")
@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired(required = true)
	private UserMapper userMapper;
	

	@Override
	/**
	 * {@inheritDoc}
	 */
	public int login(User user) {
		User u = userMapper.login(user.getUserName());
		Integer check = Constants.STATUS_OK;
		if (u == null) {
			check = Constants.STATUS_ERROR;
		}else if (!u.getPassword().equals(MD5Util.generatePassword(user.getPassword()))) {

			check = Constants.DATA_INCORRECT;
		}
		return check;
	}

	@Override
	public boolean judgeAccount(User user) {
		boolean flag = false;
		if(null != user){
			String userName = user.getUserName();//获取用户注册时的账号
			//根据账号查询数据库内是否存在相同的数据
			Integer returnResult = userMapper.judgeAccount(userName);
			if(returnResult == 1){
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public Integer addUser(User user) {
		Integer result = Constants.STATUS_OK;
		result = userMapper.addUser(user);
		if (result == null) {
			result = Constants.STATUS_ERROR;
		}else{
			result = Constants.STATUS_OK;
		}
		return result;
	}
}
