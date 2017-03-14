window.SystemConfigModule = (function($, module)
{
	//获取预约设置数据
	function getAppointSeting(){
		$.ajax({    
			url: baseUrl+'/admin/config/getAppointSeting.do',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
		    success: function (data) {
				var $pass="",//预约日期的显示
				$operate="",//预约操作
				$allow="";//是否可以预约
				$.each(data,function(i,data){
					$pass+="<div class=\"row\">";
					$pass+=	"<div class=\"col-xs-4 text-left h34\">"+data.value+"</div>";
					$pass+=	"<div class=\"col-xs-8 text-right\">";
					$pass+=		"<p>";
					if(data.appointShow==2){
					$pass+=			"<input id=\"pass_"+data.id+"\" type=\"checkbox\" checked>";
					}else{
					$pass+=			"<input id=\"pass_"+data.id+"\" type=\"checkbox\">";	
					}
					$pass+=		"</p>";
					$pass+=	"</div>";
					$pass+="</div>";
					
					$operate+="<div class=\"row\">";
					$operate+=	"<div class=\"col-xs-4 text-left h34\">"+data.value+"</div>";
					$operate+=	"<div class=\"col-xs-8 text-right\">";
					$operate+=		"<p>";
					if(data.operateAppoint==2){
					$operate+=			"<input id=\"operate_"+data.id+"\" type=\"checkbox\" checked>";
					}else{
					$operate+=			"<input id=\"operate_"+data.id+"\" type=\"checkbox\">";	
					}
					$operate+=		"</p>";
					$operate+=	"</div>";
					$operate+="</div>";
					
					$allow+="<div class=\"row\">";
					$allow+=	"<div class=\"col-xs-4 text-left h34\">"+data.value+"</div>";
					$allow+=	"<div class=\"col-xs-8 text-right\">";
					$allow+=		"<p>";
					if(data.allowAppoint==2){
					$allow+=			"<input id=\"allow_"+data.id+"\" type=\"checkbox\" checked>";
					}else{
					$allow+=			"<input id=\"allow_"+data.id+"\" type=\"checkbox\">";	
					}
					$allow+=		"</p>";
					$allow+=	"</div>";
					$allow+="</div>";
				})
				$("#pass_setting").empty().append($pass);
				$("#operate_setting").empty().append($operate);
				$("#allow_setting").empty().append($allow);
				
				//开关按钮初始化
				$("input[type=\"checkbox\"]").not("[data-switch-no-init]").bootstrapSwitch({
					onText:"允许",  
			        offText:"禁止",
			        onSwitchChange:function(event,state){  
			            if(state==true){  
			                $(this).val("2");  
			            }else{  
			                $(this).val("1");  
			            }  
			            var id=$(this).attr("id");
			            var idArr = id.split("_");
			            if(idArr[0]=='pass'){
			            	updateConfig(idArr[1],$(this).val(),0,0,$(this));
			            }else if(idArr[0]=='operate'){
			            	updateConfig(idArr[1],0,$(this).val(),0,$(this));
			            }else if(idArr[0]=='allow'){
			            	updateConfig(idArr[1],0,0,$(this).val(),$(this));
			            }
			        }  
				});
		    },
		    complete: function () {
		    	$.hideLoadding();
		    },
		    error: function (data) {
		    	$.hideLoadding();
		        console.info("error: " + data.responseText);
		    }

		});
	}
	
	//更改配置
	function updateConfig(id,appointShow,operateAppoint,allowAppoint,obj){
		$.ajax({    
			url: baseUrl+'/admin/config/update.do',       
			type:'post',    
			cache:false,  			
			dataType:'json', 
			data:{id:id,appointShow:appointShow,operateAppoint:operateAppoint,allowAppoint:allowAppoint},
			beforeSend: function () {
				//$.showLoadding({loadText:"操作中，请稍候"});
		    },
		    success: function (data) {
		    	//更新失败
				if(data=="1"){
					//obj.bootstrapSwitch('toggleState');
					alert("提示","操作失败",null,{type:"error",confirmButtonText:"确定"});
				}
		    },
		    complete: function () {
		    	$.hideLoadding();
		    },
		    error: function (data) {
		    	$.hideLoadding();
		        console.info("error: " + data.responseText);
		    }

		});
	}
	
	//初始化方法
	function init(){
		getAppointSeting();
	}
	
	module.init = init;
	
	return module;
	
})($, window.SystemConfigModule || {});