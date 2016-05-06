package com.zxkj.util;

import lombok.Data;

/**
 * 映射SQL语句
 * 
 * @author mengqingfeng
 * @version 1.0
 */
@Data
public class SQLUtil {

	/**
	 * 登陆
	 */
	private String sqlLogin = "";
	
	/**
	 * 提现申请
	 */
	private String sqlApplyMoney;
	
	/**
	 * 提现申请记录条数
	 */
	private String sqlApplyMoneyCount;
	
	/**
	 * 更新审核状态为审核通过
	 */
	private String sqlUpdateAuditStatus;
	
	/**
	 * 审核通过记录个数
	 */
	private String sqlAuditPassCount;
	
	/**
	 * 查询审核通过记录
	 */
	private String sqlExportAuditPass;
}
