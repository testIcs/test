/**
 * Administrator zhengjiaoguo  love yangqianqian
 * 2015年7月6日 下午3:31:37
 */
package com.zxkj.service;

import java.util.List;

import com.zxkj.model.ApplyMoneySearchVO;
import com.zxkj.model.ApplyMoneyVO;
import com.zxkj.model.HistoryDrawMoneyVO;
import com.zxkj.model.HistoryIncomeVO;
import com.zxkj.model.PayFlowRecordVO;
import com.zxkj.model.ThisApplyMoneyDetailVO;
/**
 * 提现申请服务接口
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月6日 下午4:54:38
 */
public interface IApplyMoneyAuditService {

	public List<ApplyMoneyVO> getApplyMoneyRecord(final ApplyMoneySearchVO applyMoneySearchVO);
	
	public int queryTotalApplyMoneyCount(ApplyMoneySearchVO applyMoneySearchVO);
	
	public void updateAuditStatus(PayFlowRecordVO payFlowRecordVO);
	
	public List<ThisApplyMoneyDetailVO> queryThisApplyMoneyDetail(String bussinessFlowNo, String userID);
	
	public double queryHistoryDrawMoney(Integer userID);
	
	public List<HistoryDrawMoneyVO> queryHistoryDrawMoneyDetail(String userID);
	
	public List<HistoryIncomeVO> queryHistoryIncomeMoneyDetail(String userID);
	
	public void updateExpenseInfoFail(String userID);
}
