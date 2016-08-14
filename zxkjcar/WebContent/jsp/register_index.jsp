<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0058)http://www.17sucai.com/preview/1/2015-04-12/356/index.html -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<title>注册</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="ccess-Control-Allow-Origin" content="*">
<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<!-- <link rel="stylesheet" type="text/css" href="../css/global.css"> -->
<script type="text/javascript" src="../3th/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="../3th/jquery.alerts.js"></script>
<script type="text/javascript" src="../script/register_index.js"></script>

<link href="../css/DefaultSkin.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/jquery.alerts.css">
<style type="text/css">
</style>
</head>
<body>
	<div>
		<form method="post" action="" id="register_form">
			<div class="aspNetHidden">
				<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="">
			</div>
			<section id="login">
				<div class="top">会员注册</div>
				<div class="content">
				    <div class="nametag">账号</div>
				    <div class="inputtag">
				    	<input id="userName" name=userName type="text"  placeholder="请输入账号" /><span>*</span>
				    </div>
				    <div class="nametag">密码</div>
				    <div class="inputtag">
				    	<input id="txtpwd" name="txtpwd" type="password" placeholder="请输入密码" /><span>*</span>
				    </div>
				    <div class="nametag">确认密码</div>
				    <div class="inputtag">
				    	<input id="txtpwd1" name="txtpwd1" type="password" placeholder="请输入密码" /><span>*</span>
				    </div>
				    <div class="nametag">身份证号</div>
				    <div class="inputtag">
				    	<input  id="idNumber" name="idNumber" type="text" placeholder="请输入身份证号" /><span>*</span></div>
				    <div class="nametag">手机号</div>
				    <div class="inputtag">
				    	<input  id="phoneNo" name="phoneNo"  type="text" placeholder="请输入手机号" /><span>*</span>
				    </div>
				    <div class="nametag">备注</div>
				    <div class="inputtag">
				    	<input id="descrip" name="descrip" type="text" /><span>*</span>
				    </div>
				    <div class="inputtag">
				    	<input name="btnRegister" id="btnRegister" type="text" class="submit" value="注册" style="cursor:pointer;"/>
				    </div>
				</div>
				
			</section>
		</form>
	</div>
	<footer>
		<footer>
		<p>
			<a href="#">电脑版</a> |<a href="#" target="_blank">客户端</a> |<a href="#">Test</a>
		</p>
		<p></p>
		<p>Copyright © 2014-2015 智与行科技</p>
	</footer>
</body>
</html>