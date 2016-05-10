package com.zxkj.dao;

import java.util.List;

import com.zxkj.model.User;


public interface UserMapper {
	/**
	 * 用户登录
	 * @param user 登陆的用户信息
	 * @return 返回登陆状态
	 */
	public User login(User user);
}
