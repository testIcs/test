<%@ page contentType="text/html; charset=UTF-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", -10);	
%>
<style type="text/css">
a:link {
    font-size: 9pt;
    color: #0000cc;
    font-family: 宋体;
    text-align: left;
    TEXT-DECORATION:none;
}
a:visited {
    font-size: 9pt;
    color: #0000cc;
    font-family: 宋体;
    text-align: left;
    TEXT-DECORATION:none;
}
a:hover {
    font-size: 9pt;
    color: #993300;
    TEXT-DECORATION:none;
}
a:active {
    font-size: 9pt;
    color: #ff0033;
    text-decoration: none;
}
dt{
    font-size:12px;
    font-weight:bold;
}
*{
    font-size:12px;
}
th >div{
    font-weight:bold !important;
}
table thead tr{
   background:url(${baseUrl}/images/accordion-header.gif) repeat-x center;
}
span.ui-icon-asc{
	top:25px;
}
span.ui-icon-desc{
	top:8px;
}
</style>

<div class="left" style="width: 120px; height: 100%; float: left;margin-right:-1px;border-right:1px solid #a3c0e8;">
	<dl style="line-height: 30px; text-align: left;">
		<dt style="background:url(${baseUrl}/images/top1.jpg) repeat-x;color:white;padding-left:10px;">提现审核</dt>
		<dd id="applyMoneyAudit"><a href="${baseUrl }/jsp/audit/applyMoneyAudit.jsp">待审核</a></dd>
		<dd id="applyMoneyHistory"><a href="${baseUrl }/jsp/applyMoneyHistory.jsp">已审核</a></dd>
		<dt style="background:url(${baseUrl}/images/top1.jpg) repeat-x;color:white;padding-left:10px;">付款</dt>
		<dd id="payFlowRecord_no_pay"><a href="${baseUrl }/jsp/payFlowRecord_no_pay.jsp">待付款</a></dd>
		<dd id="payFlowRecord_success"><a href="${baseUrl }/jsp/payFlowRecord_success.jsp">已付款</a></dd>
		<dd id="payFlowRecord_fail"><a href="${baseUrl }/jsp/payFlowRecord_fail.jsp">付款失败</a></dd>		
	</dl>
</div>

<script type="text/javascript">
//获取当前页面的jsp名称
var index_ = window.location.toString().lastIndexOf('/');
var pname = window.location.toString().substring(index_+1)
var p_index = pname.lastIndexOf('.');
var p = pname.substring(0,p_index);
//根据页面名称设置选定的样式
document.getElementById(p).style.cssText="background:url(${baseUrl}/images/collapse_arrow.png) no-repeat right";

</script>