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
<title>注册协议</title>
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
<style type="text/css">
	.main{
		    position: static;
		    margin: -14px 0 0 0;
	}
	.main p{
		font-size: .9em;
		text-indent: 26px;
		line-height: 25px;
		color: #5a5a5a;
		font-family: Microsoft Yahei;
	}
	
	.red{
		color:#d91c1c
	}
	
	.btn{
		display: block;
	    height: 30px;
	    line-height: 30px;
	    font-size: 1em;
	    color: #fff;
    	background: #1abd9b;
    	border-radius: 3px;
    	padding: 0 1em;
    	text-align: center;
    	border: 0;
    	box-sizing: border-box;
    	margin: 1em 0 ;
	}
</style>
</head>
<body>
<div class="top">使用说明</div>
<div class="main">
	<p>本产品为减少排队带来的时间损耗、路途损耗、精力损耗为基础的前提下开发而成。个人使用需按照使用说明要求进行注册使用，否则后台有权删除其账号。</p>
	<p class="red">1.注册账号名称必须为本人姓名。</p>
	<p>2.身份证号码、联系电话真实有效。</p>
	<p>3.<span class="red">备注</span>内填写备案成功且在有效期之内的金融机构名称。如：大众金融、陕西信合等简称即可。一人备案多家金融机构均需完整填写，以方便后台工作人员审核。</p>
	<p>4.管理员审批通过后方可进行正常预约。</p>
	<p>5.预约大厅可查看空白预约时段，每时段预约数量限定为：<span class="red">50</span>。</p>
	<p>6.单人单次可预约数量：<span class="red">30</span>。</p>
	<p>7.初步拟定<span class="red">每周四中午12:00</span>开放预约窗口。</p>
	<p>8.本产品如发现用户有任何违规操作行为，可删除其账号并不再提供使用权限</p>
	<div style="font-size: .8em;width: 125px;margin: 0 auto;">
		<input type="checkbox" checked="checked">我已阅读，并接受</input><br/>
		<a href="register_index.jsp" class="btn">去注册</a>
	</div>
</div>
</body>
</html>