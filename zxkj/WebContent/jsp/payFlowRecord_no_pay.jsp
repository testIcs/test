<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>待付款记录</title>
<link rel="stylesheet" href="../css/jquery-ui-1.9.2.custom.min.css" type="text/css"/>
<link rel="stylesheet" href="../css/ui.jqgrid.css" type="text/css"/>
<link rel="stylesheet" href="../css/jquery.datetimepicker.css" type="text/css"  />
<link rel="stylesheet" href="../css/jquery.alerts.css" type="text/css" />
<link rel="stylesheet" href="../css/pages.css" type="text/css"  />
<style type="text/css">
	.modal{
	position:fixed; top:50%; left:45%; z-index:1050; width:300px; margin:-250px 0 0 -100px; background:#ffffff; -webkit-border-radius:6px; -moz-border-radius:6px; border-radius:6px; outline:none; display:none;
	}
	.close{
		cursor:pointer; position:absolute; right:15px; top:14px; background:url(../css/images/close.png) no-repeat; width:16px; height:16px;
	}
	.modal-backdrop{/*bottom black*/
		position:fixed; top:0; right:0; bottom:0; left:0; z-index:1040; background:#000000; opacity:0.6; filter:alpha(opacity=60);
	}
	.modal h1,#forgetform h1,#signup-modal h1,#login-modal h1{
		background:#3689c8; font-size:18px; color:#fff; padding-left:15px; height:50px; line-height:50px; margin:0px; border-top-left-radius:6px; border-top-right-radius:6px;
	}
	.save{
	width:90px; height:32px; background:#3689c8; border:0px; text-align:center; color:#fff; float:left; border-radius:4px; cursor:pointer;
	}
	.cancel{
	width:90px; height:32px; background:#ddd; border:0px; text-align:center; color:#333; float:right; border-radius:4px; cursor:pointer;
	}

</style>
</head>
<body>
	<%@ include  file="./top.jsp"%>
	<div style="border: 3px solid white; min-width: 900px;">
		<%@ include  file="./left.jsp"%>
		<div class="right"
			style="width: 700px; height: 100%; float: left; border-left: 1px solid #a3c0e8;">
	<div style="width:900px;padding-left:10px;">
	<fieldset style="border:1px dashed #a3c0e8">
	<legend>查&nbsp;&nbsp;询</legend>
	<form id="searchForm" action="">
		申请日期从:<input type="text" id="applyStartDate" style="width: 80px;"  />
		到:<input type="text" id="applyEndDate"  style="width: 80px;" />
		姓名:<input type="text" id="realName"  style="width: 80px;" />
		提现账号:<input type="text" id="account"  style="width: 80px;" />
		导出状态:
		<select id="exportFlag">
			<option value="">请选择</option>
			<option value="0">未导出</option>
			<option value="1">已导出</option>
		</select>
		<button id="queryBtn" type="button" onclick="queryData();">查询</button>
		<button id="resetBtn" type="button" onclick="resetData();">重置</button>
		<button id="exportBtn" type="button" onclick="exportData();">导出</button>
	</form>
	</fieldset>
	</div>
   <div class="con-table">
		<table id="payRecord_jqgrid_data"></table>
		<div id="payRecord_jqgrid_pager"></div>
   </div>    
   <div class="modal" id="modify_success_form">
	<a class="close" data-dismiss="modal"></a>
    <h1>支付成功</h1>
	<form id="project_type_form" class="reg-form customForm">
		<table style="margin-left: 20px;">
			<tr>
				<td>
					<input id="id_success" type="hidden"/>
					<input id="applyMoney" type="hidden"/>
					<input id="beforePayMoney" type="hidden">
					<input id="userId" type="hidden">
				</td>				
			</tr>			
			<tr>
				<td >业务流水号:</td>
				<td>
					<input type="text" id="businessFlowNo_success" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td >支付状态:</td>
				<td>
					<select id="payStatus_success">						
						<option value="1">支付成功</option>						
					</select>
				</td>
			</tr>
			<tr>
				<td >支付流水:</td>
				<td>
					<input type="text" id="thirdOrderNo" value=""/>
				</td>
			</tr>
			<tr>
				<td >账号:</td>
				<td>
					<input type="text" id="payAccount" value=""/>
				</td>
			</tr>
			<tr>
				<td >支付金额:</td>
				<td>
					<input type="text" id="payMoney" readonly="readonly" value=""/>
				</td>
			</tr>
			<tr>
				<td >支付时间:</td>
				<td>
					<input type="text" id="payTime" value=""/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input id="savePayFlowStatusBtn" onclick="savePayFlowStatus('success');" type="button" class="save" value="保 存" />
					<input id="cancelPayFlowStatusBtn" onclick="cancelPayFlowStatus();" type="button" class="cancel" value="取 消" />
				</td>				
			</tr>
		</table>
	</form>
</div> 
<div class="modal" id="modify_fail_form">
	<a class="close" data-dismiss="modal"></a>
    <h1>支付失败</h1>
	<form id="project_type_form" class="reg-form customForm">
		<table style="margin-left: 20px;">
			<tr>
				<td >业务流水号:</td><input id="id_fail" type="hidden"/><input id="applyMoney" type="hidden"/>
				<td>
					<input type="text" id="businessFlowNo_fail" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td >支付状态:</td>
				<td>
					<select id="payStatus_fail">						
						<option value="2">支付失败</option>						
					</select>
				</td>
			</tr>	
			<tr>
				<td >失败原因:</td>
				<td>
					<textarea id="remark" rows="3" cols="20"></textarea>
				</td>
			</tr>		
			<tr>
				<td colspan="2">
					<input id="savePayFlowStatusBtn" onclick="savePayFlowStatus('fail');" type="button" class="save" value="保 存" />
					<input id="cancelPayFlowStatusBtn" onclick="cancelPayFlowStatus();" type="button" class="cancel" value="取 消" />
				</td>				
			</tr>
		</table>
	</form>
</div>  
</div>
</div>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script type="text/javascript" src="../3th/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="../3th/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript" src="../3th/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="../3th/grid.locale-cn.js"></script>
<script type="text/javascript" src="../3th/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="../3th/jquery.form.js"></script>
<script type="text/javascript" src="../3th/jquery.validate.min.js"></script>
<script type="text/javascript" src="../3th/jquery.uploadify.v2.1.4.min.js"></script>
<script type="text/javascript" src="../3th/jquery.alerts.js"></script>
<script type="text/javascript" src="../3th/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="../3th/modal.js"></script>
<script type="text/javascript" src="../3th/jquery.json-2.4.js"></script>
<script type="text/javascript" src="../script/page_commonUtil.js"></script>
<script type="text/javascript" src="../script/payFlowRecord_no_pay.js"></script>
</body>
</html>