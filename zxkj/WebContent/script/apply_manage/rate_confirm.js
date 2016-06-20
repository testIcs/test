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
	
	function init(){
		initSelect();
	}
	
	module.init = init;
	
	return module;
	
})($, window.RateConfirmModule || {});

$(function(){
	RateConfirmModule.init();
});