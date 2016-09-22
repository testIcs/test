package com.zxkj.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable 
{

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 5266346724797437246L;
	
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 用户登录名
	 */
	private String userName="";
	/**
	 * 用户密码
	 */
	private String password = "";
	/**
	 * 电话号码
	 */
	private String phone = "";
	/**
	 * email
	 */
	private String email = "";
	/**
	 * 角色ID
	 */
	private String roleType = "";
	/**
	 * 用户状态
	 */
	private String userState = "";
	/**
	 * 用户授权码
	 */
	private String openId;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 身份证号
	 */
	private String idCard;
	
	/**
	 * 住址 
	 */
	private String address;
	
}
