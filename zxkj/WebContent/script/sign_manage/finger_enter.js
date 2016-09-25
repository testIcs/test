window.FingerEnter = (function($, module)
{
	/**
	 * 获取指纹信息
	 */
	function gainZWInfo()
	{
		//location.href = '/zxkj/sign/toContractPage.do';
		
		$.ajax({
			url : '/zxkj/sign/gainZWInfo.do',
			type : 'post',
			dataType : 'text'
		}).done(function(data)
		{
			if(data)
			{
				alert("指纹录制成功!");
				
				$('.zhiwen').css(
				{
					'background': 'rgba(0, 0, 0, 0) url('+data+') no-repeat scroll 0% 0% / auto padding-box border-box'
				});
				
				location.href = '/zxkj/sign/toContractPage.do';
			}
			else 
			{
				alert("指纹录制失败!");
			}
			
		}).fail(function()
		{
			console.log('submitIdCardInfo fail!');
		});
	}
	

	
	/**
	 * 为按钮绑定事件
	 */
	function bindEvtForBtn()
	{
		$('#zw_lz').unbind().on('click', function()
		{
			gainZWInfo();
		});
	}
	
	function init()
	{
		bindEvtForBtn();
	}
	
	module.init = init;
	
	return module;
	
})($, window.FingerEnter || {});

$(function()
{
	FingerEnter.init();
});
