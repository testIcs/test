package com.zxkj.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 导出审核通过信息
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月9日 上午11:31:58
 */
@Data
public class ApplyAuditPassVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6647438978190762837L;
	
	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 业务流水
	 */
	private String applyFlowNO;
	
	/**
	 * 用户id
	 */
	private Integer userID;
	
	/**
	 * 申请提现金额
	 */
	private Double applyMoney;
	
	
	/**
	 * 账户剩余金额
	 */
	private Double surplusMoney;
	
	/**
	 * 开始申请时间
	 */
	private String beginApplyDate;
	
	/**
	 * 结束申请时间
	 */
	private String endApplyDate;
	
	/**
	 * 申请状态(0-申请中 1-申请通过 2-审核未通过)
	 */
	private Integer applyStatus;
	
	/**
	 * 支付渠道类型
	 */
	private String paygateType;
	
	/**
	 * 支付渠道名称
	 */
	private String paygateName;
	
	/**
	 * 申请提现账户
	 */
	private String account;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 审核时间
	 */
	private String auditDate;
	
	/**
	 * 审核备注
	 */
	private String auditRemark;
	
	/**
	 * 审核第几步
	 */
	private int auditStep;
	
	/**
	 * 审核角色
	 */
	private String auditRole;
	
	/**
	 * 审核人
	 */
	private String auditUser;
	
	/**
	 * 审核状态
	 */
	private Integer auditStatus;
	
	/**
	 * 审核角色类型
	 */
	private Integer roleType;
}
