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
<title>用户管理</title>
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
.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th{
	padding: 8px 1px;
}
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
	<div class="top">人员管理</div>
	<div class="container-fluid">
	  <table class="table">
	    <thead>
	        <tr>
	          <th>姓名</th>
	  	      <th>手机号</th>
	  	      <th>操作</th>
	        </tr>
	    </thead>
	    <tbody></tbody>
	  </table>
	  <div class="pagination">
	    <a href="#" class="first" data-action="first">&laquo;</a>
	    <a href="#" class="previous" data-action="previous">&lsaquo;</a>
	    <input type="text" readonly="readonly" data-max-page="40" />
	    <a href="#" class="next" data-action="next">&rsaquo;</a>
	    <a href="#" class="last" data-action="last">&raquo;</a>
	  </div>
	</div>
	
	<!-- 密码修改框 -->
	<div class="modal fade" id="resetPasswordModal" tabindex="-1" role="dialog" aria-labelledby="resetPasswordLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="resetPasswordLabel">重置密码</h4>
	      </div>
	      <div class="modal-body">
	        <form>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">新密码</label>
	            <input type="password" class="form-control" id="txtpwd" name="txtpwd">
	          </div>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">确认密码</label>
	            <input type="password" class="form-control" id="txtpwd1" name="txtpwd1">
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="savePassword">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
	<input type="hidden" id="userId"/>
	<%@ include file="../include/footer.jsp" %>
	<script type="text/javascript" src="${baseUrl}/3th/jquery.jqpagination.min.js"></script>
	<script type="text/javascript" src="${baseUrl}/script/admin/manageuser.js"></script>
	<script type="text/javascript">
		$(function(){
			ManagerUserModule.init();
		})
	</script>
</body>
</html>