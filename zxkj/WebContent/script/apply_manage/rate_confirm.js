window.RateConfirmModule = (function($, module){
	
	/**
	 * 初始化金融产品下拉框 
	 */
	function initFinancialProductsSelect(){
		SelectUtilModule.initSelectOptions("/zxkj/dic/findFinancialProducts.do", "fp_rc", 
							"initFinancialProductsSelect failed!");
	} 
	
	/**
	 * 初始化贷款利率下拉框 
	 */
	function initLendingRateSelect(){
		SelectUtilModule.initSelectOptions("/zxkj/dic/findLendingRate.do", "lr_rc", 
							"initLendingRateSelect failed!");
	}
	
	/**
	 * 初始化贷款期限下拉框 
	 */
	function initLoanTermSelect(){
		SelectUtilModule.initSelectOptions("/zxkj/dic/findLoanTerm.do", "lt_rc", 
							"initLoanTermSelect failed!");
	}
	
	/**
	 * 初始化下拉框 
	 */
	function initSelect(){
		initFinancialProductsSelect();
		initLendingRateSelect();
		initLoanTermSelect();
	}
	
	function validateLoanVal()
	{
		var _typeId = parseInt($('#fp_rc').val()),
		    _termId = parseInt($('#lt_rc').val()),
		    _rateId = parseInt($('#lr_rc').val());
		return ((-1 != _typeId) && (-1 != _termId) && (-1 != _rateId));
		 
	}
	
	function saveLoanInfo()
	{
		if(!validateLoanVal())
		{
			return alert("请选择相关项");
		}
		var _typeId = parseInt($('#fp_rc').val());
		
		$.ajax(
		{
			type : 'post',
			url : '/zxkj/apply/saveLoanInfo.do',
			dataType : 'json',
			data : $('form[name="loanForm"]').serialize()
		}).done(function(data)
		{
			if(data)
			{
				alert("保存成功", "提示");
				if((1 == _typeId) || (2 == _typeId) || (3 == _typeId)){//modify by wlh
					location.href='/zxkj/apply/toWarrantPage.do';
				}else{
					alert("less");
					location.href='/zxkj/apply/toWarrantPageForLessInfo.do';
				}
			}else{
				alert("保存失败", "提示");
			}
			
		}).fail(function()
		{
			console.log('saveLoanInfo fail!');
		});
	}
	
	function bindEvtForBtn()
	{
		$('#loan_save').unbind().on(
		{
			'click': saveLoanInfo
		});
		
	}
	
	function init(){
		initSelect();
		
		bindEvtForBtn();
	}
	
	module.init = init;
	
	return module;
	
})($, window.RateConfirmModule || {});

$(function(){
	RateConfirmModule.init();
});