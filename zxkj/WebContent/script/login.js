window.LoginModule = (function($, module){
	
	/**
	 * 用户登录
	 */
	function doLogin(){
		var _userName = $('#userName').val(),
	    	_pass = $('#password').val(),
	    	_password = DesUtilModule.encryptByDES(_pass, CommonConstModule['_desKey_']);
	
		if(!(_userName && _pass)){
			$('#check').html("<font color='red'><b>用户名或密码为空</b></font>");
			return;
		}
	
		$.ajax( {    
			url:'/zxkj/user/login.do',// 跳转到 action        
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{
				userName:_userName,
				password:_password
			},
			headers:[{"Access-Control-Allow-Origin":"localhost,127.0.0.1"}],
			success:function(data) {  
				if(data && "0" == data.status){
					window.location.href='jsp/home.jsp';
					return;
				}
				
				$('#check').html("<font color='red'><b>用户名或密码错误</b></font>");  
			 }
		});
	}
	
	/**
	 * 为按钮绑定事件 
	 */
	function bindEvtFroBtn(){
		$('#tester_login_submit').on({
			click : doLogin
		}); 
	}
	
	function init(){
		bindEvtFroBtn();
	}
	
	module.init = init;
	
	return module;
	
})($, window.LoginModule || {});

$(function(){
	LoginModule.init();
});





