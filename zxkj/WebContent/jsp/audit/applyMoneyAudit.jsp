<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>提现申请审核</title>
<link rel="stylesheet" href="../../css/jquery-ui-1.9.2.custom.min.css"
	type="text/css" />
<link rel="stylesheet" href="../../css/ui.jqgrid.css" type="text/css" />
<link rel="stylesheet" href="../../css/jquery.alerts.css" type="text/css" />
<link rel="stylesheet" href="../../css/jquery.datetimepicker.css"
	type="text/css" />
<style type="text/css">
	.modal{
		position:fixed; top:50%; left:45%; z-index:1050; width:1110px; height:550px; margin:-300px 0 0 -400px; background:#ffffff; -webkit-border-radius:6px; -moz-border-radius:6px; border-radius:6px; outline:none; display:none;
	}
	.close{
		cursor:pointer; position:absolute; right:15px; top:14px; background:url(../../css/images/close.png) no-repeat; width:16px; height:16px;
	}
	.modal-backdrop{/*bottom black*/
		position:fixed; top:0; right:0; bottom:0; left:0; z-index:1040; background:#000000; opacity:0.6; filter:alpha(opacity=60);
	}
	.modal h1,#forgetform h1,#signup-modal h1,#login-modal h1{
		background:#3689c8; font-size:18px; color:#fff; padding-left:15px; height:50px; line-height:50px; margin:0px; border-top-left-radius:6px; border-top-right-radius:6px;
	}
</style>
</head>
<body>
	<%@ include  file="../top.jsp"%>
	<div style="border: 3px solid white; min-width: 900px;">
		<%@ include  file="../left.jsp"%>
		<div class="right"
			style="width: 700px; height: 100%; float: left; border-left: 1px solid #a3c0e8;">
			<div class="navlistsearch" style="width:900px;padding-left:10px;">
			<fieldset style="border:1px dashed #a3c0e8">
			<legend>查&nbsp;&nbsp;询</legend>
				<form id="applyMoney_search_form" class="search-div" method="post">
				           申请日期从: <input type="text" id="applyStartDate" name="applyStartDate" class="nav-timeslot" style="width: 90px;" />
				           到: <input type="text" id="applyEndDate" name="applyEndDate" class="nav-timeslot" style="width: 90px;" />
					<span> 姓名：</span> <input type="text" id="applyUser"
						name="applyUser" class="nav-input" style="width: 80px;" />
				    <input type="button" id="search_btn" value="搜索" class="query-button" />
					<input type="button" id="auditPass_btn" value=" 批量审核通过" class="" />						
					<input type="button" id="reset_btn" value=" 重置" class="" />						
				</form>
			</fieldset>
			</div>
			<div class="con-table">
				<table id="applyMoneyAudit_jqgrid_data"></table>
				<div id="applyMoneyAudit_jqgrid_pager"></div>
			</div>
		</div>

	</div>
	<div class="modal" id="detail_modal" align="center">
	<a class="close" data-dismiss="modal"></a>
    <h1>账户明细数据</h1>
    <iframe id="detailFrame" src="" height="500" width="100%"></iframe>
    </div>
    <div>
    	<input id="token_hidden" type="hidden"/>
    </div>
    
	<script type="text/javascript" src="../../3th/jquery.min.js"></script>
	<script type="text/javascript"
		src="../../3th/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript"
		src="../../3th/jquery-ui-1.9.2.custom.min.js"></script>
	<!-- <script type="text/javascript" src="../../3th/jquery.ui.datepicker-zh-CN.js"></script> -->
	<script type="text/javascript" src="../../3th/grid.locale-cn.js"></script>
	<script type="text/javascript" src="../../3th/jquery.jqGrid.min.js"></script>
	<script type="text/javascript" src="../../3th/jquery.form.js"></script>
	<script type="text/javascript" src="../../3th/jquery.validate.min.js"></script>
	<script type="text/javascript" src="../../3th/jquery.uploadify.v2.1.4.min.js"></script>
	<script type="text/javascript" src="../../3th/jquery.alerts.js"></script>
	<script type="text/javascript" src="../../3th/jquery.datetimepicker.js"></script>
	<script type="text/javascript" src="../../script/page_commonUtil.js"></script>
	<script type="text/javascript" src="../../3th/modal.js"></script>
	<script type="text/javascript" src="../../script/audit/applyMoneyAudit.js"></script>
</body>
</html>