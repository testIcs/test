package com.zxkj.service;

import java.util.List;
import java.util.Map;

import com.zxkj.model.ApplyMoneyVO;
import com.zxkj.model.JqPage;
import com.zxkj.model.PayFlowRecordVO;


/**
 * 
 * @author chenchanghe
 * @date 2015年7月10日14:01:19
 *
 */
public interface PayHistoryService {
	
	/**
	 * 查询历史申请提现记录(已审核通过)总条数
	 * @param paramMap
	 * @return
	 */
	public int queryApplyMoneyHistoryCnt(Map<String, Object> paramMap);

	/**
	 * 查询历史申请提现记录(已审核通过)数据集合
	 * @param paramMap
	 * @return
	 */
	public List<ApplyMoneyVO> queryApplyMoneyHistory(Map<String, Object> paramMap,JqPage pageInfo);

	/**
	 * 查询付款记录总条数
	 * @param paramMap
	 * @return
	 */
	public int queryPayFlowRecordCnt(Map<String, Object> paramMap);

	/**
	 * 查询付款记录数据集合
	 * @param paramMap
	 * @return
	 */
	public List<PayFlowRecordVO> queryPayFlowRecord(Map<String, Object> paramMap, JqPage pageInfo);	

	/**
	 * 更新付款记录状态_支付成功
	 * @param paramMap
	 * @return
	 */
	public boolean updatePayFlowRecordSuccess(Map<String, String> paramMap);

	/**
	 * 更新付款记录状态_支付失败
	 * @param paramMap
	 * @return
	 */
	public boolean updatePayFlowRecordFail(Map<String, String> paramMap);
	

	/**
	 * 更新付款记录状态_支付失败关闭
	 * @param paramMap
	 */
	public boolean updatePayFlowRecordFailClose(Map<String, String> paramMap);


	/**
	 * 更新付款记录的导出状态
	 * @param paramMap
	 */
	public int updatePayFlowRecordExportFlag(Map<String, Object> paramMap);

}
