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
<link href="../css/DefaultSkin.css" rel="stylesheet" type="text/css">
<link href="../css/datepicktercss/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/jquery.alerts.css">
</head>
<body>
	<form id="bookingHall"  method="post">
		<section id="bookingHall">
			<div class="top">便民在线预约系统</div>
				<div class="content">
					<div class="title"><span>预约人信息</span></div>
				    <div class="table">
				    	<ul id="main-menus" class="days">
				        	<li id="MENU_1" class="day-block sel">
				        		<span id="day_1">周一</span><br /><span id="date_1">2016年8月1日</span>
				        	</li>
				        </ul>
				        <table id="appoint_people_table" width="100%" border="0" cellspacing="0" cellpadding="0"></table>
				    </div>
				</div>
		</section>
	</form>
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
<script type="text/javascript" src="../script/appoint_people.js"></script>
<script type="text/javascript">
	$(function()
	{
		AppointPeople.init(
		{
			'appDate':'${param.appDate}'
		});
		
	});
</script>
</html>