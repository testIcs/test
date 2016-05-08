package com.zxkj.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.dao.audit.AuditApplyMoneyMapper;
import com.zxkj.model.ApplyAuditPassSearchVO;
import com.zxkj.model.ApplyAuditPassVO;
import com.zxkj.service.IApplyAuditPassService;


/**
 * 查询所有审核完毕的信息
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月9日 下午2:15:39
 */
@Scope("prototype")
@Service("exportAuditPassService")
public class ApplyAuditPassServiceImpl implements IApplyAuditPassService {

	@Autowired(required = true)	
	@Resource(name = "applyAuditMapper")
	private AuditApplyMoneyMapper auditApplyMoneyMapper;
	
	@Override
	public List<ApplyAuditPassVO> queryAuditPassData(ApplyAuditPassSearchVO applyAuditPassSearchVO) {
		String auditResult = applyAuditPassSearchVO.getAuditRemark();
		boolean isQueryByCd = isQueryByCondtion(applyAuditPassSearchVO);
		if (isQueryByCd)
		{
			Integer auditStatus = getAuditStatus(auditResult);
			applyAuditPassSearchVO.setAuditStatus(auditStatus);
			return auditApplyMoneyMapper.queryAuditPassDataByCondition(putToMup(applyAuditPassSearchVO));	
		}
		return auditApplyMoneyMapper.queryAuditPassData(putToMup(applyAuditPassSearchVO));
	}
	
	public int queryTotalAuditPassCount(ApplyAuditPassSearchVO applyAuditPassSearchVO)
	{
		String auditResult = applyAuditPassSearchVO.getAuditRemark();
		boolean isQueryByCd = isQueryByCondtion(applyAuditPassSearchVO);
		if (isQueryByCd)
		{
			Integer auditStatus = getAuditStatus(auditResult);
			applyAuditPassSearchVO.setAuditStatus(auditStatus);
			return auditApplyMoneyMapper.queryTotalAuditPassCountByContidion(putToMup(applyAuditPassSearchVO));
		}
		return auditApplyMoneyMapper.queryTotalAuditPassCount();
	}
	
	/**
	 * 判断是否是条件查询
	 * @param auditResult
	 * @return
	 */
	private boolean isQueryByCondtion(ApplyAuditPassSearchVO applyAuditPassSearchVO)
	{
		String auditResult = applyAuditPassSearchVO.getAuditRemark();
		String applyAccount = applyAuditPassSearchVO.getApplyAccount();
		String applyDate = applyAuditPassSearchVO.getApplyDate();
		boolean isAuditResultNull = (auditResult == null || auditResult.isEmpty())? true:false;
		boolean isapplyAccountNull = (applyAccount == null || applyAccount.isEmpty())? true:false;
		boolean isapplyDateNull = (applyDate == null || applyDate.isEmpty())? true:false;
		// 此处不短路
		if (isAuditResultNull & isapplyAccountNull & isapplyDateNull)
		{
			return false;
		}
		return true;
	}
	
	private Integer getAuditStatus(String auditResult)
	{
		if (auditResult == null)
		{
			return null;
		}
		auditResult = auditResult.trim();
		if ("通过".equals(auditResult))
		{
			return 3;
		} else if ("驳回".equals(auditResult))
		{
			return 4;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * 初始化查询参数
	 * @param searchVO
	 * @return
	 */
	private Map<String, Object> putToMup(final ApplyAuditPassSearchVO applyAuditPassSearchVO)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		if (null != applyAuditPassSearchVO.getJqPage())
		{
			Integer pageSize = applyAuditPassSearchVO.getJqPage().getRows();
			Integer startRow = (applyAuditPassSearchVO.getJqPage().getPage().intValue() - 1) * pageSize;
			map.put("start", startRow);
			map.put("rows", pageSize);
		}
		map.put("applyAccount", applyAuditPassSearchVO.getApplyAccount());
		map.put("applyDate", applyAuditPassSearchVO.getApplyDate());
		map.put("auditRemark", applyAuditPassSearchVO.getAuditRemark());
		map.put("auditStatus", applyAuditPassSearchVO.getAuditStatus());
		return map;
	}

}
