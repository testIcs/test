package com.zxkj.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;


public class User implements Serializable 
{

	/**
	 * 搴忓垪鍖栫増鏈彿
	 */
	private static final long serialVersionUID = 5266346724797437246L;
	
	/**
	 * 鐢ㄦ埛id
	 */
	private Integer userId;
	/**
	 * 鐢ㄦ埛鐧诲綍鍚�
	 */
	private String userName="";
	/**
	 * 鐢ㄦ埛瀵嗙爜
	 */
	private String password = "";
	/**
	 * 鐢佃瘽鍙风爜
	 */
	private String phone = "";
	/**
	 * email
	 */
	private String email = "";
	/**
	 * 瑙掕壊ID
	 */
	private String roleType = "";
	/**
	 * 鐢ㄦ埛鐘舵��
	 */
	private String userState = "";
	/**
	 * 鐢ㄦ埛鎺堟潈鐮�
	 */
	private String openId;
	
	/**
	 * 鐪熷疄濮撳悕
	 */
	private String realName;
	
	/**
	 * 韬唤璇佸彿
	 */
	private String idCard;
	
	/**
	 * 浣忓潃 
	 */
	private String address;
	
	/**
	 * 娣诲姞浜嬩欢 
	 */
	private Date addTime;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	
	
}
