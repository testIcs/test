window.AddUserModule = (function($, module)
{
	/**
	 * 注册提交 
	 */
	function registerSubmit()
	{
		var userName = $("#userName").val();
		var password = $("#txtpwd").val();
		var idNumber = $("#idNumber").val();
		var phoneNo = $("#phoneNo").val();
		var descrip = $("#descrip").val();
		
		// 验证手机号是否为空 
		if(!phoneNo.length)
		{
			return jAlertError("手机号不能为空!");
		}
		
		// 验证手机号是否正确
		if(!ValidaeUtil.validatePhoneNo(phoneNo))
		{
			return jAlertError("手机号错误!");
		}
		
		$.ajax({
			url: "/zxkjcar/admin/addUser.do",
			type: "post",
			dataType: "json",
			data:{
				userName : userName,
				password : password,
				idNumber : idNumber,
				phoneNo : phoneNo,
				descrip : descrip,
				state:1
			}
		}).done(function(data){
			if(!data)
			{
				jAlert("新增成功");
				window.location.href='audituser.jsp';
				return;
			}
			jAlertError("新增失败");
		}).fail(function(){
			jAlertError("新增发生错误");
		});
	}
	
	/**
	 * 为按钮绑定事件
	 */
	function bindEventForButton()
	{
		$("#btnRegister").on("click", function(){
			registerSubmit();
		});
	}
	
	//初始化方法
	function init(){
		// 为按钮绑定事件
		bindEventForButton();
	}
	
	module.init = init;
	
	return module;
	
})($, window.AddUserModule || {});