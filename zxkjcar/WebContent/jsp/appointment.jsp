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
<body>
	<div class="top">申请预约</div>
	<div class="container-fluid" style="padding-top:20px;">
		<form>
			<div class="form-group">
		    	<label for="appAffair"><span style="color: #F00;margin-right: 10px;">*</span>预约事务数量</label>
		    	<input type="number" class="form-control" id="appAffair" placeholder="预约事务数量">
		    </div>
		    <div class="form-group">
		    	<label for="appDate"><span style="color: #F00;margin-right: 10px;">*</span>预约日期</label>
		    	<input type="datetime" id="appDate" value="${param.day }" class="form-control" id="appdate" disabled>
		    </div>
		    <div class="form-group">
		    	<label for="appTimeSlotValue"><span style="color: #F00;margin-right: 10px;">*</span>预约时间</label>
		    	<select class="form-control" name="appTimeSlotValue" id="appTimeSlotValue"><option value="0"></option></select>
		    </div>
		    <div class="form-group">
		    	<button type="button" id="appointment_submit" class="btn btn-primary" style="width:100%">提交</button>
		    </div>
		</form>
	</div>
	<%@ include file="include/footer.jsp" %>
	<script type="text/javascript" src="../script/common.js"></script>
	<script type="text/javascript" src="../script/appointment.js"></script>
	<script type="text/javascript">
	$(function()
	{
		Appointment.init(
	    {
	    	'status':'${param.status}',
	    	'selectsort' : "${param.sort}"//从预约大厅选择的时间段
	    });
	});
	</script>
</body>
</html>