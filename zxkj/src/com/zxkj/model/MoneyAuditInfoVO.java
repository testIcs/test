package com.zxkj.model;

import java.io.Serializable;

public class MoneyAuditInfoVO implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2363770669464961312L;

	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 审核备注
	 */
	private String auditRemark;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuditRemark() {
		return auditRemark;
	}
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	
}
