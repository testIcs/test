/**
 * 
 */
package com.zxkj.service;

import java.util.List;
import java.util.Map;

/**
 * 字典信息操作SERVICE
 */
public interface IDic 
{
	
	/**
	 * 查询金融产品字典信息
	 * @return 金融产品字典信息集合
	 */
	public List<Map<Integer, String>> findFinancialProducts();
	
	/**
	 * 查询贷款利率字典信息
	 * @return 贷款利率字典信息集合
	 */
	public List<Map<Integer, String>> findLendingRate();
	
	/**
	 * 查询贷款期限字典信息 
	 * @return 贷款期限字典信息集合
	 */
	public List<Map<Integer, String>> findLoanTerm();
	
	
}
