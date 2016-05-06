package com.zxkj.dao.audit;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zxkj.model.ApplyAuditPassVO;
import com.zxkj.model.ApplyMoneyHistoryVO;
import com.zxkj.model.ApplyMoneyVO;
import com.zxkj.model.HistoryDrawMoneyVO;
import com.zxkj.model.HistoryIncomeVO;
import com.zxkj.model.PayFlowRecordVO;
import com.zxkj.model.ThisApplyMoneyDetailVO;
import com.zxkj.model.UpdateApplyVO;


/**
 * 审核mapper
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月9日 下午4:28:33
 */
public interface AuditApplyMoneyMapper {

	/**
	 * 查询所有审核通过的记录
	 * @param pageInfo 页面参数
	 * @return 集合
	 */
	public List<ApplyAuditPassVO> queryAuditPassData(final Map<String, Object> map);
	
	/**
	 * 根据条件查询
	 * @param pageInfo 页面参数
	 * @return 集合
	 */
	public List<ApplyAuditPassVO> queryAuditPassDataByCondition(final Map<String, Object> map);
	
	/**
	 * 查询所有提现申请记录个数
	 * @return 个数
	 */
	public int queryTotalApplyMoneyCount(final Map<String, Object> map);
	
	/**
	 * 查询所有提现申请记录
	 * @param jqPage 页面参数
	 * @return 集合
	 */
	public List<ApplyMoneyVO> getApplyMoneyRecord(final Map<String, Object> map);
	
	/**
	 * 获取本次提现明细数据
	 * @param map
	 * @return
	 */
	public List<ThisApplyMoneyDetailVO> queryThisApplyMoneyDetail(final Map<String, Object> map);
	
	/**
	 * 获取历史提现总额
	 * @param userID
	 * @return
	 */
	public double queryHistoryDrawMoney(@Param(value = "userID") Integer userID);
	
	/**
	 * 获取历史提现明细
	 * @param userID
	 * @return
	 */
	public List<HistoryDrawMoneyVO> queryHistoryDrawMoneyDetail(@Param(value = "userID") Integer userID);
	
	/**
	 * 获取历史收益明细
	 * @param userID
	 * @return
	 */
	public List<HistoryIncomeVO> queryHistoryIncomeMoneyDetail(@Param(value = "userID") Integer userID);
	
	/**
	 * 查询审核通过的记录条数
	 * @return 条数
	 */
	public int queryTotalAuditPassCount();
	
	/**
	 * 查询审核通过的记录条数
	 * @return 条数
	 */
	public int queryTotalAuditPassCountByContidion(final Map<String, Object> map);
	
	/**
	 * 将提现申请的申请状态更新为申请通过
	 * @param updateApplyVO 
	 * @return 更新是否成功
	 */
	public void updateAuditApplyMoney(UpdateApplyVO updateApplyVO);
	
	/**
	 * 审核驳回后需要将冻结的金额还原到余额中去
	 * @param userID
	 */
	public void updateExpenseInfoFail(@Param(value = "userID") String userID);
	
	/**
	 * 向提现申请轨迹表中插入审核轨迹数据
	 * @param list
	 * @return
	 */
	public void insertDataTOHistory(@Param(value = "list") List<ApplyMoneyHistoryVO> historyVoList);
	
	/**
	 * 查询用户剩余金额
	 * @param userID
	 * @return
	 */
	public double queryUserSurplusMoney(@Param(value = "userID") Integer userID);
	
	/**
	 * 向支付流水表中插入支付中的一条数据
	 * @param list
	 * @return
	 */
	public void insertDataTOPay(@Param(value = "list") List<PayFlowRecordVO> historyVoList);
	
	/**
	 * 判断库中是否存在某条指定业务流水号的信息 
	 */
	public ApplyMoneyHistoryVO queryInfoByBusinessFlowNoAndUserId();
	
}
