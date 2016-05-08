package com.zxkj.controller.audit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxkj.model.ApplyAuditPassSearchVO;
import com.zxkj.model.ApplyAuditPassVO;
import com.zxkj.model.JqPage;
import com.zxkj.service.IApplyAuditPassService;


/**
 * 导出审核通过的提现记录
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月9日 上午10:36:46
 */
@Scope("prototype")
@Controller
@RequestMapping("/pay/applyAuditpass")
public class ApplyAuditPassController {

	@Autowired(required = true)
	private IApplyAuditPassService applyAuditPassService;
	
	@ResponseBody
	@RequestMapping(value = "/queryAuditPassData", method = RequestMethod.POST)
	public Map<String, Object> queryAuditPassData(final HttpServletRequest request)
	{
		JqPage jqPage = initJqPage(request);
		ApplyAuditPassSearchVO applyAuditPassSearchVO = initSearchCondition(request, jqPage);
		List<ApplyAuditPassVO> list = applyAuditPassService.queryAuditPassData(applyAuditPassSearchVO);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("pageInfo", jqPage);
		returnMap.put("auditPassList",list);
		return returnMap;
	}
	
	/**
	 * 查询所有审核通过的记录条数
	 * @return
	 */
	public int queryTotalAuditPassRecourd(ApplyAuditPassSearchVO applyAuditPassVO)
	{
		return applyAuditPassService.queryTotalAuditPassCount(applyAuditPassVO);
	}
	
	
	/**
	 * 初始化页面参数
	 * @param request
	 * @return
	 */
	private ApplyAuditPassSearchVO initSearchCondition(final HttpServletRequest request, final JqPage jqPage)
	{
		 ApplyAuditPassSearchVO applyAuditPassVO = new ApplyAuditPassSearchVO();
		 applyAuditPassVO.setJqPage(jqPage);
		 applyAuditPassVO.setApplyDate(request.getParameter("applyDate"));
		 applyAuditPassVO.setApplyAccount(request.getParameter("applyAccount"));
		 applyAuditPassVO.setAuditRemark(request.getParameter("auditResult"));
		return applyAuditPassVO;
	}
	
	private JqPage initJqPage(final HttpServletRequest request)
	{
		 JqPage pageInfo = new JqPage();
		 pageInfo.setPage(Integer.parseInt(request.getParameter("pageParm")));
		 pageInfo.setRows(Integer.parseInt(request.getParameter("rowsParm")));
		 pageInfo.setSidx(request.getParameter("sidxParm"));
		 pageInfo.setSord(request.getParameter("sordParm"));
		 pageInfo.setNd(request.getParameter("ndParm"));
		 pageInfo.setRecord(this.queryTotalAuditPassRecourd(initSearchCondition(request, null)));
		 pageInfo.calcTotalPage();
		return pageInfo;
	}
}
