//交付件新增模块化
window.BookingHall = (function($,module)
{
	function findBookingHallList(selDate)
	{
		var flag = selDate
		/**
		 * 预约时间段列表查询
		 */
		$.ajax( 
		{    
			url:"/zxkjcar/appoint/listBookingHall.do",   
			type:'post',    
			//cache:false, 
			dataType:'json',
			data: {
				dateStr : selDate
			},
			success:function(data) 
			{
				if(data.forbid=='true')
				{
					$("img[id$=_img]").attr("src","../css/images/grey.png");
					$("td[id$=_value]").html("周三不可申请");
					return false;
				}
				if (data.bookingHallList && data.bookingHallList.length!=0){
					$.each(data.bookingHallList, function(index, key) {
						var affairs = key["affairs"];
						var timeslotid = key["timeslotid"];
							if(45 < parseInt(affairs) && parseInt(affairs) <= 50){
								$("#td_"+parseInt(timeslotid)+"_img").attr("src","../css/images/yellow.png");
								$("#td_"+parseInt(timeslotid)+"_value").html("<a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="+(index+1)+">可申请</a>");
							}
							else if(50 < parseInt(affairs)&& parseInt(affairs)<=58){
								$("#td_"+parseInt(timeslotid)+"_img").attr("src","../css/images/red.png");
								$("#td_"+parseInt(timeslotid)+"_value").html("<a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="+(index+1)+">可申请</a>");
							}else if(parseInt(affairs) > 58){
								$("#td_"+parseInt(timeslotid)+"_img").attr("src","../css/images/grey.png");
								$("#td_"+parseInt(timeslotid)+"_value").html("不可申请");
							}else if (parseInt(affairs) <= 45){
								$("#td_"+parseInt(timeslotid)+"_img").attr("src","../css/images/green.png");
								$("#td_"+parseInt(timeslotid)+"_value").html("<a href='javaScript:void(0)' onclick='BookingHall.appointment(this)' id="+(index+1)+">可申请</a>");
							}
					});
				}   
			}
		});
	}

	/**
	 * 查看预约人员信息 
	 */
	function findAppointmentPeople()
	{
		window.location.href = "appoint_people.jsp?appDate="+$($('.sel span')[1]).html();
	}
	
	function bintEvtForBtn()
	{
		//查看预约大厅按钮事件邦定
		$("#findBookingHallList").on("click", function(){
			BookingHall.findBookingHallList(this);
		});
		
		// 查看预约按钮事件绑定
		$('#appointment_detail').on(
		{
			click : findAppointmentPeople
		});
	}
	
	//加载通知消息
	function loadNotice(){
		$.ajax({    
			url:"/zxkjcar/appoint/getNotice.do",   
			type:'post',    
			dataType:'json',
			success:function(data) 
			{
				if(data&&data.notice&&data.notice!=""){
					var noticeHtml="<div class=\"notice\">";
					noticeHtml+="<marquee direction=\"left\" behavior=\"scroll\" align=\"bottom\" height=\"40\" width=\"100%\" onmouseout=\"this.start()\" onmouseover=\"this.stop()\" scrollamount=\"2\" scrolldelay=\"1\">"+data.notice+"</marquee>";
					noticeHtml+"</div>"
					$("body").append(noticeHtml);
				}
			}
		});
	}
	
	//获取预约日期
	function getAppointmentDate(){
		$.ajax({    
			url:"/zxkjcar/appoint/getAppointmentDate.do",   
			type:'post',    
			dataType:'json',
			success:function(data) 
			{
				if(data){
					var $dateli="";
					$.each(data,function(i,list){
						var str = list.split("_")
						var selclass="";
						if(i==0)
						{
							selclass="sel";
						}
						$dateli+='<li id="MENU_'+(i+1)+'" class="day-block '+selclass+'"><span id="day_'+(i+1)+'">'+str[0]+'</span><br /><span id="date_'+(i+1)+'">'+str[1]+'</span></li>';
					})
					$("#main-menus").empty().append($dateli);
					
					//加载第一个数据
					findBookingHallList($("#date_1").text());
					
					//事件绑定
					$("li[id^=MENU_]").click(function(){
						$(this).parent().find("li").removeClass("sel");
			            $(this).addClass("sel");
			            findBookingHallList($(this).find("span[id^=date_]").text());
					})
				}
			}
		});
	}
	
	//初始化方法
	function init()
	{
		//获取预约日期
		getAppointmentDate();
		
		//加载通知消息
		loadNotice();
		
		bintEvtForBtn();
	}
	
	//预约申请，查询选中是时间段可申请事务的数量
	function appointment(obj){
		var day =$(".sel").find("span[id^=date_]").text();
		var sort = $(obj).attr("id")
		$.ajax( 
				{    
					url:"/zxkjcar/appoint/checkAppointment.do",   
					type:'post',    
					dataType:'json',
					data:{day:day,sort:sort},
					success:function(data) 
					{
						if(data.num>0){
							jAlert("该时间段还剩"+data.num+"可预约","提示",function(){
								window.location.href="/zxkjcar/jsp/appointment.jsp"
							})
						}else{
							jAlert("该时间段还剩"+data.num+"可预约","提示")
						}
						
					}
				});
		
	}
	
	module.init = init;
	module.findBookingHallList = findBookingHallList;
	module.appointment = appointment;
	
	
	return module;
})($,window.BookingHall || {});

//初始化
$(function()
{
	//模块初始化
	BookingHall.init();
});