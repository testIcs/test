<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="nav-title">
	<span class="nav-title-new">消息发送</span>
</div> 
<link rel="stylesheet" href="${baseUrl}/css/style-message.css" type="text/css" />
<!--内容区新增用例的表单div-->
<form id="message_form" name="deliverable_add_form" enctype="multipart/form-data" class="customForm">
	<div class="nav-form">
		<div class="nav-form-block1" style="height:auto; overflow:hidden;">
        	<div id="people_select_msg_center" class="nfb1-name" style="cursor: pointer" >
        		<span class="star">*</span>接收人：
        	</div>
            <div class="nfb1-con" id="person_receive" style="height:auto; overflow:hidden;">
				<div id="tag" style="height:auto; overflow:hidden;"></div>
				<span class="font03">点击收件人</span>
            </div>
        </div>
    	<div class="nav-form-block2">
        	<div class="nfb2-name"><span class="star">*</span>内容：</div>
            <div class="form-input-boxtext">
            	<textarea id="description" name="mSendInfo.messageContent" cols="80" rows="5" class="case-textarea"></textarea>
            	<p><span class="font03">消息内容不能超过200个字符</span></p>
            </div>
        </div>
	</div>
</form>
<div class="sendbutton">
	<input id="send_massage" name="submitDeliverable" type="button" value="发送" style="margin:150px 400px;"/>
<!-- 	<input id="return_msg_center" name="deliberableReturn" type="button" value="返  回" /> -->
</div>


<%-- <script type="text/javascript" src="js/3rd_party/jquery.min.js"></script> --%>
<script type="text/javascript" src="/script/3rd_party/tabControl.js"></script>

<script type="text/javascript" src="/script/message_manage/message_sent.js"></script>
