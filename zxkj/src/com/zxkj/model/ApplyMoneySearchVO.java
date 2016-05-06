package com.zxkj.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 搜索条件VO
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月13日 下午3:20:41
 */
@Data
public class ApplyMoneySearchVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1958402459275966470L;

	private String applyUser;
	
	private String applyStartDate;
	
	private String applyEndDate;
	
	private Double applyMoney;
	
	private JqPage jqPage;
}
