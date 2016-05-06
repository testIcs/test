<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>历史提现记录(已审核)</title>
<link rel="stylesheet" href="../css/jquery-ui-1.9.2.custom.min.css" type="text/css"/>
<link rel="stylesheet" href="../css/ui.jqgrid.css" type="text/css"/>
<link rel="stylesheet" href="../css/jquery.alerts.css" type="text/css" />
<link rel="stylesheet" href="../css/jquery.datetimepicker.css" type="text/css"  />
<style type="text/css">

</style>
</head>
<body>
	<%@ include  file="./top.jsp"%>
	<div style="border: 3px solid white; min-width: 900px;">
		<%@ include  file="./left.jsp"%>
		<div class="right"
			style="width: 700px; height: 100%; float: left; border-left: 1px solid #a3c0e8;">
	<div>
	<div style="width:900px;padding-left:10px;">
	<fieldset style="border:1px dashed #a3c0e8">
	<legend>查&nbsp;&nbsp;询</legend>
	<form id="searchForm" action="">
		申请日期从:<input type="text" id="applyStartDate"  style="width: 80px;" />
		到:<input type="text" id="applyEndDate"  style="width: 80px;" />
		姓名:<input type="text" id="realName"  style="width: 80px;" />
		提现账号:<input type="text" id="account"  style="width: 80px;" />
		<button id="queryBtn" type="button" onclick="queryData();">查询</button>
		<button id="resetBtn" type="button" onclick="resetData();">重置</button>
	</form>
	</div>
	</div>
    <div class="con-table">
		<table id="applyHistory_jqgrid_data"></table>
		<div id="applyHistory_jqgrid_pager"></div>
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
<script type="text/javascript" src="../script/page_commonUtil.js"></script>
<script type="text/javascript" src="../script/applyMoneyHistory.js"></script>
</body>
</html>