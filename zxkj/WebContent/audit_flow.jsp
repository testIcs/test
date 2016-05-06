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
		<header id="title" style="min-width:900px;width:100%;">提现审核</header>
		<div style="border:3px solid white;min-width:900px;">
		<div class="left" style="width:150px;height:100%;float:left;">
		<div class="lefttitle" style="color:white;background:blue;">操作</div>
			<ul style="line-height:30px;text-align:center;">
				<li>提现审核</li>
				<li>提现打印</li>
				<li style="background:url(images/accordion-header.gif) repeat-x;">历史提现</li>
				<li>付款记录</li>
			</ul>
		</div>
		<div class="right" style="width:700px;height:100%;float:left;border-left:1px solid red;">
		<div style="text-align: left;">
			<button>审核通过</button>
			<button>审核驳回</button>
		</div>
		<div style="clear: both;"></div>
		<table style="text-align: center; border: 1px solid grad;">
			<tr>
				<th width="190">提现金额</th>
				<th width="190">提现账号</th>
				<th width="290">申请时间</th>
				<th width="290">审核时间</th>
				<th width="190">审核人</th>
				<th width="190">审核状态</th>
			</tr>
			<tr>
				<td width="190">256.00</td>
				<td width="190">1234.alipay.com</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="190">zhangdan</td>
				<td width="190">通过</td>
			</tr>
			<tr>
				<td width="190">256.00</td>
				<td width="190">1234.alipay.com</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="190">zhangdan</td>
				<td width="190">通过</td>
			</tr>
			<tr>
				<td width="190">256.00</td>
				<td width="190">1234.alipay.com</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="190">zhangdan</td>
				<td width="190">通过</td>
			</tr>
			<tr>
				<td width="190">256.00</td>
				<td width="190">1234.alipay.com</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="190">zhangdan</td>
				<td width="190">通过</td>
			</tr>
			<tr>
				<td width="190">256.00</td>
				<td width="190">1234.alipay.com</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="190">zhangdan</td>
				<td width="190">通过</td>
			</tr>
			<tr>
				<td width="190">256.00</td>
				<td width="190">1234.alipay.com</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="190">zhangdan</td>
				<td width="190">通过</td>
			</tr>
			<tr>
				<td width="190">256.00</td>
				<td width="190">1234.alipay.com</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="190">zhangdan</td>
				<td width="190">通过</td>
			</tr>
			<tr>
				<td width="190">256.00</td>
				<td width="190">1234.alipay.com</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="190">zhangdan</td>
				<td width="190">通过</td>
			</tr>
			<tr>
				<td width="190">256.00</td>
				<td width="190">1234.alipay.com</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="290">1970-1-1 12:12:12</td>
				<td width="190">zhangdan</td>
				<td width="190">通过</td>
			</tr>
			<tr >
				<td colspan="5" width="800">上一页 下一页 首页 尾页</td>
			</tr>
		</table>
		</div>
		</div>
</body>
</html>