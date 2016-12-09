package com.zxkj.vo;

import java.util.Date;

import lombok.Data;

public class UserFingerPrintVO 
{
	private Integer userId;
	
	private Integer fingerPrintId;
	
	private Date addTime;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFingerPrintId() {
		return fingerPrintId;
	}

	public void setFingerPrintId(Integer fingerPrintId) {
		this.fingerPrintId = fingerPrintId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	
}
