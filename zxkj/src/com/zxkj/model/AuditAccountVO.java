package com.zxkj.model;

import java.io.Serializable;

public class AuditAccountVO implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3097964448746794918L;
	
	/**
	 * 主键Id
	 */
	private Integer id;
	
	/**
	 * 审核人用户名
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String userPwd;
	
	/**
	 * 角色类型 (0-业务审核人 1-财务审核人)
	 */
	private Integer roleType;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 电话号码
	 */
	private String phoneNumber;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Integer getRoleType() {
		return roleType;
	}
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
