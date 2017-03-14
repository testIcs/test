window.ManagerUserModule = (function($, module)
{
	
	//初始化数据
	function initData(pageNo)
    {
		
		$.ajax({    
			url:baseUrl+'/admin/queryAuditedUser.do',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{"pageNo":pageNo},
			beforeSend: function () {
				$.showLoadding();
		    },
		    success: function (data) {
				if(data)
				{
					render(data);
				}	
		    },
		    complete: function () {
		    	$.hideLoadding();
		    },
		    error: function (data) {
		    	$.hideLoadding();
		        console.info("error: " + data.responseText);
		    }

		});
	}
	
	//渲染数据
	function render(data){
		$(".table tbody").empty()
		if(data.dataList.length==0)
		{
			$(".table tbody").append("<tr><td colspan='3' style='text-align:center'>暂时无数据</td></tr>");
			$('.pagination').hide();
			return;
		}
		$datahtml = "";
		$.each(data.dataList,function(i,user){
			$datahtml +="<tr>";
			$datahtml +=  "<td>"+user.userName+"</td>";
			$datahtml +=  "<td>"+user.phoneNo+"</td>";
			$datahtml +=  "<td>";
			$datahtml +=    "<button type='button' class='btn btn-primary btn-xs' onclick='ManagerUserModule.shwoPasswordModel("+user.userId+")'>重置密码</button>"
			$datahtml +=    "<button type='button' class='btn btn-info btn-xs' onclick='ManagerUserModule.showDetail("+user.userId+")'>查看</button>"
			$datahtml +=    "<button type='button' class='btn btn-default btn-xs' onclick='ManagerUserModule.deleteUser("+user.userId+")'>删除</button>"
			$datahtml +=  "</td>";
			$datahtml += "</tr>"
		});
		$(".table tbody").append($datahtml);
		
		$('.pagination').jqPagination({
			page_string:'第 {current_page}页 共{max_page}页',
			max_page:data.pager.totalPage,
		    paged: function(page) {
		    	initData(page)
		    }
		});
	}
	
	//审核通过
	function showDetail(id){
		window.location.href=baseUrl+"/admin/showUserInfo.do?userId="+id;
	}
	
	//审核通过
	function deleteUser(id){
		confirm("确认删除吗？","",function(r){
			if(!r)
			{
				return;
			}
			$.ajax( {    
				url:baseUrl+'/admin/deleteUser.do',// 跳转到 action        
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{id:id},
				success:function(flag){
					if(flag=='0')
					{
						alert("提示","删除成功",initData(1),{type:"success",confirmButtonText:"确定"});
					}
					else
					{
						alert("提示","删除失败",null,{type:"error",confirmButtonText:"确定"});
					}
				},
				error: function (data) {
			        console.info("error: " + data.responseText);
			    }
			});
		})
	}
	
	//显示密码框
	function shwoPasswordModel(id){
		$("#userId").val(id);
		$("#txtpwd").val("");
		$("#txtpwd1").val("");
		$('form').data('bootstrapValidator').destroy();
		$('form').data('bootstrapValidator', null);
		validator();
		$("#resetPasswordModal").modal('show');
	}
	//修改密码
	function resetPassword(){
		$("form").data('bootstrapValidator').validate();
		var flag = $('form').data('bootstrapValidator').isValid();
		if(flag==false){
			return;
		}
		
		$.ajax( {    
			url:baseUrl+'/admin/resetPassword.do',// 跳转到 action        
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{id:$("#userId").val(),password:$("#txtpwd").val()},
			success:function(flag){
				if(flag=='0')
				{
					alert("提示","重置密码成功",$("#resetPasswordModal").modal('hide'),{type:"success",confirmButtonText:"确定"});
				}
				else
				{
					alert("提示","重置密码失败",null,{type:"error",confirmButtonText:"确定"});
				}
			},
			error: function (data) {
		        console.info("error: " + data.responseText);
		    }
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
		                }
		            }
		        });
	}
	
	
	function init()
	{
		initData(1);
		validator();
		
		$("#savePassword").click(function(){
			resetPassword();
		})
	}
	
	module.init = init;
	module.showDetail = showDetail;
	module.deleteUser = deleteUser;
	module.shwoPasswordModel = shwoPasswordModel;
	
	return module;
	
})($, window.ManagerUserModule || {});