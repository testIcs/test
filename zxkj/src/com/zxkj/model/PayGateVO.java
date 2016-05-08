package com.zxkj.model;

import java.io.Serializable;

public class PayGateVO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1454083548643168001L;
	
	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 支付渠道类型
	 */
	private String payGateType;
	
	/**
	 * 支付渠道名称
	 */
	private String payGateName;

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

	public String getPayGateName() {
		return payGateName;
	}

	public void setPayGateName(String payGateName) {
		this.payGateName = payGateName;
	}
	
	
	
}
