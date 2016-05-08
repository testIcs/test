package com.zxkj.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExpenseInfoVO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3674488712579020059L;
	
	/**
	 * 主键ID
	 */
	private Integer id;
	
	/**
	 * 用户id(外键)
	 */
	private Integer userId;
	
	/**
	 * 提现密码
	 */
	private String drawMoneyPassword;
	
	/**
	 * 总收入金额
	 */
	private Double totalMoney;
	
	/**
	 * 剩余金额
	 */
	private Double surplusMoney;
	
	/**
	 * 冻结金额
	 */
	private Double freezeMoney;
	
	/**
	 * 累计已提现金额
	 */
	private Double alreadyApplyMoney;

	
}
