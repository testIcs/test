window.HomeModule = (function($, module)
{
	var _status_;
	var baseUrl;
	function bindEvtForBtn()
	{
		$("#loginphone").on("click", function(){
			window.location.href='loginphone.jsp';
		});
		$("#register_index").on("click", function(){
			window.location.href='register_agreement.jsp';
		});
		$("#bookinghall").on("click", function(){
			window.location.href='bookinghall.jsp';
		});
		$("#noticeHistory").on("click", function(){
			window.location.href=baseUrl+"/notice/list.do";
		});
	}
	
	function init(param)
	{
		_status_ = param.status;
		baseUrl = param.baseUrl;
		
		bindEvtForBtn();
	}
	
	module.init = init;
	
	return module;
	
})($, window.HomeModule || {});