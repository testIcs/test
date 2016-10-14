window.LoginModule = (function($, module){
	
	/**
	 * 用户登录
	 */
	function doLogin()
    {
		var _phoneNo = $('#phoneNo').val(),
	    	_pass = $('#password').val()
		if(!(_phoneNo && _pass)){
			jAlert("密码不能为空");
			return;
		}
		
		$.ajax( {    
			url:'/zxkjcar/user/login.do',// 跳转到 action        
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{
				phoneNo:_phoneNo,
				password:_pass
			}
		}).done(function(data){
			if(data)
			{
				if("0" == data.status)
				{
					jAlert("登录成功","提示");
					if("-1"==data.role)
					{
						window.location.href='/zxkjcar/admin/index.do';
					}
					else
					{
						window.location.href='home.jsp?status='+data.status;
					}
					return;
				}
				else if("8000"==data.status)
				{
					jAlertError("账号审核中，暂时无法登陆","提示");
					return;
				}
			}
			
			jAlert("手机号或密码错误","提示");
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





