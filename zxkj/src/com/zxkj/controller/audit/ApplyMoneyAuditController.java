package com.zxkj.controller.audit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icss.lighttower.consts.MsgModel;
import com.icss.lighttowersystem.model.UserBase;
import com.icss.lighttowersystem.service.IMessageRecord;
import com.icss.lighttowersystem.service.IMessageTemplateManager;
import com.icss.lighttowersystem.service.IUserBaseManager;
import com.icss.lighttowersystem.util.DateUtil;
import com.icss.lighttowersystem.util.MessageFormatUtil;
import com.icss.lighttowersystem.vo.MessageVO;
import com.zxkj.common.Constants;
import com.zxkj.model.ApplyMoneySearchVO;
import com.zxkj.model.ApplyMoneyVO;
import com.zxkj.model.HistoryDrawMoneyVO;
import com.zxkj.model.HistoryIncomeVO;
import com.zxkj.model.JqPage;
import com.zxkj.model.PayFlowRecordVO;
import com.zxkj.model.ThisApplyMoneyDetailVO;
import com.zxkj.model.User;
import com.zxkj.service.IApplyMoneyAuditService;
import com.zxkj.service.ITokenService;
import com.zxkj.util.MessageSendThread;

/**
 * 提现申请控制器
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月6日 下午4:58:49
 */
@Scope("prototype")
@Controller
@RequestMapping("/pay/applyAudit")
public class ApplyMoneyAuditController {

	private static final Logger LOG = LoggerFactory.getLogger(ApplyMoneyAuditController.class);
	
	private MessageFormatUtil messageFormatUtil = new MessageFormatUtil();
	
	@Autowired(required = true)
	private IApplyMoneyAuditService applyMoneyAuditService;
	
	@Resource
	private IUserBaseManager userBaseManager;
	
	@Resource
	private IMessageTemplateManager messageTemplateManager;
	
	@Resource
	private IMessageRecord messageManager;
	
	/**
	 * 生成token 
	 */
	@ITokenService(save=true)
	@ResponseBody
	@RequestMapping(value = "/makeToken", method = RequestMethod.GET)
	public String makeToken(final HttpServletRequest request){
		return request.getSession(false).getAttribute("token").toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getApplyMoneyRecord", method = RequestMethod.POST)
	public Map<String, Object> getApplyMoneyRecord(final HttpServletRequest request)
	{
		JqPage jqPage = initPageMsg(request);
		ApplyMoneySearchVO searchParm = initSearchCondition(request, jqPage);
		List<ApplyMoneyVO> applyMoneyList = applyMoneyAuditService.getApplyMoneyRecord(searchParm);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("pageInfo", jqPage);
		returnMap.put("applyMoneyList",applyMoneyList);
		return returnMap;
	}
	
	/**
	 * 构造ModelAndView并跳转到新页面
	 */
	@RequestMapping(value = "/queryAccoutDetailData", method = RequestMethod.GET)
	public ModelAndView queryAccoutDetailData(final HttpServletRequest request)
	{
		String businessFlowNo = request.getParameter("businessFlow");
		String userID = request.getParameter("userID");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("audit/applymoney_detail");
		mv.getModelMap().put("businessFlowNo", businessFlowNo);
		mv.getModelMap().put("userID", userID);
		return mv; 
	}
	
	/**
	 * 本次提现明细
	 */
	@ResponseBody
	@RequestMapping(value = "/queryAccoutDetailDatas", method = RequestMethod.POST)
	public Map<String, Object> queryAccoutDetailDatas(final HttpServletRequest request)
	{
		String businessFlowNo = request.getParameter("businessFlow");
		String userID = request.getParameter("userID");
		List<ThisApplyMoneyDetailVO> detailVOList = 
		        applyMoneyAuditService.queryThisApplyMoneyDetail(businessFlowNo, userID);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("pageInfo", new JqPage());
		returnMap.put("detailVO",detailVOList);
		return returnMap;
	}
	
	/**
	 * 历史提现记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryHistoryDrawMoney", method = RequestMethod.POST)
	public Map<String, Object> queryHistoryDrawMoney(final HttpServletRequest request)
	{
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String userID = request.getParameter("userID");
		List<HistoryDrawMoneyVO>  historyDraw = applyMoneyAuditService.queryHistoryDrawMoneyDetail(userID);
		returnMap.put("historyDraw", historyDraw); 
		returnMap.put("pageInfo", new JqPage());
		return returnMap;
	}
	
	/**
	 * 历史收益明细
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryHistoryIncomeDetail", method = RequestMethod.POST)
	public Map<String, Object> queryHistoryIncomeDetail(final HttpServletRequest request)
	{
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String userID = request.getParameter("userID");
		List<HistoryIncomeVO>  historyIncome = applyMoneyAuditService.queryHistoryIncomeMoneyDetail(userID);
		returnMap.put("historyIncome", historyIncome); 
		returnMap.put("pageInfo", new JqPage());
		return returnMap;
	}
	
	/**
	 * 审核用户提现信息
	 */
	@ITokenService(remove=true)
	@ResponseBody
	@RequestMapping(value = "/updateAuditStatus", method = RequestMethod.POST)
	public boolean updateAuditStatus(final HttpServletRequest request){
		try{
			PayFlowRecordVO payFlowRecordVO = initPayFlowRecordVO(request);
			applyMoneyAuditService.updateAuditStatus(payFlowRecordVO);
			//支付金额
			String payMoney = payFlowRecordVO.getPayMoney().toString();
			//申请日期
			String beginApplyDate = DateUtil.format(
					DateUtil.parse(request.getParameter("beginApplyDate"),"yyyy-MM-dd HH:mm:ss"), 
					"yyyy-MM-dd HH:mm:ss"
			);
			//审核状态
			String auditState = payFlowRecordVO.getPassRemark();
			//获取用户对象
			UserBase userBase = userBaseManager.getUserBaseById(payFlowRecordVO.getUserId());
			if(userBase != null){
				//发送消息
				sendMessage(userBase,auditState,beginApplyDate,payMoney);
			}
			return true;
		}catch (Exception e){
			LOG.error("审核提现申请数据时出错，请检查。", e);
			return false;
		}
	}
	
	/**
	 * 审核通过或者驳回发送消息
	 * @param userBase
	 * @param auditState
	 */
	private void sendMessage(UserBase userBase,String auditState,String beginApplyDate,String payMoney){
		//获得微信消息对象
		MessageVO weChatMessage = getWeChatMessageVO(userBase,auditState,beginApplyDate,payMoney);
		
		//获得站内消息对象
		MessageVO innerMessage = getInnerMessageVO(userBase,auditState,beginApplyDate,payMoney);
		
		//获得短信消息对象
		MessageVO smsMessage = getSMSMessageVO(userBase,auditState,beginApplyDate,payMoney);
		
		//通过线程发送消息
		MessageSendThread messageSend = MessageSendThread.getInstance();
		messageSend.setWeChat(weChatMessage);
		messageSend.setInnerMessage(innerMessage);
		messageSend.setSmsMessage(smsMessage);
		messageSend.start();
	}
	
	/**
	 * 获得微信消息对象
	 * @param userBase
	 * @param auditState
	 * @param beginApplyDate
	 * @param payMoney
	 * @return
	 */
	private MessageVO getWeChatMessageVO(UserBase userBase,String auditState,String beginApplyDate,String payMoney){
		//微信消息对象
		MessageVO weChatMessage = null;
		try{
			weChatMessage = new MessageVO();
			weChatMessage.setMessageAccepter(userBase.getUserName());
			int templateId =Constants.AUDIT_PASS_WECHAT_MSGID;
			if("NO_PASS".equals(auditState)){
				templateId = Constants.AUDIT_NOPASS_WECHAT_MSGID;
			}
			String weChatContent = getMessageTemplateById(templateId,beginApplyDate,payMoney);
			weChatMessage.setMessageContent(weChatContent);
		}catch(Exception e){
			LOG.error("获取微信消息对象失败",e);
			return null;
		}
		
		return weChatMessage;
	}
	
	/**
	 * 获得站内消息对象
	 * @param userBase
	 * @param auditState
	 * @param beginApplyDate
	 * @param payMoney
	 * @return
	 */
	private MessageVO getInnerMessageVO(UserBase userBase,String auditState,String beginApplyDate,String payMoney){
		MessageVO innerMessage = null;
		try{
			innerMessage = new MessageVO();
			innerMessage.setMessageAccepter(userBase.getUserName());
			innerMessage.setUserId(userBase.getId());
			innerMessage.setMessageType(MsgModel.STATION_MESSAGE);
			innerMessage.setMessageStyle(MsgModel.TRADE_NOTICE);
			innerMessage.setMessageKind(MsgModel.NOTICE);
			innerMessage.setMessageState(MsgModel.UNREAD);
			//消息的发送时间
			innerMessage.setMessageTime(new java.sql.Date(System.currentTimeMillis()));
			String messageTitle="提现申请已通过";
			int templateId =Constants.AUDIT_PASS_INNER_MSGID; 
			if("NO_PASS".equals(auditState)){
				messageTitle="提现申请未通过";
				templateId = Constants.AUDIT_NOPASS_INNER_MSGID;
			}
			String messageContent=getMessageTemplateById(templateId, beginApplyDate, payMoney);
			innerMessage.setMessageContent(messageContent);
			innerMessage.setMessageTitle(messageTitle);
			innerMessage.setMessageResult(0);
		}catch(Exception e){
			LOG.error("获取站内消息对象失败",e);
			return null;
		}
		
		return innerMessage;
	}
	
	/**
	 * 获得短信消息对象
	 * @param userBase
	 * @param auditState
	 * @param beginApplyDate
	 * @param payMoney
	 * @return
	 */
	private MessageVO getSMSMessageVO(UserBase userBase,String auditState,String beginApplyDate,String payMoney){
		MessageVO smsMessage = null;
		try{
			smsMessage = new MessageVO();
			smsMessage.setMessageAccepter(userBase.getPhoneNo());
			int templateId =Constants.AUDIT_PASS_SMS_MSGID;
			if("NO_PASS".equals(auditState)){
				templateId = Constants.AUDIT_NOPASS_SMS_MSGID;
			}
			String messageContent=getMessageTemplateById(templateId, beginApplyDate, payMoney);
			smsMessage.setMessageContent(messageContent);
		}catch(Exception e){
			LOG.error("获取短信消息对象失败",e);
			return null;
		}
		
		return smsMessage;
	}
	
	/**
	 * 根据模拟id获取到发送内容
	 * @param id
	 * @param beginApplyDate
	 * @param payMoney
	 * @return
	 */
	private String getMessageTemplateById(int id,String beginApplyDate,String payMoney){
		return messageFormatUtil.formatMessage(messageTemplateManager.getMessageTemplate(id), new String[]{beginApplyDate,payMoney});
	}
	
	
	
	/**
	 * 根据请求初始化vo对象
	 * @param request
	 * @return
	 */
	private PayFlowRecordVO initPayFlowRecordVO(final HttpServletRequest request)
	{
		User user = (User)request.getSession().getAttribute("user");
		String auditUser =user.getUserName();
		PayFlowRecordVO payFlowRecordVO = new PayFlowRecordVO();
		payFlowRecordVO.setAuditUser(auditUser);
		payFlowRecordVO.setAccount(request.getParameter("applyAccount"));
		payFlowRecordVO.setPayAccount(request.getParameter("applyAccount"));
		payFlowRecordVO.setPayMoney(formatToDouble(request.getParameter("drawMoney")));
		payFlowRecordVO.setPaygateType(request.getParameter("paygateType"));
		payFlowRecordVO.setUserId(formatToInt(request.getParameter("userID")));
		payFlowRecordVO.setBusinessFlowNo(request.getParameter("businessFlow"));
		payFlowRecordVO.setPayStatus(0);
		payFlowRecordVO.setPassRemark(request.getParameter("auditState"));
		String flowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		payFlowRecordVO.setPayTime(flowDate);
		return payFlowRecordVO;
	}
	
	private double formatToDouble(String money)
	{
		try
		{
			double doubleMoney = Double.parseDouble(money);	
			return doubleMoney;
		} catch (NumberFormatException e)
		{
			LOG.error("格式化金额出错。", e);
			return 0.0;
		}
	}
	
	private int formatToInt(String userid)
	{
		try
		{
			int userID = Integer.parseInt(userid);	
			return userID;
		} catch (NumberFormatException e)
		{
			LOG.error("格式化用户ID出错。", e);
			return 0;
		}
	}
	
	private JqPage initPageMsg(final HttpServletRequest request)
	{
		 JqPage pageInfo = new JqPage();
		 pageInfo.setPage(Integer.parseInt(request.getParameter("pageParm")));
		 pageInfo.setRows(Integer.parseInt(request.getParameter("rowsParm")));
		 pageInfo.setSidx(request.getParameter("sidxParm"));
		 pageInfo.setSord(request.getParameter("sordParm"));
		 pageInfo.setNd(request.getParameter("ndParm"));
		 pageInfo.setRecord(this.queryTotalApplyRecourd(initSearchCondition(request, null)));
		 pageInfo.calcTotalPage();
		 return pageInfo;
	}
	/**
	 * 初始化页面参数
	 * @param request
	 * @return
	 */
	private ApplyMoneySearchVO initSearchCondition(final HttpServletRequest request, final JqPage jqPage)
	{
		 ApplyMoneySearchVO applyMoneySearchVO = new ApplyMoneySearchVO();
		 applyMoneySearchVO.setJqPage(jqPage);
		 applyMoneySearchVO.setApplyStartDate(request.getParameter("applyStartDate"));
		 applyMoneySearchVO.setApplyEndDate(request.getParameter("applyEndDate"));
		 applyMoneySearchVO.setApplyUser(request.getParameter("applyUser"));
		return applyMoneySearchVO;
	}
	
	private int queryTotalApplyRecourd(ApplyMoneySearchVO applyMoneySearchVO)
	{
		int totalCount = applyMoneyAuditService.queryTotalApplyMoneyCount(applyMoneySearchVO);
		return totalCount;
	}
}
