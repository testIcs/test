/**
 * 交付件新增模块化 
 */
window.RegisterIndex = (function($,module)
{
	
	/**
	 * 为按钮绑定事件
	 */
	function bindEventForButton()
	{
		$("#registerbtn").on("click", function(){
			var flag = $('form').data('bootstrapValidator').isValid();
			if(flag==true)
			{
				$.ajax({
					url: "/zxkjcar/user/addUser.do",
					type: "post",
					dataType: "json",
					data:{
						userName : $("#userName").val(),
						password : $("#txtpwd").val(),
						idNumber : $("#idNumber").val(),
						phoneNo : $("#phoneNo").val(),
						descrip : $("#descrip").val()
					}
				}).done(function(data){
					if(!data)
					{
						alert("提示","注册成功",function(){
							window.location.href='home.jsp';
						},{type:"info",confirmButtonText:"确定"});
						return;
					}
					alert("提示","注册失败",null,{type:"error",confirmButtonText:"确定"});
					
				}).fail(function(){
					alert("提示","注册发生错误",null,{type:"error",confirmButtonText:"确定"});
				});
			}else{
				$('form').data('bootstrapValidator').validate();
			}
			
			return false;
			
		});
	}
	
	//输入框校验
	function validator(){
			$('form').bootstrapValidator({
		　　　　　　　　message: 'This value is not valid',
		            feedbackIcons: {
            　　　　　　　　valid: 'glyphicon glyphicon-ok',
            　　　　　　　　invalid: 'glyphicon glyphicon-remove',
            　　　　　　　　validating: 'glyphicon glyphicon-refresh'
        　　　　　　　　},
		            fields: {
		            	 phoneNo:{
		                	 validators: {
		                		 	notEmpty: {
			                            message: '手机号不能为空'
			                        },
			                        regexp: {
			                            regexp: /^1[34578]\d{9}$/,
			                            message: '手机号码有误'
			                        },
			                        remote: {
			                            message: '该手机号已注册',
			                            url: '/zxkjcar/user/judgePhone.do'
			                        }
			                        
		                	 }
		                },
		            	userName: {
		                    message: '姓名验证失败',
		                    validators: {
		                        notEmpty: {
		                            message: '姓名不能为空'
		                        }
		                    }
		                },
		                txtpwd: {
		                    validators: {
		                        notEmpty: {
		                            message: '密码不能为空'
		                        }
		                    }
		                },
		                txtpwd1: {
		                    validators: {
		                        notEmpty: {
		                            message: '确认密码不能为空'
		                        },
		                        identical: {
		                            field: 'txtpwd',
		                            message: '两次密码不一致'
		                        },
		                    }
		                },
		                idNumber:{
		                	 validators: {
		                		 	notEmpty: {
			                            message: '身份证号不能为空'
			                        }  
		                	 }
		                }
		            }
		        });
	}
	
	//初始化方法
	function init(){
		validator();
		// 为按钮绑定事件
		bindEventForButton();
	}
	
	module.init = init;
	
	return module;
})($,window.RegisterIndex || {});

//初始化
$(function(){
	//模块初始化
	RegisterIndex.init();
});