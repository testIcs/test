/**
 * 公共请求url处理方法
 */
window.UrlUtilModule = (function($, module) {
	
	/**
	 * 解析url
	 */
	function request(paras)
	{ 
		var _url = location.href, 
			_paraString = _url.substring(_url.indexOf("?")+1,_url.length).split("&"), 
			_paraObj = {};
		
		for (i = 0; j = _paraString[i]; i++){ 
			_paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length); 
		} 
		
		return _paraObj[paras.toLowerCase()] || "";
	}

	/**
	 * 根据参数名获得该参数 
	 * pname等于想要的参数名
	 */ 
	function getParam(pname) { 
		// 获取参数 平且去掉？ 
	    var _params = location.search.substr(1), 
	        _arrParam = _params.split('&');
	    
	    //只有一个参数的情况
	    if (1 == _arrParam.length) { 
	        return _params.split('=')[1]; 
	    } 
	    
	    //多个参数参数的情况 
        for (var i = 0, len = _arrParam.length; i < len; i++) { 
        	var _arr = _arrParam[i].split('=');
            if (_arr[0] == pname) { 
                return _arr[1]; 
            } 
        } 
	}  
	
	return module;
	
})($, window.UrlUtilModule || {})

