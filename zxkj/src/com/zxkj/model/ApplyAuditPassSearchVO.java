package com.zxkj.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 搜索条件VO
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月13日 下午3:20:41
 */
@Data
public class ApplyAuditPassSearchVO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1958402459275966470L;

	private String applyAccount;
	
	private String applyDate;
	
	private String auditRemark;
	
	private JqPage jqPage;
	
	private Integer auditStatus;
}
