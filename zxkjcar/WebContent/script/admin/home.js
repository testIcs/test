/**
 * 后台管理首页js
 */

window.AdminHomeModule = (function($, module)
{
	function bindEvtForBtn(baseUrl)
	{
		$("#registerAudit").on("click", function(){
			window.location.href=baseUrl+'/jsp/admin/audituser.jsp';
		});
		$("#userManager").on("click", function(){
			window.location.href=baseUrl+'/jsp/admin/manageuser.jsp';
		});
		$("#addUser").on("click", function(){
			window.location.href=baseUrl+'/jsp/admin/adduser.jsp';
		});
		$("#releaseNotice").on("click", function(){
			window.location.href=baseUrl+'/admin/notice.do';
		});
		$("#queryPeopleApp").on("click", function(){
			window.location.href='../jsp/appoint_people.jsp';
		});
		$("#appointmentManager").on("click", function(){
			window.location.href=baseUrl+'/jsp/admin/appointment_manager.jsp';
		});

	}
	
	function init(baseUrl)
	{
		bindEvtForBtn(baseUrl);
	}
	
	module.init = init;
	
	return module;
	
})($, window.AdminHomeModule || {});