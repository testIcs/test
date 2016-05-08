package com.zxkj.dao;

import org.springframework.stereotype.Repository;

import com.icss.lighttowerpay.model.ApplyMoneyVO;

@Repository
public interface ApplyMoneyMapper {
	
	/**
	 * 添加提现申请记录
	 * @param applyMoney
	 */
	public Integer addApplyMoney(ApplyMoneyVO applyMoney);
	
	/**
	 * 查询申请中的提现记录
	 * @param applyMoney
	 * @return
	 */
	public Integer selectApplyStatusNo(ApplyMoneyVO applyMoney);
	
	/**
	 * 查询是否存在正在支付的提现记录
	 * @param applyMoney
	 * @return
	 */
	public Integer selectPayFlowStatus(ApplyMoneyVO applyMoney);

}
