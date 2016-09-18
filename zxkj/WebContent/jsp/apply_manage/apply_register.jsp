<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>��������</title>
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
		font-family:����ϸ��;
		font-size:14px;
	}
	.img-sex{
		position:absolute;
		top:67px;
		left:80px;
		font-family:����ϸ��;
		font-size:10px;
	}
	.img-nation{
		position:absolute;
		top:67px;
		left:160px;
		font-family:����ϸ��;
		font-size:10px;
	}
	.img-birth-year{
		position:absolute;
		top:100px;
		left:80px;
		font-family:�����������;
		font-size:10px;
	}
	.img-birth-month{
		position:absolute;
		top:100px;
		left:142px;
		font-family:�����������;
		font-size:10px;
	}
	.img-birth-day{
		position:absolute;
		top:100px;
		left:180px;
		font-family:�����������;
		font-size:10px;
	}
	.img-address1{
		position:absolute;
		top:131px;
		left:80px;
		font-family:����ϸ��;
		font-size:10px;
	}
	.img-address2{
		position:absolute;
		top:150px;
		left:80px;
		font-family:����ϸ��;
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
		font-family:����ϸ��;
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
        <div class="topright"><a href="/zxkj/home/home.do">��ҳ</a></div>
    </div>
    <div class="content">
		<div class="leftmain">
        	<div class="title"><span>ע��</span></div>
          	<div class="left-con">
           		<div class="table">
           			<form name="applyRegisterForm">
           			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                      <tr>
	                        <td class="td-left">�ա�����</td>
	                        <td>
	                        	<input type="text" id="real_name"  class="txt-search" name="user.realName"/>
	                        </td>
	                      </tr>
	                      <tr>
	                        <td class="td-left">���֤��</td>
	                        <td><input type="text" id="id_card" class="txt-search" name="user.idCard"/></td>
	                      </tr>
	                      <tr>
	                        <td class="td-left">�ء���ַ</td>
	                        <td><input type="text" id="address"  class="txt-search" name="user.address"/></td>
	                      </tr>
	                      <tr>
	                        <td class="td-left">�硡����</td>
	                        <td><input type="text" id="phone_no"  class="txt-search" name="user.phone"/></td>
	                      </tr>
	                      <tr>
	                        <td class="td-left">�� ֤ ��</td>
	                        <td>
	                        	<input type="text" id="captch"  class="txt-search" style="width:200px;float:left;"/>
	                        	<input type="button" class="txt-search" style="width:150px;float:left; margin-left:20px;" value="��ȡ��֤��"/>
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
           	  	<div class="right-title">�������������֤���������֤ʶ����</div>
                <div class="idcard-area">
                	<img alt="���֤ͼƬ" src="../css/images/pic2.jpg">
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
            	<a href="javascript:readIdCard();">
            		<input style="width:150px; height:50px; font-size:30px;" type="button" value="ɨ  ��" />
            	</a>
            	<a href="/zxkj/apply/toRateconfirm.do">
            		<input style="width:150px; height:50px; font-size:30px;" type="button" value="��  ��" />
            	</a>
            	<a href="/zxkj/apply/toApplyPage.do">
            		<input style="width:150px; height:50px; font-size:30px;" type="button" value="��  ��" />
            	</a>
            </div>
        </div>
    </div>
    <div class="footer">
    	<div class="footerleft"><span class="italic">�û����� ���ķ���</span><span class="f-a">Customer First Service Foremost</span></div>
        <div class="footerright"></div>
    </div>    
</div>
</body>
<script type="text/javascript" src="../3th/virtualkeyboard/vk_loader.js?vk_layout=CN Chinese Simpl. Pinyin&vk_skin=flat_gray" ></script>
<script type="text/javascript" src="../3th/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../3th/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="../3th/jquery.alerts.js"></script>
<script type="text/javascript">

	/**
	* xxx-x-x-xxxx��xx��xx��-xxxxxxxxxxxx��-61011119900101501X-c:\xxxx.jpg
	*/
	function resetIdCardInfo(data)
	{
		if(!data)
		{
			return alert("��Ϣ��ȡʧ��,�����¶�ȡ!", "��ʾ");
		}
		
		var _idCardInfoArr = data.split("-");
		
		if(!(
				_idCardInfoArr 
				&& 
				_idCardInfoArr[0] 
				&& 
				_idCardInfoArr[1] 
				&&
				_idCardInfoArr[2]
				&&
				_idCardInfoArr[3]
				&&
				_idCardInfoArr[4]
				&&
				_idCardInfoArr[5]
		))
		{
			return alert("��Ϣ��ȡʧ��,�����¶�ȡ!", "��ʾ");
		}

		$(".idcard-area img").next().addClass("img-div").end().remove();
		
		$("#real_name").val(_idCardInfoArr[0]);
		$("#address").val(_idCardInfoArr[4]);
		$("#id_card").val(_idCardInfoArr[5]);
		
		$(".img-name").html(_idCardInfoArr[0]);
		$(".img-sex").html(_idCardInfoArr[1]);
		$(".img-nation").html(_idCardInfoArr[2]);
		$(".img-birth-year").html(_idCardInfoArr[3].substring(0,4));
		$(".img-birth-month").html(_idCardInfoArr[3].substring(5,7));
		$(".img-birth-day").html(_idCardInfoArr[3].substring(8,10));
		$(".img-address1").html(_idCardInfoArr[4].substr(0,11));
		$(".img-address2").html(_idCardInfoArr[4].substring(11,_idCardInfoArr[4].length));
		$(".img-idcard").html(_idCardInfoArr[5]);
		$(".img-head").css({
			"background":"url("+window.location.protocol+"//"+window.location.host+"/zxkj/id_card_images/"+_idCardInfoArr[5]+".Jpg)"
		});
		
	}

	function readIdCard()
	{
		$.ajax({
			type : 'get',
			url : '/zxkj/apply/readIdCard.do'
		}).done(function(data)
	    {
			resetIdCardInfo(data);
	    }).fail(function()
	    {
	    	alert("��Ϣ��ȡʧ��,�����¶�ȡ!", "��ʾ");
	    }); 
	}
	
	$(function()
	{
		$('.txt-search').each(function(i, o)
		{
			$(o).on("focus", function()
			{
				var _self = this;
				VirtualKeyboard.toggle(_self.id, 'softkey');
				$("#kb_langselector, #kb_mappingselector, #copyrights").css("display", "none");
			}).on("blur", function()
			{
				var _self = this;
				VirtualKeyboard.toggle(_self.id, 'softkey');
			});
		});
	});
</script>
</html>