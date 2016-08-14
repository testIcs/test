package com.zxkj.dao;

import com.zxkj.model.User;


public interface UserMapper {
	/**
	 * 用户登录
	 * @param user 登陆的用户信息
	 * @return 返回登陆状态
	 */
	public User login(String userName);
	
	/**
	 * 判断账号是否存在
	 * @param userName
	 * @return
	 */
	public Integer judgeAccount(String userName);
	
	/**
	 * 用户注册
	 * @param user
	 */
	public Integer addUser(User user);
}
