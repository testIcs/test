package com.zxkj.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.lighttowerpay.model.ApplyMoneyVO;
import com.icss.lighttowerpay.model.ExpenseInfoVO;
import com.icss.lighttowerpay.service.IApplyMoneyService;
import com.zxkj.dao.ApplyMoneyMapper;
import com.zxkj.dao.ExpenseInfoMapper;
import com.zxkj.util.SpringUtil;
import com.zxkj.util.UUIDUtil;

@Scope("prototype")
@Service
@Transactional
public class ApplyMoneyServiceImpl implements IApplyMoneyService {

	public static final Log log = LogFactory.getLog(ApplyMoneyServiceImpl.class);
	
	@Resource
	private static ApplyMoneyMapper applyMoneyMapper;
	
	@Resource
	private static ExpenseInfoMapper expenseInfoMapper;
	
	private Integer flag = 0;
	
	static{
		applyMoneyMapper = (ApplyMoneyMapper)SpringUtil.getApplicationContext().getBean("applyMoneyMapper");
		expenseInfoMapper = (ExpenseInfoMapper)SpringUtil.getApplicationContext().getBean("expenseInfoMapper");
	}
	
	@Override
	public Integer addApplyMoney(List<ApplyMoneyVO> applyMoneyList) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			for (ApplyMoneyVO applyMoney : applyMoneyList) {
				String fdate = format.format(new Date());
				//设置提现业务流水号
				applyMoney.setApplyFlowNo(fdate+"-"+UUIDUtil.generateShortUuid());
				//调用持久化层接口将提现信息写入数据库
				applyMoneyMapper.addApplyMoney(applyMoney);
				//
				ExpenseInfoVO expenseInfoResult = expenseInfoMapper.selectExpenseInfoByUserId(applyMoney.getUserId());
				if(null != expenseInfoResult){
					expenseInfoResult.setSurplusMoney(expenseInfoResult.getSurplusMoney()-applyMoney.getApplyMoney());
					expenseInfoResult.setFreezeMoney(expenseInfoResult.getFreezeMoney()+applyMoney.getApplyMoney());
					expenseInfoMapper.updateExpenseInfo(expenseInfoResult);
				}
			}
			flag = 1;
		} catch (Exception e) {
			log.error(e);
		}
		return flag;
	}

	@Override
	public Integer selectApplyStatusNo(ApplyMoneyVO applyMoney) {
		return applyMoneyMapper.selectApplyStatusNo(applyMoney);
	}

	@Override
	public Integer selectPayFlowStatus(ApplyMoneyVO applyMoney) {
		return applyMoneyMapper.selectPayFlowStatus(applyMoney);
	}

}
