package com.zxkj.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.common.Constants;
import com.zxkj.dao.UserMapper;
import com.zxkj.model.User;
import com.zxkj.service.UserService;


@Scope("prototype")
@Service("userService")
/**
 * {@inheritDoc}
 * @author
 */
public class UserServiceImpl implements UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired(required = true)
	private UserMapper userMapper;

	@Override
	/**
	 * {@inheritDoc}
	 */
	public int login(User user) {
		LOG.info(">>>>>>>>>>>>loginService");
		User users = new User();
		
		users = userMapper.login(user);
		System.err.println(users);
		if(user.getUserName().equals("zxkj") && user.getPassword().equals("zxkj")){
			return Constants.STATUS_OK;
		}else{
			return Constants.DATA_INCORRECT;
		}	
	}

}
