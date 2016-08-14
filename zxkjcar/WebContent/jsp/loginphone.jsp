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
<title>会员登录</title>
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
<!-- <script type="text/javascript" src="../script/login.js"></script> -->
<link href="../css/DefaultSkin.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/jquery.alerts.css">
<style type="text/css">
#realNameHref a {
	color: #2576db;
	display: block;
	float: right;
	padding: 0 0.4em;
}
</style>
</head>
<body>
	<div>
		<form method="post" action="" id="form1">
			<section id="login">
				<div class="top">会员登录</div>
				<div class="content">
				    <div class="nametag">账号</div>
				    <div class="inputtag">
				    	<input name="userName" type="text" id="userName" placeholder="请输入用户名"  /><span>*</span>
				    </div>
				    <div class="nametag">密码</div>
				    <div class="inputtag">
				    	<input id="password" name="password" type="password" placeholder="请输入密码" /><span>*</span>
				    </div>
				    <div class="inputtag">
				    	<input name="btnLogin" id="btnLogin" type="text" class="submit" value="登录" href="#" style="cursor:pointer;"/>
				    </div>
				    <div class="inputtag" style="text-align:right; color:#900000; font-size:14px; line-height:30px; 
				    		margin-top:20px;"><a  id="btnRegister"  href="#">免费注册</a>
				    </div>
				</div>
<!-- 				<header id="title">会员登录 </header> -->
<!-- 				<span id="loginUserCue" class="logCue" style="display: none;"></span> -->
<!-- 				<div> -->
<!-- 					<span> <img src="../images/icon_user.png" width="24" -->
<!-- 						height="24" alt="用户名图标"></span> <input type="text" id="userName" -->
<!-- 						name="userName" placeholder="请输入用户名" /> -->
<!-- 				</div> -->
<!-- 				<div class="passdiv" id="passdiv"> -->
<!-- 					<span> <img src="../images/icon_password.png" width="24" -->
<!-- 						height="24" alt="密码图标"></span> <input id="password" name="password" -->
<!-- 						class="txtpwd" type="password" placeholder="请输入密码" /> -->
<!-- 				</div> -->
<!-- 				<input type="hidden" name="openid" value=""> <a -->
<!-- 					id="btnLogin" class="btnLogin" href="#">登录</a> <a href="#" -->
<!-- 					class="btnRegister" id="btnRegister">注册</a> -->
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
<!-- <link rel="stylesheet" type="text/css" href="../css/global.css"> -->
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script type="text/javascript" src="../3th/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="../3th/jquery.alerts.js"></script>
<script type="text/javascript" src="../script/login.js"></script>
</html>