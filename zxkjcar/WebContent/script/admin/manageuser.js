window.ManagerUserModule = (function($, module)
{
	
	//初始化数据
	function initData()
    {
		
		$.ajax({    
			url:'/zxkjcar/admin/queryAuditedUser.do',       
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
			$datahtml +=    "<button type='button' class='btn btn-primary btn-xs' onclick='ManagerUserModule.showDetail("+user.userId+")'>查看</button>"
			$datahtml +=    "<button type='button' class='btn btn-default btn-xs' onclick='ManagerUserModule.deleteUser("+user.userId+")'>删除</button>"
			$datahtml +=  "</td>";
			$datahtml += "</tr>"
		});
		$(".table tbody").append($datahtml);
	}
	
	//审核通过
	function showDetail(id){
		window.location.href=baseUrl+"/admin/showUserInfo.do?userId="+id;
	}
	
	//审核通过
	function deleteUser(id){
		jConfirm("确认删除吗？","提示",function(r){
			if(!r)
			{
				return;
			}
			$.ajax( {    
				url:'/zxkjcar/admin/deleteUser.do',// 跳转到 action        
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
	module.showDetail = showDetail;
	module.deleteUser = deleteUser;
	
	return module;
	
})($, window.ManagerUserModule || {});