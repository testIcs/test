<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>明细数据</title>
<link rel="stylesheet" href="../../css/jquery-ui-1.9.2.custom.min.css" type="text/css"/>
<link rel="stylesheet" href="../../css/ui.jqgrid.css" type="text/css"/>
<link rel="stylesheet" href="../../css/jquery.datetimepicker.css" type="text/css"  />
<link rel="stylesheet" href="../../css/jquery.alerts.css" type="text/css" />
<style type="text/css">
	th >div{
    font-weight:bold !important;
}
table thead tr{
   background:url(${baseUrl}/images/accordion-header.gif) repeat-x center;
}

span.ui-icon-asc{
	top:25px;
}
span.ui-icon-desc{
	top:8px;
}
</style>
</head>
<body>
	<form id="accountDetail_form" class="" method="post">
		<input type = "hidden" id="userid" value = "${userID}"/>
		<input type = "hidden" id="businessno" value = "${businessFlowNo}"/>
	</form>
	<label style='color:red'>本次提现明细</label>
   <div class="con-table">
		<table id="currentDraw_jqgrid_data"></table>
		<!-- <div id="accountDetail_jqgrid_pager"></div> -->
   </div> 
	<label style='color:red'>历史收益明细</label>
   <div class="con-table">
		<table id="historyIncome_jqgrid_data"></table>
		<!-- <div id="accountDetail_jqgrid_pager"></div> -->
   </div> 
   <label style='color:red'>历史提现记录</label>
   <div class="con-table">
		<table id="historyDrawDetail_jqgrid_data"></table>
		<!-- <div id="accountDetail_jqgrid_pager"></div> -->
   </div>    
<script type="text/javascript" src="../../3th/jquery.min.js"></script>
<script type="text/javascript" src="../../3th/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="../../3th/jquery-ui-1.9.2.custom.min.js"></script>
<!-- <script type="text/javascript" src="../../3th/jquery.ui.datepicker-zh-CN.js"></script> -->
<script type="text/javascript" src="../../3th/grid.locale-cn.js"></script>
<script type="text/javascript" src="../../3th/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="../../3th/jquery.form.js"></script>
<script type="text/javascript" src="../../3th/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../3th/jquery.uploadify.v2.1.4.min.js"></script>
<script type="text/javascript" src="../../3th/jquery.alerts.js"></script>
<script type="text/javascript" src="../../3th/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="../../script/page_commonUtil.js"></script>
<script type="text/javascript" src="../../script/audit/applymoney_detail.js"></script>
</body>
</html>