package com.zxkj.vo;

import java.io.Serializable;

import lombok.Data;
public class UserLoanVO implements Serializable
{
	private Integer id;
	
	private Integer userId;
	
	private Integer termId;
	
	private Integer typeId;
	
	private Integer ratioId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getRatioId() {
		return ratioId;
	}

	public void setRatioId(Integer ratioId) {
		this.ratioId = ratioId;
	}
	
	
	
}
