/**
 * 
 */
package com.zxkj.service;

import com.zxkj.model.User;

/**
 * 用户操作SERVICE
 */
public interface UserService 
{
	/**
	 * 用户登录
	 * @param user 登陆的用户信息
	 * @return 返回登陆状态  0 成功，1用户名或密码错误，-1其它错误
	 */
	public int login(User user);
	
	/**
	 * 判断账号是否存在
	 * @param user
	 * @return
	 */
	public boolean judgeAccount(User user);
	
	/**
	 * 用户注册
	 * @param user
	 */
	public Integer addUser(User user);
}
