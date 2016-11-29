window.FingerEnter = (function($, module)
{
	var _folderPath_, _picExist = true, _timerHandle_;
	
	/**
	 * 重置按钮信息 
	 */
	function resetBtnInfo(data)
	{
		if(data)
		{
			var _arr = data.split('--');
			if(_arr[1])
			{
				$('.facebutton').html('<font size="6px;">指纹仪正常可用</font>');
				_folderPath_ = _arr[0];
			}
			else 
			{
				$('.facebutton').html('<font size="6px;">指纹仪出错,无法录入指纹</font>');
			}
		}
		else 
		{
			$('.facebutton').html('<font>指纹仪出错,无法录入指纹</font>');
		}
	}
	
	/**
	 * 开启录指纹的线程 
	 */
	function startSignFinger()
	{
		$.ajax({
			url : '/zxkj/sign/startSignFinger.do',
			type : 'get',
			dataType : 'text'
		}).done(function(data)
		{
			resetBtnInfo(data);
			
			// 判断指纹是否存在
			_timerHandle_ = setInterval(function()
			{
				$.ajax({
					url : '/zxkj/sign/judgeFingerExist.do?folderPath='+_folderPath_,
					type : 'get',
					dataType : 'text',
				}).done(function(fileExistFlag)
				{
					if("true" == fileExistFlag)
					{
						clearInterval(_timerHandle_); 
						_picExist = false;
						$('.summary').html($('.summary').attr('after'));
						$('.zhiwen').html('');
						var _pathArr = _folderPath_.split('/');
					    $('.zhiwen').css(
						{
							'background': 'rgba(0, 0, 0, 0) url(../zhi_wen_images/' + _pathArr[_pathArr.length - 1]
								+'/fingerprint.bmp) no-repeat scroll 50% 50% / auto padding-box border-box'
						});
					    $('.facebutton').html('<a href="/zxkj/sign/toContractPage.do"><input type="button" value="下一步" /></a>');
					}
					else 
					{
						$('.zhiwen').html('指纹获取中...');
					}
					
				}).fail(function()
				{
					console.log('judgeFingerExist fail!');
				});
			}, 2000);
		}).fail(function()
		{
			console.log('startSignFinger fail!');
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
		// 开启指纹仪
		startSignFinger();
	}
	
	module.init = init;
	
	return module;
	
})($, window.FingerEnter || {});

$(function()
{
	FingerEnter.init();
});
