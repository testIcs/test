<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta charset="utf-8">

<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<%@ include file="include/header.jsp" %>
<link href="../css/datepicktercss/common.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="top">预约人信息查询</div>
	<div class="container-fluid pt20 pb10">
		<div class="row">
			<div class="col-xs-3 h34 pr0 text-right">查询日期</div>
			<div class="col-xs-6 pr0">
				<input type="text" class="form-control" name="appDatePeo" id="appDatePeo" placeholder="选择日期">
			</div>
			<div class="col-xs-3">
				<button type="button" id="serach" class="btn btn-primary">查询</button>
			</div>
		</div>
		<div class="table-responsive">
		  <table id="appoint_people_table" class="table"></table>
		</div>
		<div id="datePlugin"></div>
	</div>
	<%@ include file="include/footer.jsp" %>
	<script type="text/javascript" src="../script/appoint_people.js"></script>
	<script type="text/javascript" src="../3th/datepickter/date.js" ></script>
	<script type="text/javascript" src="../3th/datepickter/iscroll.js" ></script>
	<script type="text/javascript">
	$(function()
	{
		$('#appDatePeo').date();
		AppointPeople.init(
	    {
	    	'appDatePeo':'${param.appDate}'
	    });
	});
	</script>
</body>
</html>