package com.zxkj.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class User implements Serializable 
{
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 5266346724797437246L;
	
	private Integer id;
	/**
	 * 用户id
	 */
	private String userId = "";
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
	private String phoneNo = "";
	/**
	 * 身份证号码
	 */
	private String idNumber = "";
	/**
	 * 角色ID
	 */
	private String descrip = "";
	
	/**
	 * 
	 */
	private Date appDate;
	/**
	 * 用户状态
	 */
	private String userState = "";
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
}
