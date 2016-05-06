package com.zxkj.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class ApplyMoneyVO implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4005259199698271084L;

	/**
	 * 业务流水
	 */
	public String applyFlowNo;
	
	/**
	 * 提现用户ID
	 */
	public Integer userId;
	
	/**
	 * 提现金额
	 */
	public Double applyMoney;
	
	/**
	 * 余额
	 */
	private Double surplusMoney;
	
	/**
	 * 申请开始日期
	 */
	public String beginApplyDate;
	
	/**
	 * 申请结束日期
	 */
	public String endApplyDate;
	
	/**
	 * 提现申请状态(0,申请中。1,申请通过，2申请未通过)
	 */
	public Integer applyStatus;
	
	/**
	 * 真是姓名
	 */
	public String realName;
	
	/**
	 * 提现申请账号
	 */
	public String account;
	
	/**
	 * 提现申请渠道类型
	 */
	public String paygateType;
	
	/**
	 * 渠道名称
	 */
	private String paygateName;
	
	private String auditDate;//审核日期
	private String auditUser;//审核人
	
	
	
}
