<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>简易贷</title>
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
        	<div class="title"><span>简易贷</span></div>
          	<div class="left-con">
           	<div class="table">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td class="td-left">车价</td>
                        <td><input name="" type="text" /></td>
                      </tr>
                      <tr>
                        <td class="td-left">保险金额</td>
                        <td><input name="" type="text" /></td>
                      </tr>
                      <tr>
                        <td class="td-left">购置税费</td>
                        <td><input name="" type="text" /></td>
                      </tr>
                      <tr>
                        <td class="td-left">贷款产品</td>
                        <td><select name=""><option>简易通-A</option></select></td>
                      </tr>
                      <tr>
                        <td class="td-left">贷款期限</td>
                        <td><select name=""><option>12期</option></select></td>
                      </tr>
                      <tr>
                        <td class="td-left">增加首付</td>
                        <td><select name=""><option>0%</option></select></td>
                      </tr>
                    </table>
                </div>
            	<div class="table-button" style="text-align:center; padding-top:50px;">
                	<input name="" type="button" value="开始测算" />
                </div>
          	</div>
        </div>
        <div class="rightmain">
        	<div class="r-title">请您输入手机号和验证码将试算结果和所需资料发送至手机</div>
            <div class="r-block"><span>手　机：</span><input name="" type="text" /></div>
            <div class="r-block"><span>验证码：</span><input name="" type="text" /></div>
            <div class="numberDiv">
            	<div class="numberbar"><a>1</a><a>2</a><a>3</a><a>4</a></div>
            	<div class="numberbar"><a>5</a><a>6</a><a>7</a><a class="delete"></a></div>
            	<div class="numberbar"><a>8</a><a>9</a><a>0</a></div>
            </div>
            <div class="sendbutton"><input name="" type="button" value="点击发送" /></div>
        </div>
    </div>    
</div>
</body>
</html>