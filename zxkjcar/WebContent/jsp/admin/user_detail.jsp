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
<title>用户详情</title>
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
<style type="text/css">
	.lh40{
		height: 30px;
		line-height: 30px;
	}
</style>
</head>
<body>
	<div class="aspNetHidden">
		<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="">
	</div>
	<section id="login">
		<div class="top">用户信息</div>
	</section>
	<div class="container-fluid">
	  <div class="row lh40">
		  <div class="col-xs-4 text-right">姓名：</div>
		  <div class="col-xs-8">${user.userName}</div>
	  </div>
	  <div class="row lh40">
		  <div class="col-xs-4 text-right">手机号：</div>
		  <div class="col-xs-8">${user.phoneNo}</div>
	  </div>
	  <div class="row lh40">
		  <div class="col-xs-4 text-right">身份号：</div>
		  <div class="col-xs-8 ">${user.idNumber}</div>
	  </div>
	  <div class="row lh40">
		  <div class="col-xs-4 text-right">备注：</div>
		  <div class="col-xs-8">${user.descrip}</div>
	  </div>
	  <div class="row lh40">
		  <div class="col-xs-12 text-center" style="padding:30px 0 0 0"><a href="${baseUrl}/jsp/admin/manageuser.jsp"><button type="button" class="btn btn-success">返回</button></a></div>
	  </div>
	</div>
</body>
</html>