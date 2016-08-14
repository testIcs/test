/**
 * 交付件新增模块化 
 */
window.RegisterIndex = (function($,module)
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
			return alert("手机号不能为空!");
		}
		
		// 验证手机号是否正确
		if(!ValidaeUtil.validatePhoneNo(phoneNo))
		{
			return alert("手机号错误!");
		}
		
		$.ajax({
			url: "/zxkjcar/user/addUser.do",
			type: "post",
			dataType: "json",
			data:{
				userName : userName,
				password : password,
				idNumber : idNumber,
				phoneNo : phoneNo,
				descrip : descrip
			}
		}).done(function(data){
			if(!data)
			{
				alert("注册成功");
				window.location.href='home.jsp';
				return;
			}
			alert("注册失败");
		}).fail(function(){
			alert("注册发生错误");
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
		// 显示密码强度
        // howPwdStrength();
		
		// 为按钮绑定事件
		bindEventForButton();
	}
	
	module.init = init;
	
	module.registerSubmit = registerSubmit;
	
	
	return module;
})($,window.RegisterIndex || {});

//初始化
$(function(){
	//模块初始化
	RegisterIndex.init();
});