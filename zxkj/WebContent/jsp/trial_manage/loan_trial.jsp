<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>简易贷</title>
<link rel="stylesheet" type="text/css" href="../css/JDstyle.css" />
<style type="text/css">
.formblock {
    width: 100%;
    height: auto;
    padding: 10px 0px;
}
.formblock .line {
    width: 100%;
    height: 70px;
    margin: 5px 0px;
}
.formblock .line span {
    float: left;
    display: block;
    width: 17%;
    height: 70px;
    line-height: 70px;
    font-size: 30px;
    text-align: right;
    padding-right: 1%;
}
.formblock .line input, .formblock .line select {
    float: left;
    width: 75%;
    height: 40px;
    border: 1px #bbb solid;
    border-radius: 4px;
    font-size: 14px;
    font-family: Microsoft Yahei;
    padding-left: 10px;
    margin-top:15px
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
	    <div class="leftmain" style="float:none; margin:0px auto; height:480px; padding-top:20px;">
        	<div class="title"><span>贷款试算</span></div>
          	<div class="left-con" style="height:700px;">
           		<div class="table">
                	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td class="td-left">车价:</td>
                        <td>
                        	<input id="thePrice" placeholder="车价（不能超过8个字符）" name="thePrice" type="text" />
						</td>
                      </tr>
                      <tr>
                        <td class="td-left">保险金额:</td>
                        <td><input id="loanLimit" placeholder="保险金额（不能超过8个字符）" name="loanLimit" type="text" value="0" /></td>
                      </tr>
                      <tr>
                        <td class="td-left">购置税费:</td>
                        <td><input id="loanLimit2" placeholder="购置税费（不能超过8个字符）" name="loanLimit2" type="text" value="0" /></td>
                      </tr>
                      <tr>
                        <td class="td-left">贷款产品:</td>
                        <td><select id="listLoanType" name="listLoanType"></select></td>
                      </tr>
                      <tr>
                        <td class="td-left">贷款期限:</td>
                        <td><select id="listLoanTerm" name="listLoanTerm"></select></td>
                      </tr>
                      <tr>
                        <td class="td-left">增加首付:</td>
                        <td>
                        	<select id="addFirstPayMent" name="addFirstPayMent">
                        		<option value="0">0%</option>
								<option value="0.05">5%</option>
								<option value="0.1">10%</option>
								<option value="0.15">15%</option>
								<option value="0.2">20%</option>
								<option value="0.25">25%</option>
								<option value="0.3">30%</option>
								<option value="0.35">35%</option>
								<option value="0.4">40%</option>
                        	</select>
                        </td>
                      </tr>
                      <tr>
                        <td class="td-left">手机号:</td>
                        <td>
                        	<input id="phoneNO" placeholder="手机号码(可选)" type="text"/>
							<span style="font-size: 14px;color: #f00;">为方便您查看，我们会将计算结果发送到您手机上</span>
						</td>
                      </tr>
                    </table>
                </div>
            	<div class="table-button" style="text-align:center; padding-top:50px;">
                	<input type="button" value="开始测算" id="loanlimitsubmit"/>
                </div>
                <div id="errormsg"></div>
                <div class="list" id="result_div_loanlimit"></div>
            </div>
        </div>
    </div>
    <div class="footer">
    	<div class="footerleft"><span class="italic">用户至上 用心服务</span><span class="f-a">Customer First Service Foremost</span></div>
        <div class="footerright"></div>
    </div>    
</div>
</body>
<script type="text/javascript">
	var baseurl="<%=request.getContextPath() %>";
</script>
<script type="text/javascript" src="../3th/jquery.min.js"></script>
<script type="text/javascript" src="../script/trial_manage/loanlimit.js"></script>
</html>