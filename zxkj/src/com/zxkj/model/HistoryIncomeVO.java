package com.zxkj.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 历史收入
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月16日 下午6:23:00
 */
@Data
public class HistoryIncomeVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6349785254670426253L;
	
	//编号
	private int codeID;
	
	//财务数据生成时间
	private String generateDate;
	
	//名称
	private String prjName;
	
	//状态
	private String stateName;
	
	//奖金收益
	private double bonusIncome;
	
	//总计
	private double totalMoney;
	
	//用例收益
	private double testcaseMoney;
	
	//缺陷收益
	private double bugMoney;
	
	private double zdMoney;
	
	private double ydjMoney;
	
	private double redBagMoney;
	
	private double fjMoney;
}
