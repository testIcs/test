<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核用户</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta charset="utf-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<%@ include file="../include/header.jsp" %>
<style type="text/css">
	.table td {
    	text-align: left;
    	border-right: none;
	}
	
	.container-fluid button{
		margin:10px 0 0 0;
	}
	.table td button{
		margin:0 5px 0 0 ;
	}
</style>
</head>
<body>
<div class="top">注册人员审核</div>
<div class="container-fluid">
  <button id="addUser" class="btn btn-primary">增加用户</button>
  <table class="table">
    <thead>
        <tr>
          <th>姓名</th>
  	      <th>手机号</th>
  	      <th>操作</th>
        </tr>
    </thead>
    <tbody>
  	  
    </tbody>
  </table>
</div>
</body>
<%@ include file="../include/footer.jsp" %>
<script type="text/javascript" src="../../script/audituser.js"></script>
<script type="text/javascript">
	$(function(){
		AuditUserModule.init();
	})
</script>
</html>