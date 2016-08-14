/* 
* 工具栏事件绑定
 */
$(function(){
	//判断ajax session过期
	$.ajaxSetup({
	    contentType:"application/x-www-form-urlencoded;charset=utf-8",
	    complete:function(XMLHttpRequest,textStatus){
	          //通过XMLHttpRequest取得响应头，sessionstatus           
	          var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); 
	          if(sessionstatus=="timeout"){
	        	  jAlert("网页过期，请重新登录！","提示", function(r) {
	        		   var loginPath=XMLHttpRequest.getResponseHeader("loginPath"); 
	        		   window.top.location.replace(loginPath);
	        	  });
	       }
	    }
	});
})