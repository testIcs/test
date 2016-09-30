<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>贷款申请</title>
<link rel="stylesheet" type="text/css" href="../css/JDstyle.css" />
</head>
<body>
<div class="wrapper">
	<div class="top">
    	<div class="topleft"></div>
        <div class="topright"><a href="/zxkj/home/home.do">首页</a></div>
    </div>
    <div class="content">
    	<div class="face-title">贷款合同比对</div>
        <div class="compar">
            <div class="compaleft"></div>
            <div class="comparight">
            	<div class="blind"></div>
               	<video id="video" width="510" height="620" autoplay></video>
               	<canvas id="canvas" width="510" height="610" style="display:none;margin: 5px 0 0 0;"></canvas> 
            </div>
        </div>
        <div class="facebutton" style="width:1280px;">
        	<input style="margin:0px 15px;" type="button" value="返  回" />
        	<a href="/zxkj/sign/toSignFinish.do"><input style="margin:0px 15px;" type="button" value="下一步" /></a>
        	<input style="margin:0px 15px;" type="button" value="拍  照" />
        	<a href="signtips.html"><input style="margin:0px 15px;" type="button" value="保  存" /></a>
        </div>
    </div>  
</div>
</body>
<script type="text/javascript">
	var baseurl="<%=request.getContextPath() %>";
</script>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script type="text/javascript" src="../script/util_manage/camera.js"></script>
</html>