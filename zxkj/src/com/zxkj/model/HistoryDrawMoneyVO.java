package com.zxkj.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 历史提现记录
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月16日 下午6:23:00
 */
@Data
public class HistoryDrawMoneyVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6349785254670426253L;
	
	//提现金额
	private double drawMoney;
	
	//提现后余额
	private double afterDrawMoney;
	
	//提现前余额
	private double beforeDrawMoney;
	
	//提现申请时间
	private String applyDate;
	
	//付款时间
	private String payDate;
	
	// 支付状态
	private String payState;
}
