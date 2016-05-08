package com.zxkj.dao;

import org.springframework.stereotype.Repository;

import com.icss.lighttowerpay.model.ExpenseInfoVO;

@Repository
public interface ExpenseInfoMapper {

	/**
	 * 添加个人收支总表
	 * 
	 * @param expenseInfo
	 */
	public Integer addExpenseInfo(ExpenseInfoVO expenseInfo);

	/**
	 * 更新个人收支信息
	 * 
	 * @param expenseInfo
	 */
	public Integer updateExpenseInfo(ExpenseInfoVO expenseInfo);

	/**
	 * 按用户查找个人收支
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 */
	public int selectExpenseInfoCount(Integer userId);

	/**
	 * 按用户ID查找个人收支信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 */
	public ExpenseInfoVO selectExpenseInfoByUserId(Integer userId);

}
