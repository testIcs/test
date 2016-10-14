/**
 * 公告发布js
 */

window.ReleaseNoticeModule = (function($, module)
{
	function bindEvtForBtn()
	{
		$("#releaseNotice").on("click", function(){
			releaseNotice();
		});
	}
	
	/**
	 * 发布公告
	 */
	function releaseNotice()
	{
		var noticeContext = $("textarea").val();
		if(noticeContext == '')
		{
			jAlert("请输入公告内容","提示");
			return;
		}
		
		$.ajax({    
			url: baseUrl+'/admin/releaseNotice.do',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{'noticeContext':noticeContext},
			beforeSend: function () {
				$.showLoadding({loadText:"发布中，请稍候"});
		    },
		    success: function (data) {
				if(data && data.result && data.result=='success')
				{
					jAlert("公告发布成功","提示",function(){
						window.location.href=baseUrl+'/admin/index.do';
					});
				}
				else
				{
					jAlert("公告发布失败","提示")
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
	
	function init()
	{
		bindEvtForBtn();
	}
	
	module.init = init;
	
	return module;
	
})($, window.ReleaseNoticeModule || {});