package com.zxkj.common;

/**
 * 错误码常量
 * @author
 */
public class Constants {
	/**
	 * 未授权
	 */
	public static final int UNGRANT = -2000;
	/**
	 * 服务器异常
	 */
	public static final int SERVER_ERROR = -1000;
	/**
	 * 状态OK
	 */
	public static final int STATUS_OK = 0;
	/**
	 * 状态错误
	 */
	public static final int STATUS_ERROR = 1000;
	/**
	 * 数据不正确
	 */
	public static final int DATA_INCORRECT = 2000;
	/**
	 * 数据已存在
	 */
	public static final int DATA_ALREADY_EXIST = 3000;
	/**
	 * 数据未找到
	 */
	public static final int DATA_NOT_FOUND = 4000;
	/**
	 * 数据不完整
	 */
	public static final int DATA_NOT_COMPLETE = 5000;
	/**
	 * 验证码不正确
	 */
	public static final int VALIDATE_NOT_COMPLETE = 6000;
	/**
	 * 数据已过期
	 */
	public static final int VALIDATE_EXPIRES = 7000;
	
}