//交付件新增模块化
window.Appointment = (function($, module) 
{
	var _userLoginStatus_,selectsort;
	
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
			$.each(data.bookingHallList, function(index, key) {
				if(key.value==selectsort){
					auxArr[index] = "<option value='" + key["value"] + "' selected = 'selected'>"
					+ key["name"] + "</option>";
				}else{
					auxArr[index] = "<option value='" + key["value"] + "'>"
					+ key["name"] + "</option>";
				}
			});
			$('#appTimeSlotValue').html(auxArr.join(''));
		}
	});

	/**
	 * 注册提交 
	 */
	function appointmentSubmit() 
	{
		var appAffair = $("#appAffair").val();//预约数量
		var appDate = $("#appDate").val();//预约日期
		var appTimeSlotValue = $("#appTimeSlotValue").val();//预约时间段
		//提交前的检查
		if(!appointmentSubmitCheck(appAffair)){
			return false;
		};
		
		//查询选中是时间段可申请事务的数量
		$.ajax({
			url : "/zxkjcar/appoint/addAppointment.do",
			type : "post",
			dataType : "json",
			data : {
				appAffair : appAffair,
				appDate : appDate,
				appTimeSlotValue : appTimeSlotValue
			},
			beforeSend:function(){
	    	  $("#appointment_submit").val("处理中，请稍候...");
	    	  $("#appointment_submit").attr("disabled",true);
			}
		}).done(function(data) 
		{
			//重置提交按钮
			$("#appointment_submit").val("提交");
	    	$("#appointment_submit").attr("disabled",false);
			//回调处理
	    	if(data){
				if(data.result=='success'){
					alert("提示","预约成功",function(){
						window.location.href = 'home.jsp';
					},{type:"info",confirmButtonText:"确定"});
					return;
				}else{
			    	alert("提示",data.msg,null,{type:"error",confirmButtonText:"确定"});
				}
			}
	    	
		}).fail(function() 
		{
			//重置提交按钮
			$("#appointment_submit").val("提交");
	    	$("#appointment_submit").attr("disabled",false);
	    	alert("提示","预约发生错误",null,{type:"error",confirmButtonText:"确定"});
		});
	}
	
	/**
	 * 提交前的检查
	 */
	function appointmentSubmitCheck(appAffair){
		if(!appAffair.length)
		{
			alert("提示","预约数量不能为空",null,{type:"error",confirmButtonText:"确定"});
			return false;
		}
		
		if(appAffair==0)
		{
			alert("提示","预约数量不能为0!",null,{type:"error",confirmButtonText:"确定"});
			return false;
		}
		
		if(30 < appAffair)
		{
			alert("提示","预约数量最多为30个!",null,{type:"error",confirmButtonText:"确定"});
			return false;
		}
		
		return true;
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
		selectsort = param.selectsort
				
		// 为按钮绑定事件
		bindEventForButton();
	}

	module.init = init;

	return module;

})($, window.Appointment || {});