
$(function(){
	/**
	 * 贷款产品
	 */
	$.ajax( {    
		url:'/micromsg/rest/bug/listloantype?_='+new Date().getTime()+"&",      
		type:'get',    
		cache:false, 
		dataType:'json', 
		success:function(data) {
			var auxArr = [];
//            auxArr[0] = "<option value='-1'>--</option>";
			$.each(data.bugList, function(index, key) {
				console.log(key);
                    auxArr[index] = "<option value='" + key["value"] + "'>" + key["name"]+ "</option>";
			});
			$('#listLoanType').html(auxArr.join(''));
		 }   
	});
	
	/**
	 * 贷款期限
	 */
	$.ajax( {    
		url:'/micromsg/rest/bug/listloanterm?_='+new Date().getTime()+"&",      
		type:'get',    
		cache:false, 
		dataType:'json', 
		success:function(data) {
			var auxArr = [];
//            auxArr[0] = "<option value='-1'>--</option>";
			$.each(data.bugList, function(index, key) {
                    auxArr[index] = "<option value='" + key["value"] + "'>" + key["name"]+ "</option>";
			});
			$('#listLoanTerm').html(auxArr.join(''));
		 }   
	});
	
	$("#loanlimitsubmit").click(function(){
		loanLimitResul();
	});
	
})

/**
 * 贷款额计算结果
 */
function loanLimitResultTable(data){
	debugger;
	var thePrice = $("#thePrice").val();
	var loanLimit = 0;
	var listLoanType = $("#listLoanType option:selected").val();
	var listLoanTerm = $("#listLoanTerm option:selected").val();
	var listLoanTypeText = $("#listLoanType option:selected").text();
	var listLoanTermText = $("#listLoanTerm option:selected").text();
	var loanBaseValue =0;
	var ratioNum = 0;
	$.each(data.bugList, function(index, key) {
		loanBaseValue = key.loanBaseValue;
		ratioNum      = key.ratioNum;
	});
	var allMonth = MathUtil.accMul(listLoanTerm,12);//总月数
	var ratioNum = MathUtil.accMul(ratioNum,1);//转成数字产品最小首付比例
	var ratioMoney = MathUtil.accMul(thePrice,MathUtil.accDiv(ratioNum, 100));//首付金额
	listLoanTerm = MathUtil.accMul(listLoanTerm,1);//转成数字
	loanLimit = MathUtil.accMul(MathUtil.Subtr(thePrice,ratioMoney),1);//贷款额度
	var moneyW = MathUtil.accDiv(loanLimit, 10000);//以万元为单位
	var payEachMouth = (loanBaseValue*moneyW*listLoanTerm+loanLimit)/allMonth;//月供
	var theCarAllMonye = (loanBaseValue*moneyW*listLoanTerm+loanLimit);//总价
	var htmlResult="";
		htmlResult +='<div class="line"><span class="l">车价：</span><span class="r">'+thePrice+'元</span></div>';
		htmlResult +='<div class="line"><span class="l">首付金额：</span><span class="r">'+ratioMoney+'元</span></div>';
		htmlResult +='<div class="line"><span class="l">贷款额度：</span><span class="r">'+loanLimit+'元</span></div>';
		htmlResult +='<div class="line"><span class="l">月供：</span><span class="r" style="color: Orange;"><b>'+payEachMouth.toFixed(2)+'</b>元</span></div>';
		htmlResult +='<div class="line"><span class="l">产品：</span><span class="r">'+listLoanTypeText+'</span></div>';
		htmlResult +='<div class="line"><span class="l">贷款期限：</span><span class="r">'+listLoanTermText+'</span></div>';
		htmlResult +='<div class="line"><span class="l">提车价：</span><span class="r" style="color: red;"><b>'+theCarAllMonye.toFixed(2)+'</b>元</span></div>';
	$('#result_div_loanlimit').html(htmlResult); 
}

function loanLimitResul() {
	
	var thePrice = $("#thePrice").val();
	var loanLimit = 0;
	var listLoanType = $("#listLoanType option:selected").val();
	var listLoanTerm = $("#listLoanTerm option:selected").val();
    $('#bugCue').html("");
	if("" == thePrice){
        $('#thePrice').html("<font color='red'><b>请输入车价</b></font>");
        return false;
    }
	if(10 < thePrice.length){
        $('#thePrice').html("<font color='red'><b>车价不能超过10个字符</b></font>");
        return false;
    }
//	if("" == loanLimit){
//        $('#bugCue').html("<font color='red'><b>请输入贷款额度</b></font>");
//        return false;
//    }
//	if(10 < loanLimit.length){
//        $('#bugCue').html("<font color='red'><b>贷款额度不能超过10个字符</b></font>");
//        return false;
//    }
	$("#loanlimitresult").unbind("click").attr("class","btnGray");
	
	$.ajax({
		url : '/micromsg/rest/bug/loanlimitresult ',// servlet请求路径
		type:'get',    
		cache:false, 
		dataType:'json', 
		data : {
			thePrice:thePrice,
			//loanLimit:loanLimit,
			loanTypeId:listLoanType,
			loanTermId:listLoanTerm
			}, // 其它请求参数
		success : function(data, status) {
			loanLimitResultTable(data);
		},
		error : function(data, status, e) {
			jAlert('提交缺陷出错',"信息");
			$("#asubmit").click(function(){
				ajaxFileUpload();
			}).attr("class","btn");
		}
	})
	return false;
}
function HTMLDecode(text) 
{ 
	$('#htmlDecode').html(text); 
	var output = $('#htmlDecode').text(); 
	$('#htmlDecode').html('');
	var returnValue = output;
	output=null;
	return returnValue; 
} 
function request(paras)
{ 
	var url = location.href; 
	var paraString = url.substring(url.indexOf("?")+1,url.length).split("&"); 
	var paraObj = {} 
	for (i=0; j=paraString[i]; i++){ 
		paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length); 
	} 
	var returnValue = paraObj[paras.toLowerCase()]; 
	if(typeof(returnValue)=="undefined"){ 
		return ""; 
	}else{ 
		return returnValue; 
	} 
}
