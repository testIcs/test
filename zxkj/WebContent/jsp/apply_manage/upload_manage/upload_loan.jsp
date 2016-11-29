<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传贷款申请</title>
<link rel="stylesheet" type="text/css" href="../css/JDstyle.css" />
</head>
<body>
<div class="wrapper">
	<div class="top">
    	<div class="topleft"></div>
        <div class="topright"><a href="<%=request.getContextPath() %>/home/home.do">首页</a></div>
    </div>
    <div class="content">
		<div class="leftmain">
        	<div class="title"><span>资料上传</span></div>
          	<div class="left-con">
           		<div class="table">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                        <td class="td-left">身 份 证</td>
                        <td><a class="upload-a" href="toUploadIdCard.do">点击上传“身份证”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">贷款申请</td>
                        <td><a class="upload-a" href="toUploadLoan.do">点击上传“贷款申请”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">车辆信息</td>
                        <td><a class="upload-a" href="toUploadCar.do">点击上传“车辆信息”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">银行流水</td>
                        <td><a class="upload-a" href="toUploadBank.do">点击上传“银行流水”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">授 权 书</td>
                        <td><a class="upload-a" href="toUploadAuth.do">点击上传“授权书”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">收入证明</td>
                        <td><a class="upload-a" href="toUploadIncome.do">点击上传“收入证明”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">房产信息</td>
                        <td><a class="upload-a" href="toUploadHouse.do">点击上传“房产信息”</a></td>
                      </tr>
                      <tr>
                        <td class="td-left">其他补充</td>
                        <td><a class="upload-a" href="toUploadOther.do">点击上传“其他补充”</a></td>
                      </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="rightmain">
			<div class="idcard-block">
           	  	<div class="right-title">请您将贷款申请放置在资料扫描区</div>
                <div class="idcard-area">
                	<div class="blind"></div>
                	<video id="video" width="400" height="300" autoplay></video>
                	<canvas id="canvas" width="400" height="290" style="display:none;margin: 5px 0 0 0;"></canvas> 
                </div>
            </div>
            <div class="submit">
            	<input id="snap" type="button" style="width:175px; margin:0px;"  value="拍  照" />
            	<input id="resnap" type="button" style="width:175px; margin:0px;display:none"  value="重  拍" />
            	<input id="confirm" type="button" style="width:175px;" value="确认" />
            </div>
        </div>
    </div>  
</div>
</body>
<script type="text/javascript">
	var baseurl="<%=request.getContextPath() %>";
</script>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script type="text/javascript" src="../script/util_manage/camera.js"></script>
</html>