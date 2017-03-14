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
<%@ include file="include/header.jsp" %>
<link href="../css/datepicktercss/common.css" rel="stylesheet" type="text/css">
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
	.modal{
		top: 30%;
	}
	#noticeModalBody{
		text-indent: 25px;
		line-height: 25px;
	}
</style>
</head>
<body>
	<form id="bookingHall"  method="post">
		<section id="bookingHall">
			<div class="top">预约大厅</div>
				<div class="content">
					<div class="title"><span id="appointment_detail" style="color:#2365c4;text-decoration: underline;">查看预约</span></div>
				    <div class="table">
				    	<ul id="main-menus" class="days"></ul>
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
	<!-- 消息通知模态框 -->
	<div class="modal fade" id="noticeModal" tabindex="-1" role="dialog" aria-labelledby="noticeModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title text-center" id="noticeModalLabel"><strong>公告通知</strong></h4>
	      </div>
	      <div class="modal-body" id="noticeModalBody"></div>
	      <div class="modal-footer" style="text-align:center">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	      </div>
	    </div>
  	 </div>
    </div>
	<%@ include file="include/footer.jsp" %>
	<script type="text/javascript" src="../script/bookinghall.js"></script>
</body>
</html>