window.NoticeModule = (function($, module)
{
	//初始化数据
	function initData()
    {
		$.ajax({    
			url:baseUrl+'/notice/historyNotice.do',       
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
	function render(noticeList){
		$(".table tbody").empty()
		if(noticeList.length==0)
		{
			$(".table tbody").append("<tr><td colspan='3' style='text-align:center'>暂时无数据</td></tr>");
			return;
		}
		$datahtml = "";
		$.each(noticeList,function(i,notice){
			$datahtml +="<tr>";
			$datahtml +=  "<td><a href='javaScript:NoticeModule.showDetail("+notice.id+")'>"+notice.context+"</a></td>";
			$datahtml +=  "<td>"+$.formatDate("yyyy-MM-dd",notice.releaseTime)+"</td>";
			$datahtml += "</tr>"
		});
		$(".table tbody").append($datahtml);
	}
	
	function showDetail(id){
		$.ajax({    
			url:baseUrl+'/notice/showDetail.do',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{id:id},
			beforeSend: function () {
				$.showLoadding();
		    },
		    success: function (data) {
				if(data)
				{
					//已弹出层的形式展现公告
					$("#noticeModalBody").empty().append(data.context)
					$('#noticeModal').modal("show")
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
	//初始化
	function init()
	{
		initData();
	}
	
	module.init = init;
	module.showDetail = showDetail;
	return module;
	
})($, window.NoticeModule || {});