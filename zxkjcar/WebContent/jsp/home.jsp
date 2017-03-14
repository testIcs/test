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
<title>首页</title>
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
</head>
<body>
	<div class="top">便民在线预约系统</div>
	<div class="container-fluid">
		<ul class="mainmenu mh400">
			<li id="loginphone" name="loginphone"><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb01.png" /></b><span>会员登录</span></a></li>
			<li id="register_index" name="register_index"><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb02.png" /></b><span>会员注册</span></a></li>
			<li id="bookinghall" name="bookinghall"><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb03.png" /></b><span>预约大厅</span></a></li>
			<li id="noticeHistory" name="noticeHistory"><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb04.png" /></b><span>往期公告</span></a></li>   	 
		</ul>
	</div>
	<%@ include file="include/footer.jsp" %>
	<script type="text/javascript" src="../script/common.js"></script>
	<script type="text/javascript" src="../script/home.js"></script>
	<script type="text/javascript">
		$(function(){
			var baseUrl= "${baseUrl}";
			HomeModule.init(
		    {
		    	'status':'${param.status}',
		    	'baseUrl':baseUrl
		    });
		});
	</script>
</body>
</html>