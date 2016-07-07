<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>贷款申请</title>
<link rel="stylesheet" type="text/css" href="../css/JDstyle.css" />
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
           	  	<div class="right-title">请您将其他补充放置在资料扫描区</div>
                <div class="idcard-area"><img src="../css/images/pic11.jpg" width="600" height="320" /></div>
            </div>
            <div class="submit"><a href="toBankCard.do"><input type="button" value="提  交" /></a></div>
        </div>
    </div>
    <div class="footer">
    	<div class="footerleft"><span class="italic">用户至上 用心服务</span><span class="f-a">Customer First Service Foremost</span></div>
        <div class="footerright"></div>
    </div>    
</div>
</body>
</html>