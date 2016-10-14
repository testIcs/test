<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta charset="utf-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<%@ include file="../include/header.jsp" %>
<style type="text/css">
.content {
    padding-bottom: 30px;
}
</style>
</head>
<body>
<div class="top">新增用户</div>
<div class="container">
	<form method="post" action="" id="register_form">
		<div class="aspNetHidden">
			<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="">
		</div>
		<section id="login">
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
			    	<input name="btnRegister" id="btnRegister" type="text" class="submit" value="新增"/>
			    </div>
			</div>
			
		</section>
	</form>
	<footer>
		<p>Copyright © 2014-2016 智与行科技</p>
	</footer>
</div>
</body>
<%@ include file="../include/footer.jsp" %>
<script type="text/javascript" src="../../script/adduser.js"></script>
<script type="text/javascript">
	$(function(){
		AddUserModule.init();
	})
</script>
</html>