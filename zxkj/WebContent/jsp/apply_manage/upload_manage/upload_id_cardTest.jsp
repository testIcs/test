<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传身份证</title>
<!--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/JDstyle.css" />-->
<style type="text/css">

.rightmain{
	width:550px; height:680px; float:right; padding:5px 10px 10px 5px;
}
.idcard-block{
	width:550px; height:550px; background:#fff; text-align:center; color:#00234a; font-size:48px;
}
.idcard-area{
	width:400px; height:320px; margin:0px auto;
}
.submit{
	width:550px; height:84px; margin:0px auto; padding:60px 0px 0px 0px; text-align:center;
}
.submit input{
	width:550px; height:80px; border:0px; background:#36b42e; text-align:center; color:#fff; cursor:pointer; border-radius:4px; font-size:40px;
}
.submit input:hover{
	background:#137b0c;
}
</style>
</head>
<body>
<!-- <div class="wrapper"> -->
    <div class="content">
        <div class="rightmain">
			<div class="idcard-block">
           	  	<div class="right-title">请您将<%=request.getParameter("tpp") %>放置在识别区</div>
                <div class="idcard-area">
                	<div class="blind"></div>
                	<video id="video" width="400" height="300" autoplay></video>
                	<canvas id="canvas" width="400" height="290" style="display:none;margin: 5px 0 0 0;"></canvas> 
                </div>
            </div>
            <div class="submit">
            	<input id="snap" type="button" style="width:175px; margin:0px;"  value="拍  照" />
            	<input id="resnap" type="button" style="width:175px; margin:0px;display:none"  value="重  拍" />
            	<input id="confirm" type="button" style="width:175px;" value="确认" />
            </div>
        </div>
    </div> 

</body>
 <script type="text/javascript">
	var baseurl="<%=request.getContextPath() %>";
	var itemInfo="<%=request.getParameter("tpp") %>";
</script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/3th/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/util_manage/camera.js"></script>
</html>