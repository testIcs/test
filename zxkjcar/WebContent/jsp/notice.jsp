<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta charset="utf-8">
<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<%@ include file="include/header.jsp" %>
<style type="text/css">
	.table td{
		text-align: left;
		
	}
	.table>tbody>tr>td{
		padding:8px 7px 8px 8px;
	}
	
	.modal{
		top: 30%;
	}
	#noticeModalBody{
		text-indent: 25px;
		line-height: 25px;
	}
</style>
</head>
<body>
<div class="top">往期公告</div>
<div class="container-fluid">
  <table class="table">
    <thead>
        <tr>
          <th>公告内容</th>
  	      <th>发布时间</th>
        </tr>
    </thead>
    <tbody>
    </tbody>
  </table>
</div>
<!-- 消息通知模态框 -->
<div class="modal fade" id="noticeModal" tabindex="-1" role="dialog" aria-labelledby="noticeModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title text-center" id="noticeModalLabel"><strong>公告 详情</strong></h4>
      </div>
      <div class="modal-body" id="noticeModalBody"></div>
      <div class="modal-footer" style="text-align:center">
     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
    </div>
   </div>
  </div>
</div>
</body>
<%@ include file="include/footer.jsp" %>
<script type="text/javascript" src="${baseUrl}/script/notice.js"></script>
<script type="text/javascript">
	$(function()
	{
		NoticeModule.init();
	});
</script>
</html>