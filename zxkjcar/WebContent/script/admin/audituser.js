window.AuditUserModule = (function($, module)
{
	
	//初始化数据
	function initData()
    {
		
		$.ajax({    
			url:baseUrl+'/admin/queryBeAuditedUser.do',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
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
	function render(userList){
		$(".table tbody").empty()
		if(userList.length==0)
		{
			$(".table tbody").append("<tr><td colspan='3' style='text-align:center'>暂时无数据</td></tr>");
			return;
		}
		$datahtml = "";
		$.each(userList,function(i,user){
			$datahtml +="<tr>";
			$datahtml +=  "<td>"+user.userName+"</td>";
			$datahtml +=  "<td>"+user.phoneNo+"</td>";
			$datahtml +=  "<td>";
			$datahtml +=    "<button type='button' class='btn btn-primary btn-xs' onclick='AuditUserModule.passed("+user.userId+")'>通过</button>"
			$datahtml +=    "<button type='button' class='btn btn-default btn-xs' onclick='AuditUserModule.deleteUser("+user.userId+")'>删除</button>"
			$datahtml +=  "</td>";
			$datahtml += "</tr>"
		});
		$(".table tbody").append($datahtml);
	}
	
	//审核通过
	function passed(id){
		$.ajax( {    
			url:baseUrl+'/admin/auditUser.do',// 跳转到 action        
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{id:id,state:1}
		}).done(function(flag){
			if(flag=='0')
			{
				jAlert("审核成功","提示");
				initData();
			}
			else
			{
				jAlertError("审核失败","提示");
			}
		}).fail(function(){

		});
	}
	
	//审核通过
	function deleteUser(id){
		jConfirm("确认删除吗？","提示",function(r){
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
						jAlert("删除成功","提示");
						initData();
					}
					else
					{
						jAlertError("删除失败","提示");
					}
				},
				error: function (data) {
			        console.info("error: " + data.responseText);
			    }
			});
		})
	}
	

	function init()
	{
		initData();
	}
	
	module.init = init;
	module.passed = passed;
	module.deleteUser = deleteUser;
	
	return module;
	
})($, window.AuditUserModule || {});