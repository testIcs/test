package com.zxkj.service.impl;

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
import com.zxkj.util.DBUtil;
import com.zxkj.util.MD5Util;


@Scope("prototype")
@Service("userService")
/**
 * {@inheritDoc}
 * @author mengqingfeng
 */
public class UserServiceImpl implements UserService {
	private static final Logger LOG = LoggerFactory.getLogger(DBUtil.class);
	@Autowired(required = true)
	private UserMapper userMapper;

	@Override
	/**
	 * {@inheritDoc}
	 */
	public int login(User user) {
		LOG.info(">>>>>>>>>>>>login");
		List<User> list = userMapper.login(user);
		if(list.size()==1){
			User tempUser = list.get(0);
			boolean flag = MD5Util.validatePassword(tempUser.getPassword(),user.getPassword());
			if (flag) {
				user = tempUser;
				return Constants.STATUS_OK;
			} else {
				return Constants.DATA_INCORRECT;
			}			
		}else{
			return Constants.DATA_INCORRECT;
		}		
	}

}
