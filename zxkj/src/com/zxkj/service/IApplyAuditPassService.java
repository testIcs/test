package com.zxkj.service;

import java.util.List;

import com.zxkj.model.ApplyAuditPassSearchVO;
import com.zxkj.model.ApplyAuditPassVO;


/**
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月9日 下午2:14:38
 */
public interface IApplyAuditPassService {

	public List<ApplyAuditPassVO> queryAuditPassData(ApplyAuditPassSearchVO applyAuditPassSearchVO);
	
	public int queryTotalAuditPassCount(ApplyAuditPassSearchVO applyAuditPassVO);
}
