window.HomeModule = (function($, module)
{
	var _status_;
	
	function bindEvtForBtn()
	{
		$("#loginphone").on("click", function(){
			window.location.href='loginphone.jsp';
		});
		$("#register_index").on("click", function(){
			window.location.href='register_index.jsp';
		});
		$("#appointment").on("click", function(){
			window.location.href='appointment.jsp?status='+_status_;
		});
		$("#bookinghall").on("click", function(){
			window.location.href='bookinghall.jsp';
		});
	}
	
	function init(param)
	{
		_status_ = param.status;
		
		bindEvtForBtn();
	}
	
	module.init = init;
	
	return module;
	
})($, window.HomeModule || {});