package com.zxkj.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zxkj.model.ApplyMoneyVO;
import com.zxkj.model.PayFlowRecordVO;


@Repository
public interface PayHistoryMapper {
	public int queryApplyMoneyHistoryCnt(Map<String, Object> paramMap);

	public List<ApplyMoneyVO> queryApplyMoneyHistory(Map<String, Object> paramMap);

	public int queryPayFlowRecordCnt(Map<String, Object> paramMap);

	public List<PayFlowRecordVO> queryPayFlowRecord(Map<String, Object> paramMap);

	public List queryApplyMoneyHistoryAuditInfo(String applyFlowNO);

	public int updatePayFlowRecordSuccess(Map<String, String> paramMap);

	public int updatePayFlowRecordFail(Map<String, String> paramMap);

	public int updateExpenseInfoSuccess(String userId);

	public int updatePayFlowRecordFailClose(Map<String, String> paramMap);

	public int updateExpenseInfoFail(String userId);

	public int updatePayFlowRecordExportFlag(Map<String, Object> paramMap);
}
