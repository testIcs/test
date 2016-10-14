window.AppointPeople = (function($,module)
{
	/**
	 * 初始化某一天每个时段预约人信息  
	 */
	function initAppointPeople(data)
	{
		if(data && data.slotUsers)
		{
			var _htmStr = '<tr><td width="20%">时间</td><td>预约人</td></tr>',
			    _slotUserMapList = data.slotUsers;
			
			$.each(_slotUserMapList, function(i, slotUserMap)
			{
			    var _timeSlot = slotUserMap.slotName,
			        _userNames = slotUserMap.userNames,
			        _userNameArr = [];
			    $.each(_userNames, function(i, user)
			    {
			    	_userNameArr[_userNameArr.length] = user.userName;
			    });
			    _htmStr += '<tr><td>'+_timeSlot+'</td><td colspan="2">'+_userNameArr.join(', ')+'</td></tr>';
				
			});
			$('#appoint_people_table').html(_htmStr);
		}
	}
	
	/**
	 * 查找某一天每个时段预约人信息 
	 */
	function findAppointPeople(dateTime)
	{
		$.ajax(
		{
			type : 'post',
			url : '/zxkjcar/appoint/findEverySlotPeopleOneDay.do',
			dataTyle : 'json',
			data : 
			{
				'appDate' : dateTime	
			}
		}).done(function(data)
		{
			initAppointPeople(data);
			
		}).fail(function()
		{
			console.log('findAppointPeople error!');
		});
	}
	
	//初始化数据，默认显示当天的后一天数据
	function initData(){
		
	}
	
    //页面初始化
	function init(param)
	{
		$("#appDatePeo").val(param.appDatePeo);
		findAppointPeople(param.appDatePeo);
		
		$("#serach").click(function(){
			findAppointPeople($("#appDatePeo").val());
		})
	}
	
	
	module.init = init;
	
	return module;
	
})($,window.AppointPeople || {});