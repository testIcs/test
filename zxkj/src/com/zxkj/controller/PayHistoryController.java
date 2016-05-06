package com.zxkj.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icss.lighttower.model.WithdrawCash;
import com.icss.lighttowerpay.model.ApplyMoneyVO;
import com.zxkj.model.JqPage;
import com.zxkj.model.PayFlowRecordVO;
import com.zxkj.service.PayHistoryService;
import com.zxkj.util.ExportFileUtil;

@Controller
@RequestMapping("/pay/payHistory")
public class PayHistoryController {
	
	@Resource
	private PayHistoryService payHistoryService;
	
//	@Resource
//	private IPersonalProfit personalProfitManager;	
	
	private JqPage initPageInfo(HttpServletRequest request){
		JqPage pageInfo = new JqPage();
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		pageInfo.setPage(new Integer(page));
		pageInfo.setRows(new Integer(rows));		
		return pageInfo;
	}
	
	@RequestMapping(value = "/showApplyMoneyHistory", method = RequestMethod.POST)
	public @ResponseBody Object showApplyMoneyHistory(HttpServletRequest request){
		//初始化分页对象
		JqPage pageInfo = initPageInfo(request);	
		String realName = request.getParameter("realName");
		String account = request.getParameter("account");
		String applyStartDate = request.getParameter("applyStartDate");
		String applyEndDate = request.getParameter("applyEndDate");		
		Map<String, Object> returnMap = new HashMap<String, Object>();		
		Map<String, Object> paramMap = new HashMap<String, Object>();		
		paramMap.put("account", account);
		paramMap.put("realName", realName);
		paramMap.put("applyStartDate", applyStartDate);
		paramMap.put("applyEndDate", applyEndDate);
		int count = payHistoryService.queryApplyMoneyHistoryCnt(paramMap);
		pageInfo.setRecord(count);
		pageInfo.calcTotalPage();
//		List<ApplyMoneyVO> applyMoneyList = payHistoryService.queryApplyMoneyHistory(paramMap,pageInfo);		
		returnMap.put("pageInfo", pageInfo);	
//		returnMap.put("dataList", applyMoneyList);
		return returnMap;
	}
	
	@RequestMapping(value = "/showPayFlowRecord/{payStatus}", method = RequestMethod.POST)
	public @ResponseBody Object showPayFlowRecord(HttpServletRequest request,@PathVariable String payStatus){
		//初始化分页对象			
		JqPage pageInfo = initPageInfo(request);
		String realName = request.getParameter("realName");
		String account = request.getParameter("account");
		String applyStartDate = request.getParameter("applyStartDate");
		String applyEndDate = request.getParameter("applyEndDate");		
		String payStartDate = request.getParameter("payStartDate");
		String payEndDate = request.getParameter("payEndDate");
		String exportFlag = request.getParameter("exportFlag");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if("1".equals(payStatus)){
			payStatus = "1,3";  //已付款页面同时展示付款成功和付款失败关闭状态的记录
		}
		paramMap.put("payStatus", payStatus);
		paramMap.put("account", account);
		paramMap.put("realName", realName);
		paramMap.put("applyStartDate", applyStartDate);
		paramMap.put("applyEndDate", applyEndDate);
		paramMap.put("payStartDate", payStartDate);
		paramMap.put("payEndDate", payEndDate);
		paramMap.put("exportFlag", exportFlag);
		int count = payHistoryService.queryPayFlowRecordCnt(paramMap);
		pageInfo.setRecord(count);
		pageInfo.calcTotalPage();		
		List<PayFlowRecordVO> dataList = payHistoryService.queryPayFlowRecord(paramMap,pageInfo);
		returnMap.put("pageInfo", pageInfo);	
		returnMap.put("dataList", dataList);
		return returnMap;
	}
	@RequestMapping(value = "/modifyPayFlowRecord", method = RequestMethod.POST)
	public @ResponseBody Object modifyPayFlowRecord (HttpServletRequest request){		
		String id = request.getParameter("id");
		String applyMoney = request.getParameter("applyMoney");		
		String payStatus = request.getParameter("payStatus");
		String thirdOrderNo = request.getParameter("thirdOrderNo");
		String payAccount = request.getParameter("payAccount");
		String payMoney = request.getParameter("payMoney");
		String payTime = request.getParameter("payTime");
		String userId = request.getParameter("userId");
		String beforePayMoney = request.getParameter("beforePayMoney");
		String remark = request.getParameter("remark");
		if(payMoney==null || "".equals(payMoney)){
			payMoney = applyMoney;
		}
		Map<String, String> paramMap = new HashMap<String, String>();
		//支付成功
		if(payStatus!=null && "1".equals(payStatus)){
			paramMap.put("id", id);		
			paramMap.put("payStatus", payStatus);
			paramMap.put("thirdOrderNo", thirdOrderNo);
			paramMap.put("payAccount", payAccount);
			paramMap.put("payMoney", payMoney);
			paramMap.put("payTime", payTime);	
			Double afterMoney = Double.parseDouble(beforePayMoney) - Double.parseDouble(payMoney);
			String afterPayMoney = afterMoney.toString();
			paramMap.put("afterPayMoney", afterPayMoney);	
			paramMap.put("userId", userId);			
			try {
				//更新支付记录_成功支付
				payHistoryService.updatePayFlowRecordSuccess(paramMap);
			} catch (Exception e) {				
				return false;
			}			
			//调用接口更新tester端的账户信息
			WithdrawCash cash = new WithdrawCash();
			cash.setWithdrawUserId(Integer.parseInt(userId));
			cash.setApplyState(1); //设置成功
//			personalProfitManager.updateCashApplyState(cash);
		}else if(payStatus!=null && "2".equals(payStatus)){ //支付失败
			paramMap.put("id", id);	
			paramMap.put("payStatus", payStatus);
			paramMap.put("remark", remark);	
			//更新支付记录表信息_支付失败
			payHistoryService.updatePayFlowRecordFail(paramMap);
		}else if(payStatus!=null && "3".equals(payStatus)){ //支付失败关闭
			paramMap.put("id", id);	
			paramMap.put("payStatus", payStatus);
			paramMap.put("remark", remark);
			paramMap.put("userId", userId);
			try {
				//更新支付记录表信息_支付关闭
				payHistoryService.updatePayFlowRecordFailClose(paramMap);
			} catch (Exception e) {
				return false;
			}			
			//调用接口更新tester端的账户信息6
			WithdrawCash cash = new WithdrawCash();
			cash.setWithdrawUserId(Integer.parseInt(userId));
			cash.setApplyState(2); //设置失败
			cash.setRemark(remark);
//			personalProfitManager.updateCashApplyState(cash);
		}
		return true;
	}
	
	/**
	 * 生成导出文件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/exportPayFlowRecord/{payStatus}", method = RequestMethod.POST)
	public @ResponseBody Object exportPayFlowRecord(HttpServletRequest request,HttpServletResponse response,@PathVariable String payStatus){
		String realName = request.getParameter("realName");
		String account = request.getParameter("account");
		String applyStartDate = request.getParameter("applyStartDate");
		String applyEndDate = request.getParameter("applyEndDate");		
		String exportFlag = request.getParameter("exportFlag");		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("payStatus", payStatus);
		paramMap.put("account", account);
		paramMap.put("realName", realName);
		paramMap.put("applyStartDate", applyStartDate);
		paramMap.put("applyEndDate", applyEndDate);	
		paramMap.put("exportFlag", exportFlag);	
		JqPage pageInfo = new JqPage();		
		int count = payHistoryService.queryPayFlowRecordCnt(paramMap);
		if(count==0){
			returnMap.put("flag", "noReord");
			return returnMap;
		}
		pageInfo.setPage(1);
		pageInfo.setRows(count);
		pageInfo.setRecord(count);
		pageInfo.calcTotalPage();		
		List<PayFlowRecordVO> list = payHistoryService.queryPayFlowRecord(paramMap,pageInfo);	
		List<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
		String ids = "";
		ArrayList<String> headList = new ArrayList<String>();
		headList.add("序号");
		headList.add("业务流水号");
		headList.add("姓名");
		headList.add("支付渠道");
		headList.add("提现账号");
		headList.add("提现前余额");	
		headList.add("提现金额");		
		headList.add("申请时间");
		headList.add("支付状态");
		dataList.add(headList);
		for (int i = 0; i < list.size(); i++) {
			PayFlowRecordVO vo = list.get(i);
			if("".equals(ids)){
				ids += vo.getId();
			}else{
				ids += "," + vo.getId();
			}
			ArrayList<String> tempList = new ArrayList<String>();
			tempList.add(""+(i+1));
			tempList.add(vo.getBusinessFlowNo());
			tempList.add(vo.getRealName());
			tempList.add(vo.getPaygateName());
			tempList.add(vo.getAccount());
			tempList.add(""+vo.getBeforePayMoney());
			tempList.add(""+vo.getApplyMoney());			
			tempList.add(vo.getBeginApplyDate());
			String applyStatus = "";
			if(vo.getPayStatus()==0){
				applyStatus = "待支付";
			}else if(vo.getPayStatus()==1){
				applyStatus = "支付成功";
			}else if(vo.getPayStatus()==2){
				applyStatus = "支付失败";
			}
			tempList.add(applyStatus);
			
			dataList.add(tempList);			
		}		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMddHHmmss");
		String now = sdf.format(new Date());
		String filePath = request.getRealPath("/")+"exportFile\\toPayRecord"+now+".xls";		
		ExportFileUtil.exportExcel("待支付记录",dataList,filePath);	
		returnMap.put("savePath", filePath);
		paramMap.clear();
		paramMap.put("exportFlag", 1);
		paramMap.put("ids", ids);		
		payHistoryService.updatePayFlowRecordExportFlag(paramMap);			
		return returnMap;
	}
	
	/**
	 * 下载文件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public ModelAndView downloadFile(HttpServletRequest request,HttpServletResponse response){
		String filePath=request.getParameter("filePath");		    
	    File file = new File(filePath);// 
	    String filename = file.getName();// 获取文件名称
	    try {
			InputStream fis = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			response.reset();
			// 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream os = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			os.write(buffer);// 输出文件
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	    return null;
	}
	
}
