//交付件新增模块化
window.Appointment = (function($, module) 
{
	var _userLoginStatus_;
	
	function initStatusPromptMsg()
	{
		if("0" == _userLoginStatus_)
	    {
			$('#user_status_prompt').hide();
	    }
		else 
		{
			$('#user_status_prompt').html('您没有登录，不能提交，请先<a href="javascript:;">登录</a>').show();
		}
	}
	
	/**
	 * 预约时间段列表查询
	 */
	$.ajax({
		url : "/zxkjcar/commonData/findTimeSlots.do",
		type : 'get',
		cache : false,
		dataType : 'json',
		success : function(data) {
			var auxArr = [];
			//            auxArr[0] = "<option value='-1'>--</option>";
			$.each(data.bookingHallList, function(index, key) {
				auxArr[index] = "<option value='" + key["value"] + "'>"
						+ key["name"] + "</option>";
			});
			$('#appTimeSlotValue').html(auxArr.join(''));
		}
	});

	/**
	 * 补齐两位数 
	 */
	function padleft0(obj) 
	{
		return obj.toString().replace(/^[0-9]{1}$/, "0" + obj);
	}
	
	/**
	 * 计算天数差的函数，通用 
	 */  
	function DateDiff(sDate1) 
	{ 
		//sDate1和sDate2是2006-12-18格式  
		var nowtime = new Date();
		var year = nowtime.getFullYear();
		var month = padleft0(nowtime.getMonth() + 1);
		var day = padleft0(nowtime.getDate());
		var sDate2 = year + "-" + month + "-" + day;
		var aDate, oDate1, oDate2, iDays
		aDate = sDate1.split("-")
		oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]) //转换为12-18-2006格式  
		aDate = sDate2.split("-")
		oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])
		iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24) //把相差的毫秒数转换为天数  
		return iDays
	}

	/**
	 * 字符串转时间格式 
	 */  
	function getDate(strDate) 
	{
		var date = eval('new Date('
				+ strDate.replace(/\d+(?=-[^-]+$)/, function(a) {
					return parseInt(a, 10) - 1;
				}).match(/\d+/g) + ')');
		return date;
	}

	/**
	 * 注册提交 
	 */
	function appointmentSubmit() 
	{
		var appUserName = $("#appUserName").val();
		var appPhoneNo = $("#appPhoneNo").val();
		var appAffair = $("#appAffair").val();
		var appDate = $("#appDate").val();
		var appTimeSlotValue = $("#appTimeSlotValue").val();
		var dateDiffDay = DateDiff(appDate);
		
		if(!appPhoneNo.length)
		{
			return alert("手机号不能为空!");
		}
		
		if(!ValidaeUtil.validatePhoneNo(appPhoneNo))
		{
			return alert("手机号错误!");
		}
		
		if(!appAffair.length)
		{
			return alert("预约数量不能为空!");
		}
		
		if(30 < appAffair.length)
		{
			return alert("预约数量最多为30个!");
		}
		
		if(2 >= parseInt(dateDiffDay))
		{
			return alert("只能预约三天以后的时间请确认!");
		}
		
		$.ajax({
			url : "/zxkjcar/appoint/addAppointment.do",
			type : "post",
			dataType : "json",
			data : {
				appUserName : appUserName,
				appPhoneNo : appPhoneNo,
				appAffair : appAffair,
				appDate : getDate(appDate),
				appTimeSlotValue : appTimeSlotValue
			}
		}).done(function(data) 
		{
			if (!data) 
			{
				alert("预约成功");
				window.location.href = 'home.jsp';
				return;
			}
			alert("预约失败");
			return;
		}).fail(function() 
		{
			alert("预约发生错误");
		});
	}

	/**
	 * 为按钮绑定事件 
	 */
	function bindEventForButton() 
	{
		//注册按钮事件邦定
		$("#appointment_submit").on("click", function() {
			appointmentSubmit();
		});
	}

	//初始化方法
	function init(param) 
	{
		_userLoginStatus_ = param.status;
		
		// 初始化用户登录状态提示信息
		initStatusPromptMsg();
		
		// 邮箱提示
		// emailPrompt();

		// 为按钮绑定事件
		bindEventForButton();
	}

	module.init = init;

	return module;

})($, window.Appointment || {});