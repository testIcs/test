<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传贷款申请</title>
<link rel="stylesheet" type="text/css" href="../css/JDstyle.css" />
<style>
.idcard-block {
  height: 675px;
}
</style>
</head>
<body>
<div class="wrapper">
	<div class="top">
    	<div class="topleft"></div>
        <div class="topright"><a href="<%=request.getContextPath() %>/home/home.do">首页</a></div>
    </div>
    <div class="content">
		<div class="leftmain">
        	<div class="title"><span>资料上传</span></div>
          	<div class="left-con">
           		<div class="table">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td class="td-left">身 份 证</td>
                        <td><a class="upload-a" href="upload_a.html">点击上传“身份证”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">贷款申请</td>
                        <td><a class="upload-a" href="upload_b.html">点击上传“贷款申请”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">车辆信息</td>
                        <td><a class="upload-a" href="upload_c.html">点击上传“车辆信息”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">银行流水</td>
                        <td><a class="upload-a" href="upload_d.html">点击上传“银行流水”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">授 权 书</td>
                        <td><a class="upload-a" href="upload_e.html">点击上传“授权书”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">收入证明</td>
                        <td><a class="upload-a" href="upload_f.html">点击上传“收入证明”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">房产信息</td>
                        <td><a class="upload-a" href="upload_g.html">点击上传“房产信息”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">其他补充</td>
                        <td><a class="upload-a" href="upload_h.html">点击上传“其他补充”</a></td>
                      </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="rightmain">
			<div class="idcard-block">
           	  	<div class="right-title">请您将贷款申请放置在资料扫描区</div>
                <div class="idcard-area">
                	<video id="video" width="600" height="460" autoplay></video>
                	<canvas id="canvas" width="600" height="460" style="display:none"></canvas> 
                </div>
            </div>
            <div class="submit">
            	<input id="snap" type="button" style="width:270px; margin:0px 80px 0px 0px;"  value="拍  照" />
            	<input id="resnap" type="button" style="width:270px; margin:0px 80px 0px 0px;display:none"  value="重  拍" />
            	<input id="confirm" type="button" style="width:270px;" value="确认" />
            </div>
        </div>
    </div>
    <div class="footer">
    	<div class="footerleft"><span class="italic">用户至上 用心服务</span><span class="f-a">Customer First Service Foremost</span></div>
        <div class="footerright"></div>
    </div>    
</div>
</body>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script>     
//判断浏览器是否支持HTML5 Canvas           
window.onload = function () {          
    try{                   
		//动态创建一个canvas元 ，并获取他2Dcontext。如果出现异常则表示不支持                  
		document.createElement("canvas").getContext("2d");          
    }catch (e) {           
        document.getElementById("support").innerHTML = "浏览器不支持HTML5 CANVAS";       
    }                
};
              
//这段代 主要是获取摄像头的视频流并显示在Video 签中           
window.addEventListener("DOMContentLoaded", function () {            
	var canvas = document.getElementById("canvas"),              
		context = canvas.getContext("2d"),                
		video = document.getElementById("video"),          
        videoObj = { "video": true },             
		errBack = function (error) {
					console.log("Video capture error: ", error.code);
				};  
		
    //navigator.getUserMedia这个写法在Opera中好像是navigator.getUserMedianow       
    if (navigator.getUserMedia){  // Standard   
		navigator.getUserMedia(videoObj, function (stream) {
												video.src = stream;                
												video.play();      
										}, errBack);           
    } else if (navigator.webkitGetUserMedia){  // WebKit-prefixed      
        navigator.webkitGetUserMedia(videoObj, function (stream) {          
												video.src = window.URL.createObjectURL(stream);           
												video.play();           
										}, errBack);           
    } else if(navigator.mozGetUserMedia) { // Firefox-prefixed
		navigator.mozGetUserMedia(videoObj, function(stream){
												video.src = window.URL.createObjectURL(stream);
												video.play();
										}, errBack);
	}
	
    //这个是拍照按钮的事件，          
    $("#snap").click(function () {          
         context.drawImage(video, 0, 0, 600, 460);
         
         $("#video").hide();
         $("#canvas").show();
         
         $("#snap").hide();  
         $("#resnap").show();           
	}); 
	
	//这个是重拍按钮的事件，          
    $("#resnap").click(function () {                   
         $("#video").show();
         $("#canvas").hide();   
         
         $("#snap").show();  
         $("#resnap").hide();          
	}); 
	
	//确认事件，          
    $("#confirm").click(function () {              
         CatchCode();           
	}); 
	          
}, false);                   
    
	function CatchCode() {        
		// 获取浏览器页面的画布对象
		var canvans = document.getElementById("canvas");                  
		var base64Data = canvans.toDataURL(); //将图像转换为base64数据     
		//开始异步上             
		$.post("<%=request.getContextPath() %>/upload/uploadImage.do", { "imageData": base64Data }, function (data, status) {             
				if (data.result == '0') {                
					alert("提交成功");                   
				}else {              
				    alert("提交失败");         
				}          
            
		}, "text");           
	}      
 </script> 
</html>