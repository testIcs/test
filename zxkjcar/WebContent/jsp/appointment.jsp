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
<!-- <link rel="stylesheet" type="text/css" href="../css/global.css"> -->
<link href="../css/DefaultSkin.css" rel="stylesheet" type="text/css">
<link href="../css/datepicktercss/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/jquery.alerts.css">
<body>
	<form id="appointMentCommit"  method="post">
		<header id="title">
			<div class="back"></div>预约
		</header>
		<div id="bugCue" class="cue"></div>
		<section id="bugCommit">
			<div class="content">
				<div class="title"><span>申请预约</span></div>
			    <div id="user_status_prompt" class="tips"></div>
			    <div class="nametag">预约人姓名</div>
			    <div class="inputtag">
			    	<input id="appUserName" name="appUserName" type="text" placeholder="请输入姓名" /><span>*</span>
			    </div>
			    <div class="nametag">预约人电话</div>
			    <div class="inputtag">
			    	<input id="appPhoneNo" name="appPhoneNo" type="text" placeholder="请输入电话" /><span>*</span>
			    </div>
			    <div class="nametag">预约事务数量</div>
			    <div class="inputtag">
			    	<input id="appAffair" name="appAffair" type="text" placeholder="请输入数量" /><span>*</span>
			    </div>
			    <div class="nametag">预约日期</div>
			    <div class="inputtag">
			    	<input name="appDate" id="appDate" /><span>*</span>
			    </div>
			    <div class="nametag">预约时间</div>
			    <div class="inputtag">
			    	<select name="appTimeSlotValue" id="appTimeSlotValue"><option value="0"></option></select><span>*</span>
			    </div>
			    <div class="inputtag">
			    	<input name="appointmentSubmit" id="appointment_submit" type="text" class="submit" value="提交" 
			    			style="cursor:pointer;"/>
			    </div>
			</div>
		</section>
	</form>
	</div>
	<div id="datePlugin"></div>
	<footer>
		<p>
			<a href="#">电脑版</a> |<a href="#" target="_blank">客户端</a> |<a href="#">Test</a>
		</p>
		<p></p>
		<p>Copyright © 2014-2015 智与行科技</p>
	</footer>
</body>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script type="text/javascript" src="../3th/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="../3th/jquery.alerts.js"></script>
<script type="text/javascript" src="../3th/datepickter/date.js" ></script>
<script type="text/javascript" src="../3th/datepickter/iscroll.js" ></script>
<script type="text/javascript" src="../script/util_manage/validateUtil.js" ></script>
<script type="text/javascript" src="../script/appointment.js"></script>
<script type="text/javascript" src="../script/common.js"></script>
</head>
<script type="text/javascript">
$(function()
{
	$('#appDate').date();
	
	Appointment.init(
    {
    	'status':'${param.status}'
    });
});
</script>
</html>