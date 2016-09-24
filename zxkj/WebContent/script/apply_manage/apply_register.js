window.ApplyRegister = (function($, module)
{
	/**
	 * 重置身份证信息
	 * xxx-x-x-xxxx年xx月xx日-xxxxxxxxxxxx号-61011119900101501X-c:\xxxx.jpg
	 */
	function resetIdCardInfo(data)
	{
		if(!data)
		{
			return alert("信息读取失败,请重新读取!");
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
			return alert("信息读取失败,请重新读取!", "提示");
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

	/**
	 * 读身份证信息 
	 */
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
	    	alert("信息读取失败,请重新读取!", "提示");
	    }); 
	}
	
	/**
	 * 初始化软件盘插件 
	 */
	function initSoftKey()
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
	}
	
	/**
	 * 验证身份证信息是否填写 
	 */
	function validateIdCardInfo()
	{
		var _name = $('#real_name').val(),
		    _idCard = $('#id_card').val(),
		    _address = $('#address').val(),
		    _phoneNo = $('#phone_no').val(),
		    _captch = $('#captch').val();
		if(
				(_name && _name.length) 
				&& 
				(_idCard && _idCard.length)
				&& 
				(_address && _address.length)
				&& 
				(_phoneNo && _phoneNo.length)
				&&
				(_captch && _captch.length)
		)
		{
			return true;
		}
		else 
		{
			return false;
		}
		return false;
	}
	
	/**
	 * 跳转到税率确认页面 
	 */
	function toReateConfirmPage()
	{
		location.href = '/zxkj/apply/toRateconfirm.do';
		
		// 验证页面所填写内容
		/*if(!validateIdCardInfo())
		{
			return alert("请填写或扫描身份证信息!");
		}
		
		$.ajax({
			url : '/zxkj/apply/saveIdCardInfo.do',
			type : 'post',
			dataType : 'json',
			data : $('form[name="applyRegisterForm"]').serialize()
		}).done(function(userId)
		{
			if(userId)
			{
				alert("身份证信息保存成功!");
				location.href = '/zxkj/apply/toRateconfirm.do';
			}
			else 
			{
				alert("身份证信息保存失败!");
			}
			
		}).fail(function()
		{
			console.log('submitIdCardInfo fail!');
		});*/
	}
	

	
	/**
	 * 为按钮绑定事件
	 */
	function bindEvtForBtn()
	{
		$('#submit_ar').unbind().on('click', function()
		{
			toReateConfirmPage();
		});
	}
	
	function init()
	{
		// 初始化软件盘插件
		initSoftKey();
		
		bindEvtForBtn();
	}
	
	module.init = init;
	module.readIdCard = readIdCard;
	
	return module;
	
})($, window.ApplyRegister || {});

$(function()
{
	ApplyRegister.init();
});
