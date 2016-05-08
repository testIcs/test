<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>提现记录导出</title>
<link rel="stylesheet" href="../../css/jquery-ui-1.9.2.custom.min.css" type="text/css"/>
<link rel="stylesheet" href="../../css/ui.jqgrid.css" type="text/css"/>
<link rel="stylesheet" href="../../css/jquery.datetimepicker.css" type="text/css"  />
<link rel="stylesheet" href="../../css/jquery.alerts.css" type="text/css" />

</head>
<body>
	<%@ include  file="../top.jsp"%>
	<div class="navlistsearch">
	<fieldset style="border:1px dashed #a3c0e8">
		<legend>查&nbsp;&nbsp;询</legend>
		<form id="applyMoney_search_form" class="search-div" method="post">
			<span>申请人账号：</span>
			<input type="text" id="applyAccount" name="applyAccount" class="nav-input" style="width:80px;"/>
			<span>申请时间：</span>
			<label for="search_applytime"></label>
			<input type="text" id="applyDate" name="applyDate" class="nav-timeslot" style="width:90px;" />
			<span>审核结果：</span>
			<input type="text" id="auditResult" name="auditResult" class="nav-input" style="width:80px;"/>
			<input type="button" id="search_btn" value="搜索" class="query-button"/>
			</form>	
	</fieldset>
	</div>
   <div class="con-table">
		<table id="exportAuditPass_jqgrid_data"></table>
		<div id="exportAuditPass_jqgrid_pager"></div>
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
<script type="text/javascript" src="../../script/audit/applyAuditPass.js"></script>
</body>
</html>