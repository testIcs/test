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
<title>预约管理</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta charset="utf-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${baseUrl}/css/jqpagination.css">
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
<div class="top">预约管理</div>
<div class="container-fluid">
  <table class="table">
    <thead>
        <tr>
          <th>预约人</th>
          <th>预约时间</th>
  	      <th>预约时间段</th>
  	      <th>预约数</th>
  	      <th>操作</th>
        </tr>
    </thead>
    <tbody>
  	  
    </tbody>
  </table>
  <div class="pagination">
    <a href="#" class="first" data-action="first">&laquo;</a>
    <a href="#" class="previous" data-action="previous">&lsaquo;</a>
    <input type="text" readonly="readonly" data-max-page="40" />
    <a href="#" class="next" data-action="next">&rsaquo;</a>
    <a href="#" class="last" data-action="last">&raquo;</a>
</div>
</div>
</body>
<%@ include file="../include/footer.jsp" %>
<script type="text/javascript" src="${baseUrl}/3th/jquery.jqpagination.min.js"></script>
<script type="text/javascript" src="${baseUrl}/script/admin/manageappointment.js"></script>
<script type="text/javascript">
	var baseUrl= "${baseUrl}";
	$(function(){
		ManagerAppointment.init();
	})
</script>
</html>