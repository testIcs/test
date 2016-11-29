<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    	<div class="face-title">贷款人脸识别比对</div>
		<div class="faceblock">
			<div class="idcard-area" style="width:900px;height:600px;">
                	<div class="blind"></div>
                	<video id="video" width="900" height="600" autoplay style="margin: 10px 0 0 7px;"></video>
                	<canvas id="canvas" width="900" height="600" style="display:none;margin: 10px 0 0 7px;"></canvas> 
             </div> 
		</div>
        <div class="submit">
            	<input id="snap" type="button" style="width:175px; margin:0px;"  value="拍  照" />
            	<input id="resnap" type="button" style="width:175px; margin:0px;display:none"  value="重  拍" />
            	<input id="confirm" type="button" style="width:175px;" value="开始比对" />
        </div>
    </div>  
</div>
</body>
<script type="text/javascript">
	var baseurl="<%=request.getContextPath() %>";
</script>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script type="text/javascript">
//注意getUserMedia()在各浏览器中的区别  
//Opera --> getUserMedia  
//Chrome --> webkitGetUserMedia  
//Firefox --> mozGetUserMedia  
navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia;  
context = canvas.getContext("2d");
//只获取video:  
var constraints = {audio: false, video: true};  
var video = document.querySelector("video");  

function successCallback(stream) {  
 // Note: make the returned stream available to console for inspection  
 window.stream = stream;  
   
if (window.URL) {  
     // Chrome浏览器: URL.createObjectURL() 把 MediaStream 转为 blob URL  
     video.src = window.URL.createObjectURL(stream);  
 } else {  
     // Firefox和Opera: 可以直接把视频源设置为stream  
     video.src = stream;  
 }  
 // 播放  
 video.play();  
}  

function errorCallback(error){  
 console.log("navigator.getUserMedia error: ", error);  
}  

navigator.getUserMedia(constraints, successCallback, errorCallback);

//这个是拍照按钮的事件，          
$("#snap").click(function () {   
	 $(".blind").attr("class","blind"), $(".blind").css("opacity","1"), setTimeout(function() {
        $(".blind").attr("class","blind anim"), $(".blind").css("opacity","0")
     }, 50);  
        
     context.drawImage(video, 0, 0, 600, 450);
     
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
     // 获取浏览器页面的画布对象
	var canvans = document.getElementById("canvas");                  
	var base64Data = canvans.toDataURL(); //将图像转换为base64数据     
	//开始异步上
	$.ajax({  
           url: baseurl+"/upload/uploadImage.do",  
           type: 'POST',  
           timeout: 15*1000,  
           data:{"imageData": base64Data},
           beforeSend:function(){
        	   $("#confirm").val("比对中....");
        	   $('#confirm').attr("disabled",true);
           },
           success: function(data) {  
			if (data.result == 'success') {                
				compare(data.filePath);             
			}else {              
			    alert("比对失败"); 
			    $("#confirm").val("开始比对");
	        	$('#confirm').attr("disabled",false);
			}   
	                 
           },  
           error:function(result){  
        	   $("#confirm").val("开始比对");
	           $('#confirm').attr("disabled",false);
           }  
       });//end          
}); 

function compare(filepath){
	$.ajax({  
	 url: baseurl+"/face/compare.do",  
     type: 'POST',  
     timeout: 15*1000,  
     data:{"compareImage": filepath},
     success: function(data) {  
		if (data.result == '0') {                
			alert("比对成功");     
			window.location.href= baseurl+"/sign/toFingerEnterPage.do";
		}else {              
		    alert("比对失败");  
		    $("#confirm").val("开始比对");
        	$('#confirm').attr("disabled",false);
		}   
               
     },  
     error:function(result){  
    	 $("#confirm").val("开始比对");
     	 $('#confirm').attr("disabled",false);
     }  
  });//end  
}
</script>
</html>