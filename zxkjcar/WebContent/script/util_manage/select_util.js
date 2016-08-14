/**
 * 公共下拉框处理方法
 */
window.SelectUtilModule = (function($, module) {
	
	/**
	 * 初始化下拉框 
	 */
	function initSelectOptions(url, elementId, errorMsg)
	    {
	        $.ajax({
	            url : url,
	            type : "post",
	            dataType : "json"
	        }).done(function(data)
	        {
	        	debugger;
	            if (data && data.length)
	            {
	            	var auxArr = ['<option value="-1">请选择</option>'];
	            	$.each(data, function(index, key)
                    {
                        auxArr[auxArr.length] = "<option value='" + key["value"]
                                + "'>"
                                + key["name"]
                                + "</option>";
                    });
	            	$("#"+elementId).html(auxArr);
	            }
	        }).fail(function()
	        {
	        	console.log(errorMsg);
	        });
	    }

	module.initSelectOptions = initSelectOptions;
	
	return module;
	
})($, window.SelectUtilModule || {})

