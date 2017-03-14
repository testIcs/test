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
<title>系统配置</title>
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
<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${baseUrl}/css/bootstrap-switch.min.css">
<style type="text/css">
	.h34{
		height:34px;
		line-height: 34px;
	}
</style>
</head>
<body>
	<div class="top">发布公告</div>
	<div class="container-fluid">
	  <div class="row">
	  	<div class="col-xs-12"><h5><span class="glyphicon glyphicon-eye-open"></span>  开启后会在预约大厅显示，否则隐藏</h5></div>
	  </div>
	  <!-- 预约通道设置(预约大厅是否可以显示) -->
	  <div id="pass_setting"></div>
	  
	  <div class="row">
	  	<div class="col-xs-12"><h5><span class="glyphicon glyphicon-wrench"></span>  哪一天可进行预约操作，例如周三进行预约操作</h5></div>
	  </div>
	  <!-- 预约操作设置(哪一天可进行预约操作) -->
	  <div id="operate_setting"></div>
	  
	  <div class="row">
	  	<div class="col-xs-12"><h5><span class="glyphicon glyphicon-pencil"></span>  可预约哪一天，例如可预约除周三外的</h5></div>
	  </div>
	  <!-- 预约通道设置(预约大厅是否可以显示) -->
	  <div id="allow_setting"></div>
	</div>
	<%@ include file="../include/footer.jsp" %>
	<script type="text/javascript" src="${baseUrl}/3th/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="${baseUrl}/script/admin/system_config.js"></script>
	<script type="text/javascript">
	var baseUrl= "${baseUrl}";
		$(function(){
			SystemConfigModule.init();
		})
	</script>
</body>
</html>