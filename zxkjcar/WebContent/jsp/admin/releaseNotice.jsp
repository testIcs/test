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
<title>发布公告</title>
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
<div class="top">发布公告</div>
<div class="main" style="padding:50px 0 0 0">
	<textarea class="form-control" rows="10" placeholder="输入公告内容"></textarea>
	<div style="text-align: right;padding: 10px 20px 0 0;">
		<button id="releaseNotice" type="button" class="btn btn-default">开始注册</button>
	</div>
</div>
</body>
<%@ include file="../include/footer.jsp" %>
<script type="text/javascript">
var baseUrl= "${baseUrl}";
	$(function(){
		ReleaseNoticeModule.init();
	})
</script>
<script type="text/javascript" src="${baseUrl}/script/admin/releaseNotice.js"></script>
</html>