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
<title>后台首页</title>
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
</head>
<body>
<div class="top">便民在线预约后台管理</div>
<div class="main">
	<ul class="linkblock">
    	<li id="registerAudit" name="appointment" class="d">注册审核</li>
    	<li id="userManager" name="loginphone" class="a">人员管理</li>
    	<li id="addUser" name="bookinghall" class="c">新增用户</li>
    	<li id="releaseNotice" name="register_index" class="b">发布公告</li>
    </ul>
</div>
</body>
<%@ include file="../include/footer.jsp" %>
<script type="text/javascript" src="${baseUrl}/script/admin/home.js"></script>
<script type="text/javascript">
$(function(){
	var baseUrl= "${baseUrl}";
	AdminHomeModule.init(baseUrl);
})
</script>
</html>