<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>利率确认</title>
<link rel="stylesheet" type="text/css" href="../css/JDstyle.css" />
</head>
<body>
<div class="wrapper">
	<div class="top">
    	<div class="topleft"></div>
        <div class="topright"><a href="/zxkj/home/home.do">首页</a></div>
    </div>
    <div class="content">
		<div class="leftmain" style="float:none; margin:0px auto; height:480px; padding-top:170px;">
        	<div class="title"><span>简易贷</span></div>
          	<div class="left-con" style="height:400px;">
           		<div class="table">
           		<form name="loanForm">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td class="td-left">金融产品</td>
                        <td><select id="fp_rc" name="typeId"></select></td>
                      </tr>
                      <tr>
                        <td class="td-left">贷款利率</td>
                        <td><select id="lr_rc" name="ratioId"></select></td>
                      </tr>
                      <tr>
                        <td class="td-left">贷款期限</td>
                        <td><select id="lt_rc" name="termId"></select></td>
                      </tr>
                    </table>
                    </form>
                </div>
            	<div class="table-button" style="text-align:center; padding-top:50px;">
                	<a id="loan_save" href="javascript:;"><input type="button" value="确 定" /></a>
                	<a href="/zxkj/apply/toApplyRegisterPage.do"><input type="button" value="返 回" /></a>
                </div>
            </div>
        </div>
    </div>  
</div>
</body>
<script type="text/javascript" src="../3th/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../script/util_manage/select_util.js"></script>
<script type="text/javascript" src="../script/apply_manage/rate_confirm.js"></script>
</html>