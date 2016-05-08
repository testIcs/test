<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎进入支付系统</title>
<link rel="stylesheet" type="text/css" href="./css/indexstyle.css" />
<link rel="stylesheet" type="text/css" href="./css/jquery.alerts.css">
<script type="text/javascript" src="3th/jquery-1.9.1.js"></script>
<script type="text/javascript" src="3th/jquery.alerts.js"></script>
<script type="text/javascript" src="3th/tripledes.js"></script>
<script type="text/javascript" src="3th/model_esb.js"></script>
<script type="text/javascript" src="3th/md5.js"></script>
<script type="text/javascript" src="script/login.js"></script>
</head>
<body>
	<div class="login">
		<div class="loginform">
			<form class="customForm" id="testerLoginform" name="testerLoginform">
				<div class="l-block">
					<i class="icon-user"></i><input id="userName" name="user.userName"
						type="text" class="l-input" onpaste="return false"
						oncontextmenu="return false" oncopy="return false"
						oncut="return false" />
				</div>
				<div class="l-block">
					<i class="icon-password"></i><input id="password"
						name="user.password" type="password" class="l-input"
						onpaste="return false" oncontextmenu="return false"
						oncopy="return false" oncut="return false" />
				</div>
				<div class="l-button">
					<input id="tester_login_submit" name="tester_login_submit"
						type="button" value="登　录" class="l-inp-but" />
				</div>
				<div id="check" class="font02" style="color: red;"></div>
				<div class="font03"></div>
			</form>
		</div>
	</div>
</body>
</html>