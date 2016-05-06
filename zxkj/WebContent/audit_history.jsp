<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提现审核</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta charset="utf-8">

<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>

</head>
<body>
	<form id="formAudit" action="" method="post">
		<header id="title" style="min-width:900px;width:100%;">付款记录</header>
		<div style="border:3px solid white;min-width:900px;">
		<div class="left" style="width:150px;height:100%;float:left;">
		<div class="lefttitle" style="color:white;background:blue;">操作</div>
			<ul style="line-height:30px;text-align:center;">
				<li>提现审核</li>
				<li>提现打印</li>
				<li>历史提现</li>
				<li style="background:gray;">付款记录</li>
			</ul>
		</div>
		<div class="right" style="width:700px;height:100%;float:left;border-left:1px solid red;">
		<div style="text-align: left;">
		<div style="clear: both;"></div>
		<table style="text-align: center; border: 1px solid grad;">
			<tr>
				<th width="290">业务流水</th>
				<th width="190">支付流水</th>
				<th width="290">支付时间</th>
				<th width="290">支付状态</th>
				<th width="190">支付账号</th>
			</tr>
			<tr>
				<td width="290">tx-8900222-9000-2212</td>
				<td width="190">py-uuid-1111</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">成功</td>
				<td width="190">chinasoft.alipay.com</td>
			</tr>
			<tr>
				<td width="190">tx-8900222-9000-2212</td>
				<td width="190">py-uuid-1111</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">成功</td>
				<td width="190">chinasoft.alipay.com</td>
			</tr>
			<tr>
				<td width="290">tx-8900222-9000-2212</td>
				<td width="190">py-uuid-1111</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">成功</td>
				<td width="190">chinasoft.alipay.com</td>
			</tr>
			<tr>
				<td width="290">tx-8900222-9000-2212</td>
				<td width="190">py-uuid-1111</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">成功</td>
				<td width="190">chinasoft.alipay.com</td>
			</tr>
			<tr>
				<td width="290">tx-8900222-9000-2212</td>
				<td width="190">py-uuid-1111</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">成功</td>
				<td width="190">chinasoft.alipay.com</td>
			</tr>
			<tr>
				<td width="290">tx-8900222-9000-2212</td>
				<td width="190">py-uuid-1111</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">成功</td>
				<td width="190">chinasoft.alipay.com</td>
			</tr>
			<tr>
				<td width="290">tx-8900222-9000-2212</td>
				<td width="190">py-uuid-1111</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">成功</td>
				<td width="190">chinasoft.alipay.com</td>
			</tr>
			<tr>
				<td width="290">tx-8900222-9000-2212</td>
				<td width="190">py-uuid-1111</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">成功</td>
				<td width="190">chinasoft.alipay.com</td>
			</tr>
			<tr>
				<td width="290">tx-8900222-9000-2212</td>
				<td width="190">py-uuid-1111</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">成功</td>
				<td width="190">chinasoft.alipay.com</td>
			</tr>
			<tr >
				<td colspan="5" width="800">上一页 下一页 首页 尾页</td>
			</tr>
		</table>
		</div>
		</div>
</body>
</html>