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
<title>新增用户</title>
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
.content {
    padding-bottom: 30px;
}
</style>
</head>
<body>
	<section id="login">
		<div class="top">新增用户</div>
	</section>
	<div class="container-fluid">
  	  <form class="form-horizontal" role="form">
  		 <div class="form-group">
		    <label for="phoneNo" class="col-sm-2 control-label">手机号</label>
		    <div class="col-sm-6">
		    	<input type="text" class="form-control" id="phoneNo" name="phoneNo" data-bv-remote-name="phoneNo" placeholder="请输入手机号">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="txtpwd" class="col-sm-2 control-label">密码</label>
		    <div class="col-sm-10">
		    	<input type="password" class="form-control" id="txtpwd" name="txtpwd" placeholder="请输入密码">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
		    <div class="col-sm-10">
		    	<input type="password" class="form-control" id="txtpwd1" name="txtpwd1" placeholder="请输入确认密码">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="userName" class="col-sm-2 control-label">姓名</label>
		    <div class="col-sm-10">
		    	<input type="text" class="form-control" id="userName" name="userName" data-bv-remote-name="userName"  placeholder="请输入姓名" >
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="idNumber" class="col-sm-2 control-label">身份号</label>
		    <div class="col-sm-6">
		    	<input type="text" class="form-control" id="idNumber" name="idNumber" data-bv-remote-name="phoneNo" placeholder="请输身份号">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="descrip" class="col-sm-2 control-label">备注</label>
		    <div class="col-sm-6">
		    	<textarea class="form-control" rows="3" id="descrip" name="descrip"></textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10" style="text-align: center;">
		     	<button type="submit" id="addbtn" class="btn btn-primary w-all">提交</button>
		    </div>
		  </div>
		</form>
	</div>
	<%@ include file="../include/footer.jsp" %>
	<script type="text/javascript" src="${baseUrl}/script/admin/adduser.js"></script>
	<script type="text/javascript">
		var baseUrl= "${baseUrl}";	
		$(function(){
			AddUserModule.init();
		})
	</script>
</body>
</html>