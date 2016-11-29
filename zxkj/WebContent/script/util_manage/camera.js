
(function($){
	//判断浏览器是否支持HTML5 Canvas           
	window.onload = function () {
	    try{                   
			//动态创建一个canvas元 ，并获取他2Dcontext。如果出现异常则表示不支持                  
			document.createElement("canvas").getContext("2d");          
	    }catch (e) {           
	        document.getElementById("support").innerHTML = "浏览器不支持HTML5 CANVAS";       
	    }                
	};
	
	//增加样式
	window.addEventListener("load",function(){var s = document.createElement("style"); s.innerHTML=".idcard-block {height: 675px;}.idcard-area{position: relative;height: 460px;}.idcard-area .blind {position: absolute;left: 0;top: 0;opacity: 0;width: 100%;height: 100%;background: #fff;z-index: 1;}.idcard-area .blind.anim {transition: opacity 1500ms ease-out;-o-transition: opacity 1500ms ease-out;-moz-transition: opacity 1500ms ease-out;-webkit-transition: opacity 1500ms ease-out;}"; document.head.appendChild(s);},false);	              
	//这段代 主要是获取摄像头的视频流并显示在Video 签中           
	window.addEventListener("DOMContentLoaded", function () {            
		var canvas = document.getElementById("canvas"),              
			//context = canvas.getContext("2d"),                
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
	    
	    //点击上传身份证，在右侧显示框架页面，add by wlh          
		 $("#btIDCard").click(function () {                   
		        $("#leftFrame").attr('src','/zxkj/jsp/apply_manage/upload_manage/upload_id_cardTest.jsp?tpp=身份证');
		}); 
		 $("#btLoan").click(function () {                   
		        $("#leftFrame").attr('src','/zxkj/jsp/apply_manage/upload_manage/upload_id_cardTest.jsp?tpp=贷款申请');
		}); 
		 $("#btCarInfo").click(function () {                   
		        $("#leftFrame").attr('src','/zxkj/jsp/apply_manage/upload_manage/upload_id_cardTest.jsp?tpp=车辆信息');
		}); 
		 $("#btBankState").click(function () {                   
		        $("#leftFrame").attr('src','/zxkj/jsp/apply_manage/upload_manage/upload_id_cardTest.jsp?tpp=银行流水');
		}); 
		 $("#btWarrant").click(function () {                   
		        $("#leftFrame").attr('src','/zxkj/jsp/apply_manage/upload_manage/upload_id_cardTest.jsp?tpp=授权书');
		}); 
		 $("#btIncom").click(function () {                   
		        $("#leftFrame").attr('src','/zxkj/jsp/apply_manage/upload_manage/upload_id_cardTest.jsp?tpp=收入证明');
		}); 
		 $("#btHouseInfo").click(function () {                   
		        $("#leftFrame").attr('src','/zxkj/jsp/apply_manage/upload_manage/upload_id_cardTest.jsp?tpp=房产信息');
		}); 
		 $("#btOther").click(function () {                   
		        $("#leftFrame").attr('src','/zxkj/jsp/apply_manage/upload_manage/upload_id_cardTest.jsp?tpp=其他补充');
		}); 
		 
		 $("#btNext").click(function(){//add by wlh
			 var bts=document.getElementsByName("btUploadInfo");
			 for(var i=0;i<bts.length;i++){
				 if(bts[i].disabled==false){
					 var btInfoText=bts[i].value;
					 alert(btInfoText);
					 return;
				 }
			 }
			var nw= window.open(baseurl+"/applyUpload/toBankCard.do","_self");
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
	               success: function(data) {  
					if (data.result == '0') {                
						alert("提交成功");                   
					}else {              
					    alert("提交失败");
					    if(itemInfo=="身份证"){//modify by wlh
					    	var bt=window.parent.document.getElementById("btIDCard");
						    bt.value="已经上传";
						    bt.disabled=true;
						    bt.style.background="LimeGreen";
						    bt.style.color="GhostWhite";
					    }else if(itemInfo=="贷款申请"){
					    	var bt=window.parent.document.getElementById("btLoan");
						    bt.value="已经上传";
						    bt.disabled=true;
						    bt.style.background="LimeGreen";
						    bt.style.color="GhostWhite";
					    }else if(itemInfo=="车辆信息"){
					    	var bt=window.parent.document.getElementById("btCarInfo");
						    bt.value="已经上传";
						    bt.disabled=true;
						    bt.style.background="LimeGreen";
						    bt.style.color="GhostWhite";
					    }else if(itemInfo=="银行流水"){
					    	var bt=window.parent.document.getElementById("btBankState");
						    bt.value="已经上传";
						    bt.disabled=true;
						    bt.style.background="LimeGreen";
						    bt.style.color="GhostWhite";
					    }else if(itemInfo=="授权书"){
					    	var bt=window.parent.document.getElementById("btWarrant");
						    bt.value="已经上传";
						    bt.disabled=true;
						    bt.style.background="LimeGreen";
						    bt.style.color="GhostWhite";
					    }else if(itemInfo=="收入证明"){
					    	var bt=window.parent.document.getElementById("btIncom");
						    bt.value="已经上传";
						    bt.disabled=true;
						    bt.style.background="LimeGreen";
						    bt.style.color="GhostWhite";
					    }else if(itemInfo=="房产信息"){
					    	var bt=window.parent.document.getElementById("btHouseInfo");
						    bt.value="已经上传";
						    bt.disabled=true;
						    bt.style.background="LimeGreen";
						    bt.style.color="GhostWhite";
					    }else if(itemInfo=="其他补充"){
					    	var bt=window.parent.document.getElementById("btOther");
						    bt.value="已经上传";
						    bt.disabled=true;
						    bt.style.background="LimeGreen";
						    bt.style.color="GhostWhite";
					    }
					}   
			                 
	               },  
	               error:function(result){  
	                   
	               }  
	           });//end          
		}); 
		          
	}, false);   
}(jQuery))