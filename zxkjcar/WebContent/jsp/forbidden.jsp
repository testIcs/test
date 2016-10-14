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
<title>403</title>
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
<div class="top">出错了</div>
<div class="main">
	<ul class="linkblock">
    	<li>没有访问该地址的权限</li>
    </ul>
</div>
</body>
</html>