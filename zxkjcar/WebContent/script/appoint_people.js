window.AppointPeople = (function($,module)
{
	var _appDate_;
	
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
				debugger;
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
	function findAppointPeople()
	{
		$.ajax(
		{
			type : 'post',
			url : '/zxkjcar/appoint/findEverySlotPeopleOneDay.do',
			dataTyle : 'json',
			data : 
			{
				'appDate' : _appDate_	
			}
		}).done(function(data)
		{
			initAppointPeople(data);
			
		}).fail(function()
		{
			console.log('findAppointPeople error!');
		});
	}
	
	function init(param)
	{
		debugger;
		_appDate_ = param.appDate;
		findAppointPeople();
	}
	
	
	module.init = init;
	
	return module;
	
})($,window.AppointPeople || {});