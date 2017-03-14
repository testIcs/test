window.LoginModule = (function($, module){
	/**
	 * 用户登录
	 */
	function doLogin()
    {
		$("#errorMsg").empty();
		$(".errorMsg").hide();
		var _phoneNo = $("#phoneNo").val();
		var _password = $("#password").val();
		if(_phoneNo==''){
			$("#errorMsg").empty().append("手机号不能为空");
			$(".errorMsg").show();
			return;
		}
		
		if(_password==''){
			$("#errorMsg").empty().append("密码不能为空");
			$(".errorMsg").show();
			return;
		}
		
		$.ajax({    
			url:baseUrl+'/user/login.do',       
			type:'post',    
			cache:false,  			
			dataType:'json',
			data:{
				phoneNo:_phoneNo,
				password:_password
			},
			beforeSend: function () {
				$("#btnLogin").attr("disabled",true);
				$("#btnLogin").text("登录中")
		    },
		    success: function (data) {
		    	if(data)
				{
					if("0" == data.status)
					{
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
						$("#errorMsg").empty().append("账号审核中，暂时无法登陆");
						$(".errorMsg").show();
						
						$("#btnLogin").attr("disabled",false);
						$("#btnLogin").text("登录")
						
						return;
					}
				}
		    	$("#errorMsg").empty().append("手机号或密码错误");
				$(".errorMsg").show();
				
				$("#btnLogin").attr("disabled",false);
				$("#btnLogin").text("登录")
		    },
		    error: function (data) {
		    	$("#errorMsg").empty().append("登录发生错误");
				$(".errorMsg").show();
				
				$("#btnLogin").attr("disabled",false);
				$("#btnLogin").text("登录")
				
		        console.info("error: " + data.responseText);
		    }

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





