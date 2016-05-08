package com.zxkj.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 本次提现明细
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月16日 下午1:59:26
 */
@Data
public class ThisApplyMoneyDetailVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2661780520198304026L;
	
	/**
	 * 本次提取金额
	 */
	private Double thisDrawMoney;
	
	/**
	 * 可提余额
	 */
	private Double surplusMoney;
	
	/**
	 * 本次提现后金额
	 */
	private Double afterDrawMoney;
	
	/**
	 * 历史总收益
	 */
	private Double historyIncomeMoney;
	
	/**
	 * 历史提现金额
	 */
	private Double historyDrawMoney;
	
	/**
	 * 申请提现时间
	 */
	private String applyDate;

}
