package com.zxkj.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ApplyMoneyHistoryVO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5885200080655604205L;
	
	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 提现流水号(批量审批的时候，提现流水号是多个)
	 */
	private String applyFlowNo;
	
	/**
	 * 审核日期
	 */
	private String auditDate;
	
	/**
	 * 审核状态(1-审核发起 2-正在审核 3-审核通过 4-审核驳回)
	 */
	private Integer auditStatus;
	
	/**
	 * 审核备注
	 */
	private String auditRemark;
	
	/**
	 * 审核人
	 */
	private String auditUser;
	
	/**
	 * 角色类型
	 */
	private Integer roleType;
	
	/**
	 * 审核步骤
	 */
	private Integer auditStep;
}
