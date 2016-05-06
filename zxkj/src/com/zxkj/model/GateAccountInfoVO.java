package com.zxkj.model;

import java.io.Serializable;

public class GateAccountInfoVO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1876663471236243826L;
	
	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 支付渠道名称
	 */
	private String payGateType;
	
	/**
	 * 账户名称
	 */
	private String accountName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayGateType() {
		return payGateType;
	}

	public void setPayGateType(String payGateType) {
		this.payGateType = payGateType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	
	
}
