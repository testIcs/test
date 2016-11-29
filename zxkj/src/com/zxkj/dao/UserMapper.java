package com.zxkj.dao;

import com.zxkj.model.User;

public interface UserMapper 
{
	/**
	 * 用户登录
	 * @param user 登陆的用户信息
	 * @return 返回登陆状态
	 */
	public User findUserByUser(User user);
	
	/**
	 * 保存用户身份证信息
	 * @param user
	 */
	void saveIdCardInfo(User user);
}
