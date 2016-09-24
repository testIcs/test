<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>贷款申请</title>
<link rel="stylesheet" type="text/css" href="../css/JDstyle.css" />
<link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.9.2.custom.min.css" />
<style type="text/css">
	.img-div{
		width:400px; 
		height:255px;
		position:relative;
		margin:auto auto;
        background: url(../css/images/idcard.jpg) no-repeat 0px 0px;
	}
	.img-name{
		position:absolute;
		top:34px;
		left:80px;
		font-family:华文细黑;
		font-size:14px;
	}
	.img-sex{
		position:absolute;
		top:67px;
		left:80px;
		font-family:华文细黑;
		font-size:10px;
	}
	.img-nation{
		position:absolute;
		top:67px;
		left:160px;
		font-family:华文细黑;
		font-size:10px;
	}
	.img-birth-year{
		position:absolute;
		top:100px;
		left:80px;
		font-family:方正黑体简体;
		font-size:10px;
	}
	.img-birth-month{
		position:absolute;
		top:100px;
		left:142px;
		font-family:方正黑体简体;
		font-size:10px;
	}
	.img-birth-day{
		position:absolute;
		top:100px;
		left:180px;
		font-family:方正黑体简体;
		font-size:10px;
	}
	.img-address1{
		position:absolute;
		top:131px;
		left:80px;
		font-family:华文细黑;
		font-size:10px;
	}
	.img-address2{
		position:absolute;
		top:150px;
		left:80px;
		font-family:华文细黑;
		font-size:10px;
	}
	.img-idcard{
		position:absolute;
		top:210px;
		left:142px;
		font-family:OCR-B 10 BT;
		font-size:14px;
        letter-spacing:4px;
	}
	.img-head{
		position:absolute;
		top:45px;
		left:260px;
		font-family:华文细黑;
		font-size:10px;
        width:26mm; 
        height:32mm;
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
        	<div class="title"><span>注册</span></div>
          	<div class="left-con">
           		<div class="table">
           			<form name="applyRegisterForm">
           			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                      <tr>
	                        <td class="td-left">姓　　名</td>
	                        <td>
	                        	<input type="text" id="real_name"  class="txt-search" name="realName"/>
	                        </td>
	                      </tr>
	                      <tr>
	                        <td class="td-left">身份证号</td>
	                        <td><input type="text" id="id_card" class="txt-search" name="idCard"/></td>
	                      </tr>
	                      <tr>
	                        <td class="td-left">地　　址</td>
	                        <td><input type="text" id="address"  class="txt-search" name="address"/></td>
	                      </tr>
	                      <tr>
	                        <td class="td-left">电　　话</td>
	                        <td><input type="text" id="phone_no"  class="txt-search" name="phone"/></td>
	                      </tr>
	                      <tr>
	                        <td class="td-left">验 证 码</td>
	                        <td>
	                        	<input type="text" id="captch"  class="txt-search" style="width:200px;float:left;"/>
	                        	<input type="button" class="txt-search" style="width:150px;float:left; margin-left:20px;" 
	                        			value="获取验证码"/>
	                        </td>
	                      </tr>
                    	</table>
           			</form>
                </div>
                <div class="keyboard">
                	<div id="softkey"></div>
                </div>
            </div>
        </div>
        <div class="rightmain">
			<div class="idcard-block">
           	  	<div class="right-title">请您将二代身份证放置在身份证识别区</div>
                <div class="idcard-area">
                	<img alt="身份证图片" src="../css/images/pic2.jpg">
                	<div>
                		<div class="img-name"></div>
                		<div class="img-sex"></div>
                		<div class="img-nation"></div>
                		<div class="img-birth-year"></div>
                		<div class="img-birth-month"></div>
                		<div class="img-birth-day"></div>
                		<div class="img-address1"></div>
                		<div class="img-address2"></div>
                		<div class="img-idcard"></div>
                		<div class="img-head"></div>
                	</div>
                </div>
            </div>
            <div class="submit">
            	<a href="javascript:ApplyRegister.readIdCard();">
            		<input style="width:150px; height:50px; font-size:30px;" type="button" value="扫  描" />
            	</a>
            	<a id="submit_ar" href="javascript:;">
            		<input style="width:150px; height:50px; font-size:30px;" type="button" value="提  交" />
            	</a>
            	<a href="/zxkj/apply/toApplyPage.do">
            		<input style="width:150px; height:50px; font-size:30px;" type="button" value="返  回" />
            	</a>
            </div>
        </div>
    </div>  
</div>
</body>
<script type="text/javascript" src="../3th/virtualkeyboard/vk_loader.js?vk_layout=CN Chinese Simpl. Pinyin&vk_skin=flat_gray" ></script>
<script type="text/javascript" src="../3th/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../3th/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="../3th/jquery.alerts.js"></script>
<script type="text/javascript" src="../script/apply_manage/apply_register.js"></script>
</html>