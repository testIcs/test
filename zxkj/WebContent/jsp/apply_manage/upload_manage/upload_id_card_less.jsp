<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传身份证</title>
<link rel="stylesheet" type="text/css" href="../css/JDstyle.css" />
<style type="text/css">
.rightIframe{
	width:550px; height:830px; float:right; padding:40px 50px 50px 40px;
}
.submit{
	width:550px; height:84px; margin:0px auto; padding:60px 0px 0px 0px; text-align:center;
}
.submit input{
	width:550px; height:80px; border:0px; background:#36b42e; text-align:center; color:#fff; cursor:pointer; border-radius:4px; font-size:40px;
}
.submit input:hover{
	background:#137b0c;
}
</style>
</head>
<body>
<div class="wrapper">
	<div class="top">
    	<div class="topleft"></div>
        <div class="topright"><a href="/zxkj/home/home.do">首页</a></div>
    </div>
    <div class="content">
		<div class="leftmain">
        	<div class="title"><span>资料上传</span></div>
          	<div class="left-con">
           		<div class="table">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td class="td-left">身 份 证</td>
                       <!--  <td><a class="upload-a" href="toUploadIdCard.do">点击上传“身份证”</a></td> -->
                        <td><input type="button" id="btIDCard" name="btUploadInfo" value="点击上传“身份证”"></td>
                      </tr>
                      <tr>
                        <td class="td-left">贷款申请</td>
                        <!-- <td><a class="upload-a" href="toUploadLoan.do">点击上传“贷款申请”</a></td> -->
                        <td><input type="button" id="btLoan" name="btUploadInfo" value="点击上传“贷款申请”"></td>
                      </tr>
                      <tr>
                        <td class="td-left">车辆信息</td>
                         <!--<td><a class="upload-a" href="toUploadCar.do">点击上传“车辆信息”</a></td> -->
                        <td><input type="button" id="btCarInfo" name="btUploadInfo" value="点击上传“车辆信息”"></td>
                      </tr>
                      <tr>
                        <td class="td-left">银行流水</td>
                        <!-- <td><a class="upload-a" href="toUploadBank.do">点击上传“银行流水”</a></td> -->
                        <td><input type="button" id="btBankState" name="btUploadInfo" value="点击上传“银行流水”"></td>
                      </tr>
                      <tr>
                        <td class="td-left">授 权 书</td>
                        <!-- <td><a class="upload-a" href="toUploadAuth.do">点击上传“授权书”</a></td> -->
                        <td><input type="button" id="btWarrant" name="btUploadInfo" value="点击上传“授权书”"></td>
                      </tr>
                      <tr>
                        <td class="td-left">收入证明</td>
                         <!--<td><a class="upload-a" href="toUploadIncome.do">点击上传“收入证明”</a></td> -->
                        <td><input type="button" id="btIncom" name="btUploadInfo" value="点击上传“收入证明”"></td>
                      </tr>
                     <!-- <tr>
                        <td class="td-left">房产信息</td>
                        <td><input type="button" id="btHouseInfo" name="btUploadInfo" value="点击上传“房产信息”"></td>
                      </tr>
                      <tr>
                        <td class="td-left">其他补充</td>
                        <td><input type="button" id="btOther" name="btUploadInfo" value="点击上传“其他补充”"></td>
                      </tr> -->
                      
                    </table>
                     <div class="submit">
            	<input id="btNext" type="button" style="width:175px;" value="下一步"  />
            </div>
                </div>
            </div>
        </div>
        <!--  <div class="rightmain">
			<div class="idcard-block">
           	  	<div class="right-title">请您将二代身份证放置在身份证识别区</div>
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
        </div>-->
        <div class="rightIframe">
        <iframe name="leftFrame" id="leftFrame" scrolling="no" frameborder="0" width="600" height="830"  src=""></iframe>
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