/**
 * 
 */
package com.zxkj.service;

import com.zxkj.model.User;

/**
 * @author mengqingfeng
 * 用户操作SERVICE
 */
public interface UserService {
	/**
	 * 用户登录
	 * @param user 登陆的用户信息
	 * @return 返回登陆状态  0 成功，1用户名或密码错误，-1其它错误
	 */
	public int login(User user);
	
	
}
