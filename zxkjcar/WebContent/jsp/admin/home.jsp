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
	<div class="container-fluid" id="test">
		<ul class="mainmenu" style="padding:20px 0 0 0">
			<li id="registerAudit" name="appointment"><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb01.png" /></b><span>注册审核</span></a></li>
			<li id="userManager" name="loginphone"><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb02.png" /></b><span>人员管理</span></a></li>
			<li id="queryPeopleApp" name="queryPeopleApp"><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb03.png" /></b><span>预约信息</span></a></li>
			<li id="appointmentManager" name="appointmentManager"><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb04.png" /></b><span>预约管理</span></a></li>  
			<li id="addUser" name="bookinghall" ><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb02.png" /></b><span>新增用户</span></a></li>
			<li id="releaseNotice" name="register_index"><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb08.png" /></b><span>发布公告</span></a></li>
			<li id="appointSetting" name="appoint_setting"><a href="javaScript:void('0')" ><b><img src="${baseUrl}/css/images/tb07.png" /></b><span>预约设置</span></a></li>  
			 	 
		</ul>
	</div>
	<%@ include file="../include/footer.jsp" %>
	<script type="text/javascript" src="${baseUrl}/script/admin/home.js"></script>
	<script type="text/javascript">
	$(function(){
		AdminHomeModule.init(baseUrl);
	})
	</script>
</body>
</html>