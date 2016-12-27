window.ManagerAppointment = (function($, module)
{
	
	//初始化数据
	function initData(pageNo)
    {
		$.ajax({    
			url:baseUrl+'/admin/appointment/pageList.do',       
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
			return;
		}
		$datahtml = "";
		$.each(data.dataList,function(i,appointment){
			$datahtml +="<tr>";
			$datahtml +=  "<td>"+appointment.appUserName+"</td>";
			$datahtml +=  "<td>"+$.formatDate("yyyy-MM-dd",new Date(appointment.appDate))+"</td>";
			$datahtml +=  "<td>"+appointment.appTimeSlotName+"</td>";
			$datahtml +=  "<td>"+appointment.appAffair+"</td>";
			$datahtml +=  "<td>";
			$datahtml +=    "<button type='button' class='btn btn-primary btn-xs' onclick='ManagerAppointment.deleteAppointment("+appointment.id+")'>删除</button>"
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
	function deleteAppointment(id){
		jConfirm("确认删除吗？","提示",function(r){
			if(!r)
			{
				return;
			}
			$.ajax( {    
				url:baseUrl+'/admin/appointment/delete.do',// 跳转到 action        
				type:'post',    
				cache:false,  			
				dataType:'json', 
				data:{id:id},
				success:function(flag){
					if(flag=='0')
					{
						jAlert("删除成功","提示");
						initData(1);
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
		initData(1);
	}
	
	module.init = init;
	module.deleteAppointment = deleteAppointment;
	
	return module;
	
})($, window.ManagerAppointment || {});