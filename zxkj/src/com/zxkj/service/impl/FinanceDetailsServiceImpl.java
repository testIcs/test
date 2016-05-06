package com.zxkj.service.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxkj.dao.ExpenseInfoMapper;
import com.zxkj.dao.FinanceDetailsMapper;
import com.zxkj.model.ExpenseInfoVO;
import com.zxkj.util.SpringUtil;


@Scope("prototype")
@Service
@Transactional
public class FinanceDetailsServiceImpl  {
	
	public static final Log log = LogFactory.getLog(ApplyMoneyServiceImpl.class);

	@Resource
	private static FinanceDetailsMapper financeDetailsMapper;
	
	@Resource
	private static ExpenseInfoMapper expenseInfoMapper;
	
	private Integer flag = 0;
	
	static{
		financeDetailsMapper = (FinanceDetailsMapper)SpringUtil.getApplicationContext().getBean("financeDetailsMapper");
		expenseInfoMapper = (ExpenseInfoMapper)SpringUtil.getApplicationContext().getBean("expenseInfoMapper");
	}
	
//	@Override
//	public int findFinanceDetailsCount(FinanceDetailVO financeDetailVO) {
//		return financeDetailsMapper.findFinanceDetailsCount(financeDetailVO);
//	}

//	@Override
//	public Integer addFinanceDetails(FinanceDetailVO financeDetailVO) {
//		try {
//			int count = findFinanceDetailsCount(financeDetailVO);
//			if(count>0){
//				financeDetailsMapper.updateFinanceDetails(financeDetailVO);
//			}else{
//				financeDetailsMapper.addFinanceDetails(financeDetailVO);
//			}
//			
//			ExpenseInfoVO expenseInfoResult = expenseInfoMapper.selectExpenseInfoByUserId(financeDetailVO.getUserId());
//			if(expenseInfoResult != null){
//				expenseInfoResult.setTotalMoney(expenseInfoResult.getTotalMoney()+financeDetailVO.getRewardMoney());
//				expenseInfoResult.setSurplusMoney(expenseInfoResult.getSurplusMoney()+financeDetailVO.getRewardMoney());
//				flag = expenseInfoMapper.updateExpenseInfo(expenseInfoResult);
//			}else{
//				ExpenseInfoVO expenseInfo = new ExpenseInfoVO();
//				expenseInfo.setUserId(financeDetailVO.getUserId());
//				expenseInfo.setDrawMoneyPassword(financeDetailVO.getCashPassword());
//				expenseInfo.setTotalMoney(financeDetailVO.getRewardMoney());
//				expenseInfo.setSurplusMoney(financeDetailVO.getRewardMoney());
//				expenseInfo.setFreezeMoney(0d);
//				expenseInfo.setAlreadyApplyMoney(0d);
//				flag = expenseInfoMapper.addExpenseInfo(expenseInfo);
//			}
//			flag = 1;
//		} catch (Exception e) {
//			log.error(e);
//		}
//		return flag;
//	}

//	@Override
//	public Integer updateFinanceDetails(FinanceDetailVO financeDetailVO) {
//		try {
//			financeDetailsMapper.updateFinanceDetails(financeDetailVO);
//			flag = 1;
//		} catch (Exception e) {
//			log.error(e);
//		}
//		return flag;
//	}

}
