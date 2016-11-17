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
<title>预约大厅</title>
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
<style type="text/css">
	.notice{
		position: fixed;
		bottom: 0;
		display: block;
		background: rgba(0,0,0,0.69);
		width: 100%;
		color: #ffc600;
		height: 40px;
    	line-height: 40px;
	}
</style>
</head>
<body>
	<form id="bookingHall"  method="post">
		<section id="bookingHall">
			<div class="top">便民在线预约系统</div>
				<div class="content">
					<div class="title"><span>预约大厅</span><span id="appointment_detail" style="cursor:pointer;">查看预约</span></div>
				    <div class="table">
				    	<ul id="main-menus" class="days">
				        	<li id="MENU_1" class="day-block sel"><span id="day_1">周一</span><br /><span id="date_1">2016年8月1日</span></li>
				        	<!-- <li id="MENU_2" class="day-block"><span id="day_2">周二</span><br /><span id="date_2">2016年8月2日</span></li> -->
				        	<li id="MENU_3" class="day-block"><span id="day_3">周三</span><br /><span id="date_3">2016年8月3日</span></li>
				        	<li id="MENU_4" class="day-block"><span id="day_4">周四</span><br /><span id="date_4">2016年8月4日</span></li>
				        	<li id="MENU_5" class="day-block"><span id="day_5">周五</span><br /><span id="date_5">2016年8月5日</span></li>
				        </ul>
				        <table width="100%" border="0" cellspacing="0" cellpadding="0">
				          <tr>
				            <td>时间</td>
				            <td>状态</td>
				            <td>操作</td>
				          </tr>
				          <tr>
				            <td>9:30-10:00</td>
				            <td><img id="td_1_img" src="../css/images/green.png" width="18" height="19" /></td>
				            <td id="td_1_value"><a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="1">可申请</a></td>
				          </tr>
				          <tr>
				            <td>10:00-10:30</td>
				            <td><img id="td_2_img" src="../css/images/green.png" width="18" height="19" /></td>
				            <td id="td_2_value"><a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="2">可申请</a></td>
				          </tr>
				          <tr>
				            <td>10:30-11:00</td>
				            <td><img id="td_3_img" src="../css/images/green.png" width="18" height="19" /></td>
				            <td id="td_3_value"><a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="3">可申请</a></td>
				          </tr>
				          <tr>
				            <td>11:00-11:30</td>
				            <td><img id="td_4_img" src="../css/images/green.png" width="18" height="19" /></td>
				            <td id="td_4_value"><a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="4">可申请</a></td>
				          </tr>
				          <tr>
				            <td>11:30-12:00</td>
				            <td><img  id="td_5_img" src="../css/images/green.png" width="18" height="19" /></td>
				            <td id="td_5_value"><a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="5">可申请</a></td>
				          </tr>
				          <tr>
				            <td>14:30-15:00</td>
				            <td><img id="td_6_img" src="../css/images/green.png" alt="" width="18" height="19" /></td>
				            <td id="td_6_value"><a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="6">可申请</a></td>
				          </tr>
				          <tr>
				            <td>15:00-15:30</td>
				            <td><img id="td_7_img" src="../css/images/green.png" alt="" width="18" height="19" /></td>
				            <td id="td_7_value"><a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="7">可申请</a></td>
				          </tr>
				          <tr>
				            <td>15:30-16:00</td>
				            <td><img id="td_8_img" src="../css/images/green.png" alt="" width="18" height="19" /></td>
				            <td id="td_8_value"><a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="8">可申请</a></td>
				          </tr>
				          <tr>
				            <td>16:00-16:30</td>
				            <td><img id="td_9_img" src="../css/images/green.png" alt="" width="18" height="19" /></td>
				            <td id="td_9_value"><a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="9">可申请</a></td>
				          </tr>
				           <tr>
				            <td>16:30-17:00</td>
				            <td><img id="td_10_img" src="../css/images/green.png" alt="" width="18" height="19" /></td>
				            <td id="td_10_value"><a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="10">可申请</a></td>
				          </tr>
				        </table>
				    </div>
				</div>
		</section>
	</form>
	<footer>
<!-- 		<p> -->
<!-- 			<a href="#">电脑版</a> |<a href="#" target="_blank">客户端</a> |<a href="#">Test</a> -->
<!-- 		</p> -->
		<p></p>
		<p>Copyright © 2014-2015 智与行科技</p>
	</footer>
</body>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script type="text/javascript" src="../3th/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="../3th/jquery.alerts.js"></script>

<script type="text/javascript" src="../script/common.js"></script>
<script type="text/javascript" src="../script/bookinghall.js"></script>
</html>