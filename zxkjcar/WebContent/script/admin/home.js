/**
 * 后台管理首页js
 */

window.AdminHomeModule = (function($, module)
{
	function bindEvtForBtn(baseUrl)
	{
		$("#userManager").on("click", function(){
			window.location.href=baseUrl+'/jsp/admin/audituser.jsp';
		});
		$("#releaseNotice").on("click", function(){
			window.location.href=baseUrl+'/admin/notice.do';
		});

	}
	
	function init(baseUrl)
	{
		bindEvtForBtn(baseUrl);
	}
	
	module.init = init;
	
	return module;
	
})($, window.AdminHomeModule || {});