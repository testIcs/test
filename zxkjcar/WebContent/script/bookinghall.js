//交付件新增模块化
window.BookingHall = (function($,module)
{
	
	//补齐两位数
    function padleft0(obj) 
    {
        return obj.toString().replace(/^[0-9]{1}$/, "0" + obj);
    }
	
	/**
	*获取某日期后几个工作日后的日期
	*参数:date:给定日期;itervalByDay:相隔工作日
	*/
	function getworkday(dat,itervalByDay)
	{
		var str=dat.split("-");
		var date=new Date(); 
		date.setUTCFullYear(str[0], str[1] - 1, str[2]); 
		date.setUTCHours(0, 0, 0, 0); 
		var millisceonds =date.getTime();
		for(var i=1;i<=itervalByDay;i++){
		millisceonds +=24*60*60*1000;
		date.setTime(millisceonds);
		if(date.getDay()==0||date.getDay()==6) i--;
		}
		
		return date;
		}
	
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
				if (data.bookingHallList && data.bookingHallList.length!=0){
					$.each(data.bookingHallList, function(index, key) {
						var affairs = key["affairs"];
						var timeslotid = key["timeslotid"];
							if(50 < parseInt(affairs)&& parseInt(affairs) < 80){
								$("#td_"+parseInt(timeslotid)+"_img img").removeAttr("src");
								$("#td_"+parseInt(timeslotid)+"_img img").attr("src","../css/images/yellow.png");
								$("#td_"+parseInt(timeslotid)+"_value").html("可申请");
							}
							else if(80 < parseInt(affairs) && parseInt(affairs) <99){
								$("#td_"+parseInt(timeslotid)+"_img img").removeAttr("src");
								$("#td_"+parseInt(timeslotid)+"_img img").attr("src","../css/images/red.png");
								$("#td_"+parseInt(timeslotid)+"_value").html("可申请");
							}else if(parseInt(affairs) > 99){
								$("#td_"+parseInt(timeslotid)+"_img").removeAttr("src");
								$("#td_"+parseInt(timeslotid)+"_img").attr("src","../css/images/green.png");
								$("#td_"+parseInt(timeslotid)+"_value").html("不可申请");
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
	
	//初始化方法
	function init()
	{
		var Week = ['周日','周一','周二','周三','周四','周五','周六']; 
		for(var i=1 ;i <6 ; i++){
			/**
			 * 根据日期得到当天日期
			 * 然后进行校验得到三天以后的日期
			 */
			var nowtime = new Date();
			var year = nowtime.getFullYear();
			var month = padleft0(nowtime.getMonth() + 1);
			var day = padleft0(nowtime.getDate());
			var date = getworkday(year + "-" + month + "-" + day ,i+2);
			
			/**
			 * 根据返回的日期进行界面赋值，显示日期和星期
			 */
			var year = date.getFullYear(); 
			var month = date.getMonth() + 1; 
			var day = date.getDate(); 
			var rq = year + "-" + padleft0(month) + "-" + padleft0(day);
			var day = date.getUTCDay();
			$("#day_"+i).html(Week[date.getUTCDay()]);
			$("#date_"+i).html(rq);
		}
		//邮箱提示
		findBookingHallList($("#date_1").text());
	}
	
	bintEvtForBtn();
	
	module.init = init;
	module.findBookingHallList = findBookingHallList;
	
	
	return module;
})($,window.BookingHall || {});

//初始化
$(function()
{
	//模块初始化
	BookingHall.init();
	
	// 初始化菜单
    $("#main-menus").on("click", "li[id]", function(event)
    {
    	for(var i=1;i<9;i++){
    		$("#td_"+parseInt(i)+"_img img").removeAttr("src");
    		$("#td_"+parseInt(i)+"_img img").attr("src","../css/images/green.png");
    		$("#td_"+parseInt(i)+"_value").html("可申请");
    	}
        var id = $(this).attr("id");
        var num = id.split("_")[1];
        if (id == "MENU_2")
        { // 第二天
            $(this).parent().find("li").removeClass("sel");
            $(this).addClass("sel");
            BookingHall.findBookingHallList($("#date_"+num).text());
        }
        else if (id == "MENU_3")
        { // 第三天
            $(this).parent().find("li").removeClass("sel");
            $(this).addClass("sel");
            BookingHall.findBookingHallList($("#date_"+num).text());
        }
        else if (id == "MENU_4")
        { // 第四天
            $(this).parent().find("li").removeClass("sel");
            $(this).addClass("sel");
            BookingHall.findBookingHallList($("#date_"+num).text());
        }
        else if (id == "MENU_5")
        { // 第五天
            $(this).parent().find("li").removeClass("sel");
            $(this).addClass("sel");
            BookingHall.findBookingHallList($("#date_"+num).text());
        }
        else
        {
            $(this).parent().find("li").removeClass("sel");
            $(this).addClass("sel");
            BookingHall.findBookingHallList($("#date_"+num).text());
        }
    });
});