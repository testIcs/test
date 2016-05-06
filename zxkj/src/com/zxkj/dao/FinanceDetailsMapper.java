package com.zxkj.dao;

import org.springframework.stereotype.Repository;

import com.icss.lighttowerpay.model.FinanceDetailVO;

@Repository
public interface FinanceDetailsMapper {

	/**
	 * 查询用户是否有财务明细
	 * 
	 * @param userName
	 *            用户名称
	 * @return
	 */
	public int findFinanceDetailsCount(FinanceDetailVO financeDetailVO);

	/**
	 * 财务明细
	 * 
	 * @param financeDetailVO
	 */
	public Integer addFinanceDetails(FinanceDetailVO financeDetailVO);

	/**
	 * 更新用户的活动财务明细
	 * 
	 * @param userName
	 *            用户名称
	 * @param reMoney
	 * 			  变动金额
	 */
	public Integer updateFinanceDetails(FinanceDetailVO financeDetailVO);
}
