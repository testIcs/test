<%@ page contentType="text/html; charset=UTF-8"%>
<div class="footer"><p class="text-center">Copyright © 2014-2017 智与行科技</p></div>
<!-- 第三方公共js -->
<script type="text/javascript" src="${baseUrl}/3th/jquery.min.js"></script>
<script type="text/javascript" src="${baseUrl}/3th/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${baseUrl}/script/util_manage/validateUtil.js"></script>
<script type="text/javascript" src="${baseUrl}/3th/bootstrap.min.js"></script>
<script type="text/javascript" src="${baseUrl}/3th/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="${baseUrl}/3th/BeAlert.js"></script>

<!-- 工程公共的js -->
<script type="text/javascript" src="${baseUrl}/script/common.js"></script>
<script type="text/javascript" src="${baseUrl}/script/util_manage/jquery.custom.plugs.js"></script>
<script type="text/javascript">
	var h = $(document).height(); //浏览器时下窗口文档的高度   
	var topdiv=$(".top");
	if(topdiv.length>0){
		$(".container-fluid").css("min-height", (h-70)+"px");
	}else{
		$(".container-fluid").css("min-height", (h-20)+"px");
	}
	var baseUrl= "${baseUrl}";
</script>
