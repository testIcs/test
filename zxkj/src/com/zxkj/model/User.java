package com.zxkj.model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 5266346724797437246L;
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
	
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
}
