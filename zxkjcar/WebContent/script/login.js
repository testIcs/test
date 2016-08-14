window.LoginModule = (function($, module){
	
	/**
	 * 用户登录
	 */
	function doLogin()
    {
		var _userName = $('#userName').val(),
	    	_pass = $('#password').val()
		if(!(_userName && _pass)){
			alert("密码不能为空");
			return;
		}
		
		$.ajax( {    
			url:'/zxkjcar/user/login.do',// 跳转到 action        
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{
				userName:_userName,
				password:_pass
			}
		}).done(function(data){
			if(data && ("0" == data.status))
			{
				jAlert("登录成功","提示");
				window.location.href='home.jsp?status='+data.status;
				return;
			}
			jAlert("登录失败","提示");
		}).fail(function(){
			jAlert("登录发生错误","提示");
		});
	}
	
	/**
	 * 为按钮绑定事件 
	 */
	function bindEvtFroBtn()
    {
		$('#btnLogin').on(
	    {
			click : doLogin
		}); 
		
		$("#btnRegister").on("click", function()
		{
			window.location.href='register_index.jsp';
		});
	}
	
	function init()
	{
		bindEvtFroBtn();
	}
	
	module.init = init;
	module.doLogin = doLogin;
	
	return module;
	
})($, window.LoginModule || {});

$(function()
{
	LoginModule.init();
});





