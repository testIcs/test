package com.zxkj.service.impl;


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
		LOG.info(">>>>>>>>>>>>login");
		if(user.getUserName().equals("zxkj") && user.getPassword().equals("zxkj")){
			return Constants.STATUS_OK;
		}else{
			return Constants.DATA_INCORRECT;
		}	
	}

}
