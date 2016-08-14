window.ValidaeUtil = (function($)
{
	
	return {
		"validatePhoneNo" : function(phoneNo)
		{
			return /^(13[0-9]|14[5|7]|15[0-9]|18[0-9])\d{8}$/.test(phoneNo);
		}
	};
	
})($);