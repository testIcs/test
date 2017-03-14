<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<title>会员登录</title>
<meta name="ccess-Control-Allow-Origin" content="*">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<%@ include file="include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${baseUrl}/css/login.css">
</head>
<body>
	<div class="container-fluid">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal">
                    <div class="thumbur">
					    <div class="icon-lock"></div>
					</div>
                    <span class="heading">用户登录</span>
                    <div class="form-group">
                        <input type="text" class="form-control" id="phoneNo" placeholder="手机号">
                        <i class="glyphicon glyphicon-user"></i>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" placeholder="密　码">
                        <i class="glyphicon glyphicon-lock"></i>
                    </div>
                    <div class="alert alert-danger errorMsg" role="alert">
					  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
					  <span class="sr-only">Error:</span>
					  <span id="errorMsg"></span>
					</div>
                    <div class="form-group">
                        <button type="button" id="btnLogin" class="btn btn-primary">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
	<%@ include file="include/footer.jsp" %>
	<script type="text/javascript" src="../script/login.js"></script>
</body>
</html>