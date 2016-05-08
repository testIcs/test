package com.zxkj.model;

import java.io.Serializable;

public class PayFlowRecordVO extends ApplyMoneyVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1594353708808754081L;
	
	/**
	 * 主键id 
	 */
	private String id; 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getBusinessFlowNo() {
		return businessFlowNo;
	}

	public void setBusinessFlowNo(String businessFlowNo) {
		this.businessFlowNo = businessFlowNo;
	}

	public String getThirdOrderNo() {
		return thirdOrderNo;
	}

	public void setThirdOrderNo(String thirdOrderNo) {
		this.thirdOrderNo = thirdOrderNo;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayRemark() {
		return payRemark;
	}

	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}

	public Double getBeforePayMoney() {
		return beforePayMoney;
	}

	public void setBeforePayMoney(Double beforePayMoney) {
		this.beforePayMoney = beforePayMoney;
	}

	public Double getAfterPayMoney() {
		return afterPayMoney;
	}

	public void setAfterPayMoney(Double afterPayMoney) {
		this.afterPayMoney = afterPayMoney;
	}

	public String getPassRemark() {
		return passRemark;
	}

	public void setPassRemark(String passRemark) {
		this.passRemark = passRemark;
	}
	

		
	public Integer getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(Integer exportFlag) {
		this.exportFlag = exportFlag;
	}



	/**
	 * 业务流水号
	 */
	private String businessFlowNo;
	
	/**
	 * 支付渠道支付流水号
	 */
	private String thirdOrderNo;
	
	/**
	 * 支付状态(0-支付中 1-支付成功 2-支付失败)
	 */
	private Integer payStatus;	
	
	/**
	 * 支付账号
	 */
	private String payAccount;
	
	/**
	 * 支付时间
	 */
	private String payTime;
	
	/**
	 * 支付金额
	 */
	private Double payMoney;
	
	/**
	 * 备注
	 */
	private String payRemark;
	
	/**
	 * 支付前余额
	 */
	private Double beforePayMoney;
	
	/**
	 * 支付后余额
	 */
	private Double afterPayMoney;
	
	/**
	 * PASS/NO_PASS
	 */
	private String passRemark;
	
	/**
	 * 导出状态 0-未导出 1-已导出
	 */
	private Integer exportFlag;
	
	
}
