<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html lang="zh-CN">
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
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrapValidator.min.css">
<link href="../css/DefaultSkin.css" rel="stylesheet" type="text/css">
<style type="text/css">
</style>
</head>
<body>
	<div class="aspNetHidden">
		<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="">
	</div>
	<section id="login">
		<div class="top">会员注册</div>
	</section>
	<div class="container-fluid">
	  	<form class="form-horizontal" role="form">
	  		 <div class="form-group">
			    <label for="phoneNo" class="col-sm-2 control-label">手机号</label>
			    <div class="col-sm-6">
			    	<input type="text" class="form-control" id="phoneNo" name="phoneNo" data-bv-remote-name="phoneNo" placeholder="请输入手机号">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="txtpwd" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-10">
			    	<input type="password" class="form-control" id="txtpwd" name="txtpwd" placeholder="请输入密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-10">
			    	<input type="password" class="form-control" id="txtpwd1" name="txtpwd1" placeholder="请输入确认密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="userName" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-10">
			    	<input type="text" class="form-control" id="userName" name="userName" data-bv-remote-name="userName"  placeholder="请输入姓名" >
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="idNumber" class="col-sm-2 control-label">身份号</label>
			    <div class="col-sm-6">
			    	<input type="text" class="form-control" id="idNumber" name="idNumber" data-bv-remote-name="phoneNo" placeholder="请输身份号">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="descrip" class="col-sm-2 control-label">备注</label>
			    <div class="col-sm-6">
			    	<textarea class="form-control" rows="3" id="descrip" name="descrip"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10" style="text-align: center;">
			     	<button type="submit" id="registerbtn" class="btn btn-primary">立即注册</button>
			    </div>
			  </div>
		</form>
	</div>
	<footer>
<!-- 		<p> -->
<!-- 			<a href="#">电脑版</a> |<a href="#" target="_blank">客户端</a> |<a href="#">Test</a> -->
<!-- 		</p> -->
<!-- 		<p></p> -->
		<p>Copyright © 2014-2015 智与行科技</p>
	</footer>
</body>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script type="text/javascript" src="../3th/jquery.alerts.js"></script>
<script type="text/javascript" src="../3th/bootstrap.min.js"></script>
<script type="text/javascript" src="../3th/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="../script/register_index.js"></script>
</html>