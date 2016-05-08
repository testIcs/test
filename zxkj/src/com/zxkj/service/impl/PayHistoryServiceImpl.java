package com.zxkj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxkj.dao.PayHistoryMapper;
import com.zxkj.model.ApplyMoneyVO;
import com.zxkj.model.JqPage;
import com.zxkj.model.PayFlowRecordVO;
import com.zxkj.service.PayHistoryService;


@Scope("prototype")
@Service("payHistoryService")
@Transactional
public class PayHistoryServiceImpl implements PayHistoryService  {
	
	@Resource
	private PayHistoryMapper payHistoryMapper;


	@Override
	public List<ApplyMoneyVO> queryApplyMoneyHistory(
			Map<String, Object> paramMap,JqPage pageInfo) {		
		paramMap.put("start", (pageInfo.getPage()-1)*pageInfo.getRows());
		paramMap.put("rows", pageInfo.getRows());
		List<ApplyMoneyVO> dataList = payHistoryMapper.queryApplyMoneyHistory(paramMap);
		for (ApplyMoneyVO applyMoneyVO : dataList) {
			List list = payHistoryMapper.queryApplyMoneyHistoryAuditInfo(applyMoneyVO.getApplyFlowNo());
			if(list.size()>0){
				Map m = (Map) list.get(0);
				String audit_date = m.get("audit_date")==null?"":m.get("audit_date").toString();
				applyMoneyVO.setAuditDate(audit_date);
				String audit_user = m.get("audit_user")==null?"":m.get("audit_user").toString();
				applyMoneyVO.setAuditUser(audit_user);			
			}
		}
		return dataList;		 
	}

	@Override
	public int queryApplyMoneyHistoryCnt(Map<String, Object> paramMap) {		
		return payHistoryMapper.queryApplyMoneyHistoryCnt(paramMap);
	}

	@Override
	public int queryPayFlowRecordCnt(Map<String, Object> paramMap) {
		return payHistoryMapper.queryPayFlowRecordCnt(paramMap);
	}

	@Override
	public List<PayFlowRecordVO> queryPayFlowRecord(
			Map<String, Object> paramMap, JqPage pageInfo) {
		paramMap.put("start", (pageInfo.getPage()-1)*pageInfo.getRows());
		paramMap.put("rows", pageInfo.getRows());
		return payHistoryMapper.queryPayFlowRecord(paramMap);
	}

	@Override
	public boolean updatePayFlowRecordSuccess(Map<String, String> paramMap){		
		
		//更新支付记录表信息_成功支付
		payHistoryMapper.updatePayFlowRecordSuccess(paramMap);	
		//更新账户表信息 _支付成功
		payHistoryMapper.updateExpenseInfoSuccess(paramMap.get("userId"));		
		
		return true;			
	}

	@Override
	public boolean updatePayFlowRecordFail(Map<String, String> paramMap) {
		payHistoryMapper.updatePayFlowRecordFail(paramMap);
		return true;
	}
	

	@Override
	public boolean updatePayFlowRecordFailClose(Map<String, String> paramMap) {
		payHistoryMapper.updatePayFlowRecordFailClose(paramMap);
		payHistoryMapper.updateExpenseInfoFail(paramMap.get("userId"));
		return true;
	}
	

	@Override
	public int updatePayFlowRecordExportFlag(Map<String, Object> paramMap) {
		return payHistoryMapper.updatePayFlowRecordExportFlag(paramMap);
	}

}
