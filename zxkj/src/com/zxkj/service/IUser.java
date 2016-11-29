/**
 * 
 */
package com.zxkj.service;

import com.zxkj.model.User;

/**
 * 用户操作SERVICE
 */
public interface IUser
{
	/**
	 * 用户登录
	 * @param user 登陆的用户信息
	 * @return 返回登陆状态  0 成功，1用户名或密码错误，-1其它错误
	 */
	int login(User user);
	
	/**
	 * 保存用户身份证信息
	 * @param user
	 */
	Integer saveIdCardInfo(User user);
	
	
	User findUserByUser(User user);
	
}
