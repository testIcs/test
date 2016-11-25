
$(function(){
	/**
	 * 贷款产品
	 */
	$.ajax( {    
		url: baseurl+'/dic/findFinancialProducts.do',      
		type:'post',    
		cache:false, 
		dataType:'json', 
		success:function(data) {
			var auxArr = [];
			$.each(data, function(index, key) {
                    auxArr[index] = "<option value='" + key["value"] + "'>" + key["name"]+ "</option>";
			});
			$('#listLoanType').html(auxArr.join(''));
		 }   
	});
	
	/**
	 * 贷款期限 
	 */
	$.ajax( {    
		url: baseurl+'/dic/findLoanTerm.do',  
		type:'post',    
		cache:false, 
		dataType:'json', 
		success:function(data) {
			var auxArr = [];
			$.each(data, function(index, key) {
                    auxArr[index] = "<option value='" + key["value"] + "'>" + key["name"]+ "</option>";
			});
			$('#listLoanTerm').html(auxArr.join(''));
		 }   
	});
	
	$("#loanlimitsubmit").click(function(){
		loanLimitResul();
	});
	
})

//试算
function loanLimitResul() {
	$("#errormsg").empty();
	$("#result_div_loanlimit").empty();
	//1非空判断
	var thePrice = $("#thePrice").val();
	var phoneNo = $("#phoneNO").val()
	var loanLimit = 0;
	var listLoanType = $("#listLoanType option:selected").val();
	var listLoanTerm = $("#listLoanTerm option:selected").val();
	if("" == thePrice){
        $('#errormsg').html("<font color='red'><b>请输入车价</b></font>");
        return false;
    }
	if(8 < thePrice.length){
        $('#errormsg').html("<font color='red'><b>车价不能超过8个字符</b></font>");
        return false;
    }
	/*if(""==phoneNo)//wlh 20161125 手机号不再必填
	{
		$('#errormsg').html("<font color='red'><b>请输入手机号</b></font>");
        return false;
	}*/
	var reg = /^0?1[3|4|5|7|8][0-9]\d{8}$/;
	if (""!=phoneNo&&reg.test(phoneNo)) {
		$('#errormsg').html("<font color='red'><b>请输入正确的手机号</b></font>");
        return false;
	}
	loanLimitResultTable();
	return false;
}

/**
 * 贷款额计算结果
 */
function loanLimitResultTable(){
	var thePrice = $("#thePrice").val();//总价
	var loanLimit = $("#loanLimit").val();//保险金额
	var loanLimit2 = $("#loanLimit2").val();//购置税费
	var listLoanType = $("#listLoanType option:selected").val();//贷款产品
	var listLoanTerm = $("#listLoanTerm option:selected").val();//贷款期限
	var addFirstPayMent = $("#addFirstPayMent option:selected").val();//增加首付
	/**
	 * 1	简易通-A
		2	简易通-C
		3	简易通-D
		4	车融通-A
		5	车融通-C
		6	车融通-D
		7	车融-E证通
		8	车易通-A（5%保证金）
		9	车易通-C（10%保证金）
		10	车易通-D
	 */
	if(listLoanType =="1"){
		getResultJA(thePrice, listLoanTerm, addFirstPayMent);
	}else if (listLoanType =="2"){
		getResultJC(thePrice, listLoanTerm, addFirstPayMent);
	}else if (listLoanType =="3"){
		getResultJD(thePrice, listLoanTerm, addFirstPayMent);
	}else if (listLoanType =="4"){
		getResultRA(thePrice, listLoanTerm, addFirstPayMent);
	}else if (listLoanType =="5"){
		getResultRC(thePrice, listLoanTerm, addFirstPayMent);
	}else if (listLoanType =="6"){
		getResultRD(thePrice, listLoanTerm, addFirstPayMent);
	}else if (listLoanType =="7"){
		getResultRE(thePrice, loanLimit, loanLimit2, listLoanTerm);
	}else if (listLoanType =="8"){
		getResultA(thePrice, listLoanTerm, addFirstPayMent);
	}else if (listLoanType =="9"){
		getResultC(thePrice, listLoanTerm, addFirstPayMent);
	}else if (listLoanType =="10"){
		getResultD(thePrice, listLoanTerm, addFirstPayMent);
	}
}

function htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods){
//	var htmlResult="";
//	htmlResult +='<div class="line"><span class="l">&#x9996;&#x4ED8;&#x91D1;&#x989D;&#xFF1A;</span>'+
//		'<span class="r">'+firstpayment.toFixed(2)+'元</span></div>';
//	htmlResult +='<div class="line"><span class="l">&#x4FDD;&#x8BC1;&#x91D1;&#x989D;&#xFF1A;</span>'+
//		'<span class="r">'+deposit.toFixed(2)+'元</span></div>';
//	htmlResult +='<div class="line"><span class="l">&#x6BCF;&#x6708;&#x79DF;&#x91D1;&#xFF1A;</span>'+
//	'<span class="r">'+rent.toFixed(2)+'元</span></div>';
//	htmlResult +='<div class="line"><span class="l">&#x6BCF;&#x65E5;&#x79DF;&#x91D1;&#xFF1A;</span>'+
//		'<span class="r" style="color: Orange;"><b>'+dailyrent.toFixed(2)+'</b>元</span></div>';
//	htmlResult +='<div class="line"><span class="l">&#x6BCF;&#x65E5;&#x79DF;&#x91D1;&#xFF1A;</span>'+
//		'<span class="r">'+periods.toFixed(2)+'</span></div>';
//$('#result_div_loanlimit').html(htmlResult); 
	//将结果返回到后台
	$.ajax({
		url : baseurl+'/trial/loanlimitresult.do',//
		type:'post',    
		cache:false, 
		dataType:'json', 
		data : {
			phoneNo:$("#phoneNO").val(),
			firstpayment:firstpayment.toFixed(2),
			deposit:deposit.toFixed(2),
			rent:rent.toFixed(2),
			dailyrent:dailyrent.toFixed(2),
			periods:periods.toFixed(2)
			}, // 其它请求参数
		success : function(data, status) {
			if(data.result=='0')
			{
				alert('测算结果已发达您的手机上，请注意查收',"提示");
			}
			else
			{
				alert('出错了',"提示");
			}
		},
		error : function(data, status, e) {
			alert('出错了',"信息");
		}
	})
}

//车易通A
function getResultA(carprice, operator, shoufu){
	var carprice=parseInt(carprice);
	var loan=parseInt(loan);
	var rent=parseInt(rent);
	var deposit=parseInt(deposit);
	var periods=parseInt(periods);
	var dailyrent=parseInt(dailyrent);
	var downpayment=parseInt(downpayment);
	var firstpayment=parseInt(firstpayment);
	var rate=parseInt(rate);
	firstpayment=carprice*shoufu;
	if(!(isNaN(carprice))) loan=carprice-firstpayment+470;
	else{alert("请您输入车价")}
	deposit=carprice*0.05;//
	if(operator=="1"){periods=12;rate=7.035}
	else if(operator=="2"){periods=24;rate=10.656}
	else if(operator=="3"){periods=36;rate=11.9265}
	else if(operator=="4"){periods=48;rate=12.573}
	else if(operator=="5"){periods=60;rate=12.963}
	else{alert("请您选择融资年限")}
	rate=rate/1200;
	var rent=(rate*Math.pow(1+rate,periods)*loan)/(Math.pow(1+rate,periods)-1);
	dailyrent=rent/30;
	displayResultInfo(firstpayment, deposit, rent, dailyrent, periods);
	//填写页面数据
	htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods);
}

//车易通C
function getResultC(carprice, operator, shoufu){
	var carprice=parseInt(carprice);
	var loan=parseInt(loan);
	var rent=parseInt(rent);
	var deposit=parseInt(deposit);
	var periods=parseInt(periods);
	var dailyrent=parseInt(dailyrent);
	var downpayment=parseInt(downpayment);
	var firstpayment=parseInt(firstpayment);
	var rate=parseInt(rate);firstpayment=carprice*shoufu;
	if(!(isNaN(carprice)))loan=carprice-firstpayment+470;
	else{alert("请您输入车价")}
	deposit=carprice*0.1;
	if(operator=="1"){periods=12;rate=13.957}
	else if(operator=="2"){periods=24;rate=13.144}
	else if(operator=="3"){periods=36;rate=12.916}
	else if(operator=="4"){periods=48;rate=12.8385}
	else if(operator=="5"){periods=60;rate=12.8180}
	else{alert("请您选择融资年限")}rate=rate/1200;
	var rent=(rate*Math.pow(1+rate,periods)*loan)/(Math.pow(1+rate,periods)-1);
	dailyrent=rent/30;periods=periods-deposit/rent;
	displayResultInfo(firstpayment, deposit, rent, dailyrent, periods);
	//填写页面数据
	htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods);
}

//车易通D
function getResultD(carprice, operator, shoufu){
	var carprice=parseInt(carprice);
	var loan=parseInt(loan);
	var rent=parseInt(rent);
	var deposit=parseInt(deposit);
	var periods=parseInt(periods);
	var dailyrent=parseInt(dailyrent);
	var downpayment=parseInt(downpayment);
	var firstpayment=parseInt(firstpayment);
	var rate=parseInt(rate);
	firstpayment=carprice*shoufu+carprice*0.2;
	if(!(isNaN(carprice)))loan=carprice-firstpayment+470;
	else{alert("请您输入车价")}
	deposit=0;
	if(!(isNaN(carprice))){
		if(operator=="1"){periods=12;rate=16.625}
		else if(operator=="2"){periods=24;rate=15.773}
		else if(operator=="3"){periods=36;rate=15.475}
		else if(operator=="4"){periods=48;rate=15.323}
		else if(operator=="5"){periods=60;rate=15.232}}
	else{alert("请您选择融资年限")}rate=rate/1200;
	var rent=(rate*Math.pow(1+rate,periods)*loan)/(Math.pow(1+rate,periods)-1);
	dailyrent=rent/30;
	displayResultInfo(firstpayment, deposit, rent, dailyrent, periods);
	//填写页面数据
	htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods);
}
//简易通-A
function getResultJA(carprice, operator, shoufu){
	var carprice=parseInt(carprice);
	var loan=parseInt(loan);
	var rent=parseInt(rent);
	var deposit=parseInt(deposit);
	var periods=parseInt(periods);
	var dailyrent=parseInt(dailyrent);
	var downpayment=parseInt(downpayment);
	var firstpayment=parseInt(firstpayment);
	var rate=parseInt(rate);
	firstpayment=carprice*shoufu+carprice*0.4;
	if(!(isNaN(carprice)))loan=carprice-firstpayment+470;
	else{alert("请您输入车价")}
	deposit=0;
	if(!(isNaN(carprice))){
		if(operator=="1"){periods=12;rate=16.15}
		else if(operator=="2"){periods=24;rate=15.3}
		else if(operator=="3"){periods=36;rate=15.002}}
	else{alert("请您输入车价")}rate=rate/1200;
	var rent=(rate*Math.pow(1+rate,periods)*loan)/(Math.pow(1+rate,periods)-1);
	dailyrent=rent/30;
	displayResultInfo(firstpayment, deposit, rent, dailyrent, periods);
	//填写页面数据
	htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods);
}

//简易通-C
function getResultJC(carprice, operator, shoufu){
	//var carprice=document.getElementById("carprice").value;
	//var operator=document.getElementById("operator").value;
	//var shoufu=document.getElementById("shoufu").value;
	var carprice=parseInt(carprice);
	var loan=parseInt(loan);
	var rent=parseInt(rent);
	var deposit=parseInt(deposit);
	var periods=parseInt(periods);
	var dailyrent=parseInt(dailyrent);
	var downpayment=parseInt(downpayment);
	var firstpayment=parseInt(firstpayment);
	var rate=parseInt(rate);
	firstpayment=carprice*shoufu;
	if(!(isNaN(carprice)))loan=carprice-firstpayment+470;
	else{alert("请您输入车价")}
	deposit=0;
	if(!(isNaN(carprice))){
		if(operator=="1"){periods=12;rate=-46.41}
		else if(operator=="2"){periods=24;rate=-18.347}
		else if(operator=="3"){periods=36;rate=-8.395}}
	else{alert("请您输入车价")}rate=rate/1200;
	var rent=(rate*Math.pow(1+rate,periods)*loan)/(Math.pow(1+rate,periods)-1);
	dailyrent=rent/30;
	firstpayment=carprice*shoufu+carprice*0.3;
	displayResultInfo(firstpayment, deposit, rent, dailyrent, periods);
	//填写页面数据
	htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods);
}

//简易通-D
function getResultJD(carprice, operator, shoufu){
	//var carprice=document.getElementById("carprice").value;
	//var operator=document.getElementById("operator").value;
	//var shoufu=document.getElementById("shoufu").value;
	var carprice=parseInt(carprice);
	var loan=parseInt(loan);
	var rent=parseInt(rent);
	var deposit=parseInt(deposit);
	var periods=parseInt(periods);
	var dailyrent=parseInt(dailyrent);
	var downpayment=parseInt(downpayment);
	var firstpayment=parseInt(firstpayment);
	var rate=parseInt(rate);firstpayment=carprice*shoufu;
	if(!(isNaN(carprice)))loan=carprice-firstpayment+470;
	else{alert("请您输入车价")}
	deposit=0;
	if(!(isNaN(carprice))){
		if(operator=="1"){periods=12;rate=-46.55}
		else if(operator=="2"){periods=24;rate=-18.422}
		else if(operator=="3"){periods=36;rate=-8.447}
		else if(operator=="4"){alert("简易通D产品最高融资3年")}
		else if(operator=="5"){alert("简易通D产品最高融资3年")}}
	else{alert("请您输入车价")}rate=rate/1200;
	var rent=(rate*Math.pow(1+rate,periods)*loan)/(Math.pow(1+rate,periods)-1);dailyrent=rent/30;
	firstpayment=carprice*shoufu+carprice*0.3;
	displayResultInfo(firstpayment, deposit, rent, dailyrent, periods);
	//填写页面数据
	htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods);
}

//车融通-A
function getResultRA(carprice, operator, shoufu){
	//var carprice=document.getElementById("carprice").value;
	//var operator=document.getElementById("operator").value;
	//var shoufu=document.getElementById("shoufu").value;
	var carprice=parseInt(carprice);
	var loan=parseInt(loan);
	var rent=parseInt(rent);
	var deposit=parseInt(deposit);
	var periods=parseInt(periods);
	var dailyrent=parseInt(dailyrent);
	var downpayment=parseInt(downpayment);
	var firstpayment=parseInt(firstpayment);
	var rate=parseInt(rate);firstpayment=carprice*shoufu;
	if(!(isNaN(carprice)))loan=carprice-firstpayment+470;
	else{alert("请您输入车价")}
	deposit=carprice*0.05;
	if(operator=="1"){periods=12;rate=4.573}
	else if(operator=="2"){periods=24;rate=8.184}
	else if(operator=="3"){periods=36;rate=9.453}
	else if(operator=="4"){periods=48;rate=10.099}
	else if(operator=="5"){periods=60;rate=10.489}
	else{alert("请您选择融资年限")}rate=rate/1200;
	var rent=(rate*Math.pow(1+rate,periods)*loan)/(Math.pow(1+rate,periods)-1);
	dailyrent=rent/30;
	displayResultInfo(firstpayment, deposit, rent, dailyrent, periods);
	//填写页面数据
	htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods);
}

//车融通-C
function getResultRC(carprice, operator, shoufu){
	//var carprice=document.getElementById("carprice").value;
	//var operator=document.getElementById("operator").value;
	//var shoufu=document.getElementById("shoufu").value;
	var carprice=parseInt(carprice);
	var loan=parseInt(loan);
	var rent=parseInt(rent);
	var deposit=parseInt(deposit);
	var periods=parseInt(periods);
	var dailyrent=parseInt(dailyrent);
	var downpayment=parseInt(downpayment);
	var firstpayment=parseInt(firstpayment);
	var rate=parseInt(rate);
	firstpayment=carprice*shoufu;
	if(!(isNaN(carprice)))loan=carprice-firstpayment+470;
	else{alert("请您输入车价")}
	deposit=carprice*0.1;
	if(operator=="1"){periods=12;rate=11.881}
	else if(operator=="2"){periods=24;rate=11.045}
	else if(operator=="3"){periods=36;rate=10.791}
	else if(operator=="4"){periods=48;rate=10.69}
	else if(operator=="5"){periods=60;rate=10.65}
	else{alert("请您选择融资年限")}rate=rate/1200;
	var rent=(rate*Math.pow(1+rate,periods)*loan)/(Math.pow(1+rate,periods)-1);
	dailyrent=rent/30;
	periods=periods-deposit/rent;
	displayResultInfo(firstpayment, deposit, rent, dailyrent, periods);
	//填写页面数据
	htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods);
}

//车融通-D
function getResultRD(carprice, operator, shoufu){
	//var carprice=document.getElementById("carprice").value;
	//var operator=document.getElementById("operator").value;
	//var shoufu=document.getElementById("shoufu").value;
	var carprice=parseInt(carprice);
	var loan=parseInt(loan);
	var rent=parseInt(rent);
	var deposit=parseInt(deposit);
	var periods=parseInt(periods);
	var dailyrent=parseInt(dailyrent);
	var downpayment=parseInt(downpayment);
	var firstpayment=parseInt(firstpayment);
	var rate=parseInt(rate);
	firstpayment=carprice*shoufu+carprice*0.2;
	if(!(isNaN(carprice)))loan=carprice-firstpayment+470;
	else{alert("请您输入车价")}
	deposit=0;
	if(!(isNaN(carprice))){
		if(operator=="1"){periods=12;rate=14.155}
		else if(operator=="2"){periods=24;rate=13.299}
		else if(operator=="3"){periods=36;rate=12.299}
		else if(operator=="4"){periods=48;rate=12.846}
		else if(operator=="5"){periods=60;rate=12.754}}
	else{alert("请您选择融资年限")}rate=rate/1200;
	var rent=(rate*Math.pow(1+rate,periods)*loan)/(Math.pow(1+rate,periods)-1);
	dailyrent=rent/30;
	displayResultInfo(firstpayment, deposit, rent, dailyrent, periods);
	//填写页面数据
	htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods);
}

//车融通-E
function getResultRE(carprice, baoxian, gouzhishui, operator){
	//var carprice=document.getElementById("carprice").value;
	//var baoxian=document.getElementById("baoxian").value;
	//var gouzhishui=document.getElementById("gouzhishui").value;
	//var operator=document.getElementById("operator").value;
	var carprice=parseInt(carprice);
	var baoxian=parseInt(baoxian);
	var gouzhishui=parseInt(gouzhishui);
	var loan=parseInt(loan);
	var rent=parseInt(rent);
	var deposit=parseInt(deposit);
	var periods=parseInt(periods);
	var dailyrent=parseInt(dailyrent);
	var downpayment=parseInt(downpayment);
	var firstpayment=parseInt(firstpayment);
	var rate=parseInt(rate);
	if(!(isNaN(carprice)))loan=carprice+470+baoxian+gouzhishui;
	else{alert("请您输入车价")}
	deposit=0;
	if(!(isNaN(loan))){
	if(operator=="1"){periods=12;rate=-46.55}
	else if(operator=="2"){periods=24;rate=-18.422}
	else if(operator=="3"){periods=36;rate=-8.447}
	else if(operator=="4"){alert("车融E证通产品最高融资3年")}
	else if(operator=="5"){alert("车融E证通产品最高融资3年")}}
	else{alert("请您输入车辆、保险及购置税的价格")}rate=rate/1200;
	var rent=(rate*Math.pow(1+rate,periods)*loan)/(Math.pow(1+rate,periods)-1);dailyrent=rent/30;
	firstpayment=(loan-470)*0.3;
	displayResultInfo(firstpayment, deposit, rent, dailyrent, periods);
	//填写页面数据
	htmlResultToPage(firstpayment, deposit, rent, dailyrent, periods);
}
function displayResultInfo(firstpayment, deposit, rent, dailyrent, periods){//add by wlh 弹出试算结果信息
	alert("您的测试结果为:首付金额：" + firstpayment + "元，保证金额：" + deposit + "元，每月租金：" + rent
            + "元，每日租金：" + dailyrent + "元，每时租金：" + periods+ "元");
}