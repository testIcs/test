// 日期插件绑定
window.CommonDateTimePickerBind = (function($, module) {
	// 绑定日期控件 -从今天开始
	function bindDateTimePickerStart(elementId) {
		$("#" + elementId).datetimepicker({
			timepicker : false,
			scrollMonth : false,
			scrollTime : false,
			scrollInput : false,
			minDate: 0
		});
	}
	
	// 绑定日期控件
	function bindDateTimePicker(elementId) {
		$("#" + elementId).datetimepicker({
			timepicker : false,
			scrollMonth : false,
			scrollTime : false,
			scrollInput : false
		});
	}
	
	// 绑定日期控件 (开始日期到结束日期时间段)
	function bindStartToEndDateTimePicker(startElementID, endElementID) {
		$("#" + startElementID).datetimepicker({
			timepicker : false,
			scrollTime : false,
			scrollInput : false,
			onSelectDate : function(dateTime) {
				$("#" + endElementID).datetimepicker({
					controlType : 'select',
					minDate : $("#" + startElementID).val(),
					onSelect : function(dt) {
						$("#" + endElementID).datetimepicker("setDate", dt);
					}
				});
			}
		});
		$("#" + endElementID).datetimepicker({
			timepicker : false,
			scrollTime : false,
			scrollInput : false,
			onSelectDate : function(dateTime) {
				$("#" + startElementID).datetimepicker({
					controlType : 'select',
					maxDate : $("#" + endElementID).val(),
					onSelect : function(dt) {
						$("#" + startElementID).datetimepicker("setDate", dt);
					}

				});
			}
		});
	}

	
	module.bindDateTimePicker = bindDateTimePicker;
	module.bindDateTimePickerStart = bindDateTimePickerStart;
	module.bindStartToEndDateTimePicker = bindStartToEndDateTimePicker;
	return module;

})($, window.CommonDateTimePickerBind || {});

/**
 * 定义公共的用来处理按钮被多次点击
 */
window.CommonHandlePreventMoreClickButton = (function($, module) {
	
	/**
	 * 回调
	 */
	function callBack(){
		with (arguments.callee) {
			//只需执行一次,便可以更改按钮状态
			do{
				$(obj).css({
					"background-color":"#ccc",
					"cursor":"text"
				});
				$(obj).attr("disabled", "disabled");
				
			}while(-1 > 0);
			
			window.console.log("loop: " + loop);
			
			loop = loop-1;
			
			if (0 == loop) {
				$(obj).css({
					"background-color":"#ddd",
					"cursor":"pointer"
				});
				$(obj).removeAttr("disabled");
				clearInterval(sh);
				return;
			}	
		}
	}
	
	/**
	 * 定期执行
	 */
	function periodicalExecuter(evt, elementId){
		callBack.obj = evt;
		callBack.loop = 5;
		sh = setInterval(function(){
			callBack();
		},1000);
	}
	
	/**
	 * 处理按钮多次点击
	 */
	function handlePreventMoreClick(evt,elementId){
		periodicalExecuter(evt, elementId);
	}
	
	module.periodicalExecuter = periodicalExecuter;
	module.handlePreventMoreClick = handlePreventMoreClick;
	
	return module;
})($, window.CommonHandlePreventMoreClickButton || {})

