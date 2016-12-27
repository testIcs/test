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

<link href="../css/DefaultSkin.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="top">便民在线预约系统</div>
<div class="main">
	<ul class="linkblock">
    	<li id="loginphone" name="loginphone" class="a">会员登录</li>
    	<li id="register_index" name="register_index" class="b">会员注册</li>
    	<!--  li id="appointment" name="appointment" class="c">申请预约</li>-->
    	<li id="bookinghall" name="bookinghall" class="d">预约大厅</li>
    </ul>
</div>
</body>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script type="text/javascript" src="../3th/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="../3th/jquery.alerts.js"></script>

<script type="text/javascript" src="../script/common.js"></script>
<script type="text/javascript" src="../script/home.js"></script>
<script type="text/javascript">
	$(function()
	{
		HomeModule.init(
	    {
	    	'status':'${param.status}'
	    });
	});
</script>
</html>