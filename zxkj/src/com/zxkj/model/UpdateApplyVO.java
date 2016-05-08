package com.zxkj.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 更新提现申请表
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月14日 上午10:29:30
 */
@Getter
@Setter
public class UpdateApplyVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4843928596728242770L;
	
	/**
	 * 申请状态
	 */
	private int applyStatus;
	
	/**
	 * 审核时间
	 */
	private String auditDate;
	
	/**
	 * 业务流水集合
	 */
	private List<String> businessFlowNos;
	
	/**
	 * 业务流水
	 */
	private String businessFlowNo;
}
