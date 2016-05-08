package com.zxkj.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.icss.lighttower.model.WithdrawCash;
import com.zxkj.common.Constants;
import com.zxkj.dao.audit.AuditApplyMoneyMapper;
import com.zxkj.model.ApplyMoneyHistoryVO;
import com.zxkj.model.ApplyMoneySearchVO;
import com.zxkj.model.ApplyMoneyVO;
import com.zxkj.model.HistoryDrawMoneyVO;
import com.zxkj.model.HistoryIncomeVO;
import com.zxkj.model.PayFlowRecordVO;
import com.zxkj.model.ThisApplyMoneyDetailVO;
import com.zxkj.model.UpdateApplyVO;
import com.zxkj.service.IApplyMoneyAuditService;

/**
 * 提现申请服务
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月6日 下午3:35:20
 */
@Scope("prototype")
@Service("applyMoneyAuditService")
public class ApplyMoneyAuditServiceImpl implements IApplyMoneyAuditService {

	private static final Logger LOG = LoggerFactory.getLogger(ApplyMoneyAuditServiceImpl.class);

	@Resource
	private AuditApplyMoneyMapper auditApplyMoneyMapper;
	
//	@Resource
//	private IPersonalProfit personalProfitManager;

	@Override
	/**
	 * 获取所有提现申请记录
	 */
	public List<ApplyMoneyVO> getApplyMoneyRecord(final ApplyMoneySearchVO applyMoneySearchVO) {
		return auditApplyMoneyMapper.getApplyMoneyRecord(putToMup(applyMoneySearchVO));
	}
	
	/**
	 * 获取提现申请的记录个数
	 */
	public int queryTotalApplyMoneyCount(ApplyMoneySearchVO applyMoneySearchVO)
	{
		return auditApplyMoneyMapper.queryTotalApplyMoneyCount(putToMup(applyMoneySearchVO));
	}
	
	/**
	 * 判断是否是重复审核提交 
	 */
	private boolean hasVerifySubmiteRepeatly(PayFlowRecordVO pfrVO){
		ApplyMoneyHistoryVO amhVO = auditApplyMoneyMapper.queryInfoByBusinessFlowNoAndUserId();
		return (null != amhVO);
	}
	
	/**
	 * 向提现申请审核轨迹表插入数据
	 * 向支付流水表中插入数据
	 * 更新提现申请审核表中的数据
	 * 如果是驳回，需要更新收入总表中的余额和冻结金额数据
	 * 由于涉及到几条sql语句的插入和更新操作，所以要加上事务
	 */
	public void updateAuditStatus(PayFlowRecordVO payFlowRecordVO)
	{
		//是重复提交,返回
		if(hasVerifySubmiteRepeatly(payFlowRecordVO)){
			return;
		}
		
		// 是否驳回
		boolean isBhBoolean = isInsertIntoPayFlowData(payFlowRecordVO);
		//更新提现申请表
		auditApplyMoneyMapper.updateAuditApplyMoney(initUpdateApplyVO(payFlowRecordVO));
		
		//向提现申请轨迹表中插入数据
		insertDataTOHistory(payFlowRecordVO);
		
		
		//如果是提现审核通过就向支付流水表中插入数据
		if (isBhBoolean)
		{
			insertDataTOPayFlow(payFlowRecordVO);
		}
		// 如果驳回审核，那么就要将冻结的金额加到余额中，冻结金额变为0
		if (!isBhBoolean)
		{
			updateExpenseInfoFail(payFlowRecordVO.getUserId() + "");
		}
		//更新众测平台表中数据
		updateTohession(payFlowRecordVO, isBhBoolean);
	}
	
	/**
	 * 当提现审核驳回时向众测系统夸进程更新tbl_withdraw_cash表中的数据
	 * @param payFlowRecordVO
	 */
	private void updateTohession(PayFlowRecordVO payFlowRecordVO, boolean isBhBoolean)
	{
		if (!isBhBoolean)
		{
			//调用接口更新tester端的账户信息
			WithdrawCash cash = new WithdrawCash();
			cash.setWithdrawUserId(payFlowRecordVO.getUserId());
			cash.setApplyState(Constants.NUM_TWO_AUDIT); //设置失败
//			personalProfitManager.updateCashApplyState(cash);
		}
	}
	
	/**
	 * 如果是审核驳回就不需要向支付流水表中插入数据了
	 * 如果是审核通过就需要向支付流水表中插入数据
	 * @param payFlowRecordVO
	 * @return
	 */
	private boolean isInsertIntoPayFlowData(PayFlowRecordVO payFlowRecordVO)
	{
		String passRemark = payFlowRecordVO.getPassRemark().trim();
		if (Constants.AUDIT_PASS.equals(passRemark))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 获取用户剩余金额
	 * @param userID
	 * @return
	 */
	private double queryUserSurplusMoney(Integer userID)
	{
		return auditApplyMoneyMapper.queryUserSurplusMoney(userID);
	}
	
	/**
	 * 获取本次提现明细
	 */
	public List<ThisApplyMoneyDetailVO> queryThisApplyMoneyDetail(String bussinessFlowNo, String userID)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("applyFlowNo", bussinessFlowNo);
		map.put("userID", userID);
		
		List<ThisApplyMoneyDetailVO> list = auditApplyMoneyMapper.queryThisApplyMoneyDetail(map);
		if (list.size() > 0)
		{
			ThisApplyMoneyDetailVO vo = list.get(0);
			double historyDrawMoney = queryHistoryDrawMoney(parseUserid(userID));
			vo.setHistoryDrawMoney(historyDrawMoney);
		}
		return list;
	}
	
	/**
	 * 获取历史提现金额
	 */
	public double queryHistoryDrawMoney(Integer userID)
	{
		 double historyDoubel = auditApplyMoneyMapper.queryHistoryDrawMoney(userID);
		 return historyDoubel;
	}
	
	/**
	 * 历史收益
	 */
	public List<HistoryIncomeVO> queryHistoryIncomeMoneyDetail(String userID)
	{
		List<HistoryIncomeVO> voList = auditApplyMoneyMapper.queryHistoryIncomeMoneyDetail(parseUserid(userID));
		getIncomeDetailTotal(voList);
		return voList;
	}
	
	/**
	 * 处理历史收益明细小计
	 */
	private void getIncomeDetailTotal(List<HistoryIncomeVO> list)
	{
		for (HistoryIncomeVO item : list)
		{
			BigDecimal testCaseDecimal = new BigDecimal(item.getTestcaseMoney());
			BigDecimal bugDecimal = new BigDecimal(item.getBugMoney());
			BigDecimal jjDecimal = new BigDecimal(item.getBonusIncome());
			BigDecimal fjDecimal = new BigDecimal(item.getFjMoney());
			BigDecimal ydjDecimal = new BigDecimal(item.getYdjMoney());
			BigDecimal zdDecimal = new BigDecimal(item.getZdMoney());
			BigDecimal redBagDecimal = new BigDecimal(item.getRedBagMoney());
			//小计
			double allItemTotal = testCaseDecimal.add(bugDecimal).add(jjDecimal).add(ydjDecimal).add(zdDecimal).add(redBagDecimal).subtract(fjDecimal).doubleValue();
			item.setTotalMoney(allItemTotal);
		}
	}
	
	/**
	 * 历史提现记录
	 */
	public List<HistoryDrawMoneyVO> queryHistoryDrawMoneyDetail(String userID)
	{
		return auditApplyMoneyMapper.queryHistoryDrawMoneyDetail(parseUserid(userID));
	}
	
	private Integer parseUserid(String userID)
	{
		Integer userId = 0;
		try
		{
			userId = Integer.parseInt(userID);
		}
		catch (NumberFormatException e)
		{
			LOG.error("转换用户ID出错。", e);
		}
		return userId;
	}
	
	/**
	 * 向支付流水表中插入数据
	 * @param payFlowRecordVO
	 */
	private void insertDataTOPayFlow(PayFlowRecordVO payFlowRecordVO)
	{
		double surplusMoney = queryUserSurplusMoney(payFlowRecordVO.getUserId());
		payFlowRecordVO.setBeforePayMoney(surplusMoney);
		List<PayFlowRecordVO>  payList = new ArrayList<PayFlowRecordVO>();
		payList.add(payFlowRecordVO);
		auditApplyMoneyMapper.insertDataTOPay(payList);
	}
	/**
	 * 向提现申请轨迹表中插入审核数据
	 * @param bussinessFlowNos
	 * @return
	 */
	private void insertDataTOHistory(PayFlowRecordVO payFlowRecordVO)
	{
		List<ApplyMoneyHistoryVO>  historyVoList = generateHistoryList(payFlowRecordVO);
		auditApplyMoneyMapper.insertDataTOHistory(historyVoList);
	}
	
	/**
	 * 生成vo对象集合
	 * @param bussinessFlowNos
	 * @return
	 */
	private List<ApplyMoneyHistoryVO> generateHistoryList(PayFlowRecordVO payFlowRecordVO)
	{
		List<ApplyMoneyHistoryVO> list = new ArrayList<ApplyMoneyHistoryVO>();
		
		/**
		 * 打包历史提现记录VO
		 */
		ApplyMoneyHistoryVO applyMoneyHistoryVO = new ApplyMoneyHistoryVO();
		
		//业务流水号
		String bussinessFlowNo = payFlowRecordVO.getBusinessFlowNo();
		//审核日期
		String auditDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				
		//通过状态
		String auditState = payFlowRecordVO.getPassRemark();
		//审核状态
		int auditNum = getHistoryState(auditState);
		//审核备注
		String auditRemark = getAuditRemark(auditState);
		
		//重置业务流水号
		applyMoneyHistoryVO.setApplyFlowNo(bussinessFlowNo);
		//重置审核日期
		applyMoneyHistoryVO.setAuditDate(auditDate);
		//重置审核备注
		applyMoneyHistoryVO.setAuditRemark(auditRemark);
		//重置审核状态
		applyMoneyHistoryVO.setAuditStatus(auditNum);
		//重置审核步骤
		applyMoneyHistoryVO.setAuditStep(1);
		//重置审核人
		applyMoneyHistoryVO.setAuditUser(payFlowRecordVO.getAuditUser());
		//重置角色类型
		applyMoneyHistoryVO.setRoleType(2);
		
		list.add(applyMoneyHistoryVO);
		
		return list;
	}
	
	/**
	 * 根据界面传递参数返回插入数据库中的审核信息
	 * @param auditState
	 * @return
	 */
	private String getAuditRemark(String auditState)
	{
		String auditRemark="";
		if (Constants.AUDIT_PASS.equals(auditState))
		{
			auditRemark = "审核通过";
		}
		else if (Constants.AUDIT_NOPASS.equals(auditState))
		{
			auditRemark = "审核驳回";
		}
		return auditRemark;
	}
	
	private int getHistoryState(String auditState)
	{
		int auditStatus = 0;
		if (Constants.AUDIT_PASS.equals(auditState))
		{
			auditStatus = Constants.NUM_THREE_PASS;
		}
		else if (Constants.AUDIT_NOPASS.equals(auditState))
		{
			auditStatus = Constants.NUM_FOUR_PASS;
		}
		return auditStatus;
	}
	
	/**
	 * 初始化更新vo对象
	 * @param payFlowRecordVO
	 * @return
	 */
	private UpdateApplyVO initUpdateApplyVO(PayFlowRecordVO payFlowRecordVO)
	{
		int applyState = 0;
		String auditState = payFlowRecordVO.getPassRemark().trim();
		if (Constants.AUDIT_PASS.equals(auditState))
		{
			applyState = Constants.PAY_TYPE_ONE;;
		}
		else if (Constants.AUDIT_NOPASS.equals(auditState))
		{
			applyState = Constants.PAY_TYPE_TWO;
		}
		UpdateApplyVO updateApplyVO = new UpdateApplyVO();
		String auditDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		updateApplyVO.setApplyStatus(applyState);
		updateApplyVO.setAuditDate(auditDate);
		updateApplyVO.setBusinessFlowNo(payFlowRecordVO.getBusinessFlowNo());
		return updateApplyVO;
	}
	
	/**
	 * 初始化查询参数
	 * @param searchVO
	 * @return
	 */
	private Map<String, Object> putToMup(final ApplyMoneySearchVO searchVO)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != searchVO.getJqPage())
		{
			Integer pageSize = searchVO.getJqPage().getRows();
			Integer startRow = (searchVO.getJqPage().getPage().intValue() - 1) * pageSize;
			map.put("start", startRow);
			map.put("rows", pageSize);
		}
		map.put("applyUser", searchVO.getApplyUser());
		map.put("applyStartDate", searchVO.getApplyStartDate());
		map.put("applyEndDate", searchVO.getApplyEndDate());
		return map;
	}
	
	/**
	 * 审核驳回后需要将冻结的金额还原到余额中取
	 */
	public void updateExpenseInfoFail(String userID)
	{
		auditApplyMoneyMapper.updateExpenseInfoFail(userID);
	}
}
